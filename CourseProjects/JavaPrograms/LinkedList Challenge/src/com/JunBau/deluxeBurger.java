package com.JunBau;

public class deluxeBurger extends defaultburger {

    private boolean chips;
    private boolean drink;

    public deluxeBurger(String breadType, String patty, boolean chips, boolean drink) {
        super(breadType, patty, false, false, false, false);
        this.chips = chips;
        this.drink = drink;
    }

    @Override
    public double getTotalCost() {
        totalCost = baseCost;
        if(chips) {
            totalCost += 0.70;
            System.out.println("Added chips for: 0.70p");
        }
        if (drink) {
            totalCost += 1.00;
            System.out.println("Added drink for: 1.00p");
        }
        return totalCost;
    }
}
