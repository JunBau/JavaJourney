package com.JunBau;

public class Main {

    public static void main(String[] args) {

/*        int myInt = 3;
        if (myInt == 1) {
            System.out.println("my value = 1");
        } else if (myInt == 2) {
            System.out.println("the value is 2");
        } else {
            System.out.println("not 1 or 2");
        }*/

        int switchValue = 3;

        switch(switchValue) {
            case 1:
                System.out.println("Value is 1");
                break;

            case 2:
                System.out.println("Value is 2");
                break;

                case 3:case 4:case 5:
                System.out.println("Was 3, 4 or 5");
                System.out.println("actually it was a " + switchValue);
                break;

            default:
                System.out.println("Value is not 1 or 2");
                break;
        }

        // more code here
        // only testing one variable, testing the same variable.
        // byte short char int

        String playerInput = "a";

        switch(playerInput.toLowerCase()) {
            case "a":
                System.out.println("Value is a");
                break;

            case "b":
                System.out.println("Value is b");
                break;

            case "c":
                System.out.println("Value is c");

                default:
                    System.out.println("The value " + playerInput + " is not in the range...");
                    break;
        }




    }
}
