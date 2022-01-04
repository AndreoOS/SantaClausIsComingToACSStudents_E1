package dataprocessing;

import entities.Child;
import enums.AgeCategory;

public class BabyScoreStrategy implements CalculateScoreStrategy{

    private Child child;

    public BabyScoreStrategy(Child child) {
        this.child = child;
    }

    @Override
    public Double getScore() {
        return 10.0;
    }
}
