package com.example.feproject.inventory;

/*
 * Item is a game object that can be held by a game unit
 * Items will interchange between a unit and the Convoy
 * Items have a name, a value, a description, quantity
 * */

import java.util.Comparator;

public class Item {

    protected String name, description;
    protected int value, quantity;

    public Item() {}


    // getters
    public int getValue() {

        return value;

    }

    public int getQuantity() {

        return quantity;

    }

    public String getName() {

        return name;

    }

    public String getDescription() {

        return description;

    }

    public static class ItemComparable implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {

            // https://www.geeksforgeeks.org/java/compare-objects-by-multiple-fields-in-java/

            // compare by name
            int nameComparison = o1.name.compareTo(o2.name);
            if (nameComparison != 0) {

                return nameComparison;

            }

            int valComparison = o1.value - o2.value;
            if (valComparison != 0) {

                return valComparison;

            }

            // if both the name and the value compare by quantity
            return o1.getQuantity() - o2.getQuantity();
        }

    }

}