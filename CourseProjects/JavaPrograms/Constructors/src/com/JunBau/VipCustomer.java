package com.JunBau;

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipCustomer(String name, String emailAddress) {
        this(name, 500.00, emailAddress);
        System.out.println("Constructor, 1 default value.");
    }

    public VipCustomer() {
        this("Bob", 600.00,"Bob@Contoso.com");
        System.out.println("Default constructor called.");
    }

    public VipCustomer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
        System.out.println("Custom constructor called. All user input.");
    }

    public String getName() {
        return this.name;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
}
