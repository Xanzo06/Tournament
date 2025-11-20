package org.example;

/**
 * Класс представляющий атлета в турнире
 * Хранит информацию об имени, возрасте, весе, категории и поле
 * @author Xanzo06
 * @version 1.0
 */
public class Athlete {
    private String name;
    private int age;
    private int weight;
    private String category;
    private boolean male;

    private Exercise squat;
    private Exercise benchPress;
    private Exercise deadlift;

    /**
     * Конструктор для создания атлета
     * @param name имя атлета
     * @param age возраст атлета
     * @param weight вес атлета
     * @param category весовая категория атлета
     * @param male пол атлета (true/false)
     */
    public Athlete(String name, int age, int weight, String category,boolean male) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.category = category;
        this.male = male;

        this.squat = new Exercise("Squat");
        this.benchPress = new Exercise("Bench Press");
        this.deadlift = new Exercise("Deadlift");
    }

    /**
     * Метод добавляет попытку в упражнении (присед)
     * @param weight вес попытки
     * @param attemptNumber номер попытки
     * @param success успешность (true/false)
     */
    public void setSquatAttempt(double weight, int attemptNumber, boolean success) {
        squat.addAttempt(weight, attemptNumber, success);
    }
    /**
     * Метод добавляет попытку в упражнении (жим лёжа)
     * @param weight вес попытки
     * @param attemptNumber номер попытки
     * @param success успешность (true/false)
     */
    public void setBenchPress(double weight, int attemptNumber, boolean success) {
        benchPress.addAttempt(weight, attemptNumber, success);
    }
    /**
     * Метод добавляет попытку в упражнении (становая тяга)
     * @param weight вес попытки
     * @param attemptNumber номер попытки
     * @param success успешность (true/false)
     */
    public void setDeadlift(double weight, int attemptNumber, boolean success) {
        deadlift.addAttempt(weight, attemptNumber, success);
    }

    /**
     * Метод возвращает сумму лучших результатов
     * @return сумма результатов (присед + жим + становая)
     */
    public double getTotalScore() {
        return squat.getBestResult() + benchPress.getBestResult() + deadlift.getBestResult();
    }

    /**
     * Возвращает строковое представление об атлете (все попытки)
     * @return возвращает строковое представление об атлете
     */
    public String getAttemptInfo() {
        StringBuilder athleteInfo = new StringBuilder();
        athleteInfo.append("Спортсмен: ").append(name).append("\n");

        athleteInfo.append(squat.getAttemptInfo()).append("\n");
        athleteInfo.append(benchPress.getAttemptInfo()).append("\n");
        athleteInfo.append(deadlift.getAttemptInfo()).append("\n");
        return athleteInfo.toString();
    }

    /**
     * Метод возвращает информацию об атлете (имя, возраст, вес, категорию)
     * @return информацию об атлете
     */
    public String getInfo() {
        return "Спортсмен: " + name + " ; " + " Возраст: " + age + " ; " + " Вес: " + weight + " ; " + " Категория: " + category;
    }

    /**
     * Метод возвращает имя атлета
     * @return имя атлета
     */
    public String getName() {
        return name;
    }
    /**
     * Метод возвращает вес атлета
     * @return вес атлета
     */
    public int getWeight(){
        return weight;
    }
    /**
     * Метод возвращает пол атлета
     * @return пол атлета
     */
    public boolean isMale() {
        return male;

    }
}
