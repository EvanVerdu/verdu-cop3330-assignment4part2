package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportSingleList {

    public static void ImportSingleList(ArrayList<Assignment4.Item> MainList, String FilePath) {
        //Asks user input for a file path (Text Area + button press)
        //Will read and format file so that it is visible in the GUI of the Application

        //read user input for file path
        //reads the information on the file
        //will parse the information into MainList and display the single list for the user to see

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));


            String str;
            int counter = 0; // Makes sure the number of items doesn't exceed 100

            while ((str = reader.readLine()) != null && counter < 100){ //Reads the file separates by each line

                Assignment4.Item New = new Assignment4.Item(); //Reads the file and creates an item from the information on the file.
                String[] values = str.split(",", 4);

                  int count = 0;
                  for (String s : values){
                      for (int i = 0; i < 4; i++){
                         if (count == 0){
                             New.Name = s;
                         }
                         else if (count == 1){
                             New.Complete = s;
                         }
                         else if (count == 2){
                             New.Description = s;
                         }
                         else if (count == 3){
                             New.DueDate = s;
                         }
                      }
                      count++;
                  }

                MainList.add(New);  //adds the item to the list
                counter++;
            }

        } catch (IOException e){
            System.out.println("File read error");
        }


    }

}
