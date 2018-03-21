package com.JunBau;

public class Main {

    public static void main(String[] args) {

        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0, 2.0));

        for (int i=0; i<2; i++ ) {
            System.out.println("The value is currently: " +i);
        }

        for (int rate=2; rate<9; rate++ ) {
            System.out.println("10,000 at " + rate + "%" + " is equal to " + String.format ("%.2f",calculateInterest(10000.0, rate)));
        }

        System.out.println("Below is the second challenge. Reverse above.");

        for (int rate=8; rate>1; rate-- ) {
            System.out.println("10,000 at " + rate + "%" + " is equal to " + String.format ("%.2f",calculateInterest(10000.0, rate)));
        }

        int count = 0;

        for (int prime=3; prime<50; prime++) {
             if (isPrime(prime)){
                 System.out.println("the number " + prime + " is prime!");
                 count++;
                 System.out.println("count is now: " + count);
             }

             if (count == 3) {
                 System.out.println("The count is now 3, breaking out!");
                 break;
             }

            }
        }

    public static boolean isPrime(int n) {
        if(n == 1 ){
            return false;
        }

        for (int i=2; i<= n/2; i++) {
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount*(interestRate/100));

    }
}
