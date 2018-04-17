package com.JunBau;


import java.util.ArrayList;

/**
 * Created by eanjtab on 7/27/2017.
 */
public class Bank {
    private String bankName;
    ArrayList<ArrayList<Customer>> branchesOfBank = new ArrayList<ArrayList<Customer>>();
    private static Boolean customerStatus = false;
    private static int branchCode = 0;
    ArrayList<String> unisqCustomerList = new ArrayList<String>();

    public Bank(String bankName) {
        this.branchesOfBank = branchesOfBank;
        this.customerStatus = customerStatus;
        this.branchCode = branchCode;
    }

    public ArrayList<ArrayList<Customer>> getBranchesOfBank() {
        return branchesOfBank;
    }


    public void createBranch() {
        // Creating 5 branches of the Bank BOA
        for (int i = 0; i < 5; i++) {
        }
    }

    public void addCustomer (String customerName, double transAmount, int branchCode) {
        if (customerExists(customerName) >= 0) {
            System.out.println("Customer " + customerName + " already a BOA customer");
        } else {
            String brCode = getBranchName(branchCode);
            ArrayList<Customer> customer = this.branchesOfBank.get(branchCode);
            Customer C1 = new Customer(customerName, new ArrayList<Double>());
            customer.add(C1);
            unisqCustomerList.add(customerName);
            System.out.println("Customer " + C1.getCustomerName() + " is added to " + brCode);
            ArrayList<Double> transactions = C1.getTransactions();
            transactions.add(transAmount);
            System.out.println("Transaction added is " + transactions.get(transactions.size() - 1));

        }
    }

    public void removeCustomer (String customerName) {
        if (customerExists(customerName) >= 0) {
            for (int br = 0; br < branchesOfBank.size(); br++) {
                ArrayList<Customer> customers = this.branchesOfBank.get(br);
                for (int cust = 0; cust < customers.size(); cust++) {
                    Customer C1 = customers.get(cust);
                    if (C1.getCustomerName().equals(customerName)) {
                        customers.remove(cust);
                        System.out.println("INFO: customer " + customerName + " and all trasactions are deleted from Bank" );
                    }
                }
            }

        } else {System.out.println("ERROR: " + customerName + " is not a BOA customer");
        }
    }

    public void addTransaction (String customerName, double transaction) {
        double balance=0;
        if (customerExists(customerName) >= 0) {
            Customer C1 = findCustomer(customerName);
            ArrayList<Double> transactions = C1.getTransactions();
            transactions.add(transaction);
            System.out.println("INFO: customer " + customerName + " with " + getBranchName(this.branchCode) + " has done " + transaction + " transaction");
            for (int tr=0; tr<transactions.size(); tr++) {
                balance += transactions.get(tr);
            }
            System.out.println("IFNO: current balance of " + customerName + "= " + balance);
        } else {
            System.out.println("ERROR: " + customerName + " is not a BOA customer");
        }
    }

    public void printCustomerAndTransactions () {
        Boolean custStatus = false;
        for (int br=0; br<branchesOfBank.size();br++) {
            ArrayList<Customer> customers = this.branchesOfBank.get(br);
            System.out.println("BRANCH ------------ : " + getBranchName(br));
            for (int cust=0; cust<customers.size();cust++) {
                //Customer C1 = new Customer(customer, new ArrayList<Double>());
                Customer C1 = customers.get(cust);
                System.out.println("Customer : " + C1.getCustomerName() );
                ArrayList<Double> transactions = C1.getTransactions();
                for (int tr=0; tr<transactions.size(); tr++) {
                    System.out.println((tr+1) + " : " + transactions.get(tr));
                }
            }
        }
    }


    public void printCustomerDetails (String customer) {
        double balance = 0;
        Customer C1 = findCustomer(customer);
        if (C1 != null) {
            System.out.println("Transactions for the customer " + customer + " linked ------> " + getBranchName(this.branchCode));
            ArrayList<Double> transactions = C1.getTransactions();
            for (int tr=0; tr<transactions.size(); tr++) {
                System.out.println((tr+1) + " : " + transactions.get(tr));
                balance += transactions.get(tr);
            }
            System.out.println("IFNO: current balance of " + customer + " = " + balance);
        } else {
            System.out.println("ERROR: " + customer + " is not a BOA customer");
        }

    }

    private Customer findCustomer (String customer)  {
        //Boolean custStatus = false;
        for (int br = 0; br < branchesOfBank.size(); br++) {
            ArrayList<Customer> customers = this.branchesOfBank.get(br);
            for (int cust = 0; cust < customers.size(); cust++) {
                Customer C1 = customers.get(cust);
                if (C1.getCustomerName().equals(customer)) {
                    this.customerStatus = true;
                    this.branchCode = br;
                    return C1;
                }
            }
        }
        if (!this.customerStatus) {
            //this.customerStatus = false;
            System.out.println(customer + " is not a BOA customer");
        }
        return null;
    }

    private int customerExists (String customer) {
        //Boolean custStatus = false;
        return unisqCustomerList.indexOf(customer);
    }


    public String getBranchName(int brCode) {
        switch (brCode) {
            case 0:
                return "BOA Corporate Branch";
            case 1:
                return "BOA Seattle Branch";
            case 2:
                return "BOA Redmond Branch";
            case 3:
                return "BOA Bellevue Branch";
            case 4:
                return "BOA Renton Branch";
        }
        return "BOA Corporate Branch";
    }

    public void printBranchDetails() {
        for (int i = 0; i < this.branchesOfBank.size(); i++) {
            ArrayList<Customer> brName = this.branchesOfBank.get(i);
            switch (i) {
                case 0:
                    System.out.println("BOA Corporate Branch: customers linked to the Branch    = " + brName.size());
                    break;
                case 1:
                    System.out.println("BOA Seattle Branch: customers linked to the Branch      = " + brName.size());
                    break;
                case 2:
                    System.out.println("BOA Redmond Branch: customers linked to the Branch      = " + brName.size());
                    break;
                case 3:
                    System.out.println("BOA Bellevue Branch: customers linked to the Branch     = " + brName.size());
                    break;
                case 4:
                    System.out.println("BOA Renton Branch: customers linked to the Branch       = " + brName.size());
                    break;
                default:
                    System.out.println("ERROR: No bank branch specified");
                    break;
            }
        }
    }

}