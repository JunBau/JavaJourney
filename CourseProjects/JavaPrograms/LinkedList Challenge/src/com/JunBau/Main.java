package com.JunBau;

public class Main {

    public static void main(String[] args) {
	// write your code here

        defaultburger hamburger = new defaultburger("Brioche", "Beef", true,true,false,false);

        System.out.println(hamburger.getBaseCost());

        System.out.println(hamburger.getTotalCost());

        healthBurger gains = new healthBurger("Beef", false,false,false,false,true,false);
        System.out.println(gains.getBaseCost());
        System.out.println(gains.getTotalCost());

        deluxeBurger fatShit = new deluxeBurger("White", "Beef", true, false);
        System.out.println(fatShit.getBaseCost());
        System.out.println(fatShit.getTotalCost());

}
}
