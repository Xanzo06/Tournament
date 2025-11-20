package org.example;

import java.util.Random;

/**
 * Класс представляет судью, который может случайным образом определить успешность попытки
 * Хранит информацию об имени, номере лицензии, стаже
 */
public class Judge {
    String name;
    int licenseNumber;
    int experienceYears;

    /**
     * Конструктор для создания объекта судьи
     * @param name имя
     * @param licenseNumber номер лицензии
     * @param experienceYears стаж судьи в годах
     */
    public Judge(String name, int licenseNumber, int experienceYears) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.experienceYears = experienceYears;
    }

    /**
     * Метод возвращает имя судьи
     * @return имя судьи
     */
    public String getName() {
        return name;
    }
    /**
     * Метод устанавливает имя судьи
     * @param name имя судьи
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Метод возвращает номер лицензии судьи
     * @return номер лицензии судьи
     */
    public int getLicenseNumber() {
        return licenseNumber;
    }
    /**
     * Метод устанавливаеь номер лицензии судьи
     * @param licenseNumber номер лизенции судьи
     */
    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    /**
     * Метод возвращает стаж судьи в годах
     * @return стаж судьи в годах
     */
    public int getExperienceYears() {
        return experienceYears;
    }

    /**
     * Метод устанавливает стаж судьи в годах
     * @param experienceYears стаж судьи в годах
     */
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    /**
     * Метод случайным образом определяет успешность попытки
     * @return true/false
     */
    public boolean validateAttempt() {
        Random random = new Random();
        int chance = random.nextInt(100);
        return chance < 50;
    }
}
