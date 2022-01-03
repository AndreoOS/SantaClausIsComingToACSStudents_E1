package data;

import entities.Child;
import entities.Gift;
import enums.Cities;

import java.util.List;

public class InitialData {
    private List<Child> children;
    private List<Gift> santaGiftsList;

    public InitialData() {
        // constructor for json
    }

    public InitialData(List<Child> children, List<Gift> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
