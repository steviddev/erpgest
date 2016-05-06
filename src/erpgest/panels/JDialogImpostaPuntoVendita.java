/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.MainFrame;
import erpgest.db.DbConn;
import erpgest.utils.Utils;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JDialogImpostaPuntoVendita extends javax.swing.JDialog {

    MainFrame parentFrame;
    InterfaceCallBackPuntoVendita parentPanel;    
    String idAnagraficaPadre = ""; 
    String idPuntoVendita    = "";
    
    /**
     * Creates new form JDialogImpostaPuntoVendita
     */
    public JDialogImpostaPuntoVendita(MainFrame parent,InterfaceCallBackPuntoVendita parentPanel,String idAnagraficaPadre, String idPuntoVendita) {
        super(parent,"Gestione Punti vendita", true);
        this.parentFrame = parent;
        this.parentPanel = parentPanel;          
        
        initComponents();
        
        this.idAnagraficaPadre = idAnagraficaPadre;
        this.idPuntoVendita    = idPuntoVendita;
        
        popolaJTextFields(idAnagraficaPadre,idPuntoVendita);
        
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
        jButtonAnnulla = new javax.swing.JButton();
        jButtonSalva = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCAP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCitta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIndirizzo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Punto Vendita"));

        jButtonAnnulla.setText("Annulla");
        jButtonAnnulla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnullaActionPerformed(evt);
            }
        });

        jButtonSalva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/disk.png"))); // NOI18N
        jButtonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono:");

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldTelefono.setForeground(new java.awt.Color(0, 0, 204));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CAP:");

        jTextFieldCAP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCAP.setForeground(new java.awt.Color(0, 0, 204));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Città:");

        jTextFieldCitta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCitta.setForeground(new java.awt.Color(0, 0, 204));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Indirizzo:");

        jTextFieldIndirizzo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldIndirizzo.setForeground(new java.awt.Color(0, 0, 204));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAnnulla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIndirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCAP, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldIndirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCAP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnulla)
                    .addComponent(jButtonSalva))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnullaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnullaActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonAnnullaActionPerformed

    private void jButtonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvaActionPerformed
        if( jTextFieldNome.getText().equals("") || 
            jTextFieldIndirizzo.getText().equals("") ||
            jTextFieldCitta.getText().equals("")){

            JOptionPane.showMessageDialog(parentFrame.getFrame(), "Inserire Nome, Indirizzo, Citta, obbligatoriamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        parentPanel.aggiornaListaPuntiVendita(idAnagraficaPadre);
    }//GEN-LAST:event_jButtonSalvaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnulla;
    private javax.swing.JButton jButtonSalva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldCAP;
    public javax.swing.JTextField jTextFieldCitta;
    public javax.swing.JTextField jTextFieldIndirizzo;
    public javax.swing.JTextField jTextFieldNome;
    public javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

    private void popolaJTextFields(String idAnagraficaPadre, String idPuntoVendita) {
        if (idPuntoVendita.equals("") || idAnagraficaPadre.equals("")) {
            return;
        }
        DbConn conn = new DbConn();
        conn.makeConn();
        
        String query = "";
        ResultSet res = null;
        String risultato = "";
        try {
            query = "SELECT * FROM PUNTO_VENDITA "
                    + " WHERE ID = '"+idPuntoVendita+"' "
            + " AND ID_ANAGRAFICA_PADRE = '"+idAnagraficaPadre+"'"
                    + " AND ATTIVO = 'S' "
                    + " ORDER BY DATA_MODIFICA DESC";
            
            res = conn.selectSMS(query);
            if( res.next() ){
                jTextFieldNome.setText(res.getString("NOME"));
                jTextFieldIndirizzo.setText(res.getString("INDIRIZZO"));
                jTextFieldCitta.setText(res.getString("CITTA"));
                jTextFieldCAP.setText(res.getString("CAP"));
                jTextFieldTelefono.setText(res.getString("TELEFONO"));
            }
            
        } catch (Exception e) {

            Utils.logError(e, "", true);
        }
        conn.close();
    }
}
