package factory;

import dataprocessing.*;
import entities.Child;
import enums.AgeCategory;

public class CalculateScoreStrategyFactory {
    public static CalculateScoreStrategy createStrategy(AgeCategory ageCategory, Child child) {
        switch (ageCategory) {
            case BABY -> {
                return new BabyScoreStrategy(child);
            }
            case KID -> {
                return new KidScoreStrategy(child);
            }
            case TEEN -> {
                return new TeenScoreStrategy(child);
            }
            case YOUNG_ADULT -> {
                return new YoungAdultScoreStrategy(child);
            }
            default -> {
                return null;
            }
        }
    }
}
