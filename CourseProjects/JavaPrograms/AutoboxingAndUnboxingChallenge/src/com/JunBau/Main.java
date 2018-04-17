package com.JunBau;

import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
	// write your code here

        bank.defaultBranches();

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit) {
            System.out.println("\tEnter your choice: ");
            try {
                choice = userInput.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid input, please choose a number. " +
                "(0 for instructions)");
            }

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printBranch();
                    break;
                case 2:
                    addBranch();
                    break;
                case 3:
                    searchBranch();
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    printCustomers();
                    break;
                case 6:
                    addTransaction();
                    break;
                case 7:
                    printTrans();
                    break;
                default:
                    System.out.println("Error: Invalid option");
                    break;
            }
        }

    }


    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print branch list.");
        System.out.println("\t 2 - To add a branch.");
        System.out.println("\t 3 - To find a branch.");
        System.out.println("\t 4 - To add a customer.");
        System.out.println("\t 5 - To print list of customers.");
        System.out.println("\t 6 - To add a transaction.");
        System.out.println("\t 7 - To print list of transactions.");
    }

    public static void printBranch() {
        bank.printBranches();
    }

    public static void addBranch() {
        System.out.println("Please enter branch name to add: ");
        String branchName = userInput.next();
        bank.addBranch(branchName);
    }

    public static void searchBranch() {
        System.out.println("Please enter branch name to validate existence: ");
        String branchName = userInput.next();
        bank.findingBranch(branchName);
    }

    public static void addCustomer () {
        System.out.println("Please choose a Branch: ");
        String branchName = userInput.next();
        if(bank.onFile(branchName)) {
            System.out.println("Please enter the name of the account holder: ");
            String cusName = userInput.next();
            if (!bank.custOnFile(branchName,cusName)){
                bank.addCustomer(branchName, cusName);
                System.out.println("Please enter initial transaction: ");
                double value = userInput.nextInt();
                bank.addTransaction(branchName,cusName,value);
            } else {
                System.out.println("Record already exists.");
            }
        } else
            System.out.println("Branch does not exist.");
    }

    public static void printCustomers () {
        System.out.println("Please choose a branch to display: ");
        String branchName = userInput.next();
        if (bank.onFile(branchName)) {
        bank.printCustomer(branchName);
        } else
            System.out.println("Branch does not exist.");
    }

    public static void addTransaction() {
        System.out.println("Please enter branch name: ");
        String branchName = userInput.next();
        if(bank.onFile(branchName)) {
            System.out.println("Please enter person name: ");
            String custName = userInput.next();
            if(bank.custOnFile(branchName,custName)){
                System.out.println("Please enter amount: ");
                double value = userInput.nextDouble();
                bank.addTransaction(branchName, custName, value);
            }
        } else
            System.out.println("Branch does not exist.");

    }

    public static void printTrans() {
        System.out.println("Please enter branch name: ");
        String branchName = userInput.next();
        if(bank.onFile(branchName)) {
            System.out.println("Please enter customer name: ");
            String custName = userInput.next();
            if(bank.custOnFile(branchName,custName)) {
                bank.printTrans(branchName, custName);
            }
        } else
            System.out.println("Record does not exist.");
    }

}
