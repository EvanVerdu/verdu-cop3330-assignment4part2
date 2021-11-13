package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.ArrayList;

public class IncompleteItem {

    public static void IncompleteItem(ArrayList<Assignment4.Item> MainList, String Marks2){
        //Gets input from user (Specific List, and item) + button press.
        //Marks the item as incomplete

        for (Assignment4.Item Str: MainList){
            if (Str.Name.equals(Marks2)){
                Str.Complete = "Incomplete";
            }
        }

    }


}
