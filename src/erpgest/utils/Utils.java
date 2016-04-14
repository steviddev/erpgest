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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

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

    public static boolean validaCF(String cf) {

        if (cf == null || cf.equals("") || cf.length() != 16) {
            return false;
        }

        int i, s, c;
        String cf2;
        int setdisp[] = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20,
            11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23};
        if (cf.length() == 0) {
            return false;
        }
        if (cf.length() != 16) {
            return false;
        }
        cf2 = cf.toUpperCase();
        for (i = 0; i < 16; i++) {
            c = cf2.charAt(i);
            if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'Z')) {
                return false;
            }
        }
        s = 0;
        for (i = 1; i <= 13; i += 2) {
            c = cf2.charAt(i);
            if (c >= '0' && c <= '9') {
                s = s + c - '0';
            } else {
                s = s + c - 'A';
            }
        }
        for (i = 0; i <= 14; i += 2) {
            c = cf2.charAt(i);
            if (c >= '0' && c <= '9') {
                c = c - '0' + 'A';
            }
            s = s + setdisp[c - 'A'];
        }
        if (s % 26 + 'A' != cf2.charAt(15)) {
            return false;
        } else {
            return true;
        }
    }

    public class CFException extends Exception {

        public CFException() {
            super("Errore: Il Codice Fiscale inseirto non è valido.");
        }
    }
    
    public static String ControllaPIVA(String pi)
    {
        int i, c, s;
        if( pi.length() == 0 )  return "";
        if( pi.length() != 11 )
            return "La lunghezza della partita IVA non è\n"
            + "corretta: la partita IVA dovrebbe essere lunga\n"
            + "esattamente 11 caratteri.\n";
        for( i=0; i<11; i++ ){
            if( pi.charAt(i) < '0' || pi.charAt(i) > '9' )
                return "La partita IVA contiene dei caratteri non ammessi:\n"
                + "la partita IVA dovrebbe contenere solo cifre.\n";
        }
        s = 0;
        for( i=0; i<=9; i+=2 )
            s += pi.charAt(i) - '0';
        for( i=1; i<=9; i+=2 ){
            c = 2*( pi.charAt(i) - '0' );
            if( c > 9 )  c = c - 9;
            s += c;
        }
        if( ( 10 - s%10 )%10 != pi.charAt(10) - '0' )
            return "La partita IVA non è valida:\n"
            + "il codice di controllo non corrisponde.";
        return "";
    }    
    
    public static void logError(Exception e, String message, boolean standardError) {
        try {
            String strData = ((Calendar.getInstance()).getTime()).toString();
            PrintStream appoggio;
            PrintStream stderr = new PrintStream(new FileOutputStream("LOGERROR.txt", true));
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
