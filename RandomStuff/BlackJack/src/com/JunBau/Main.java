package com.JunBau;

import java.util.Scanner;

public class Main {

    // Created by Phillip Alejo
    // Most functionality will be in different classes. Game functionality is in BlackJackF
    // The entry point of the program should be clean looking...  Obviously didn't happen. such a messy black jack method.
    // Maybe I should use caps as a currency for teh lolz?

    private static Scanner userInput = new Scanner(System.in);
    private static blackJackF playerz = new blackJackF();

    public static void main(String[] args) {
	// write your code here

        boolean quit = false;
        int choice = 0;
        printMenu();

        while (!quit) {

            System.out.println("\n(Main menu) enter your choice: ");
            try {
                choice = userInput.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid input, please choose a number. " +
                        "(0 for instructions)");
                userInput.next();
            }

            //This will be the main menu.
            //Shall I use switches within switches?

            switch(choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    testOnePlayer();
                    break;
                case 2:
                    individualFunctions();
                    break;
            }
        }
    }

    // Menu interactions
    public static void printMenu() {
        System.out.print("\n 0 - Instructions");
        System.out.print("\n 1 - 1 Player");
        System.out.print("\n 2 - Test individual functions!\n");
    }

    // Black jack game..

    public static void testOnePlayer() {
        playerz.onePlayer();
    }


    // These are more for testing tbh...

    public static void individualFunctions() {
        boolean quit = false;
        int choice = 0;
        testingInstructions();

        while (!quit) {

            System.out.println("\n(Test Menu) enter your choice: [0 for instructions]");
            try {
                choice = userInput.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid input, please choose a number. " +
                        "(0 for instructions)");
                userInput.next();
            }

            switch(choice) {
                case 0:
                    testingInstructions();
                    break;
                case 1:
                    addPlayer();
                    break;
                case 2:
                    printPlayers();
                    break;
                case 3:
                    addFullDeck();
                    break;
                case 4:
                    printCard();
                    break;
                case 5:
                    shuffleDeck();
                    break;
                case 6:
                    quit = true;
                    printMenu();
                    break;
            }
        }
    }

    public static void testingInstructions() {
        System.out.print("\n 0 - Instructions");
        System.out.print("\n 1 - Add a player");
        System.out.print("\n 2 - Print player list");
        System.out.print("\n 3 - Create a full deck for player");
        System.out.print("\n 4 - Print card list for a player");
        System.out.print("\n 5 - Shuffle the deck for a player");
        System.out.print("\n 6 - Quit\n");
    }

    public static void addPlayer() {
        System.out.println("Please enter player name: ");
        String playername = userInput.next();
        playerz.addPlayer(playername);
    }


    public static void printCard() {
        System.out.println("Please enter player name to display cards: ");
        String playername = userInput.next();
        playerz.printCardList(playername);
    }

    public static void printPlayers() {
        playerz.printPlayerList();
    }

    public static void addFullDeck() {
        System.out.println("Please enter player name to add a full deck to: ");
        String playerName = userInput.next();
        playerz.createDeck(playerName);
    }

    public static void shuffleDeck() {
        System.out.println("Enter the name of the player to shuffle deck: ");
        String playerName = userInput.next();
        playerz.shuffledDeck(playerName);
    }


}
