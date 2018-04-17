package com.JunBau;

import java.util.ArrayList;

/**
 * Created by eanjtab on 7/30/2017.
 */

public class Customer {
    private String customerName;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    private static Bank BOA =  new Bank("BOA");

    public Customer(String customerName, ArrayList<Double> transactions) {
        this.customerName = customerName;
        this.transactions = transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }


}