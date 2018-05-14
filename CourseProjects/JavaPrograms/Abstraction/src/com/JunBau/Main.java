package com.JunBau;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Dog dog = new Dog("Husky");
        dog.breathe();
        dog.eat();

        Parrot bird = new Parrot("Polly");
        bird.breathe();
        bird.eat();
        bird.fly();

        Penguin penguin = new Penguin("Bruh");
        penguin.fly();
    }

    // Interface (implements) has a relation ship, abstract (extends) is a relationship
}
