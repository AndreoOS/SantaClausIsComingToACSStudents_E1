package actions;

import data.AnnualChanges;
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

public final class Simulation {
    private Database database;
    private Double budgetUnit;
    private GiftList giftList;

    public Simulation(final Database database, final GiftList giftList) {
        this.database = database;
        this.giftList = giftList;
    }

    /**
     * Wrapper method that calls the methods for simulating round 0 and the subsequent
     * rounds
     * @param odb Database to store the results
     */
    public void simulateAll(final OutputDatabase odb) {
        initialRound(odb);
        simulateYears(odb);
    }

    /**
     * Method that simulates round 0. Sets the list for all the nice scores, age categories,
     * removes all the young adults from the database then sets the assigned budged for every child
     * in the database. After, the gifts are distributed. All of the children from the database are
     * then transformed into output children (for output purposes) then put into a list. That list
     * is then put into another list (output database.annualChildren). The received gifts are
     * then removed from every child's list
     * @param odb Database that stores the results
     */
    private void initialRound(final OutputDatabase odb) {
        setNiceScoreHistory();
        setAgeCategories();
        database.removeYoungAdults();
        setAssignedBudgets();
        giveGifts();
        Children giftedChildren = new Children();
        for (Child child : database.getInitialData().getChildren()) {
            giftedChildren.getChildren().add(new OutputChild(child));
        }
        odb.getAnnualChildren().add(giftedChildren);
        removeGifts();
    }

    /**
     * Firstly, the method increments the age of every child in the database then sets the age
     * categories once again. After that, method goes through all the annual changes: adds new
     * children, modifies the current ones, and updates the children. After that, method is similar
     * to initialRound method.
     * @param odb Database that stores the results
     */
    private void simulateYears(final OutputDatabase odb) {
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
            removeGifts();
        }
    }

    /**
     * Method goes through all the children from the database and the gift preferences of every
     * child. As long as the budget permits it, the cheapest gift from Santa's stash is
     * distributed to the child.
     */
    private void giveGifts() {
        Gift assignedGift;
        for (Child child : database.getInitialData().getChildren()) {
            Double budget = child.getAssignedBudget();
            for (Category giftCategory : child.getGiftsPreferences()) {
                assignedGift = null;
                if (giftList.getSpecifiedList(giftCategory) != null) {
                    for (Gift foundGift : giftList.getSpecifiedList(giftCategory)) {
                        if (assignedGift != null) {
                            if (assignedGift.getPrice().compareTo(foundGift.getPrice()) > 0) {
                                assignedGift = foundGift;
                            }
                        } else {
                            assignedGift = foundGift;
                        }
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

    /**
     * Method clears the list of received gifts for every child
     */
    private void removeGifts() {
        for (Child child : database.getInitialData().getChildren()) {
            child.getReceivedGifts().clear();
        }
    }

    /**
     * This method sets the age category for every child, then calculates the average score
     * using different strategies based on the age category
     */
    private void setAgeCategories() {
        for (Child child : database.getInitialData().getChildren()) {
            child.setAgeCategory();
            CalculateScoreStrategy strategy = CalculateScoreStrategyFactory
                    .createStrategy(child.getAgeCategory(), child);
            if (strategy != null) {
                child.setAverageScore(strategy.getScore());
            }
        }
    }

    /**
     * Method calculates the budget unit for the year, then calculates the assigned budget for
     * every child in the database
     */
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
