/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.MainFrame;
import erpgest.db.DbConn;
import erpgest.utils.Utils;
import erpgest.utils.UtilsGen;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JPanelAmministrazione extends javax.swing.JPanel {

    
    MainFrame parentFrame ;
    
    String UPDATE_OK = "Aggiornamento effettuato.";
    String INSERT_OK = "Inserimento effettuato.";
    
    public void setParentFrame(MainFrame parent){
        this.parentFrame = parent;
    }    
    
    /**
     * Creates new form JPanelAmministrazione
     */
    public JPanelAmministrazione() {
        initComponents();
        popolaCampi();
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
        buttonSalva = new javax.swing.JButton();
        jTextFieldRagioneSociale = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldPartitaIVA = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextFieldIndirizzo = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jTextFieldCittaAzienda = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextFieldCAPAzienda = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextFieldTelefonoAzienda = new javax.swing.JTextField();

        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dati Anagrafici"));
        jPanel1.setLayout(null);

        buttonSalva.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        buttonSalva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/disk.png"))); // NOI18N
        buttonSalva.setText("  Salva");
        buttonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSalva);
        buttonSalva.setBounds(850, 130, 120, 30);

        jTextFieldRagioneSociale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldRagioneSociale.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldRagioneSociale);
        jTextFieldRagioneSociale.setBounds(20, 40, 260, 30);

        jLabel51.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel51.setText("Ragione Sociale");
        jPanel1.add(jLabel51);
        jLabel51.setBounds(20, 20, 130, 20);

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel21.setText("Partita IVA");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(290, 20, 170, 20);

        jTextFieldPartitaIVA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldPartitaIVA.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldPartitaIVA);
        jTextFieldPartitaIVA.setBounds(290, 40, 170, 30);

        jLabel50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel50.setText("Indirizzo");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(20, 110, 260, 20);

        jTextFieldIndirizzo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldIndirizzo.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldIndirizzo);
        jTextFieldIndirizzo.setBounds(20, 130, 260, 30);

        jLabel55.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel55.setText("Città");
        jPanel1.add(jLabel55);
        jLabel55.setBounds(290, 110, 260, 20);

        jTextFieldCittaAzienda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCittaAzienda.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldCittaAzienda);
        jTextFieldCittaAzienda.setBounds(290, 130, 260, 30);

        jLabel54.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel54.setText("CAP");
        jPanel1.add(jLabel54);
        jLabel54.setBounds(560, 110, 110, 20);

        jTextFieldCAPAzienda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCAPAzienda.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldCAPAzienda);
        jTextFieldCAPAzienda.setBounds(560, 130, 110, 30);

        jLabel52.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel52.setText("Telefono");
        jPanel1.add(jLabel52);
        jLabel52.setBounds(680, 110, 130, 20);

        jTextFieldTelefonoAzienda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldTelefonoAzienda.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldTelefonoAzienda);
        jTextFieldTelefonoAzienda.setBounds(680, 130, 130, 30);

        add(jPanel1);
        jPanel1.setBounds(10, 10, 1020, 220);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvaActionPerformed

        if (jTextFieldRagioneSociale.getText().equals("") ||
                jTextFieldPartitaIVA.getText().equals("") || 
                jTextFieldIndirizzo.getText().equals("") ||
                jTextFieldCAPAzienda.getText().equals("") ||
                jTextFieldCittaAzienda.getText().equals("")) {
                JOptionPane.showMessageDialog(parentFrame.getFrame(), "Inserire Ragione Sociale ,partita iva, indirizzo ,citta e cap dell'azienda, sono obbligatori.", "Attenzione", JOptionPane.ERROR_MESSAGE);
                popolaCampi();
                return;            
        }
        /*
        Thread t = new Thread(new erpgest.utils.ShowWaiting(parentFrame.getFrame(), null, "Salvataggio in corso. Attendere"));
        t.start();

        while (parentFrame.waiting == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        Thread tt = new Thread(new SalvaDatiNelDB());
        tt.start();        
        */
        
        Map <String,String> conf = UtilsGen.caricaConfigurazione();
        Properties prop = new Properties();
        
        prop.put("RagioneSociale", jTextFieldRagioneSociale.getText().trim().toUpperCase().replaceAll("'", "''"));
        prop.put("PartitaIva", jTextFieldPartitaIVA.getText().trim().toUpperCase().replaceAll("'", "''"));
        prop.put("Indirizzo", jTextFieldIndirizzo.getText().trim().toUpperCase().replaceAll("'", "''"));
        prop.put("Citta", jTextFieldCittaAzienda.getText().trim().toUpperCase().replaceAll("'", "''"));
        prop.put("CAP", jTextFieldCAPAzienda.getText().trim().toUpperCase().replaceAll("'", "''"));
        prop.put("Telefono", jTextFieldTelefonoAzienda.getText().trim().toUpperCase().replaceAll("'", "''"));
        //prop.putAll(conf);
        try {
            prop.store(new FileOutputStream("./system/sysconf.properties"), null);
        } catch (IOException ex) {
            Utils.logError(ex, "", true);
            System.out.println("KO");
        }
        System.out.println("OK");
        popolaCampi();
    }//GEN-LAST:event_buttonSalvaActionPerformed

    public boolean aziendaRegistrata(){
        boolean registrata = true;
        if (jTextFieldRagioneSociale.getText().equals("") ||
                jTextFieldPartitaIVA.getText().equals("") || 
                jTextFieldIndirizzo.getText().equals("") ||
                jTextFieldCAPAzienda.getText().equals("") ||
                jTextFieldCittaAzienda.getText().equals("")) {
            registrata = false;
        }
        return registrata;
    }
    
    private void popolaCampi(){
        String ragioneSociale = "",cap="",nomeAzienda="",indirizzo="",telefono="",partitaIva="",citta="";
        try {
            Map <String,String> conf = UtilsGen.caricaConfigurazione();
            ragioneSociale = conf.get("RagioneSociale");
            partitaIva     = conf.get("PartitaIva");
            cap            = conf.get("CAP");
            telefono       = conf.get("Telefono");
            indirizzo      = conf.get("Indirizzo");
            citta           = conf.get("Citta");            
        } catch (Exception e) {
        }

        Map <String,String> conf = UtilsGen.caricaConfigurazione();
        try {
            ragioneSociale = conf.get("RagioneSociale");
            partitaIva     = conf.get("PartitaIva");
            cap            = conf.get("CAP");
            telefono       = conf.get("Telefono");
            indirizzo      = conf.get("Indirizzo");
            citta           = conf.get("Citta");            
        } catch (Exception e) {
        }

        
        jTextFieldRagioneSociale.setText(ragioneSociale);
        jTextFieldPartitaIVA.setText(partitaIva);
        jTextFieldIndirizzo.setText(indirizzo);
        jTextFieldCittaAzienda.setText(citta);
        jTextFieldCAPAzienda.setText(cap);
        jTextFieldTelefonoAzienda.setText(telefono);
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonSalva;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel50;
    public javax.swing.JLabel jLabel51;
    public javax.swing.JLabel jLabel52;
    public javax.swing.JLabel jLabel54;
    public javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldCAPAzienda;
    public javax.swing.JTextField jTextFieldCittaAzienda;
    public javax.swing.JTextField jTextFieldIndirizzo;
    public javax.swing.JTextField jTextFieldPartitaIVA;
    public javax.swing.JTextField jTextFieldRagioneSociale;
    public javax.swing.JTextField jTextFieldTelefonoAzienda;
    // End of variables declaration//GEN-END:variables

    private void closeDialog() {
        if (parentFrame.waiting != null) {
            parentFrame.waiting.dispose();
            parentFrame.waiting = null;
            parentFrame.validate();
            parentFrame.repaint();
        }

    } 
    
    private  class SalvaDatiNelDB implements Runnable {

        public SalvaDatiNelDB() {
        }

        @Override
        public void run() {
            String ragioneSociale = jTextFieldRagioneSociale.getText()
                    ,cap=jTextFieldCAPAzienda.getText()
                    ,nomeAzienda=jTextFieldRagioneSociale.getText()
                    ,indirizzo=jTextFieldIndirizzo.getText()
                    ,telefono=jTextFieldTelefonoAzienda.getText()
                    ,partitaIva=jTextFieldPartitaIVA.getText()
                    ,citta=jTextFieldTelefonoAzienda.getText();
            
            String query = "";
            String risultato = "";
            
            DbConn conn = new DbConn();
            conn.makeConn();
            
            try {

                query = "UPDATE CONFIGURAZIONE "
                        + " SET VALORE = '"+ragioneSociale+"' "
                        + " WHERE NOME = 'RAGIONE_SOCIALE'"
                        + " AND ATTIVO = 'S'";
                risultato = conn.update(query);
                
                if (risultato.equals(UPDATE_OK)) {
                    query = "UPDATE CONFIGURAZIONE "
                            + " SET VALORE = '"+indirizzo+"' "
                            + " WHERE NOME = 'INDIRIZZO'"
                            + " AND ATTIVO = 'S'";
                    risultato = conn.update(query);                    
                }                
                if (risultato.equals(UPDATE_OK)) {
                    query = "UPDATE CONFIGURAZIONE "
                            + " SET VALORE = '"+partitaIva+"' "
                            + " WHERE NOME = 'PARTITA_IVA'"
                            + " AND ATTIVO = 'S'";
                    risultato = conn.update(query);                    
                }                
                if (risultato.equals(UPDATE_OK)) {
                    query = "UPDATE CONFIGURAZIONE "
                            + " SET VALORE = '"+citta+"' "
                            + " WHERE NOME = 'CITTA'"
                            + " AND ATTIVO = 'S'";
                    risultato = conn.update(query);                    
                }
                if (risultato.equals(UPDATE_OK)) {
                    query = "UPDATE CONFIGURAZIONE "
                            + " SET VALORE = '"+cap+"' "
                            + " WHERE NOME = 'CAP'"
                            + " AND ATTIVO = 'S'";
                    risultato = conn.update(query);                    
                }                                

                if (!risultato.equals(UPDATE_OK)) {
                    
                    query = "INSERT INTO CONFIGURAZIONE ("
                            + " RAGIONE_SOCIALE,"
                            + " PARTITA_IVA,"
                            + " INDIRIZZO,"
                            + " CITTA,"
                            + " CAP,"
                            + " TELEFONO"
                            + ") VALUES ("
                            + "'"+ragioneSociale+"',"
                            + "'"+partitaIva+"',"
                            + "'"+indirizzo+"',"
                            + "'"+citta+"',"
                            + "'"+cap+"',"
                            + "'"+telefono+"'"
                            + ");";
                    risultato = conn.insert(query);
                    if (!risultato.equals(INSERT_OK)) {
                        closeDialog();
                        JOptionPane.showMessageDialog(parentFrame.getFrame(), "Impossibile inserire i dati", "Attenzione", JOptionPane.ERROR_MESSAGE);
                        conn.close();
                        return;                          
                    }
                    
                }
                
                
            } catch (Exception e) {
                Utils.logError(e, null, true);
                closeDialog();                
            }
            closeDialog();
            conn.close();            
            
        }
    }
}
