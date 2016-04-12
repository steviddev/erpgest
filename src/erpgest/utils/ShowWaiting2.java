/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erpgest.utils;

import erpgest.MainFrame;

/**
 *
 * @author Stefano Vidili <www.stevid.it>
 */

public class ShowWaiting2 implements Runnable {

    MainFrame mainFrame;
    javax.swing.JDialog jp;
    String message = "";

    public ShowWaiting2(MainFrame mainFrame, javax.swing.JDialog _jp) {
        this.mainFrame = mainFrame;
        jp = _jp;
    }
    
    public ShowWaiting2(MainFrame mainFrame, javax.swing.JDialog _jp,String message) {
        this.mainFrame = mainFrame;
        jp = _jp;
        this.message = message;
    }    

    @Override
    public void run() {
        if (jp == null) {
            if( message.equals("") ){
                mainFrame.waiting2 = new erpgest.utils.Waiting2(mainFrame);
                mainFrame.waiting.setVisible(true);            
            }else{
                mainFrame.waiting2 = new erpgest.utils.Waiting2(mainFrame,null,message);
                mainFrame.waiting2.setVisible(true);              
            
            }

        } else {
            mainFrame.waiting2 = new erpgest.utils.Waiting2(mainFrame, jp);
            mainFrame.waiting.setVisible(true);
        }
    }
}