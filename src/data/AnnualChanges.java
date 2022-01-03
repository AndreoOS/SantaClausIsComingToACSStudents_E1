package data;

import entities.Child;
import entities.ChildUpdate;
import entities.Gift;
import enums.Category;

import java.util.List;

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
}
