package com.JunBau;

public class Player {

    public String fullName;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {

        this.health = this.health - damage;

        System.out.println(damage + " hit points taken!");
        if(this.health <= 0) {
            System.out.println(fullName + " has blanked out...");
//reduce number of lives for player.
        }

    }

    public int healthRemaining() {
        return this.health;
    }

}
