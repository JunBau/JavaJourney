package com.JunBau;

public class Porsche extends Car {

    public Porsche() {
        super(4,"fancy shit");
    }

    public boolean startEngine() {
        System.out.println("Engine is purring!");
        return true;
    }

    public int accelerate(boolean accUp) {
        int x = 1;
        while(accUp && x <= 80) {
            System.out.println("Speed is " + x + " MPH");
            x += 5;
        }
        x -= 3;
        return x;
    }
}


