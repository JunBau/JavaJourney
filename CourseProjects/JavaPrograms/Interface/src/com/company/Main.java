package com.company;

public class Main {

    public static void main(String[] args) {

        ITelephone myPhone;
        myPhone = new DeskPhone(75632);
        myPhone.powerOn();
        myPhone.callPhone(75632);
        myPhone.answerPhone();

        myPhone = new MobilePhone(999);
        myPhone.powerOn();
        myPhone.dial(598);
        myPhone.callPhone(999);
        myPhone.answerPhone();

    }
}
