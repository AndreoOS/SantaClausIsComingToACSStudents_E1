package entities;

import enums.Category;
import enums.Cities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class OutputChild {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private List<Category> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public OutputChild(Child child) {
        id = child.getId();
        lastName = child.getLastName();
        firstName = child.getFirstName();
        city = child.getCity();
        age = child.getAge();
        giftsPreferences = cloneGiftPreferences(child.getGiftsPreferences()); // clone
        averageScore = child.getAverageScore();
        niceScoreHistory = cloneNiceScoreHistory(child.getNiceScoreHistory()); // clone
        assignedBudget = child.getAssignedBudget();
        receivedGifts = cloneReceivedGifts(child.getReceivedGifts());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
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

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    private List<Gift> cloneReceivedGifts(List<Gift> receivedGifts) {
        List<Gift> clone = new ArrayList<>();
        for (Gift gift : receivedGifts) {
            clone.add(new Gift(gift));
        }
        return clone;
    }

    private List<Category> cloneGiftPreferences(List<Category> giftPreferences) {
        return new ArrayList<>(giftPreferences);
    }

    private List<Double> cloneNiceScoreHistory(List<Double> niceScoreHistory) {
        return new ArrayList<>(niceScoreHistory);
    }
}
