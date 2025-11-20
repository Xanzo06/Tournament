package org.example;

import java.util.Scanner;

/**
 * Класс интерактивного меню для управления турниром
 * Позволяет пользователю добавлять атлетов, вводить результаты, искать атлетов, выводить результаты
 */
public class PowerliftingMenu {

    private Scanner scanner;
    private Tournament tournament;

    /**
     * Конструктор для создания объекта меню
     * @param scanner объект класса Сканера для получения ввода от пользователя
     * @param tournament объект класса Турнира с которым взаимодействует меню
     */
    public PowerliftingMenu(Scanner scanner, Tournament tournament) {
        this.scanner = scanner;
        this.tournament = tournament;
    }

    /**
     * Метод выводит главное меню
     */

    public void showMainMenu() {
        System.out.println("Меню турнира: ");
        System.out.println("1. Добавить атлета");
        System.out.println("2. Ввести результаты");
        System.out.println("3. Найти атлета по имени");
        System.out.println("4. Вывести все результаты");
        System.out.println("5. Вывести результаты по категориям");
        System.out.println("6. Выйти");
        System.out.println("Выберите опцию (1-6)");
    }

    /**
     * Метод обрабатывает выбор пользователя из главного меню и выполняет соответствующие действия
     * @return true/false
     */

    public boolean handleUserInput() {
        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Введите номер опции: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                validChoice = true;
            } else {
                System.out.println("Введите число: ");
                scanner.nextLine();
                System.out.println("Введите номер опции: ");
            }
        }

        switch (choice) {
            case 1:
                addNewAthlete();
                System.out.println("Выбрано: Добавление нового атлета");
                break;
            case 2:
                inputCompetitionResults();
                System.out.println("Выбрано: Ввод результатов");
                break;
            case 3:
                System.out.println("Введите имя для поиска атлета: ");
                String nameSearch = scanner.nextLine();
                Athlete findAthlete = tournament.findAthleteByName(nameSearch);
                if (findAthlete != null) {
                    System.out.println("Атлет найден: ");
                    System.out.println(findAthlete.getInfo());
                } else {
                    System.out.println("Атлет с именем " + nameSearch + " не найден в турнире");
                }
                break;
            case 4:
                tournament.printAllResults();
                break;
            case 5:
                tournament.printResultsByCategory();
                break;
            case 6:
                System.out.println("Выход");
                return false;
        }
        return true;
    }

    /**
     * Метод взаимодействует с пользователем для добавления нового атлета в турнир
     */
    public void addNewAthlete() {
        System.out.println("Добавление нового атлета");
        String name = scanner.nextLine();
        System.out.println("Введите возраст атлета: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите вес спортсмена: ");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите категорию: ");
        String category = scanner.nextLine();
        String male;
        boolean isMale = true;
        boolean validMale = false;
        while (!validMale) {
            System.out.println("Введите пол: (М/Ж)");
            male = scanner.nextLine();
            if (male.equalsIgnoreCase("М")) {
                isMale = true;
                validMale = true;
            } else if (male.equalsIgnoreCase("Ж")) {
                isMale = false;
                validMale = true;
            } else {
                System.out.println("Неккоректный ввод поля. Чтобы продолжить введите М или Ж");
            }
        }
        Athlete newAthlete = new Athlete(name, age, weight, category, isMale);
        tournament.addAthlete(newAthlete);
        System.out.println("Атлет " + name + " добавлен");


    }

    /**
     * Метод взаимодействует с пользователем для ввода результатов попытки для созданного атлета
     */
    public void inputCompetitionResults() {
        System.out.println("---Ввод результатов соревнований--- ");
        System.out.println("Введите имя Атлета:");
        String name = scanner.nextLine();
        Athlete athlete = tournament.findAthleteByName(name);
        if (athlete != null) {
            System.out.println("Введите упражнение (присед/жим/становая): ");
            String exercise = scanner.nextLine();
            System.out.println("Введите вес: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Введите номер попытки: ");
            int attemptNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Успешна ли попытка (да/нет)");
            String success;
            boolean successResult = true;
            boolean validSuccess = false;
            while (!validSuccess) {
                System.out.println("Успешна ли попытка (да/нет)");
                success = scanner.nextLine();
                if (success.equalsIgnoreCase("Да")) {
                    successResult = true;
                    validSuccess = true;
                } else if (success.equalsIgnoreCase("Нет")) {
                    successResult = false;
                    validSuccess = true;
                } else {
                    System.out.println("Некорректный ввод поля. Чтобы продолжить введите 'Да' или 'Нет'.");
                }
            }
            if (exercise.equals("присед")) {
                athlete.setSquatAttempt(weight, attemptNumber, successResult);
            } else if (exercise.equals("жим")) {
                athlete.setBenchPress(weight, attemptNumber, successResult);
            } else if (exercise.equals("становая")) {
                athlete.setDeadlift(weight, attemptNumber, successResult);
            } else {
                System.out.println("Неверное упражнение: " + exercise);
                return;
            }

            System.out.println("Попытка добавлена для " + name +
                    " упражнение " + exercise + ", вес: "
                    + weight + "кг, номер попытки:"
                    + ", результат: " + (successResult ? "Успешно" : "Неудачно"));
        } else {
            System.out.println("Атлет " + name + " не найден.");
        }
    }


}
