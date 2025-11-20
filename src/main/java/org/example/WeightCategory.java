package org.example;

/**
 * Класс представляющий весовую категорию в турнире
 * Определяет категорию, минимальный и максимальный вес
 * @author Xanzo06
 * @version 1.0
 */
public class WeightCategory {
    String categoryName;
    double minWeight;
    double maxWeight;

    /**
     * Конструктор для создания объекта весовой категории
     * @param categoryName имя категории
     * @param minWeight минимальный вес
     * @param maxWeight максимальный вес
     */
    public WeightCategory(String categoryName, double minWeight, double maxWeight) {
        this.categoryName = categoryName;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    /**
     * Метод возвращает имя категории
     * @return имя категории
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Метод устанавливает имя категории
     * @param categoryName имя категории
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    /**
     * Метод возвращает минимальный вес в упражнении
     * @return минимальный вес
     */
    public double getMinWeight() {
        return minWeight;
    }
    /**
     * Метод устанавливает минимальный вес в упражнении
     * @param minWeight минимальный вес упражнения
     */
    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }
    /**
     * Метод возвращает максимальный вес в упражнении
     * @return максимальный вес
     */
    public double getMaxWeight() {
        return maxWeight;
    }
    /**
     * Метод устанавливает максимальный вес в упражнении
     * @param maxWeight максимальный вес упражнения
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Метод проверяет попадает ли указанный вес в диапазон категории
     * @param weight вес для проверки
     * @return true/false
     */
    public boolean isInCategory(double weight) {
        if (weight >= minWeight && weight <= maxWeight) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод возвращает строковое представление весовой категории
     * @return строковое описание категории, диапазона от минимального до максимального веса
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(categoryName).append(" ").append(minWeight).append(" - ").append(maxWeight).append(" кг");
        return str.toString();
    }

}
