package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */


import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportSingleList {

    public static void ExportSingleList(ArrayList<Assignment4.Item> MainList){
        //Creates a file in directory src/exportname (Text Area + button press)
        //Contains a format that will allow it to be imported again
        int count = 0;

        try{
            FileWriter writer = new FileWriter("src/ExportFile.txt");

            for (Assignment4.Item Str: MainList){
                writer.write(Str.Name + "," + Str.Complete + "," + Str.Description + "," + Str.DueDate);
                if (count != MainList.size()-1){
                    writer.write("\n");
                    count++;
                }

            }

            writer.flush();
            writer.close();

        } catch (IOException e){
            System.out.println("File read error");
        }

    }
}
