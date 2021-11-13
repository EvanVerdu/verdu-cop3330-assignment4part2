package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Assignment4 extends Application {

      @Override
      public void start(Stage PrimaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("/SceneBuilder2.fxml"));

                PrimaryStage.setScene(new Scene(root));
                PrimaryStage.show();
      }


      public static void main(String[] Args){

          launch(Args);
      }


    //Lets the ArrayLists store items with a name, description and due date.
    public static class Item {
        public String Name;
        public String Description;
        public String DueDate;
        public String Complete;
    }

}
