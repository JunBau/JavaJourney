package com.JunBau;

import java.util.ArrayList;

public class ShoppingList {

    private ArrayList<String> shoppingList = new ArrayList<String>();

    public void addShoppingItem(String item) {
        shoppingList.add(item);
    }


    public ArrayList<String> getShoppingList() {
        return shoppingList;
    }

    public void printShoppingList() {
        System.out.println("You have " + shoppingList.size() + " items in your list");
        for (int i=0; i < shoppingList.size(); i++) {
            System.out.println((i+1) + ". " + shoppingList.get(i));
        }
    }

    public void updateItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            updateItem(position, newItem);
        }
    }

    public void removeItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeItem(position);
        }
    }


    private void updateItem(int position, String newItem) {
        shoppingList.set(position, newItem);
        System.out.println("Shopping item " + (position+1) + " has been modified.");
    }

    private void removeItem(int position) {
        shoppingList.remove(position);
        System.out.println("The item in position " + (position+1) + " has been removed." );
    }

    private int findItem(String searchItem) {
        return shoppingList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if(position >= 0) {
            return true;
        }
        return false;
    }

}
