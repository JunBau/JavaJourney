package com.JunBau;

public class Vehicle {

    private String type;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String type, String size) {
        this.type = type;
        this.size = size;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
    }

    public void move(int velocity, int direction) {
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " mph, in direction " + currentDirection );
    }

    public void stop() {
        currentVelocity = 0;
    }
}
