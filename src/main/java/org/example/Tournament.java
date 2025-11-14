package org.example;

import java.time.LocalDate;

public class Tournament {
    private String name;
    private LocalDate date;
    private String location;
    private Athlete[] athletes;
    int count;
    public Tournament(String name, LocalDate date, String location){
        this.name = name;
        this.date = date;
        this.location = location;
        this.athletes = new Athlete[10];
        this.count = 0;
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
                System.out.println(athletes[i].getInfo());
                System.out.println("Присед: " + athletes[i].getSquad());
                System.out.println("Жим: " + athletes[i].getBenchPress());
                System.out.println("Становая: " + athletes[i].getDeadlift());
                System.out.println("Сумма: " + athletes[i].getTotal());
                System.out.println("---");
            }
        }
    }
    public void getInfoTournament(){
        System.out.println("Название турнира: " + name + " ; "
                + "Проводится в городе: " + location +
                " ; " + "Время проведения: " + date);
    }


}
