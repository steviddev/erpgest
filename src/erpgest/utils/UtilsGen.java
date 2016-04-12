/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erpgest.utils;

import erpgest.MainFrame;

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
}
