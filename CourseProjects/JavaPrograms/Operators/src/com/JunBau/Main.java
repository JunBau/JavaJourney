package com.JunBau;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println(result);

        int previousResults = result;

        result = result - 1;

        System.out.println("The previous result was: " + previousResults);
        System.out.println("The current result is: " + result);

        previousResults = result;

        result = result * 10;
        System.out.println("That * 10 is: " +result);

        previousResults = result;

        result = result / 5;
        System.out.println("Now, lets divide by 5: " + result);

        previousResults = result;

        result = result % 3;
        System.out.println("Now do % 3: " + result);

        previousResults = result;

        result = result + 1;
        System.out.println("Now add one...: " + result);
        result++;
        System.out.println("add ++: " + result);

        boolean isAlien = false;
        if (isAlien == false)
            System.out.println("This ain't no alien!");
        else
            System.out.println("Aliens are real...");

        int topScore = 100;
        if (topScore >= 100)
            System.out.println("You beat Gavin!!");

        int secondTopScore = 70;
        if(topScore > secondTopScore && topScore < 100);
        System.out.println("Greater than top score and less than 100");

        if ((topScore > 100) || secondTopScore <= 60)
            System.out.println("One of these tests is true.");

        int newValue = 50;
        if(newValue == 50)
            System.out.println("The newValue is: " + newValue);

        boolean isCar = false;

        boolean wasCar = isCar ? true : false;
        if (wasCar)
        System.out.println();

        double firstDouble = 20d;
        System.out.println("First is: " + firstDouble);
        double secondDouble = 80d;
        System.out.println("Second is: " + secondDouble);
        double doubleResult = (firstDouble + secondDouble) * 25;
        System.out.println(doubleResult);
        System.out.println(("Now add the numbers and multiply by 25: " + (doubleResult)));

        System.out.println("on to the next...");

        double remainOp = doubleResult % 40;
        System.out.println(remainOp);
        if (remainOp <= 20)
            System.out.println("Total was over the limit");


    }
}
