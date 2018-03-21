package com.JunBau;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if (score < 5000 && score > 1000) {
            System.out.println("Your score is " + score);
        } else if (score < 1000) {
            System.out.println("You suck dude.");
        } else {
            System.out.println("A+!");
        }

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        // If variables are created within a code block, you cannot access them outside the code block.
        // External variables within a code block are called scopes.
        // Created variables within a code block are not stored whilst executed.

        score = 10000;
        levelCompleted = 8;
        bonus = 200;
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        // Re-using variables is faster and uses less memory +Positive
        // Re-using variables doesn't allow you keep a record of values -Negative
        // Duplicating code is hard to track.
    }
}
