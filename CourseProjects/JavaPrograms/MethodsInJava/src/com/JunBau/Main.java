package com.JunBau;

public class Main {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 1000;
        int levelCompleted = 5;
        int bonus = 100;
        String playerName = "bob";

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

        highScore = calculateHighScorePosition(highScore);
        displayHighScorePosition(playerName,highScore);

        score = 500;
        levelCompleted = 2;
        bonus = 200;
        playerName = "aidan";

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

        highScore = calculateHighScorePosition(highScore);
        displayHighScorePosition(playerName,highScore);

        score = 200;
        levelCompleted = 1;
        bonus = 200;
        playerName = "alex";

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

        highScore = calculateHighScorePosition(highScore);
        displayHighScorePosition(playerName,highScore);

        score = 10;
        levelCompleted = 2;
        bonus = 20;
        playerName = "miguel";

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was: " + highScore);

        highScore = calculateHighScorePosition(highScore);
        displayHighScorePosition(playerName,highScore);

        }


    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            return finalScore;
        } else {
            return -1;
        }
    }

    public static void displayHighScorePosition(String playersName, int position) {

        System.out.println(playersName + " managed to get into position: " + position + " on the high score table.");

    }

    public static int calculateHighScorePosition(int playerScore) {

        if(playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500 && playerScore < 1000) {
            return 2;
        } else if (playerScore >= 100 && playerScore < 500) {
            return 3;
        } else {
            return 4;
        }

    }
}
