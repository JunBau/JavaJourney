package com.JunBau;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branches> bank = new ArrayList<Branches>();

    public Bank() {

    }

    public ArrayList<Branches> getBank() {
        return bank;
    }

    public Bank(ArrayList<Branches> bank) {
        this.bank = bank;
    }

    // Bank branch interactions

    public void defaultBranches () {
        bank.add(Branches.addBranch("Halifax"));
        bank.add(Branches.addBranch("Natwest"));
        bank.add(Branches.addBranch("Barclays"));
    }

    public void addBranch (String branchName) {
        bank.add(Branches.addBranch(branchName));
        System.out.println(branchName + " has been added.");
    }


    public void findingBranch (String searchName) {
        if(onFile(searchName)) {
            System.out.println(searchName + " exists.");
        } else {
            System.out.println(searchName + " Doesn't exist.");
        }
    }

    public void printBranches () {
        System.out.println("The following branches are available: ");
        for (int i = 0; i < bank.size() ; i++) {
            System.out.println((i + 1) + ": " + bank.get(i).getBranchName());
        }
    }

    // Bank branch validations

    public boolean onFile(String searchName) {
        int position = findBranch(searchName);
        if(position >= 0){
            return true;
        }
        return false;
    }

    private int findBranch(String searchName) {
        for(int i = 0; i < bank.size(); i++) {
            Branches banks = bank.get(i);

            if(banks.getBranchName().equals(searchName)) {
                return i;
            }
        }
        return -1;
    }

    // Customer interactions

    public void addCustomer(String branchName, String cusName) {
        bank.get(findBranch(branchName)).addCustomer(cusName);
        System.out.println("Added " + cusName + " to " + branchName);
    }

    public boolean custOnFile(String branchName, String custName) {
        int position = findCust(branchName,custName);
        if(position >= 0) {
            return true;
        }
        System.out.println(custName + " does not exist. ");
        return false;
    }

    private int findCust(String branchName, String custName) {
        for(int i = 0; i < bank.get(findBranch(branchName)).getCustomers().size(); i++) {

            if(bank.get(findBranch(branchName)).getCustName(i).equals(custName)) {
                return i;
            }
        }
        return -1;
    }

    public void printCustomer(String branchname) {
        System.out.println("The following belongs to " + branchname);
        for(int i = 0; i < bank.get(findBranch(branchname)).getCustomers().size(); i++) {
            System.out.println(bank.get(findBranch(branchname)).printCusName(i));
        }
    }

    // Customer transactions

    public void addTransaction(String branchName, String custName, double trans) {
        bank.get(findBranch(branchName)).addTransaction(custName, trans);
        System.out.println(trans + " has been added to " + custName
                + " under " + branchName);
    }

    public void printTrans(String branchName,String custName) {
        bank.get(findBranch(branchName)).printTransactions(custName);
    }


}
