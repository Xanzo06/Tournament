package org.example;

public class Athlete {
    private String name;
    private int age;
    private int weight;
    private String category;

    private double squad;
    private double benchPress;
    private double deadlift;

    public Athlete(String name, int age, int weight, String category){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.category = category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSquad() {
        return squad;
    }

    public void setSquad(double squad) {
        this.squad = squad;
    }

    public double getBenchPress() {
        return benchPress;
    }

    public void setBenchPress(double benchPress) {
        this.benchPress = benchPress;
    }

    public double getDeadlift() {
        return deadlift;
    }

    public void setDeadlift(double deadlift) {
        this.deadlift = deadlift;
    }

    public Double getTotal(){
        return squad + benchPress + deadlift;
    }
    public String getInfo(){
        return "Спортсмен: " + name + " ; " + " Возраст: " + age + " ; " + " Вес: " + weight + " ; " + " Категория: " +  category;
    }
}