package org.example;

public class WeightCategory {
    String categoryName;
    double minWeight;
    double maxWeight;

    public WeightCategory(String categoryName, double minWeight, double maxWeight) {
        this.categoryName = categoryName;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean isInCategory(double weight) {
        if (weight >= minWeight && weight <= maxWeight) {
            return true;
        } else {
            return false;
        }
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(categoryName).append(" ").append(minWeight).append(" - ").append(maxWeight).append(" кг");
        return str.toString();
    }

}
