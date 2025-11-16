package org.example;

public class Attempt {
    private double weight;
    private int attemptNumber;
    private boolean success;

    public Attempt(double weight, int attemptNumber, boolean success) {
        this.weight = weight;
        this.attemptNumber = attemptNumber;
        this.success = success;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public boolean isSuccessful() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}

