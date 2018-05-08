package com.company;

public interface ITelephone {

     void powerOn();
     void dial(int phoneNumber);
     void answerPhone();
     boolean callPhone(int phoneNumber);
     boolean isRinging();

}
