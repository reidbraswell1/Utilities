/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilities.date_utilities;

import com.utilities.constants.Constants;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateUtilities class to provide methods 
 * to verify string dates.
 * 
 * @author reid
 */
public class DateUtilities {
   
    /**
     * Verify a given date time string passed
     * for verification. Returns true if the
     * date is good false otherwise.
     * 
     * @param timeString
     * @param dateFormat
     * @param locale
     * @return true or false 
     */
    public static boolean isDateValid(String timeString, String dateFormat, Locale locale) {
       
       try {
           DateFormat df = new SimpleDateFormat(dateFormat, locale); 
           df.setLenient(false);
           df.parse(timeString);
           return true;
       }//try//
       catch(Exception exc) {
           return false;
       }//catch//
    }//verifyDate//
    
    /**
     * Get the date for the given time string.
     * If the date is not valid return null.
     * 
     * @param timeString
     * @param dateFormat
     * @param locale
     * @return date
     */
    public static Date getDate(String timeString, String dateFormat, Locale locale) {

        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(dateFormat, locale);
            df.setLenient(false);
            date = df.parse(timeString);
            return date;
        }//try//
        catch(Exception exc) {
            return date;
        }//catch//
    }//getDate//
    
    public static String formatDate(Date date, String dateFormat, Locale locale) {
        
        DateFormat df = new SimpleDateFormat(dateFormat, locale);
        return df.format(date);
    }//formatDate//

/**
 * Main class to test.
 * 
 * @param args 
 */
public static void main(String[] args) {

    Locale locale = Locale.US;
    String timeString = null;
    
    timeString="03/04/2014 11:59 pm";
    if(isDateValid(timeString,Constants.DATE_FORMAT_MM_DD_YYYY_HH_MM_AM_PM,locale)) {
        System.out.println("Date " + timeString + " is good");
        Date date = null;
        date = getDate(timeString, Constants.DATE_FORMAT_MM_DD_YYYY_HH_MM_AM_PM, locale);
        String stringDate = null;
        stringDate = formatDate(date, Constants.DATE_FORMAT_YYYY_MM_DD_HH_MM, locale);
        System.out.println("New Date Format " + stringDate);
    }
    else
        System.out.println("Date " + timeString + " is bad");
    
    timeString="03/04/2014 12:30 zm";
    if(DateUtilities.isDateValid(timeString,Constants.DATE_FORMAT_MM_DD_YYYY_HH_MM_AM_PM,locale))
        System.out.println("Date " + timeString + " is good");
    else
        System.out.println("Date " + timeString + " is bad");
    
}//main//

}//DateUtilities//
