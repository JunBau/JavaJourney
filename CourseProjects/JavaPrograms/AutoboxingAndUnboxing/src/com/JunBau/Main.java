package com.JunBau;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i= 0; i < 10; i++) {
            integerArrayList.add(Integer.valueOf(i));
        }

        for (int i=0; i < integerArrayList.size(); i++) {
            System.out.println(integerArrayList.get(i).intValue());
        }

        Integer myIntValue = 56; // Integer.valueOf(56)
        int myInt = myIntValue; // myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(dbl);
        }

        for (int i=0; i < myDoubleValues.size() ; i++) {
            double value = myDoubleValues.get(i);
            System.out.println(i + " ----->" + value);
        }


    }

}
