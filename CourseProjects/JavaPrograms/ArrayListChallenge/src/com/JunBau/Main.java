package com.JunBau;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);
    private static MobilePhone mobile = new MobilePhone();

    //Most challenging task I've had yet, but was a blast!

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.println("\tEnter your choice: ");
            try {
                choice = userInput.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid number. try again.");
            }
            userInput.nextLine();

            //Switches are so cool!

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    System.out.println("Terminating program...");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
                    break;
            }

        }


    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To add a contact.");
        System.out.println("\t 2 - To list contacts.");
        System.out.println("\t 3 - To remove a contact.");
        System.out.println("\t 4 - To find a contact.");
        System.out.println("\t 5 - To update a contact.");
        System.out.println("\t 6 - Quit.");
    }

    public static void addContact() {
        System.out.println("Please enter the Name: ");
        String name = userInput.nextLine();
        System.out.println("Please enter the Number: ");
        String Number = userInput.nextLine();
        mobile.addContact(name,Number);
    }

    public static void printList() {
        mobile.printContact();
    }

    public static void removeContact() {
        System.out.println("Please enter name to remove: ");
        String name = userInput.nextLine();
        mobile.removeContact(name);
    }

    public static void searchContact() {
        System.out.print("Please enter search item: ");
        String searchItem = userInput.nextLine();
        if(mobile.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in the list.");
        } else {
            System.out.println("Search item does not exist.");
        }
    }

    public static void updateContact() {
        System.out.println("Please enter name to update: ");
        String searchItem = userInput.next();
        if(mobile.onFile(searchItem)) {
            System.out.println("Please enter new name: ");
            String newName = userInput.next();
            System.out.println("Please enter new number: ");
            String newNo = userInput.next();
            mobile.updateContact(searchItem, newName, newNo);
            System.out.println("Record changed.");
        } else
        {
            System.out.println("Record not found...");
        }
    }

}
