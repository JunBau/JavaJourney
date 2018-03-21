package com.JunBau;

public class Main {

    public static void main(String[] args) {

        int newScore = calculateScore("Jun", 500);
        System.out.println("New score is: " + newScore);
        calculateScore(75);
        calculateScore();

        calcFeetAndInchesToCentimeters(7,5);
        calcFeetAndInchesToCentimeters(157);


    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player "  + playerName + " scored " + score  + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score  + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score...");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet >= 0 && inches >= 0 && inches <=12) {
            feet = feet*30.48;
        System.out.println("That's: " + feet + "cm" );

            inches = inches*2.54d;
            System.out.println("That's: " + inches + "cm");

            double centimeters = feet+=inches;
            System.out.println("the total of feet and inches: " + centimeters + "cm");
        }
        System.out.println("Invalid Parameters");
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches >= 0) {
            double feet = inches/12d;
            double remainingInches = (int) inches % 12;
            System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches);
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        }
        return -1;
    }

}
