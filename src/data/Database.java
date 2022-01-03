package data;

import entities.Child;
import entities.Gift;
import enums.Cities;
import lombok.Data;

import java.util.List;

public class Database {
    private Integer numberOfYears;
    private Double santaBudget;
    private List<Child> childList;
    private List<Gift> giftList;
    private List<Cities> cityList;
    private List<AnnualChanges> annualChanges;

    public Database() {
        // constructor for json
    }
    public Database(Integer numberOfYears, Double santaBudget, List<Child> childList,
                    List<Gift> giftList, List<Cities> cityList, List<AnnualChanges> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.childList = childList;
        this.giftList = giftList;
        this.cityList = cityList;
        this.annualChanges = annualChanges;
    }
}
