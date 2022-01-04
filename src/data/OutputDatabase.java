package data;

import entities.Child;

import java.util.ArrayList;
import java.util.List;

public class OutputDatabase {
    private List<List<Child>> listAllGiftedChildren;

    public OutputDatabase() {
        listAllGiftedChildren = new ArrayList<>();
    }

    public List<List<Child>> getListAllGiftedChildren() {
        return listAllGiftedChildren;
    }

    public void setListAllGiftedChildren(List<List<Child>> listAllGiftedChildren) {
        this.listAllGiftedChildren = listAllGiftedChildren;
    }
}
