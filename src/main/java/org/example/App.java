package org.example;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Tournament tournament = new Tournament("Турнир по тяжёлой атлетике", LocalDate.now(), "Москва");
        tournament.getInfoTournament();
        System.out.println();

        tournament.addWeightCategory(new WeightCategory("Лёгкий вес", 60.0, 70.0));
        tournament.addWeightCategory(new WeightCategory("Средний вес", 75.0, 85.0));
        tournament.addWeightCategory(new WeightCategory("Тяжёлый вес", 90.0, 100.0));

        Athlete athlete1 = new Athlete("Борис", 22, 60, "Троеборье");
        Athlete athlete2 = new Athlete("Алексей", 20, 83, "Троеборье");
        Athlete athlete3 = new Athlete("Григорий", 23, 92, "Троеборье");

        Judge judge = new Judge("Антон", 98765, 25);

        athlete1.setSquatAttempt(200.0, 1, judge.validateAttempt());
        athlete1.setSquatAttempt(210.0, 2, judge.validateAttempt());
        athlete1.setSquatAttempt(225.0, 3, judge.validateAttempt());

        athlete1.setBenchPress(110.0, 1, judge.validateAttempt());
        athlete1.setBenchPress(120.0, 2, judge.validateAttempt());
        athlete1.setBenchPress(130.0, 3, judge.validateAttempt());

        athlete1.setDeadlift(170.0, 1, judge.validateAttempt());
        athlete1.setDeadlift(185.0, 2, judge.validateAttempt());
        athlete1.setDeadlift(200.0, 3, judge.validateAttempt());

        athlete2.setSquatAttempt(220.0, 1, judge.validateAttempt());
        athlete2.setSquatAttempt(230.0, 2, judge.validateAttempt());
        athlete2.setSquatAttempt(245.0, 3, judge.validateAttempt());

        athlete2.setBenchPress(115.0, 1, judge.validateAttempt());
        athlete2.setBenchPress(125.0, 2, judge.validateAttempt());
        athlete2.setBenchPress(135.0, 3, judge.validateAttempt());

        athlete2.setDeadlift(180.0, 1, judge.validateAttempt());
        athlete2.setDeadlift(195.0, 2, judge.validateAttempt());
        athlete2.setDeadlift(210.0, 3, judge.validateAttempt());

        athlete3.setSquatAttempt(190.0, 1, judge.validateAttempt());
        athlete3.setSquatAttempt(205.0, 2, judge.validateAttempt());
        athlete3.setSquatAttempt(215.0, 3, judge.validateAttempt());

        athlete3.setBenchPress(120.0, 1, judge.validateAttempt());
        athlete3.setBenchPress(130.0, 2, judge.validateAttempt());
        athlete3.setBenchPress(140.0, 3, judge.validateAttempt());

        athlete3.setDeadlift(175.0, 1, judge.validateAttempt());
        athlete3.setDeadlift(190.0, 2, judge.validateAttempt());
        athlete3.setDeadlift(205.0, 3, judge.validateAttempt());


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

        System.out.println("Вывод результатов по категориям: ");
        tournament.printResultsByCategory();
        System.out.println();

        WeightCategory cat = tournament.determineCategory(80.0);
        if (cat != null){
            System.out.println("Атлет с весом 80.0 кг попдает в категорию: " + cat);
        }else {
            System.out.println("Атлет с весом 80.0 кг не попадает ни в одну из существующих категорий");
        }



    }
}