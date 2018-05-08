package com.company;

import java.util.ArrayList;

public class Human implements ISaveable {

    // Experimental right now tbh... lolol.

    private String Name;
    private int HitPoints;
    private int Strength;
    private String Weapon;

    public Human(String name, int hitPoints, int strength) {
        Name = name;
        HitPoints = hitPoints;
        Strength = strength;
        this.Weapon = "Sword";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHitPoints() {
        return HitPoints;
    }

    public void setHitPoints(int hitPoints) {
        HitPoints = hitPoints;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public String getWeapon() {
        return Weapon;
    }

    public void setWeapon(String weapon) {
        Weapon = weapon;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Name='" + Name + '\'' +
                ", HitPoints=" + HitPoints +
                ", Strength=" + Strength +
                ", Weapon='" + Weapon + '\'' +
                '}';
    }

    @Override
    public void DisplayItems(ArrayList<String> Item) {
        if (!Item.isEmpty()) {
            for (int i = 0; i < Item.size(); i++) {
                System.out.println(Item.get(i));
            }
        } else {
            System.out.println(Item + " contains no records...");
        }
    }

    @Override
    public void AddItems(ArrayList<String> ItemName, ArrayList<String> DestinationSave) {
        DestinationSave.addAll(ItemName);
    }
}
