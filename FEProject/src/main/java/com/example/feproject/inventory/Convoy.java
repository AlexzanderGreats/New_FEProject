package com.example.feproject.inventory;

import java.util.ArrayList;

/*
 *
 * Convoy: collective inventory between player units
 *
 * During in-game only the player unit will be able to access the Convoy.
 * Convoy stores all items.
 * */

public class Convoy {

    ArrayList<Item> items;

    Convoy(){

        items = new ArrayList<>();

    }

    public void addItem(Item item){

        items.add(item);

    }

    public ArrayList<Item> getItems(){

        return items;

    }

    public Item getItem(int index){

        return items.get(index);

    }

    // user would like to get an item by its name
    // issue: multiple items by the same name
    public ArrayList<Item> getItem(String name) throws Exception{

        // Sort Our List by Name (O(n Log n))
        items.sort(new Item.ItemComparable());

        int left = 0;
        int right = items.size() -1;
        int foundIndex = -1;

        // Binary Search
        while (left <= right) {

            int mid = (left + right) / 2;
            int cmp = items.get(mid).getName().compareTo(name);

            if (cmp == 0) {

                foundIndex = mid;
                break;

            }

            else if (cmp < 0) {

                left = mid + 1;

            }

            else {

                right = mid - 1;

            }

        }

        if (foundIndex == -1) {

            throw new Exception("[Error]! [Item] Not [Found]!");

        }

        // Collecting All Matches
        ArrayList<Item> result = new ArrayList<>();

        //Scan left
        int i = foundIndex;
        while (i >= 0 && items.get(i).getName().equals(name)) {

            i--;

        }

        i++; // Move back to first match

        while (i < items.size() && items.get(i).getName().equals(name)) {

            result.add(items.get(i));
            i++;

        }

        return result;

    }

}