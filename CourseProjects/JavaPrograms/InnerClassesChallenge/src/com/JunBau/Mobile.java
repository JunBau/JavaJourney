package com.JunBau;

import java.util.Scanner;

public class Mobile {

    private static String OperatingSystem = "JunOS v0.00001";
    private static Music music;
    private static Scanner userInput = new Scanner(System.in);

    public static void JunOSInitialize() {
        System.out.println("\n" + OperatingSystem);
        System.out.println("\nWelcome to JunOS!");
        printMenu();

        boolean quit = false;
        int choice = 0;

        while(!quit) {

            try {
                choice = userInput.nextInt();
            } catch ( Exception choosingInt) {
                System.out.println("Invalid input");
                userInput.nextLine();
            }

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    music.MusicPlayer();
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("\nPlease choose a program:");
        System.out.println("0 - Dashboard");
        System.out.println("1 - Music Player");
    }

}
