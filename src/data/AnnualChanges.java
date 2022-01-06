package data;

import dataprocessing.CalculateScoreStrategy;
import entities.Child;
import entities.ChildUpdate;
import entities.Gift;
import enums.AgeCategory;
import enums.Category;
import factory.CalculateScoreStrategyFactory;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnnualChanges {
    private Double newSantaBudget;
    private List<Gift> newGifts;
    private List<Child> newChildren;
    private List<ChildUpdate> childrenUpdates;

    public AnnualChanges() {
        // constructor for json
    }

    public AnnualChanges(Double newSantaBudget, List<Gift> newGifts, List<Child> newChildren,
                         List<ChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public List<Child> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<Child> newChildren) {
        this.newChildren = newChildren;
    }

    public void addNewChildren(Database database) {
        for (Child newChild : newChildren) {
            newChild.getNiceScoreHistory().add(newChild.getNiceScore());
            database.getInitialData().getChildren().add(newChild);
        }
    }

    public void updateChildren(Database database) {
        for (ChildUpdate childUpdate : childrenUpdates) {
            Child foundChild = database.getInitialData().getChildWithId(childUpdate.getId());
            if (foundChild != null) {
                if (childUpdate.getNiceScore() != null) {
                    foundChild.setNiceScore(childUpdate.getNiceScore());
                    foundChild.getNiceScoreHistory().add(childUpdate.getNiceScore());
                }
                if (childUpdate.getGiftsPreferences().size() != 0) {
                    for (Category newCategory : childUpdate.getGiftsPreferences()) {
                        foundChild.getGiftsPreferences().remove(newCategory);
                    }
                    List<Category> newGiftPreferences = Stream.concat(childUpdate.getGiftsPreferences().stream(),
                            foundChild.getGiftsPreferences().stream()).collect(Collectors.toList());
                    newGiftPreferences = newGiftPreferences.stream().distinct().collect(Collectors.toList());
                    foundChild.setGiftsPreferences(newGiftPreferences);

                }
            }
        }
    }

    public void updateBudget(Database database) {
        database.setSantaBudget(newSantaBudget);
    }

}
