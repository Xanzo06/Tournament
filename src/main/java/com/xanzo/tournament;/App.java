package org.example;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Athlete athlete1 = new Athlete("Борис", 22, 80, "Троеборье");
        Athlete athlete2 = new Athlete("Алексей", 20, 83, "Троеборье");
        Athlete athlete3 = new Athlete("Григорий", 23, 82, "Троеборье");

        athlete1.setSquad(200.0);
        athlete1.setBenchPress(120.0);
        athlete1.setDeadlift(180.0);

        athlete2.setSquad(230.0);
        athlete2.setBenchPress(150.0);
        athlete2.setDeadlift(200.0);

        athlete3.setSquad(225.0);
        athlete3.setBenchPress(141.5);
        athlete3.setDeadlift(190.0);

        Tournament tournament = new Tournament("Турнир по тяжёлой атлетике", LocalDate.now(), "Москва");
        tournament.getInfoTournament();
        System.out.println();

        tournament.addAthlete(athlete1);
        tournament.addAthlete(athlete2);
        tournament.addAthlete(athlete3);

        Athlete found = tournament.findAthleteByName("Борис");
        if (found != null){
            System.out.println("Найден Атлет: " + found.getInfo());
        }else {
            System.out.println("Атлет не найден");
        }
        System.out.println();

        System.out.println("Вывод всей информации об атлетах: ");
        tournament.printAllResults();



    }
}