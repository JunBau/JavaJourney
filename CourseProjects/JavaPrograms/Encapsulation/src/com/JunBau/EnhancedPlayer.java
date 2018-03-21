package com.JunBau;

public class EnhancedPlayer {

    private String fullName;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;

        if (health >= 0 && health <= 100) {
            this.hitPoints = health;
        }

        this.weapon = weapon;
    }

    public void loseHealth(int damage) {

        this.hitPoints = this.hitPoints - damage;

        System.out.println(damage + " hit points taken!");
        if (this.hitPoints <= 0) {
            System.out.println(fullName + " has blanked out...");
//reduce number of lives for player.
        }
    }

    public int getHealth() {
        return hitPoints;
    }


}
