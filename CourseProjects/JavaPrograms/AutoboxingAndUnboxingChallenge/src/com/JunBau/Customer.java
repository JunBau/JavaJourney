package com.JunBau;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addTransaction(Double dbl) {
        transactions.add(dbl);
        System.out.println("Transaction added " + dbl);
    }

    public static Customer addCustomer(String name) {
        return new Customer(name);
    }

}
