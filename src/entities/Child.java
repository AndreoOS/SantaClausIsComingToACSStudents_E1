package entities;

import enums.AgeCategory;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Cities city;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private AgeCategory ageCategory;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public Child() {
        // constructor for json
        this.niceScoreHistory = new ArrayList<>();
        this.receivedGifts = new ArrayList<>();
    }

    public Child(Integer id, String firstName, String lastName, Integer age, Cities city,
                 Double niceScore, List<Category> giftsPreferences) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory() {
        if (age < 5) {
            this.ageCategory = AgeCategory.BABY;
        } else if (age <= 12) {
            this.ageCategory = AgeCategory.KID;
        } else if (age <= 18) {
            this.ageCategory = AgeCategory.TEEN;
        } else {
            this.ageCategory = AgeCategory.YOUNG_ADULT;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

}
