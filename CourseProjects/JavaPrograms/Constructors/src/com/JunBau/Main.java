package com.JunBau;

public class Main {

    public static void main(String[] args) {

        BankAccount Halifax = new BankAccount(151188, 0.00, "bob", "hi@bob.com", "921301");
        System.out.println(Halifax.getAccountNumber());
        System.out.println(Halifax.getBalance());

        Halifax.depositFunds(1000);
        System.out.println(Halifax.getBalance());
        Halifax.withdrawFunds(500);
        System.out.println(Halifax.getBalance());
        Halifax.withdrawFunds(501);
        System.out.println(Halifax.getBalance());
//
//        BankAccount junsAccount = new BankAccount("Jun", "Jun@jun.com", "12345");
//        System.out.println(junsAccount.getAccountNumber() + " name: " + junsAccount.getCustomerName());


//        VipCustomer alpha = new VipCustomer("Alpha", 700.00, "Alpha@Contoso.com");
//        System.out.println("Name: " + alpha.getName() + " Limit: " + alpha.getCreditLimit() + " Email: " + alpha.getEmailAddress());
//
//        VipCustomer bravo = new VipCustomer("Bravo", "Bravo@Screwmicrosoft.com");
//        System.out.println("Name: " + bravo.getName() + " Limit: " + bravo.getCreditLimit() + " Email: " + bravo.getEmailAddress());
//
//        VipCustomer bob = new VipCustomer();
//        System.out.println("Name: " + bob.getName() + " Limit: " + bob.getCreditLimit() + " Email: " + bob.getEmailAddress());

    }
}
