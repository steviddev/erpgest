/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erpgest.utils;

import erpgest.MainFrame;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class UtilsGen {
    public static void centraDialogo(MainFrame parent, javax.swing.JDialog dialog) {

        // Centro la casella sul Frame chiamante***************************//
        int xPos = (int) (parent.getLocation().getX()
                + (parent.getWidth() / 2) - (dialog.getWidth() / 2));
        int yPos = (int) (parent.getLocation().getY()
                + (parent.getHeight() / 2) - (dialog.getHeight() / 2));
        dialog.setLocation(xPos, yPos);
        //*****************************************************************//

    } 
    
    public static Map<String, String>  caricaConfigurazione() {
        //leggo il file di properties
        Properties properties = new Properties();
        Map<String, String> map;// = (Map)properties;        
        Map<String, String>  CONFIGURAZIONE = null;
        
//        Map properties = new Properties();
//        Map<String, String> map = new HashMap<String, String>(properties);
        try {
            properties.load(new FileInputStream("./system/sysconf.properties"));
            map = (Map) properties;
            CONFIGURAZIONE = map;

        } catch (Exception e) {
            //messaggio di errore e poi esce se non è presente
            Utils.logError(e, "", true);
        }
        return CONFIGURAZIONE;
    }        
    
}
