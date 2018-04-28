package com.JunBau;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        inOrder(placesToVisit, "Sidney");
        inOrder(placesToVisit, "Melbourne");
        inOrder(placesToVisit, "Brisbane");
        inOrder(placesToVisit, "Perth");
        inOrder(placesToVisit, "Canberra");
        inOrder(placesToVisit, "Adelaide");
        inOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        inOrder(placesToVisit, "Arkham");
        inOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void visit(LinkedList cities) {
        Scanner userInput = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities within the list.");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printVisitMenu();
        }

        while (!quit) {
            int action = 3;

            try {
                action = userInput.nextInt();
            } catch (Exception actionInt) {
                System.out.println("Invalid input.");
                userInput.nextLine();
            }

            switch (action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("No more cities to visit.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("Back to the beginning.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printVisitMenu();
                    break;
            }
        }

    }

    private static void printVisitMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - To quit");
        System.out.println("1 - To move to the next city");
        System.out.println("2 - To move to the previous city");
        System.out.println("3 - To show the menu");
    }

    // Print the list to screen method.

    private static void printList(LinkedList<String> linkedlist){
        Iterator<String> i= linkedlist.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("===============================");
    }

    // This method will add a String to the Arraylist and will sort it in alphabetical order.

    private static boolean inOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0) {
                //equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if(comparison > 0) {
                //new city should appear before this one
                //alphabetise
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on to next city
            }
        }

        stringListIterator.add(newCity);
        return true;
    }
}
