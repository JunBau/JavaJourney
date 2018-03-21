package com.JunBau;


public class room {


    private String roomType;
    private Dimensions dimensions;
    private Floor floor;
    private Furniture furniture;
    private Wall wall;
    private Lights lights;

    public room(String roomType, Dimensions dimensions, Floor floor, Furniture furniture, Wall wall, Lights lights) {
        this.roomType = roomType;
        this.dimensions = dimensions;
        this.floor = floor;
        this.furniture = furniture;
        this.wall = wall;
        this.lights = lights;
    }

    public String getRoomType() {
        return roomType;
    }

    public void turnOnLight() {
        lights.turnOn();
    }

    public Lights getLights() {
        return lights;
    }

    private void furnitures() {
        furniture.getFurnitureShape(12,20,"Red");
    }
}
