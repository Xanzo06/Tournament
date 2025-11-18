package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private String name;
    private LocalDate date;
    private String location;
    private Athlete[] athletes;
    private WeightCategory[] weightCategories;
    int count;
    int categoryCount;
    public Tournament(String name, LocalDate date, String location){
        this.name = name;
        this.date = date;
        this.location = location;
        this.athletes = new Athlete[10];
        this.weightCategories = new WeightCategory[3];
        this.count = 0;
        this.categoryCount = 0;
    }
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
    public void addWeightCategory(WeightCategory category){
        if (categoryCount < weightCategories.length){
            weightCategories[categoryCount] = category;
            categoryCount++;
        }else {
            System.out.println("Достигнут лимит весовых категорий (" +weightCategories.length + ")");
        }
    }
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
    public void printAllResults() {
        for (int i = 0; i < count; i++) {
            if (athletes[i] != null) {
                System.out.println(athletes[i].getAttemptInfo());
                System.out.println("Сумма: " + athletes[i].getTotalScore());
                System.out.println("---");
            }
        }
    }
    public void getInfoTournament(){
        System.out.println("Название турнира: " + name + " ; "
                + "Проводится в городе: " + location +
                " ; " + "Время проведения: " + date);
    }
    public WeightCategory determineCategory(double weight){
        for (int i = 0; i < categoryCount; i++){
            WeightCategory weightCategory = weightCategories[i];
            if (weightCategory.isInCategory(weight)){
                return weightCategory;
            }
        }
        return null;
    }
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
