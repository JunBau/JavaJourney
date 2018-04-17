package com.JunBau;

    import java.util.Scanner;

        public class Main {

            private static Scanner scanner = new Scanner(System.in);
            private static Bank BOA = new Bank("BOA");

            public static void main(String[] args) {

//        BOA.createBranch();
//        BOA.addCustomer("Anjum", 100.00, 0);
//        BOA.addCustomer("Tabu", 5000.00, 1);
//        BOA.addCustomer("Imad", 25.00, 0);
//        BOA.addCustomer("Wasim", 10.25, 1);
//        BOA.addCustomer("Liaq", 19.87, 2);
//        BOA.printBranchDetails();
//        System.out.println("******** Printing customer details *********");
//        BOA.printCustomerDetails("Anjum");
//        BOA.addCustomer("Anjum", 200.00, 0);
//        BOA.printCustomerDetails("Anjum");
//        BOA.printCustomerDetails("Tabu");
//        System.out.println("**********************************************************");
//        BOA.printCustomerAndTransactions();
//        BOA.removeCustomer("Tabu");
//        System.out.println("**********************************************************");
//        BOA.printCustomerAndTransactions();
//        BOA.removeCustomer("Tabu XXX");
//        BOA.addTransaction("Anjum", -50.00);
//        System.out.println("**********************************************************");
//        BOA.printCustomerAndTransactions();
//        BOA.addTransaction("Tabrez", -50.00);

                boolean quit = false;
                int choice = 0;
                // Creating five branches of Bank of America
                BOA.createBranch();
                while (!quit) {
                    System.out.println("Enter 0 to print choice options: ");
                    System.out.println("Enter 1 to print Brach details: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 0:
                            printInstructions();
                            break;
                        case 1:
                            printBranchDetails();
                            break;
                        case 2:
                            addCustomer();
                            break;
                        case 3:
                            printCustomersPerBranch();
                            break;
                        case 4:
                            // Do transaction
                            doTransaction();
                            break;
                        case 5:
                            // Search Customer
                            getCustomerDetails();
                            break;
                        case 6:
                            //remove customer
                            removeCustomer();
                            break;
                        case 7:
                            //print all customer and their transactions
                            getAllCustomerTransactions();
                            break;
                        default:
                            System.out.println("Error: Invalid option");
                            break;
                    }
                }

            }

            private static void printBranchDetails () {
                System.out.println("Branch Code 0 ----->    BOA Corporate Branch");
                System.out.println("Branch Code 1 ----->    BOA Seattle Branch");
                System.out.println("Branch Code 2 ----->    BOA Redmond Branch");
                System.out.println("Branch Code 3 ----->    BOA Bellevue Branch");
                System.out.println("Branch Code 4 ----->    BOA Renton Branch");
            }

            public static void printInstructions() {
                System.out.println("\nPress ");
                System.out.println("\t 0 - To print choice options.");
                System.out.println("\t 1 - To print the branch details and branch codes.");
                System.out.println("\t 2 - To add a customer to the Bank Branch.");
                System.out.println("\t 3 - To print customers per Branch.");
                System.out.println("\t 4 - To do a transaction.");
                System.out.println("\t 5 - To get customer details and balance");
                System.out.println("\t 6 - To delete a customer.");
                System.out.println("\t 7-  To print all customers and transactions.");
            }

            public static void addCustomer() {
                System.out.println("Enter customer name");
                String customerName = scanner.nextLine();
                System.out.println("Enter branch code");
                int branchCode = scanner.nextInt();
                System.out.println("Enter deposit amount");
                double transaction = scanner.nextDouble();
                BOA.addCustomer(customerName, transaction, branchCode);
            }

            public static void removeCustomer () {
                System.out.println("Enter customer name");
                String customerName = scanner.nextLine();
                BOA.removeCustomer(customerName);
            }

            public static void doTransaction() {
                System.out.println("Enter customer name");
                String customerName = scanner.nextLine();
                System.out.println("Enter deposit amount");
                double transaction = scanner.nextDouble();
                BOA.addTransaction(customerName, transaction);
            }

            public static void getCustomerDetails () {
                System.out.println("Enter customer name");
                String customerName = scanner.nextLine();
                BOA.printCustomerDetails(customerName);
            }

            public static void printCustomersPerBranch() {
                BOA.printBranchDetails();
            }

            public static void getAllCustomerTransactions () {
                BOA.printCustomerAndTransactions();
            }
        }

