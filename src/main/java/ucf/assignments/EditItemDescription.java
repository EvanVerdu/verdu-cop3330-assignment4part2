package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import java.util.ArrayList;

public class EditItemDescription {

    public static void EditItemDescription(ArrayList<Assignment4.Item> MainList, String DescriptionName, String DescriptionNewZ){
        //Scans user input after they type in the text area and press the edit description button.
        //Searches for the item and changes its description

        for (Assignment4.Item Str: MainList){
            if (Str.Name.equals(DescriptionName)){
                Str.Description = DescriptionNewZ;
            }
        }

    }
}
