/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.MainFrame;
import erpgest.db.DbConn;
import erpgest.utils.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JDialogImpostaPrezzo extends javax.swing.JDialog {

    MainFrame parentFrame;
    JPanelListinoPrezzi parentPanel;    
    String idProdotto = "";
    String idListino = "";
    /**
     * Creates new form JDialogImpostaPrezzo
     */
    public JDialogImpostaPrezzo(MainFrame parent,JPanelListinoPrezzi parentPanel,String idListino,String idArticolo,String nomeListino,String nomeArticolo,
            String descrizioneArticolo,String prezzo) {
        super(parent, "Imposta Prezzo Prodotto", true);
        this.parentFrame = parent;
        this.parentPanel = parentPanel;        
        initComponents();
        jTextFieldPrezzo.setDocument(new erpgest.utils.JTextFieldDoubleDocument(11) );

        this.idProdotto = idArticolo;
        this.idListino = idListino;
        jTextFieldPrezzo.setText(prezzo);
        jLabelNomeListino.setText(nomeListino);
        jLabelNomeArticolo.setText(nomeArticolo);
        jLabelDescrizioneArticolo1.setText(descrizioneArticolo);        
        
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);        

        erpgest.utils.UtilsGen.centraDialogo(parent, this);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNomeListino = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNomeArticolo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelprezzo = new javax.swing.JLabel();
        jLabelDescrizioneArticolo1 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancella = new javax.swing.JButton();
        jTextFieldPrezzo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(441, 340));
        setMinimumSize(new java.awt.Dimension(441, 340));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Imposta Prezzo Articolo"));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Listino: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 40, 60, 15);

        jLabelNomeListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelNomeListino.setText("-");
        jPanel1.add(jLabelNomeListino);
        jLabelNomeListino.setBounds(210, 40, 160, 20);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Nome Articolo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 70, 100, 15);

        jLabelNomeArticolo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelNomeArticolo.setText("-");
        jPanel1.add(jLabelNomeArticolo);
        jLabelNomeArticolo.setBounds(210, 70, 160, 20);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Descrizione:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(130, 100, 80, 15);

        jLabelprezzo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelprezzo.setText("Prezzo :");
        jPanel1.add(jLabelprezzo);
        jLabelprezzo.setBounds(130, 150, 70, 20);

        jLabelDescrizioneArticolo1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelDescrizioneArticolo1.setText("-");
        jPanel1.add(jLabelDescrizioneArticolo1);
        jLabelDescrizioneArticolo1.setBounds(210, 100, 160, 20);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOK);
        jButtonOK.setBounds(100, 220, 90, 31);

        jButtonCancella.setText("Cancella");
        jButtonCancella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancellaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancella);
        jButtonCancella.setBounds(220, 220, 90, 31);
        jPanel1.add(jTextFieldPrezzo);
        jTextFieldPrezzo.setBounds(210, 150, 110, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 420, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancellaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancellaActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        DbConn conn = new DbConn();
        conn.makeConn();
        try {
            String query = "UPDATE PREZZI "
                    + " SET PREZZO = '"+jTextFieldPrezzo.getText()+"'"
                    + " WHERE ID_LISTINO = '"+idListino+"'"
                    + " AND ID_ARTICOLO = '"+idProdotto+"'"
                    + " AND ATTIVO = 'S'";
            
            conn.update(query);
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        dispose();
        parentPanel.popolaTabellaListino();
        
    }//GEN-LAST:event_jButtonOKActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancella;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDescrizioneArticolo1;
    private javax.swing.JLabel jLabelNomeArticolo;
    private javax.swing.JLabel jLabelNomeListino;
    private javax.swing.JLabel jLabelprezzo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPrezzo;
    // End of variables declaration//GEN-END:variables

    public void popolaCampi(String idProdotto ,String idListino,String listino, String articolo, String descrizione, String prezzo){
        this.idProdotto = idProdotto;
        this.idListino = idListino;
        jTextFieldPrezzo.setText(prezzo);
        jLabelNomeListino.setText(listino);
        jLabelNomeArticolo.setText(articolo);
        jLabelDescrizioneArticolo1.setText(descrizione);
    
    }

}
