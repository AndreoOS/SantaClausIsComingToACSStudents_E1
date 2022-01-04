package data;

import entities.Child;
import entities.Gift;
import enums.AgeCategory;
import enums.Cities;

import java.util.List;

public class Database {
    private Integer numberOfYears;
    private Double santaBudget;
    private InitialData initialData;
    private List<AnnualChanges> annualChanges;

    public Database() {
        // constructor for json
    }
    public Database(Integer numberOfYears, Double santaBudget, List<AnnualChanges> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.annualChanges = annualChanges;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(List<AnnualChanges> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public void removeYoungAdults() {
        initialData.getChildren().removeIf(child -> child.getAgeCategory().equals(AgeCategory.YOUNG_ADULT));
    }

    public Double getSumOfAverage() {
        Double sum = 0.0;

        for(Child child : initialData.sortChildrenById()) {
            sum = sum + child.getAverageScore();
        }
        return sum;
    }



}
