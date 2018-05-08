package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> Inventory = new ArrayList<String>();
    static Scanner UserInput = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here

        Human player = new Human("Hero", 100, 50);
        boolean quit = false;
        int choice = 0;
        DisplayInstructions();

        while(!quit) {

            System.out.println("\n" + player.toString());

            try {
                choice = Integer.parseInt(UserInput.nextLine());
            } catch (Exception ChoiceCatch) {

            }

            switch(choice) {

                case 0:
                    DisplayInstructions();
                    break;

                case 1:
                    player.AddItems(readValues(), Inventory);
                    break;

                case 2:
                    player.DisplayItems(Inventory);
                    break;

                case 3:
                    quit = true;
                    break;

            }

        }

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    private static void DisplayInstructions() {
        System.out.println("Please enter your choice: " +
                "\n0 - Print options." +
                "\n1 - Add items to inventory." +
                "\n2 - Display items in inventory." +
                "\n3 - Exit.");
    }
}
