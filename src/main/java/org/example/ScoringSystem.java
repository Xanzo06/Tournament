package org.example;

public final class ScoringSystem {

    public static double calculateWilksScore(Athlete athlete) {
        double weight = athlete.getWeight();
        double sum = athlete.getTotalScore();

        final double aMale = -216.0475144;
        final double bMale = 16.2606339;
        final double cMale = -0.002388645;
        final double dMale = -0.00113732;
        final double eMale = 7.01863E-06;
        final double fMale = -1.291E-08;

        final double aFemale = 594.31747775582;
        final double bFemale = -27.23842536447;
        final double cFemale = 0.82112226871;
        final double dFemale = -0.00930733913;
        final double eFemale = 4.731582E-05;
        final double fFemale = -9.054E-08;

        double a, b, c, d, e, f;

        if (athlete.isMale()) {
            a = aMale;
            b = bMale;
            c = cMale;
            d = dMale;
            e = eMale;
            f = fMale;
        } else {
            a = aFemale;
            b = bFemale;
            c = cFemale;
            d = dFemale;
            e = eFemale;
            f = fFemale;
        }

        return (500 * sum) / (a + b * weight +
                c * Math.pow(weight, 2) +
                d * Math.pow(weight, 3) +
                e * Math.pow(weight, 4) +
                f * Math.pow(weight, 5));
    }

    public static double calculateIPFPoints(Athlete athlete) {
        double weight = athlete.getWeight();
        double sum = athlete.getTotalScore();

        final double aMale = 474.563;
        final double bMale = 12.7127;
        final double cMale = -0.032379;
        final double dMale = 0.000143;

        final double aFemale = 230.849;
        final double bFemale = 11.3432;
        final double cFemale = -0.02728;
        final double dFemale = 0.000171;

        double a, b, c, d;
        if (athlete.isMale()) {
            a = aMale;
            b = bMale;
            c = cMale;
            d = dMale;
        } else {
            a = aFemale;
            b = bFemale;
            c = cFemale;
            d = dFemale;
        }
        return (sum / (a + b * weight + c * Math.pow(weight, 2) + d * Math.pow(weight, 3))) * 100;

    }

    public static int compareAthletes(Athlete athlete1, Athlete athlete2) {

        double wilks1 = calculateWilksScore(athlete1);
        double wilks2 = calculateWilksScore(athlete2);

        return Double.compare(wilks1, wilks2);
    }
}
