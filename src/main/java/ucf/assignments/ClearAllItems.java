package ucf.assignments;

import java.util.ArrayList;

public class ClearAllItems {

    public static void ClearAllItems(ArrayList<Assignment4.Item> MainList){
        //removes all the items of the list
        MainList.removeAll(MainList);
    }
}
