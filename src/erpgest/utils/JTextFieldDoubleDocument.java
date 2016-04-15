/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.utils;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JTextFieldDoubleDocument extends PlainDocument {

    int size;

    public JTextFieldDoubleDocument(int size) {
        this.size = size;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(str == null){
            return;
        }

        if(getLength() + str.length() > size){
            Toolkit.getDefaultToolkit().beep();
            return;
        }

        boolean isValid = true;
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                if(str.charAt(i) != '.'){
                    isValid = false;
                    break;
                } else {
                    if(this.getText(0, this.getLength()).contains(".")){
                        isValid = false;
                        break;
                    }
                }
            }
        }
        
        if(isValid){
            super.insertString(offs, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

}

