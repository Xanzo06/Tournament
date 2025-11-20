package org.example;

/**
 * Класс представляет одну попытку в упражнении
 * Хранит в себе вес, номер поптыки, успешно (true/false)
 * @author Xanzo06
 * @version 1.0
 */
public class Attempt {
    private double weight;
    private int attemptNumber;
    private boolean success;

    /**
     * Конструктор для создания объекта попытки
     * @param weight вес с которым была совершенна попытка
     * @param attemptNumber номер попытки
     * @param success успешна ли попытка
     */
    public Attempt(double weight, int attemptNumber, boolean success) {
        this.weight = weight;
        this.attemptNumber = attemptNumber;
        this.success = success;
    }

    /**
     * Метод возвращает вес, с которым была совершенна попытка
     * @return вес попытки
     */

    public double getWeight() {
        return weight;
    }

    /**
     * Метод устанавливает вес, с которым была совершенна попытка
     * @param weight вес попытки
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Метод возвращает номер попытки
     * @return номер попытки
     */

    public int getAttemptNumber() {
        return attemptNumber;
    }

    /**
     * Метод устанавливает номер попытки
     * @param attemptNumber номер попытки
     */

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    /**
     * Метод проверяет, была ли попытка успешной
     * @return true/false
     */

    public boolean isSuccessful() {
        return success;
    }

    /**
     * Метод устанавливает была ли попытка успешной
     * @param success true/false
     */

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Метод возвращает строкове представление попытки
     * @return строка с информацией о попытке
     */

    public String getInfo(){
        String result;
        if(isSuccessful()){
            result = "УСПЕШНО";
        }else {
            result = "НЕУДАЧНО";
        }
        return "Попытка " + getAttemptNumber() + ": " + getWeight() + " кг- " + result;
    }

}

