package com.JunBau;

import java.util.ArrayList;

public class Branches {

    private String branchName;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getCustName(int i) {
        return customers.get(i).getName();
    }

    public Branches(String branchName) {
        this.branchName = branchName;
    }

    public Branches(String branchName, ArrayList<Customer> customers) {
        this.branchName = branchName;
        this.customers = customers;
    }

    public void addCustomer(String cusName) {
        customers.add(Customer.addCustomer(cusName));
    }

    public static Branches addBranch(String name) {
        return new Branches(name);
    }

    public String printCusName(int i) {
        return customers.get(i).getName();
    }

    public void addTransaction(String custName, double value) {
        customers.get(findCustomer(custName)).addTransaction(value);
    }

    public void printTransactions(String custName) {
        System.out.println("The following transactions under " + custName);
        for(int i =0; i < customers.get(findCustomer(custName)).getTransactions().size(); i++) {
            System.out.println(customers.get(findCustomer(custName)).getTransactions());
        }
    }

    private int findCustomer(String cusSearchName) {
        for (int i=0; i < customers.size(); i++) {
            Customer cus = customers.get(i);

            if(cus.getName().equals(cusSearchName)) {
                return i;
            }
        }
        return -1;
    }
}
