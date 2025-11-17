package org.example;

import java.util.Random;

public class Judge {
    String name;
    int licenseNumber;
    int experienceYears;

    public Judge(int licenseNumber, String name, int experienceYears) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    public boolean validateAttempt(){
        Random random = new Random();
        int chance = random.nextInt(100);
        return chance < 50;
    }
}
