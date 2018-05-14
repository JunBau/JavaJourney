package com.JunBau;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getName() + ": I cannot fly. I will swim!");
    }

}
