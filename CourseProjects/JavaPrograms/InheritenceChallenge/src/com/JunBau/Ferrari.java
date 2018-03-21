package com.JunBau;

public class Ferrari extends Car {

    private String seatType;
    private String model;

    public Ferrari(String seatType, String model) {
        super("Car", "Sports", "Ferrari", 4, 3, 6, false);
        this.seatType = seatType;
        this.model = model;
    }

    public void accelerate(int rate) {

        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10){
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20){
            changeGear(2);
        } else if (newVelocity > 20 && newVelocity <= 30){
            changeGear(3);
        } else {
            changeGear(4);
        }

        if (newVelocity > 0) {}
        changeVelocity(newVelocity, getCurrentDirection());
    }
}
