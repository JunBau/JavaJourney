package com.JunBau;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        int[] myInteger = getIntegers(5);
        int[] sorted = sortIntegers(myInteger);
        printArray(myInteger);

        System.out.println("The sorted array are as follows...");
        printArray(sorted);




    }

    public static int[] getIntegers(int value) {
        System.out.println("Enter " + value + " integer values. \r");
        int[] values = new int[value];

        for(int i=0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArray(int[] myInteger) {
        for (int i = 0; i < myInteger.length; i++) {
            System.out.println("Element " + i + ", typed value was " + myInteger[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        for(int i=0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        int temp;

        // Only continue this loop until the flag is set to true.
        while(flag) {
            flag = false;
            // this will swap the lower values with the higher values... arrays always start at 0.
            for(int i=0; i<sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
