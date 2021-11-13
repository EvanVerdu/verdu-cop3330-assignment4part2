package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.ArrayList;

public class EditItemDueDate {

    public static void EditItemDueDate(ArrayList<Assignment4.Item> MainList, String DueDateName, String DueDateNewZ){
        //Scans user input after they type in the text area and press the edit due date button.
        //Searches the list and item and changes its due date

        for (Assignment4.Item Str: MainList){
            if (Str.Name.equals(DueDateName)){
                Str.DueDate = DueDateNewZ;
            }
        }

    }
}
