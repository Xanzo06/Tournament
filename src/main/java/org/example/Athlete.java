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

        this.squat = new Exercise("Squat");
        this.benchPress = new Exercise("Bench Press");
        this.deadlift = new Exercise("Deadlift");
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

    public String getAttemptInfo() {
        StringBuilder athleteInfo = new StringBuilder();
        athleteInfo.append("Спортсмен: ").append(name).append("\n");

        athleteInfo.append(squat.getAttemptInfo()).append("\n");
        athleteInfo.append(benchPress.getAttemptInfo()).append("\n");
        athleteInfo.append(deadlift.getAttemptInfo()).append("\n");
        return athleteInfo.toString();
    }


    public String getInfo() {
        return "Спортсмен: " + name + " ; " + " Возраст: " + age + " ; " + " Вес: " + weight + " ; " + " Категория: " + category;
    }

    public String getName() {
        return name;
    }
}
