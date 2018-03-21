package com.JunBau;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // int has a width of 32
        int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myTotal = (myMinValue/2);
        System.out.println(myTotal);

        // short has a width of 16
        short myShortValue = -32768;
        short myMaxShort = 32767;
        short myTotalShort = (short) (myShortValue/2);
        System.out.println(myTotalShort);

        // byte has a width of 8
        byte myByteValue = -128;
        byte myMaxByte = 127;
        byte myTotalByte = (byte) (myByteValue/2);
        System.out.println(myTotalByte);

        // long has a width of 64
        long myLongValue = 100L;

        // Long and INT does not require declaration, Java favors them. Shorts and Bytes need to declared.


    }
}
