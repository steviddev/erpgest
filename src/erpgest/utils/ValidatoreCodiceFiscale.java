/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.utils;

/**
 *
 * @author Stefano Vidili <www.stevid.it>
 */
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidatoreCodiceFiscale {

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

}
