package com.JunBau;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private ArrayList<Contacts> phoneBook = new ArrayList<Contacts>();
    private Scanner scanner = new Scanner(System.in);

    public void addContact(String name, String Number) {
        phoneBook.add(Contacts.addContact(name, Number));
        System.out.println("Added " + name + " with the number: " + Number);
    }

    public void printContact() {
        System.out.println("The following are stored: ");
        for (int i = 0; i < phoneBook.size(); i++) {
            System.out.println((i + 1) + ". Name: " + phoneBook.get(i).getContactName()
                    + "         Number: " + phoneBook.get(i).getNumber());
        }
    }

    public void removeContact(String name) {
        int position = findItem(name);
        if (position >= 0) {
            removeContact(position);
            System.out.println(name + " has been removed.");
        } else {
            System.out.println(name + " doesn't match a record.");
        }
    }

    private void removeContact(int position) {
        phoneBook.remove(position);
        System.out.println((position + 1) + " has been removed.");
    }

    public void updateContact(String currentName, String newName, String newNo) {
        int position = findItem(currentName);
        if (position >= 0) {
            updateContact(position,newName,newNo);
        }
    }

    private void updateContact(int position, String name, String number) {
        phoneBook.set(position, Contacts.addContact(name, number));
        System.out.println("Name " + (position+1) + " has been modified.");
    }

    private int findItem(String searchName) {
        // here we are going through the ArrayList and are going to perform a check.
        for (int i = 0; i < phoneBook.size(); i++) {
            Contacts contact = phoneBook.get(i);
            //this is the check, it's basically saying, if the given parameter "searchName" done by user input matches a contact name in the array list
            // it will return the element number that the match is from.
            if (contact.getContactName().equals(searchName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean onFile(String searchName) {
        int position = findItem(searchName);
        if(position >= 0) {
            return true;
        }
        return false;
    }
}
