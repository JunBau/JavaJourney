package com.JunBau;

import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        // Just testing this out right now...

        System.out.println("Test, sending a TLS email using googlemail...");

        // First we want to login, currently just testing GMAIL.

        System.out.println("Please enter Email address: ");
        String username = userInput.nextLine();

        // Need to hash out password here.
        System.out.println("Please enter password: ");
        String password = userInput.nextLine();

        boolean quit = false;
        int choice = 0;
        ClientGuide();

        while (!quit) {

            try {
                choice = Integer.parseInt(userInput.nextLine());
            } catch (Exception choiceTing) {
                System.out.println("Invalid input!");
            }


            switch (choice) {
                case 0:
                    ClientGuide();
                    break;
                case 1:
                    TLSEmail(username,password);
                    break;
                case 2:
                    quit = true;
                    break;

            }

        }

    }

    public static void ClientGuide() {
        System.out.println("This is a simple mail client." +
                "\n0 - Print options" +
                "\n1 - TLS Email" +
                "\n2 - Quit");
    }

    public static void TLSEmail(String username, String password) {
        System.out.println("Please enter subject line: ");
        String msgSubject = userInput.nextLine();

        System.out.println("Please enter message body: ");
        String msgBody = userInput.nextLine();

        System.out.println("Please enter to address: ");
        String toAddress = userInput.nextLine();

        TLSEmail.tlsEmail(username,password,toAddress,msgBody, msgSubject);

    }

}