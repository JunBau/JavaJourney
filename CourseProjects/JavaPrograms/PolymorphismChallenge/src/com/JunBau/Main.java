package com.JunBau;

public class Main {

    public static void main(String[] args) {

        BMW test = new BMW();

        System.out.println(test.getName());
        test.accelerate(true);
        test.startEngine();

        Car test2 = new Car(2,"Fiat");
        System.out.println(test2.getName());
        test2.accelerate(true   );
        test2.startEngine();

    }
}
