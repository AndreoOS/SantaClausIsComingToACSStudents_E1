package actions;

import data.Database;
import data.GiftList;
import data.OutputDatabase;
import dataprocessing.CalculateScoreStrategy;
import entities.Child;
import entities.Children;
import entities.Gift;
import entities.OutputChild;
import enums.Category;
import factory.CalculateScoreStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Database database;
    private Double budgetUnit;
    private GiftList giftList;

    public Simulation(Database database, GiftList giftList) {
        this.database = database;
        this.giftList = giftList;
    }

    public void simulateYears(OutputDatabase odb) {


    }

    public void initialYear(OutputDatabase odb) {
        for(Child child : database.getInitialData().getChildren()) {
            child.setAgeCategory();
            child.getNiceScoreHistory().add(child.getNiceScore());
            CalculateScoreStrategy strategy = CalculateScoreStrategyFactory
                    .createStrategy(child.getAgeCategory(), child);
            if (strategy != null) {
                child.setAverageScore(strategy.getScore());
            }
        }
        budgetUnit = database.getSantaBudget() / database.getSumOfAverage();
        for (Child child : database.getInitialData().getChildren()) {
            child.setAssignedBudget(budgetUnit * child.getAverageScore());
        }
        database.removeYoungAdults();
        // bag cadourile la copii
        giveGifts();
        // adaug copii in lista si lista in output database
        Children giftedChildren = new Children();
        for (Child child : database.getInitialData().getChildren()) {
            giftedChildren.getChildren().add(new OutputChild(child));
        }
        odb.getAnnualChildren().add(giftedChildren);
    }

    private void giveGifts() {
        Gift assignedGift = null;
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
                    if (budget > assignedGift.getPrice()) {
                        child.getReceivedGifts().add(assignedGift);
                        budget = budget - assignedGift.getPrice();
                    }
                }
            }
       }
    }

}
