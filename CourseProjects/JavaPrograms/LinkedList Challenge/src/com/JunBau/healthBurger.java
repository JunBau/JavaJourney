package com.JunBau;

public class healthBurger extends defaultburger {

    private boolean pickles;
    private boolean radish;

    public healthBurger(String patty, boolean lettuce, boolean tomato, boolean cheese, boolean onions, boolean pickles, boolean radish) {
        super("Brown Brye", patty, lettuce, tomato, cheese, onions);
        this.pickles = pickles;
        this.radish = radish;
    }

    @Override
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
        totalCost = baseCost;
        if (pickles) {
            totalCost += 0.30;
            System.out.println("Added pickles for: 0.30p");
        }
        if (radish) {
            totalCost += 0.30;
            System.out.println("Added radish for: 0.30p");
        }
            return totalCost;
        }

}
