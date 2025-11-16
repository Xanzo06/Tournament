package org.example;

public class Athlete {
    private String name;
    private int age;
    private int weight;
    private String category;

    private Exercise squat;
    private Exercise benchPress;
    private Exercise deadlift;

    public Athlete(String name, int age, int weight, String category) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.category = category;
    }

    public void setSquatAttempt(double weight, int attemptNumber, boolean success) {
        squat.addAttempt(weight, attemptNumber, success);
    }

    public void setBenchPress(double weight, int attemptNumber, boolean success) {
        benchPress.addAttempt(weight, attemptNumber, success);
    }

    public void setDeadlift(double weight, int attemptNumber, boolean success) {
        deadlift.addAttempt(weight, attemptNumber, success);
    }

    public double getTotalScore() {
        return squat.getBestResult() + benchPress.getBestResult() + deadlift.getBestResult();
    }


    public String getInfo() {
        return "Спортсмен: " + name + " ; " + " Возраст: " + age + " ; " + " Вес: " + weight + " ; " + " Категория: " + category;
    }
}
