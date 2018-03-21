package com.JunBau;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // width of an int = 32 (4 bytes)
        int myIntValue = 5/2;

        // width of a float = 32 (4 bytes)
        // Float has seven decimals of precision
        float myFloatValue = 5f / 3f;

        // width of a double = 64 (8 bytes)
        // Double has sixteen decimals of precision
        double myDouableValue = 5d / 3d;

        System.out.println(myIntValue);
        System.out.println(myFloatValue);
        System.out.println(myDouableValue);

        int userPound = 200;
        double oneKiloG = 0.45359237d;
        double convertPoundKilo = (double) (userPound * oneKiloG);

        System.out.println("KG = " + convertPoundKilo);


    }
}
