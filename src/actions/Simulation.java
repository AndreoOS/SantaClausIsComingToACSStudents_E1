package actions;

import common.Constants;
import data.AnnualChanges;
import data.Database;
import data.GiftList;
import data.OutputDatabase;
import dataprocessing.CalculateScoreStrategy;
import entities.Child;
import entities.Children;
import entities.Gift;
import entities.OutputChild;
import enums.AgeCategory;
import enums.Category;
import factory.CalculateScoreStrategyFactory;

public class Simulation {
    private Database database;
    private Double budgetUnit;
    private GiftList giftList;

    public Simulation(Database database, GiftList giftList) {
        this.database = database;
        this.giftList = giftList;
    }

    public void simulateAll(OutputDatabase odb) {
        initialRound(odb);
        simulateYears(odb);
    }

    public void initialRound(OutputDatabase odb) {
        setNiceScoreHistory();
        setAgeCategories();
        database.removeYoungAdults();
        setAssignedBudgets();
        // bag cadourile la copii
        giveGifts();
        // adaug copii in lista si lista in output database
        Children giftedChildren = new Children();
        for (Child child : database.getInitialData().getChildren()) {
            giftedChildren.getChildren().add(new OutputChild(child));
        }
        odb.getAnnualChildren().add(giftedChildren);
        removeGifts();
    }

    private void simulateYears(OutputDatabase odb) {
        for (int i = 1; i <= database.getNumberOfYears(); i++) {
            for (Child child : database.getInitialData().getChildren()) {
                child.setAge(child.getAge() + 1);
                setAgeCategories();
            }
            AnnualChanges annualChange = database.getAnnualChanges().get(i - 1);
            annualChange.addNewChildren(database);
            annualChange.updateChildren(database);
            annualChange.updateBudget(database);
            setAgeCategories();
            database.removeYoungAdults();
            setAssignedBudgets();
            giveGifts();
            Children giftedChildren = new Children();
            for (Child child : database.getInitialData().getChildren()) {
                giftedChildren.getChildren().add(new OutputChild(child));
            }
            odb.getAnnualChildren().add(giftedChildren);
            // stergem gifturile
            removeGifts();
        }
    }

    private void giveGifts() {
        Gift assignedGift;
        for (Child child : database.getInitialData().getChildren()) {
            Double budget = child.getAssignedBudget();
            for (Category giftCategory : child.getGiftsPreferences()) {
                assignedGift = null;
                for (Gift foundGift : giftList.getSpecifiedList(giftCategory)) {
                    if (assignedGift != null) {
                        if(assignedGift.getPrice().compareTo(foundGift.getPrice()) > 0) {
                            assignedGift = foundGift;
                        }
                    } else {
                        assignedGift = foundGift;
                    }
                }
                if (assignedGift != null) {
                    if (Double.compare(budget, assignedGift.getPrice()) > 0
                            && !child.getReceivedGifts().contains(assignedGift)) {
                        child.getReceivedGifts().add(assignedGift);
                        budget = budget - assignedGift.getPrice();
                    }
                }
            }
       }
    }

    private void removeGifts() {
        for (Child child : database.getInitialData().getChildren()) {
            child.getReceivedGifts().clear();
        }
    }

    private void setAgeCategories() {
        for(Child child : database.getInitialData().getChildren()) {
            child.setAgeCategory();
            CalculateScoreStrategy strategy = CalculateScoreStrategyFactory
                    .createStrategy(child.getAgeCategory(), child);
            if (strategy != null) {
                child.setAverageScore(strategy.getScore());
            }
        }
    }

    private void setAssignedBudgets() {
        budgetUnit = database.getSantaBudget() / database.getSumOfAverage();
        for (Child child : database.getInitialData().getChildren()) {
            child.setAssignedBudget(budgetUnit * child.getAverageScore());
        }
    }

    private void setNiceScoreHistory() {
        for (Child child : database.getInitialData().getChildren()) {
            child.getNiceScoreHistory().add(child.getNiceScore());
        }
    }

}
