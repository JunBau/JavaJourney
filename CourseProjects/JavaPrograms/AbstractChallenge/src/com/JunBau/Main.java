package com.JunBau;

public class Main {

    public static void main(String[] args) {

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringData = "10 5 6 3 8 5 39 245";

        String[] data = stringData.split(" ");
        for (String v : data) {
            tree.addItem(new Node(v));
        }

        tree.traverse(tree.getRoot());

        // The custom list will order the list alphabetically according to the first character. for numbers, it will order it
        // in regards to the first number (Not the whole.) This is an effect of using the "Compare to function".

        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("39"));
        tree.removeItem(new Node("8"));
        tree.traverse(tree.getRoot());
    }
}
