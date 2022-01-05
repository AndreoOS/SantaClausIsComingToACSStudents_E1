package entities;

import java.util.ArrayList;
import java.util.List;

public class Children {
    List<OutputChild> children;

    public Children() {
        children = new ArrayList<>();
    }

    public List<OutputChild> getChildren() {
        return children;
    }

    public void setChildren(List<OutputChild> children) {
        this.children = children;
    }
}
