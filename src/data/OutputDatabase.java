package data;

import entities.Children;

import java.util.ArrayList;
import java.util.List;

public class OutputDatabase {
    private List<Children> annualChildren;

    public OutputDatabase() {
        annualChildren = new ArrayList<>();
    }

    public List<Children> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(List<Children> annualChildren) {
        this.annualChildren = annualChildren;
    }
}
