package com.JunBau;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer HP = new Printer(100,false);

        System.out.println(HP.getTonerLevel());
        HP.printPage(3);
        System.out.println(HP.getTonerLevel());

        HP.addToner(10);

        HP.printPage(1);

        System.out.println(HP.getTonerLevel());


    }
}
