package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.ArrayList;

public class CompleteItem {

    public static void CompleteItem(ArrayList<Assignment4.Item> MainList, String Marks1){
        //Gets input from user (Specific List, and item) + button press.
        //Marks an Item as complete

        for (Assignment4.Item Str: MainList){
            if (Str.Name.equals(Marks1)){
                Str.Complete = "Complete";
            }
        }

    }
}
