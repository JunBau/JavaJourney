package com.JunBau;

public class Car {
    private boolean engine;
    private int wheels;
    private int cylinders;
    private String name;

    public Car(int cylinders, String name) {
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.name = name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public boolean startEngine() {
        System.out.println("Engine is active");
        return true;
    }

    public int accelerate(boolean accUp) {
        int x = 1;
        while(accUp && x <= 60) {
            System.out.println("Speed is " + x + " MPH");
            x++;
        }
        while (accUp == false) {
            x--;
            System.out.println("Speed is " + x + " MPH");
        }
        return x;
    }

    public int brake() {
        return 0;
    }


}
