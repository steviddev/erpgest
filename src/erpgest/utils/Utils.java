/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.utils;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author pino
 */
public class Utils {
    
    public static void ResultSetClose(ResultSet rSet, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e1) {
        }
        try {
            statement = null;
        } catch (Exception e1) {
        }
        try {
            if (rSet != null) {
                rSet.getStatement().close();
            }
        } catch (Exception e1) {
        }
        try {
            if (rSet != null) {
                rSet.close();
            }
        } catch (Exception e1) {
        }
        try {
            rSet = null;
        } catch (Exception e1) {
        }
    } 
    
    public static String roundDoubleToString(double myDouble) {
        int decimalPlace = 3;

        //BigDecimal bd = new BigDecimal(myDouble);
        BigDecimal bd = new BigDecimal(Math.ceil(myDouble * 20) / 20);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.toPlainString();
        //myDouble = bd.doubleValue();
        //return myDouble;
    }
    
   public static Double roundDouble(double myDouble) {
        int decimalPlace = 3;

        BigDecimal bd = new BigDecimal(myDouble);
        //BigDecimal bd = new BigDecimal(Math.ceil(myDouble * 20) / 20);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        //return bd.toPlainString();
        return bd.doubleValue();
        // myDouble = bd.doubleValue();
        //return myDouble;
    }    
    public static Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }   
    
    public static int daysBetween(String d1, String d2) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date data1 = dateFormat.parse(d1);
            Date data2 = dateFormat.parse(d2);
            return Math.abs((int) ((data1.getTime() - data2.getTime()) / (1000 * 60 * 60 * 24)));
        } catch (ParseException e) {
            // If a ParseException was produced, show an error message.
            //System.out.println("The date format is incorrect.");
        }
        return -1;
    }

    public static int daysBetween(Date d1, Date d2) {

        return Math.abs((int) ((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24)));

    } 
    
    public static int minutesBetweenDatesAndTime(Date laterDate,Date earlierDate){
        long result = ((laterDate.getTime()/60000) - (earlierDate.getTime()/60000));
        return (int) result;    
    }

    public static String jSONManager(String key){
        
        return "";
    }
    
    public static void logError(Exception e, String message, boolean standardError) {
        try {
            String strData = ((Calendar.getInstance()).getTime()).toString();
            PrintStream appoggio;
            PrintStream stderr = new PrintStream(new FileOutputStream(".\\" + "LOGERROR.txt", true));
            stderr.println("/------------------------INIZIO----------------------------/");
            stderr.println(strData);
            stderr.println(message);
            if (standardError) {
                appoggio = System.err;
                System.setErr(stderr);
                e.printStackTrace();
                System.setErr(appoggio);
                appoggio = null;
            }
            stderr.println("/-------------------------FINE---------------------------/");
            stderr.println("");
            stderr.close();
            stderr = null;

        } catch (Exception ex) {
        }

    }    
}
