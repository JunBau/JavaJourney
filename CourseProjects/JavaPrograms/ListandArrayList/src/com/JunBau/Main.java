package com.JunBau;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ShoppingList shoppingList = new ShoppingList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("\tEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    shoppingList.printShoppingList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    findItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of shopping items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify and item in the list.");
        System.out.println("\t 4 - To remove and item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To display list (efficiently).");
        System.out.println("\t 7 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the item name: ");
        shoppingList.addShoppingItem(scanner.nextLine());
    }

    public static void updateItem() {
        System.out.print("Please enter the current item name: ");
        String itemPo = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String replacementItem = scanner.nextLine();
        shoppingList.updateItem(itemPo,replacementItem);
    }

    public static void removeItem() {
        System.out.print("Please enter the item name to remove: ");
        String itemPo = scanner.nextLine();
        shoppingList.removeItem(itemPo);
    }

    public static void findItem(){
        System.out.print("Please enter search item: ");
        String searchItem = scanner.nextLine();
        if(shoppingList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in the list.");
        } else {
            System.out.println("Search item does not exist.");
        }

    }
    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>(shoppingList.getShoppingList());
    }
}
