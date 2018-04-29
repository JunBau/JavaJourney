package com.JunBau;

import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
	// Here will be the entry point. I'll ask if the user would like to start the OS.
        // From there, they will be interacting with the Mobile class, this class will contain the app "Music".
        // Music will be a Music player.

        System.out.print("Loading");
        try {
            for (int i = 0; i < 3; i++) {
//                Thread.sleep(600);
                System.out.print(".");
//                Thread.sleep(600);
            }
        } catch (Exception e) {
            // Still don't know what to put here?
        }

        boolean quit = false;

        System.out.println("\nWould you like to start JunOS? (Y/N)");


        while (!quit) {
            String choice = userInput.nextLine().toLowerCase();

            if (choice.equals("y")) {
                Mobile.JunOSInitialize();
                quit = true;
            } else {
                System.out.println("K.");
            }
        }
    }
}
