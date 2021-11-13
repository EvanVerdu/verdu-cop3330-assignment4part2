package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Evan Verdu
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CheckDateValidity {

    //Checks to make sure the date is in the gregorian calendar and in the specific format.
    public static int DateValidity(String Date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            format.parse(Date);
            return 1;
        } catch (ParseException e) {
            return 0;
        }
    }

}
