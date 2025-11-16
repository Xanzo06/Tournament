package org.example;

public class Exercise {
    private String name;
    private Attempt[] attempts;

    public Exercise(String name) {
        this.name = name;
        this.attempts = new Attempt[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attempt[] getAttempts() {
        return attempts;
    }

    public void setAttempts(Attempt[] attempts) {
        this.attempts = attempts;
    }

    public void addAttempt(double weight, int attemptNumber, boolean success) {
        if (attemptNumber >= 1 && attemptNumber <= 3) {
            attempts[attemptNumber - 1] = new Attempt(weight, attemptNumber, success);
        }
    }

    public double getBestResult() {
        double best = 0.0;
        for (Attempt attempt : attempts) {
            if (attempt.getWeight() > best && attempt.isSuccessful()) {
                best = attempt.getWeight();
            }
        }
        return best;
    }

    public int getSuccessfulAttemptsCount() {
        int count = 0;
        for (Attempt attempt : attempts) {
            if (attempt.isSuccessful()) {
                count++;
            }
        }
        return count;
    }

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



