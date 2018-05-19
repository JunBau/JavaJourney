package com.JunBau;

public class CustomList implements NodeList {

    private ListItem root = null;

    public CustomList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }


    // This is similar to how a linked list works...

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null) {
            // The list was empty. so this item becomes the first item.
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {

            int comparison = (currentItem.compareTo(item));

            if (comparison < 0) {
                // item is greater, move right if possible.
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // No next item, insert at the end of the list.
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }

            } else if (comparison > 0) {
                // item is less, insert before.
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
                } else {
                    // the node without a previous is a root.
                    item.setNext(this.root).setPrevious(item);
                    this.root = item;
                }
                return true;

            } else {
                // equal
                System.out.println(item.getValue() + " is already present, no addition.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting " + item.getValue());

        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison == 0) {
                // Found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0 ) {
                currentItem = currentItem.next();
            } else {
                // comparison > 0
                // we are at a item greater than the one to be deleted, unlisted item.

                return false;
            }
        }

        // We have reached the end of the list.
        // Without finding the item to delete.
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("List is empty.");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }



}
