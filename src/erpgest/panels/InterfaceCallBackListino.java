/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public interface InterfaceCallBackListino {
    public void settaListino(String idListino,String idPrezzo);
    public void settaListino(String idListino,String idPrezzo,String prezzo,String listino);
    public void settaListino(String idListino,String idPrezzo,String prezzo,String listino,String colli);
}
