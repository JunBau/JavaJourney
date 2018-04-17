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

    public Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public void addTransaction(Double dbl) {
        transactions.add(dbl);
        System.out.println("Transaction added " + dbl);
    }

    public static Customer addCustomer(String name) {
        return new Customer(name);
    }

    public Double printTrans(int i) {
        return transactions.get(i);
    }



}
