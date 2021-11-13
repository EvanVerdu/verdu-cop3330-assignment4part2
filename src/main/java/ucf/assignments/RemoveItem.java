package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.ArrayList;

public class RemoveItem {

    public static void RemoveItem(ArrayList<Assignment4.Item> MainList, String RemoveItemName){
        // gathers name of item to remove from user in text area and after pressing the remove item button.
        // Removes Item

        MainList.removeIf(Str -> Str.Name.equals(RemoveItemName));

    }

}
