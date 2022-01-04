package dataprocessing;

import entities.Child;

public class YoungAdultScoreStrategy implements CalculateScoreStrategy{
    private Child child;

    public YoungAdultScoreStrategy(Child child) {
        this.child = child;
    }

    @Override
    public Double getScore() {
        return 0.0;
    }
}
