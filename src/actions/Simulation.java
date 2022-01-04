package actions;

import data.Database;
import data.OutputDatabase;
import dataprocessing.CalculateScoreStrategy;
import entities.Child;
import factory.CalculateScoreStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Database database;
    private Double budgetUnit;

    public Simulation(Database database) {
        this.database = database;
    }

    public void InitialYear(OutputDatabase odb) {
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
        // adaug copii in lista si lista in output database
        List<Child> giftedChildren = new ArrayList<>();
        for (Child child : database.getInitialData().getChildren()) {
            giftedChildren.add(child);
        }
        odb.getListAllGiftedChildren().add(giftedChildren);
    }

}
