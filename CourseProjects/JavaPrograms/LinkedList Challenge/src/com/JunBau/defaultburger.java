package com.JunBau;

public class defaultburger {

    private String breadType;
    private String patty;
    public double totalCost;
    private additionalItems additionalItems;

    public double baseCost = 4.00;
    private boolean lettuce;
    private boolean tomato;
    private boolean cheese;
    private boolean onions;


    public defaultburger(String breadType, String patty, boolean lettuce, boolean tomato, boolean cheese, boolean onions) {
        this.breadType = breadType;
        this.patty = patty;
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.cheese = cheese;
        this.onions = onions;
    }

    public String getBreadType() {
        return breadType;
    }

    public String getPatty() {
        return patty;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isOnions() {
        return onions;
    }

    public double getTotalCost() {
        totalCost = baseCost;
        if (isLettuce()) {
            totalCost += 0.25;
            System.out.println("Added lettuce for: 0.25p");
        }
        if (isTomato()) {
            totalCost += 0.25;
            System.out.println("Added tomato for: 0.25p");
        }
        if (isCheese()) {
            totalCost += 0.25;
            System.out.println("Added cheese for: 0.25p");
        }
        if (isOnions()) {
            totalCost += 0.25;
            System.out.println("Added onions for: 0.25p");
        }
        return totalCost;
    }

    public double getBaseCost() {
        System.out.println("Called base price: ");
        return baseCost;
    }

}
