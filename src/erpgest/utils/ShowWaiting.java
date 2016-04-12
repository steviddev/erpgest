/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.utils;

import erpgest.MainFrame;
import javax.swing.JFrame;

/**
 *
 * @author pino
 */
public class ShowWaiting implements Runnable {

    MainFrame mainFrame;
    javax.swing.JDialog jp;
    String message = "";

    public ShowWaiting(MainFrame mainFrame, javax.swing.JDialog _jp) {
        this.mainFrame = mainFrame;
        jp = _jp;
    }
    
    public ShowWaiting(MainFrame mainFrame, javax.swing.JDialog _jp,String message) {
        this.mainFrame = mainFrame;
        jp = _jp;
        this.message = message;
    }    

    @Override
    public void run() {
        if (jp == null) {
            if( message.equals("") ){
                mainFrame.waiting = new erpgest.utils.Waiting(mainFrame);
                mainFrame.waiting.setVisible(true);            
            }else{
                mainFrame.waiting = new erpgest.utils.Waiting(mainFrame,null,message);
                mainFrame.waiting.setVisible(true);              
            
            }

        } else {
            mainFrame.waiting = new erpgest.utils.Waiting(mainFrame, jp);
            mainFrame.waiting.setVisible(true);
        }
    }
}
