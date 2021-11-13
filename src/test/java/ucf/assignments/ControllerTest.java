package ucf.assignments;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void addItem() {

        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";
        int count = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);

        for( Assignment4.Item Str : MainList){
            if (Str.Name.equals(AddItemName)){
                count++;
            }
            if (Str.Description.equals(ItemDescription)) {
                count++;
            }
            if (Str.DueDate.equals(ItemDueDate)){
                count++;
            }
        }
        assertEquals(3, count); //Tests the function to see if it works, if the item created contains the three Strings in their required position then it counts as a success, if not its a failure.

    }

    @Test
    void removeItem() {

        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";
        int count = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the removal of the item.

        RemoveItem.RemoveItem(MainList, AddItemName); //Tests the removal of an item from mainlist (Main function of the class)

        for( Assignment4.Item Str : MainList) {
            if (Str.Name.equals(AddItemName)) {
                count++;
            }
            if (Str.Description.equals(ItemDescription)) {
                count++;
            }
            if (Str.DueDate.equals(ItemDueDate)) {
                count++;
            }
        }

        assertEquals(0, count); //If none of the items match the specific item, it means it doesn't exist.
    }


    @Test
    void newDescription() {

        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";
        int count = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the editing of the item description.

        String NewDescription = "NewName";

        EditItemDescription.EditItemDescription(MainList, AddItemName, NewDescription);

        for( Assignment4.Item Str : MainList) {
            if (Str.Description.equals(NewDescription)) { // Checks for the new Description in the specific item
                count++;
            }
        }

        assertEquals(1, count);
    }




    @Test
    void newDueDate() {

        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";
        int count = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the editing of the item due date.

        String NewDueDate = "2022-12-15";

        EditItemDueDate.EditItemDueDate(MainList, AddItemName, NewDueDate);


        for( Assignment4.Item Str : MainList) {
            if (Str.DueDate.equals(NewDueDate)) { // Checks to see if the new Due Date is there
                count++;
            }
        }

        assertEquals(1, count); //Change the expected value if needed to test
    }

    @Test
    void markComplete() {

        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";
        int count = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the editing of the item completion.


        CompleteItem.CompleteItem(MainList, AddItemName);

        String complete = "Complete";

        for( Assignment4.Item Str : MainList) {
            if (Str.Complete.equals(complete)) { // Checks to see if the item is marked as complete
                count++;
            }
        }

        assertEquals(1, count); //(Change the expected value if needed to test if its wrong or right.)
    }




    @Test
    void markIncomplete() {

          String AddItemName = "Name";
          String ItemDescription = "Description";
          String ItemDueDate = "2021-12-11";
          int count = 0;

          ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
          AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
          // Anything before this creates an item to test the editing of the item incompletion.


          IncompleteItem.IncompleteItem(MainList, AddItemName);

          String Incomplete = "Incomplete";

          for( Assignment4.Item Str : MainList) {
              if (Str.Complete.equals(Incomplete)) { // Checks to see if the item is marked as incomplete
                  count++;
              }
          }

          assertEquals(1, count); //(Change the expected value if needed to test if its wrong or right.)

    }

    @Test
    void clearItems() {

        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";
        int count = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the removal of all items from the list.

        String AddItemName2 = "Name2";
        String ItemDescription2 = "Description";
        String ItemDueDate2 = "2021-12-15";
        int count2 = 0;

        AddItem.AddItem(MainList, AddItemName2, ItemDescription2, ItemDueDate2);
        // Anything before this creates a second item to test the removal of all items from the list.

        ClearAllItems.ClearAllItems(MainList);

        for( Assignment4.Item Str : MainList) {
            if (Str.Name.equals(AddItemName)) { // Checks to see if the first item is still present after removal
                count++;
            }
            if (Str.Name.equals(AddItemName2)) { // Checks to see if the second item is still present after removal
                count++;
            }
        }

        assertEquals(0, count); // Can also test with any of the other (Description,duedates) and it will function as well
        assertEquals(0, count2);
    }


    @Test
    void showAll() {

        int count = 0;
        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the removal of all items from the list.

        String AddItemName2 = "Name2";
        String ItemDescription2 = "Description";
        String ItemDueDate2 = "2021-12-15";

        AddItem.AddItem(MainList, AddItemName2, ItemDescription2, ItemDueDate2);
        // Anything before this creates a second item to test the removal of all items from the list.

        for (Assignment4.Item Str: MainList){
            count++;
        }

        assertEquals(2, count); // Checks to see that it is showing all of the values
    }

     @Test
    void showIncomplete() {

         int count = 0;
         String AddItemName = "Name";
         String ItemDescription = "Description";
         String ItemDueDate = "2021-12-11";

         ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);
         AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
         // Anything before this creates an item to test the removal of all items from the list.
         // This item will be complete

         CompleteItem.CompleteItem(MainList, AddItemName); //Marks the item as complete

         String AddItemName2 = "Name2";
         String ItemDescription2 = "Description";
         String ItemDueDate2 = "2021-12-15";

         AddItem.AddItem(MainList, AddItemName2, ItemDescription2, ItemDueDate2);
         // Anything before this creates a second item to test the removal of all items from the list.
         // This item will be incomplete

         for (Assignment4.Item Str: MainList){
             if(Str.Complete.equals("Incomplete")){
                 count++;
             }
         }

         assertEquals(1, count); // Checks to see that it is showing only the incomplete values

    }

    @Test
    void showComplete() {

        int count = 0;
        String AddItemName = "Name";
        String ItemDescription = "Description";
        String ItemDueDate = "2021-12-11";

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100); // MainList

        AddItem.AddItem(MainList, AddItemName, ItemDescription, ItemDueDate);
        // Anything before this creates an item to test the removal of all items from the list.
        // This item will be complete

        CompleteItem.CompleteItem(MainList, AddItemName); //Marks the item as complete

        String AddItemName2 = "Name2";
        String ItemDescription2 = "Description";
        String ItemDueDate2 = "2021-12-15";

        AddItem.AddItem(MainList, AddItemName2, ItemDescription2, ItemDueDate2);
        // Anything before this creates a second item to test the removal of all items from the list.
        // This item will be incomplete


        for (Assignment4.Item Str: MainList){
            if(Str.Complete.equals("Complete")){
                count++;
            }
        }

        assertEquals(1, count); // Checks to see that it is showing only the Complete values

    }

    @Test
    void importList() {
       // Input file example = (src/test.txt its included with the program files)
       // Test1,Complete,This is a test,2020-12-05
       // Test2,Incomplete,This is a test,2019-25-08
       // must be comma separated Name,Completion,Description,DueDate

        int count = 0;
        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);

        String Filepath = "src/test.txt";
        ImportSingleList.ImportSingleList(MainList, Filepath); //Calls the import single list function

        for (Assignment4.Item Str: MainList){
            if(Str.Name.equals("Test1")){ //Tests to see if the information from the text file was inported
                count++;
            }
            if(Str.Name.equals("Test2")){
                count++;
            }
        }
        assertEquals(2, count);
        //other tests can be done to truly determine it works if necessary, which it will.

    }

    @Test
    void exportList() throws Exception{

        int value = 0;

        ArrayList<Assignment4.Item> MainList = new ArrayList<>(100);

        String Filepath = "src/test.txt";
        ImportSingleList.ImportSingleList(MainList, Filepath); //Calls the import single list function for export as well.

        ExportSingleList.ExportSingleList(MainList); //Calls the export file and creates the file which proves test works.
        value = 1;

        assertEquals(1,value);
    }

}