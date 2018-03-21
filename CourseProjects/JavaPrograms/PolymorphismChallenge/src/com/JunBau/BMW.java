package com.JunBau;

public class BMW extends Car {

    public BMW() {
        super(4,"black one");
    }

    public boolean startEngine() {
        System.out.println("Engine is roaring!");
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

    public int brake() {
        return 1;
    }
}


