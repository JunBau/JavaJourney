package com.JunBau;

public class Furniture {

    private Dimensions dimensions;
    private String furnitureName;

    public Furniture(Dimensions dimensions, String furnitureName) {
        this.dimensions = dimensions;
        this.furnitureName = furnitureName;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void getFurnitureShape(int x, int y, String colour){
        System.out.println("The furnitures size is a " + x + " by " + y + " and is the colour " + colour + furnitureName);
    }
}
