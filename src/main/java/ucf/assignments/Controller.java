package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {

    //intializes each of the items on the GUI
    @FXML
    public TextField AddItemNames;
    @FXML
    public TextField ItemDescriptions;
    @FXML
    public TextField ItemDueDates;
    @FXML
    public TextField RemoveItemNames;
    @FXML
    public TextField DescriptionNames;
    @FXML
    public TextField DescriptionNew;
    @FXML
    public TextField DueDateNames;
    @FXML
    public TextField DueDateNew;
    @FXML
    public TextField Mark;
    @FXML
    public TextField ImportItemslists;
    @FXML
    public TextField DisplayInfo;

    @FXML
    public ListView<String> ItemList;
    @FXML
    public TextArea Textarea;



    ArrayList<Assignment4.Item> MainList = new ArrayList<>(100); // Creates the List

    //Creates an item in the list
    public void AddItem(javafx.event.ActionEvent actionEvent) {

        String AddItemName = AddItemNames.getText();
        String ItemDescription = ItemDescriptions.getText();
        String ItemDueDate = ItemDueDates.getText();

        for (Assignment4.Item Str: MainList){    //Makes it so each item must have a unique name
            if (Str.Name.equals(AddItemName)){
                return;
            }
        }

        if(ItemDescription.length()<1 || ItemDescription.length()>256){ //Makes it so Description can't be smaller than 1 or bigger than 256
            return;
        }


        if(!ItemDueDate.matches("\\d{4}-\\d{2}-\\d{2}")){     //Makes it so the item cannot be created if the DueDate is not in the correct format or not a valid date
            return;
        }
        if(CheckDateValidity.DateValidity(ItemDueDate) == 0){     //Makes it so the item cannot be created if the DueDate is not in the correct format or not a valid date
            return;
        }

        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate); //Adds the item to the MainList
        ItemList.getItems().add(AddItemName); //Adds Item to the list view
    }



    //Removes an item from the List
    public void RemoveItem(javafx.event.ActionEvent actionEvent) {
        String RemoveItemName = RemoveItemNames.getText();
        RemoveItem.RemoveItem(MainList, RemoveItemName); //Removes item from the array list
        ItemList.getItems().remove(RemoveItemName); //Removes Item from the list view
    }



    //Edits the description of an item
    public void NewDescription(javafx.event.ActionEvent actionEvent){
        String DescriptionName = DescriptionNames.getText();
        String DescriptionNewZ = DescriptionNew.getText();

        if(DescriptionNewZ.length()<1 || DescriptionNewZ.length()>256){ //Makes it so Description can't be smaller than 1 or bigger than 256
            return;
        }

        EditItemDescription.EditItemDescription(MainList, DescriptionName, DescriptionNewZ);
    }



    //Edits the due date of an item
    public void NewDueDate(javafx.event.ActionEvent actionEvent){
        String DueDateName = DueDateNames.getText();
        String DueDateNewZ = DueDateNew.getText();

        if(!DueDateNewZ.matches("\\d{4}-\\d{2}-\\d{2}")){     //Makes it so the item cannot be created if the DueDate is not in the correct format
            return;
        }
        if(CheckDateValidity.DateValidity(DueDateNewZ) == 0){     //Makes it so the item cannot be created if the DueDate is not in the correct format or not a valid date
            return;
        }

        EditItemDueDate.EditItemDueDate(MainList, DueDateName,DueDateNewZ);
    }



    //Marks the item on the list view as complete, //When Item.Complete = 0 its incomplete, when Item.Complete = 1 its complete.
    public void MarkComplete(javafx.event.ActionEvent actionEvent){
        String Marks1 = Mark.getText();
        CompleteItem.CompleteItem(MainList, Marks1);

    }



    //Marks the item on the list view as incomplete //When Item.Complete = 0 its incomplete, when Item.Complete = 1 its complete.
    public void MarkIncomplete(javafx.event.ActionEvent actionEvent){
        String Marks2 = Mark.getText();
        IncompleteItem.IncompleteItem(MainList, Marks2);
    }



    //Clears all items in the list and the list view
    public void ClearItems(javafx.event.ActionEvent actionEvent){
        ClearAllItems.ClearAllItems(MainList);
        ItemList.getItems().clear();
    }


    //Shows all items on the list
    public void ShowAll(javafx.event.ActionEvent actionEvent){
        ItemList.getItems().clear();
        for (Assignment4.Item Str: MainList){
            ItemList.getItems().add(Str.Name);
        }
    }


    //Shows only the incomplete items in the list
    public void ShowIncomplete(javafx.event.ActionEvent actionEvent){
        ItemList.getItems().clear();
        for (Assignment4.Item Str: MainList){
            if(Str.Complete.equals("Incomplete")){
                ItemList.getItems().add(Str.Name);
            }
        }
    }


    //Shows only the complete items in the list
    public void ShowComplete(javafx.event.ActionEvent actionEvent){
        ItemList.getItems().clear();
        for (Assignment4.Item Str: MainList){
            if(Str.Complete.equals("Complete")){
                ItemList.getItems().add(Str.Name);
            }
        }
    }


    //Gathers and parses information from a file, and adds the information to the list view and the main list
    public void ImportList(javafx.event.ActionEvent actionEvent) {
        String ImportItemsListFilePath = ImportItemslists.getText();
        ImportSingleList.ImportSingleList(MainList, ImportItemsListFilePath);
        for (Assignment4.Item Str: MainList){
            ItemList.getItems().add(Str.Name);
        }
    }


    //Exports all the data from the mainlist into a file that would also be ready for import
    public void ExportList(javafx.event.ActionEvent actionEvent){
        ExportSingleList.ExportSingleList(MainList);
    }


    //Displays the information of the item of which the name is inputted and the button is pressed onto the text area.
    public void DisplayInformationArea(javafx.event.ActionEvent actionEvent){
        String Displayinfo = DisplayInfo.getText();
        Textarea.setEditable(false);

        for (Assignment4.Item Str: MainList){
            if (Str.Name.equals(Displayinfo)){
                Textarea.setText("Item Name: " + Str.Name + ".\n" +              //Item Name Display
                                 "Item Completion: " + Str.Complete + ".\n" +    //Item Completion Display
                                 "Item DueDate: " + Str.DueDate + ".\n" +        //Item DueDate Display
                                 "Item Description: " + Str.Description);  //Item Description Display
            }
        }
    }


    public void Help(javafx.event.ActionEvent actionEvent) throws Exception{
        Stage HelpStage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        Pane root = FXMLLoader.load(getClass().getResource("/Help!.fxml"));

        HelpStage.setScene(new Scene(root));
        HelpStage.showAndWait();

    }



}
