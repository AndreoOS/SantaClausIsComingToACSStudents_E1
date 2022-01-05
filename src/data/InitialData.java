package data;

import entities.Child;
import entities.Gift;
import enums.Category;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    private List<Child> children;
    private List<Gift> santaGiftsList;

    public InitialData() {
        // constructor for json
        children = new ArrayList<>();
        santaGiftsList = new ArrayList<>();
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

    public List<Child> sortChildrenById() {
        return children.stream().sorted((o1, o2) -> {
            if (o1.getId().compareTo(o2.getId()) > 0) {
                return o1.getId().compareTo(o2.getId());
            } else {
                return o2.getId().compareTo(o1.getId());
            }
        }).toList();
    }
}
