package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет турнир по тяжёлой атлетике
 * Управляет списком атлетов, весовыми категориями
 * Хранит в себе имя турнира, дату турнира, место проведения турнира, счетчик атлетов, счётчик категорий
 * @author Xanzo06
 * @version 1.0
 */
public class Tournament {
    private String name;
    private LocalDate date;
    private String location;
    private Athlete[] athletes;
    private WeightCategory[] weightCategories;
    int count;
    int categoryCount;

    /**
     * Конструктор для создания объекта турнира
     * @param name имя турнира
     * @param date дату проведения турнира
     * @param location локацию турнира
     */
    public Tournament(String name, LocalDate date, String location){
        this.name = name;
        this.date = date;
        this.location = location;
        this.athletes = new Athlete[10];
        this.weightCategories = new WeightCategory[3];
        this.count = 0;
        this.categoryCount = 0;
    }

    /**
     * Метод добавляюший нового атлета в турнир с помощью объекта класса Атлет
     * @param athlete объект класса Атлет для добавления
     */
    public void addAthlete(Athlete athlete){
        if (count >= athletes.length){
            int rearmLength = athletes.length * 2;
            Athlete[] newAthletes = new Athlete[rearmLength];
            System.arraycopy(this.athletes, 0, newAthletes, 0, this.athletes.length);
            this.athletes = newAthletes;
        }
        athletes[count] = athlete;
        count++;

    }

    /**
     * Метод добавляющий весовую категорию в турнир
     * @param category объект класса Весовой категории для добавления
     */
    public void addWeightCategory(WeightCategory category){
        if (categoryCount < weightCategories.length){
            weightCategories[categoryCount] = category;
            categoryCount++;
        }else {
            System.out.println("Достигнут лимит весовых категорий (" +weightCategories.length + ")");
        }
    }

    /**
     * Метод для поиска атлета по имени в турнире
     * @param name имя атлета для поиска
     * @return объект класса Атлета
     */
    public Athlete findAthleteByName(String name){
        for (Athlete athlete : athletes) {
            if (athlete != null){
                if (athlete.getName().equals(name)) {
                    return athlete;
                }
            }
        }
        return null;
    }

    /**
     * Метод выводит всю информацию об атлетах, попытках, сумме
     */
    public void printAllResults() {
        for (int i = 0; i < count; i++) {
            if (athletes[i] != null) {
                System.out.println(athletes[i].getAttemptInfo());
                System.out.println("Сумма: " + athletes[i].getTotalScore());
                System.out.println("---");
            }
        }
    }

    /**
     * Метод выводит всю информацию о турнире, название, место проведения, дату провдения
     */
    public void getInfoTournament(){
        System.out.println("Название турнира: " + name + " ; "
                + "Проводится в городе: " + location +
                " ; " + "Время проведения: " + date);
    }

    /**
     * Метод определяет в какую весовую категорию попадает атлет с указанным весом
     * @param weight вес атлета
     * @return объект класса Весовой категории
     */
    public WeightCategory determineCategory(double weight){
        for (int i = 0; i < categoryCount; i++){
            WeightCategory weightCategory = weightCategories[i];
            if (weightCategory.isInCategory(weight)){
                return weightCategory;
            }
        }
        return null;
    }

    /**
     * Выводит информацию о всех результатах по категориям
     */
    public void printResultsByCategory(){
        for (int i = 0; i < categoryCount; i++){
            if (weightCategories[i] != null){
                WeightCategory currentCategory = weightCategories[i];
                System.out.println("Категория: " + currentCategory);

                List<Athlete> athleteInThisCategory = new ArrayList<>();

                for (int j = 0; j < count; j++) {
                    Athlete athlete = athletes[j];
                    if (currentCategory.isInCategory(athlete.getWeight())){
                        athleteInThisCategory.add(athlete);
                    }
                }
                for (int s = 0; s < athleteInThisCategory.size(); s++){
                    Athlete athleteInCategory = athleteInThisCategory.get(s);
                    System.out.println((s + 1) + ". " + athleteInCategory.getName() + "-" + athleteInCategory.getTotalScore());
                }
                System.out.println("---");
            }
        }
    }


}
