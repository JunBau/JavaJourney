package com.JunBau;

public class Main {

    public static void main(String[] args) {

        String myString = "This is a string.";
        System.out.println("myString is equal to " + myString);
        myString = myString + " we're going to add to this string.";
        System.out.println("myString is equal to " + myString);
        myString = myString + " \u00a9 2015.";
        System.out.println("myString is equal to " + myString);

        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println("Result is " + numberString);

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println(lastString);

    }
}
