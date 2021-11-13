package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import jdk.jfr.Description;

import java.util.ArrayList;

public class AddItem {

    //Adds an item to a specific List
    public static void AddItem(ArrayList<Assignment4.Item> MainList, String AddItemName, String ItemDescription, String ItemDueDate){
        // gathers input from user after typing in text areas and clicking the button (AddItem)
        // adds a class item type that holds the name, description and due date to the list.

        Assignment4.Item New = new Assignment4.Item();
        New.Name = AddItemName;
        New.Description = ItemDescription;
        New.DueDate = ItemDueDate;
        New.Complete = "Incomplete"; //Base value is incomplete for all items

        MainList.add(New);
    }


}
