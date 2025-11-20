package org.example;

/**
 * Класс представляет упражнение
 * Управляет массивом попыток для упражнения
 * @author Xanzo06
 * @version 1.0
 */
public class Exercise {
    private String name;
    private Attempt[] attempts;

    /**
     * Конструктор для создания объекта упражнения
     * @param name имя упражнения
     */
    public Exercise(String name) {
        this.name = name;
        this.attempts = new Attempt[3];
    }

    /**
     * Метод возвращает имя упражнения
     * @return имя упражнения
     */

    public String getName() {
        return name;
    }

    /**
     * Метод устанавливает имя упражнения
     * @param name имя упражнения
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает массив попыток
     * @return массив попыток
     */

    public Attempt[] getAttempts() {
        return attempts;
    }

    /**
     * Метод устанваливает массив попыток для этого упражнения
     * @param attempts массив объектов
     */

    public void setAttempts(Attempt[] attempts) {
        this.attempts = attempts;
    }

    /**
     * Метод добавляет попытку в упражнение
     * @param weight вес попытки
     * @param attemptNumber номер попытки
     * @param success Успешность true/false
     */

    public void addAttempt(double weight, int attemptNumber, boolean success) {
        if (attemptNumber >= 1 && attemptNumber <= 3) {
            attempts[attemptNumber - 1] = new Attempt(weight, attemptNumber, success);
        }
    }

    /**
     * Метод возвращает лучший результат попытки (максимальный вес) среди всех успешных попыток в упражнении
     * @return лучший результат попытки
     */

    public double getBestResult() {
        double best = 0.0;
        for (Attempt attempt : attempts) {
            if (attempt.getWeight() > best && attempt.isSuccessful()) {
                best = attempt.getWeight();
            }
        }
        return best;
    }

    /**
     * Метод возвращает количество успешных попыток в упражнении
     * @return количество успешных попыток
     */

    public int getSuccessfulAttemptsCount() {
        int count = 0;
        for (Attempt attempt : attempts) {
            if (attempt.isSuccessful()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Метод возвращает строковое представление (информацию о попытках и лучший результат)
     * @return строка с информацией об упражнении
     */

    public String getAttemptInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Упражнение: ").append(name).append("\n");
        int attemptNumber = 1;
        for (Attempt attempt : attempts) {
            if (attempt != null) {
                info.append("Попытка: ").append(attemptNumber)
                        .append(": ").append(attempt.getWeight())
                        .append(" кг -")
                        .append(attempt.isSuccessful() ? "УСПЕШНО" : "НЕУДАЧНО")
                        .append("\n");
            } else {
                info.append("Попытка ").append(attemptNumber).append(": ").append("Не выполнена").append("\n");
            }
            attemptNumber++;

        }
        info.append("Лучший результат: ").append(getBestResult()).append(" кг");

        return info.toString();

    }

}



