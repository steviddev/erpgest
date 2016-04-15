/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.MainFrame;
import erpgest.db.DbConn;
import erpgest.utils.Utils;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JPanelListinoPrezzi extends javax.swing.JPanel {
    String UPDATE_OK = "Aggiornamento effettuato.";
    String INSERT_OK = "Inserimento effettuato.";    
    MainFrame parentFrame;
    
    /**
     * Creates new form JPanelListinoPrezzi
     */
    public JPanelListinoPrezzi() {
        initComponents();
        nascondiPannelloCopiaListino();
        nascondiPannelloNuovoListino();
        caricaComboListini();
        
        jTable1.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    jButtonImpostaPrezzoActionPerformed(null);
                }
            }
        });        
        jTable1.setCellSelectionEnabled(false);
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setSelectionMode(0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonImpostaPrezzo = new javax.swing.JButton();
        jButtonInserisciProdotto = new javax.swing.JButton();
        jButtonEliminaArticoloDaListino = new javax.swing.JButton();
        jButtonAggiornaTabella = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelListinoSelezionato = new javax.swing.JLabel();
        jLabelIDListino = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxListini = new javax.swing.JComboBox();
        jButtonNuovoListino = new javax.swing.JButton();
        jButtonEliminaListino = new javax.swing.JButton();
        jPanelCreazioneListino = new javax.swing.JPanel();
        jButtonOkCreazione = new javax.swing.JButton();
        jTextFieldNuovoListino = new javax.swing.JTextField();
        jButtonAnnullaCreazioneListino = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanelCopiaListini = new javax.swing.JPanel();
        jButtonCopiaListino = new javax.swing.JButton();
        jButtonAnnullaCopiaListino = new javax.swing.JButton();
        jComboBoxListinoDaCuiCopiare = new javax.swing.JComboBox();
        jButtonConferma = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Listino Prezzi"));
        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Prodotti"));
        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome Prodotto", "Descrizione", "prezzo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMinWidth(200);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 820, 220);

        jButtonImpostaPrezzo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonImpostaPrezzo.setText("Imposta Prezzo");
        jButtonImpostaPrezzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImpostaPrezzoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImpostaPrezzo);
        jButtonImpostaPrezzo.setBounds(680, 280, 160, 34);

        jButtonInserisciProdotto.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonInserisciProdotto.setText("Inserisci Prodotto");
        jButtonInserisciProdotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserisciProdottoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInserisciProdotto);
        jButtonInserisciProdotto.setBounds(20, 280, 150, 40);

        jButtonEliminaArticoloDaListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonEliminaArticoloDaListino.setText("Elimina");
        jButtonEliminaArticoloDaListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaArticoloDaListinoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminaArticoloDaListino);
        jButtonEliminaArticoloDaListino.setBounds(180, 280, 190, 40);

        jButtonAggiornaTabella.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonAggiornaTabella.setText("Aggiorna");
        jButtonAggiornaTabella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAggiornaTabellaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAggiornaTabella);
        jButtonAggiornaTabella.setBounds(390, 280, 130, 40);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Listino Selezionato: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(260, 20, 150, 15);

        jLabelListinoSelezionato.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelListinoSelezionato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListinoSelezionato.setText("-");
        jPanel1.add(jLabelListinoSelezionato);
        jLabelListinoSelezionato.setBounds(380, 20, 180, 20);

        jLabelIDListino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIDListino.setText("-");
        jPanel1.add(jLabelIDListino);
        jLabelIDListino.setBounds(750, 10, 80, 30);

        add(jPanel1);
        jPanel1.setBounds(30, 240, 870, 340);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("Scegli Listino ");
        add(jLabel3);
        jLabel3.setBounds(50, 50, 110, 20);

        jComboBoxListini.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jComboBoxListini.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxListiniItemStateChanged(evt);
            }
        });
        add(jComboBoxListini);
        jComboBoxListini.setBounds(150, 50, 150, 25);

        jButtonNuovoListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonNuovoListino.setText("Nuovo Listino");
        jButtonNuovoListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuovoListinoActionPerformed(evt);
            }
        });
        add(jButtonNuovoListino);
        jButtonNuovoListino.setBounds(350, 30, 140, 34);

        jButtonEliminaListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonEliminaListino.setText("Elimina Listino");
        jButtonEliminaListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaListinoActionPerformed(evt);
            }
        });
        add(jButtonEliminaListino);
        jButtonEliminaListino.setBounds(350, 80, 140, 34);

        jPanelCreazioneListino.setBorder(javax.swing.BorderFactory.createTitledBorder("Creazione Nuovo Listino"));
        jPanelCreazioneListino.setEnabled(false);
        jPanelCreazioneListino.setLayout(null);

        jButtonOkCreazione.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonOkCreazione.setText("OK");
        jButtonOkCreazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkCreazioneActionPerformed(evt);
            }
        });
        jPanelCreazioneListino.add(jButtonOkCreazione);
        jButtonOkCreazione.setBounds(250, 10, 90, 31);

        jTextFieldNuovoListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNuovoListinoActionPerformed(evt);
            }
        });
        jPanelCreazioneListino.add(jTextFieldNuovoListino);
        jTextFieldNuovoListino.setBounds(10, 20, 230, 30);

        jButtonAnnullaCreazioneListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonAnnullaCreazioneListino.setText("Annulla");
        jButtonAnnullaCreazioneListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnullaCreazioneListinoActionPerformed(evt);
            }
        });
        jPanelCreazioneListino.add(jButtonAnnullaCreazioneListino);
        jButtonAnnullaCreazioneListino.setBounds(250, 50, 90, 31);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanelCreazioneListino.add(jTextField2);
        jTextField2.setBounds(10, 20, 230, 30);

        add(jPanelCreazioneListino);
        jPanelCreazioneListino.setBounds(560, 30, 350, 90);

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setText("Copia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(350, 170, 140, 34);

        jPanelCopiaListini.setBorder(javax.swing.BorderFactory.createTitledBorder("Copia Da Listino"));
        jPanelCopiaListini.setLayout(null);

        jButtonCopiaListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonCopiaListino.setText("OK");
        jButtonCopiaListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCopiaListinoActionPerformed(evt);
            }
        });
        jPanelCopiaListini.add(jButtonCopiaListino);
        jButtonCopiaListino.setBounds(250, 20, 90, 31);

        jButtonAnnullaCopiaListino.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonAnnullaCopiaListino.setText("Annulla");
        jButtonAnnullaCopiaListino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnullaCopiaListinoActionPerformed(evt);
            }
        });
        jPanelCopiaListini.add(jButtonAnnullaCopiaListino);
        jButtonAnnullaCopiaListino.setBounds(250, 60, 90, 31);

        jComboBoxListinoDaCuiCopiare.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jPanelCopiaListini.add(jComboBoxListinoDaCuiCopiare);
        jComboBoxListinoDaCuiCopiare.setBounds(20, 30, 180, 25);

        add(jPanelCopiaListini);
        jPanelCopiaListini.setBounds(560, 120, 350, 100);

        jButtonConferma.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonConferma.setText("Visualizza");
        jButtonConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfermaActionPerformed(evt);
            }
        });
        add(jButtonConferma);
        jButtonConferma.setBounds(350, 130, 140, 34);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNuovoListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNuovoListinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNuovoListinoActionPerformed

    private void jButtonNuovoListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuovoListinoActionPerformed
        visualizzaPannelloNuovoListino();
        nascondiPannelloCopiaListino();
    }//GEN-LAST:event_jButtonNuovoListinoActionPerformed

    private void jButtonAnnullaCreazioneListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnullaCreazioneListinoActionPerformed
        nascondiPannelloNuovoListino();
    }//GEN-LAST:event_jButtonAnnullaCreazioneListinoActionPerformed
    
    private void nascondiPannelloNuovoListino(){
        jTextFieldNuovoListino.setText("");
        jPanelCreazioneListino.setEnabled(false);
        jPanelCreazioneListino.setVisible(false);    
    }

    private void visualizzaPannelloNuovoListino(){
        jTextFieldNuovoListino.setText("");
        jPanelCreazioneListino.setEnabled(true);
        jPanelCreazioneListino.setVisible(true);    
    }    
    
    private void nascondiPannelloCopiaListino(){
        jPanelCopiaListini.setEnabled(false);
        jPanelCopiaListini.setVisible(false);    
    }    

    private void visualizzaPannelloCopiaListino(){
        jPanelCopiaListini.setEnabled(true);
        jPanelCopiaListini.setVisible(true);    
    }      
    
    private void jButtonOkCreazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkCreazioneActionPerformed
        if (jTextFieldNuovoListino.getText().equals("")) {
            JOptionPane.showMessageDialog(parentFrame, "Inserire un nome valido", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String nomeNuovoListino = jTextFieldNuovoListino.getText().trim().toUpperCase().replaceAll("'", "''");
        if( controllaPresenzaListino(nomeNuovoListino)){
            JOptionPane.showMessageDialog(parentFrame, "Nome gia presente, sceglierne uno nuovo", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;        
        }
        
 
        
        DbConn conn = new DbConn();
        conn.makeConn();
        
        try {
            String result = conn.insert("INSERT INTO LISTINI (NOME ) VALUES ('"+nomeNuovoListino+"')");
            if(result.equals(INSERT_OK)){
                JOptionPane.showMessageDialog(parentFrame.getFrame(), "Inserimento avvenuto correttamente", "OK", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(parentFrame, "Spiacenti inserimento non effettuato", "Attenzione", JOptionPane.ERROR_MESSAGE);
                conn.close();
                return;
            }
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        caricaComboListini();
        
        nascondiPannelloNuovoListino();
    }//GEN-LAST:event_jButtonOkCreazioneActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nascondiPannelloNuovoListino();
        caricaComboCopiaListini();
        visualizzaPannelloCopiaListino();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonCopiaListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCopiaListinoActionPerformed
        
        //controllo se si tratta dello stesso listino
        if ( ((String)jComboBoxListini.getSelectedItem()).equals( ((String)jComboBoxListinoDaCuiCopiare.getSelectedItem())  )) {
            JOptionPane.showMessageDialog(parentFrame, "Impossibile copiare sullo stesso listino", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String listinoSorgente = (String)jComboBoxListinoDaCuiCopiare.getSelectedItem();
        String listinoDestinazione = (String)jComboBoxListini.getSelectedItem();
        
        if ( listinoSorgente.equals("-")  || listinoDestinazione.equals("-") ) {
            JOptionPane.showMessageDialog(parentFrame, "Selezionare un listino valido", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;            
        }
        
        //controllo se il listino di partenza ha almeno un prodotto con il prezzo
        if( !controlloPresenzaPrezziNelListino(listinoSorgente) ){
            JOptionPane.showMessageDialog(parentFrame, "Il listino scelto da cui copiare, non ha prezzi.", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;             
        }

        //metto alert
        int n = JOptionPane.showConfirmDialog(null,
                "ATTENZIONE!! Tutti i dati del listino selezionato verranno cancellati?\n"
                        + " cancellandolo si perderanno tutti i prezzi!!.si vuole continuare?",
                "",
                JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            //faccio la copia cancellando il sorgente
            copiaListino(listinoSorgente);
            nascondiPannelloCopiaListino();
        } else {            
            return;
        } 
        

    }//GEN-LAST:event_jButtonCopiaListinoActionPerformed

    private void jButtonAnnullaCopiaListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnullaCopiaListinoActionPerformed
        nascondiPannelloCopiaListino();
    }//GEN-LAST:event_jButtonAnnullaCopiaListinoActionPerformed

    private void jButtonInserisciProdottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserisciProdottoActionPerformed
        JPanelRicercaProdottiPerListino dialog = new JPanelRicercaProdottiPerListino(this.parentFrame,this);
    }//GEN-LAST:event_jButtonInserisciProdottoActionPerformed

    private void jComboBoxListiniItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxListiniItemStateChanged
        
     /*
        Thread t = new Thread(new erpgest.utils.ShowWaiting(parentFrame, null,"Elaborazione in corso. Attendere"));
        t.start();
        while (parentFrame.waiting == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        //    Thread tt = new Thread(new esegui(aTest.myJD,aTest.actionStop));
        Thread tt = new Thread(new popolaTabellaConListino());
        tt.start();        
        */
        
    }//GEN-LAST:event_jComboBoxListiniItemStateChanged

    private void jButtonConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfermaActionPerformed
        if (((String)jComboBoxListini.getSelectedItem()).equals("-") ) {
            JOptionPane.showMessageDialog(parentFrame, "Selezionare un listino valido", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;
        }
/*
        if( !controlloPresenzaPrezziNelListino(((String)jComboBoxListini.getSelectedItem())) ){
            JOptionPane.showMessageDialog(parentFrame, "Il listino scelto, non ha prezzi.", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;             
        }   */     
        jLabelListinoSelezionato.setText(((String)jComboBoxListini.getSelectedItem()));
        jLabelIDListino.setText(getIDListino( ((String)jComboBoxListini.getSelectedItem()) ,true));        
        popolaTabellaListino();
        

        
    }//GEN-LAST:event_jButtonConfermaActionPerformed

    private void jButtonEliminaListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaListinoActionPerformed
        
        String listinoScelto = (String)jComboBoxListini.getSelectedItem();
        
        if ( listinoScelto.equals("-") ) {
            JOptionPane.showMessageDialog(parentFrame, "Selezionare un listino valido", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;             
        }
        
        int n = JOptionPane.showConfirmDialog(null,
                "ATTENZIONE!! Si vuole cancellare il listino "+ listinoScelto +"?\n"
                        + " cancellandolo si perderanno tutti i prezzi!!",
                "",
                JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            disabilitaListino(listinoScelto);
        } else {            
            return;
        } 
    }//GEN-LAST:event_jButtonEliminaListinoActionPerformed

    private void jButtonImpostaPrezzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImpostaPrezzoActionPerformed
        if (jLabelIDListino.getText().equals("") || jLabelIDListino.getText().equals("-")) {
            return;
        }
        try {
            
            String idProdotto = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        } catch (Exception e) {
            new javax.swing.JOptionPane().showMessageDialog(
                    jPanel1,
                    "Selezionare Un Elemento",
                    "Attenzione",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;            
        }
        impostaPrezzo();
    }//GEN-LAST:event_jButtonImpostaPrezzoActionPerformed

    private void jButtonEliminaArticoloDaListinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaArticoloDaListinoActionPerformed
        
        if (jLabelIDListino.getText().equals("") || jLabelIDListino.getText().equals("-")) {
            return;
        }
        
        int n = JOptionPane.showConfirmDialog(null,
                "ATTENZIONE!! Si vuole il prezzo del prodotto?",
                "",
                JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            disabilitaPrezzoProdotto();
        } else {            
            return;
        } 
    }//GEN-LAST:event_jButtonEliminaArticoloDaListinoActionPerformed

    private void jButtonAggiornaTabellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAggiornaTabellaActionPerformed
        if (jLabelIDListino.getText().equals("") || jLabelIDListino.getText().equals("-")) {
            return;
        }
        popolaTabellaListino();
    }//GEN-LAST:event_jButtonAggiornaTabellaActionPerformed
    
    public void popolaTabellaListino(){
        Thread t = new Thread(new erpgest.utils.ShowWaiting(parentFrame, null,"Elaborazione in corso. Attendere"));
        t.start();
        while (parentFrame.waiting == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        Thread tt = new Thread(new popolaTabellaConListino());
        tt.start();         
    }
    
    public void setParentFrame(MainFrame parent){
        this.parentFrame = parent;
    }    
    
    private boolean controlloPresenzaPrezziNelListino(String nomeListino){
    
        if (nomeListino.equals("") || nomeListino == null) {
            return false;
        }
        boolean risultato = false;
        DbConn conn = new DbConn();
        conn.makeConn();
        try {
            
            String query = "select count(*) from listini l,prezzi p\n" +
                            "where l.NOME = '"+nomeListino+"'\n" +
                            "and p.id_listino = l.id\n" +
                            "and l.attivo = 'S'";
            ResultSet res = conn.selectSMS(query);
            int count = res.getInt(1);
            if( count > 0 ){
                risultato = true;
            }else
                risultato = false;
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        return risultato;        
        
    }
    
    private void resettaTabellaListini(){
        jLabelIDListino.setText("-");
        jLabelListinoSelezionato.setText("-");
        caricaComboListini();
        jTable1.setVisible(false);
        
        DefaultTableModel defaultModel = (DefaultTableModel) jTable1.getModel();

        while (defaultModel.getRowCount() > 0) {
            defaultModel.removeRow(0);
        }        
        jTable1.invalidate();
        jTable1.validate();
        jTable1.repaint(); 
        jTable1.setVisible(true);
        validate();
        repaint();        
    }
    
    private void caricaComboListini(){
        DbConn conn = new DbConn();
        conn.makeConn();
        jComboBoxListini.removeAllItems();
        jComboBoxListini.addItem("-");
        try {
            String query = "SELECT * FROM LISTINI WHERE ATTIVO = 'S'";
            ResultSet res = conn.selectSMS(query);
            while( res.next() ){
                jComboBoxListini.addItem(res.getString("NOME"));
            }
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        conn.close();
    }
    
    private void caricaComboCopiaListini(){
        DbConn conn = new DbConn();
        conn.makeConn();
        jComboBoxListinoDaCuiCopiare.removeAllItems();
        jComboBoxListinoDaCuiCopiare.addItem("-");
        try {
            String query = "SELECT * FROM LISTINI WHERE ATTIVO = 'S'";
            ResultSet res = conn.selectSMS(query);
            while( res.next() ){
                if (!res.getString("NOME").equals((String)jComboBoxListini.getSelectedItem())) {
                    jComboBoxListinoDaCuiCopiare.addItem(res.getString("NOME"));
                }
                
            }
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        conn.close();
    }    
    
    private boolean controllaPresenzaListino(String nome){
        
        if (nome.equals("") || nome == null) {
            return false;
        }
        boolean risultato = false;
        DbConn conn = new DbConn();
        conn.makeConn();
        try {
            
            String query = "SELECT COUNT(*) FROM LISTINI WHERE NOME='"+nome+"' AND ATTIVO = 'S'";
            ResultSet res = conn.selectSMS(query);
            int count = res.getInt(1);
            if( count > 0 ){
                risultato = true;
            }else
                risultato = false;
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        return risultato;
    }      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAggiornaTabella;
    private javax.swing.JButton jButtonAnnullaCopiaListino;
    private javax.swing.JButton jButtonAnnullaCreazioneListino;
    private javax.swing.JButton jButtonConferma;
    private javax.swing.JButton jButtonCopiaListino;
    private javax.swing.JButton jButtonEliminaArticoloDaListino;
    private javax.swing.JButton jButtonEliminaListino;
    private javax.swing.JButton jButtonImpostaPrezzo;
    private javax.swing.JButton jButtonInserisciProdotto;
    private javax.swing.JButton jButtonNuovoListino;
    private javax.swing.JButton jButtonOkCreazione;
    private javax.swing.JComboBox jComboBoxListini;
    private javax.swing.JComboBox jComboBoxListinoDaCuiCopiare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelIDListino;
    private javax.swing.JLabel jLabelListinoSelezionato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCopiaListini;
    private javax.swing.JPanel jPanelCreazioneListino;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldNuovoListino;
    // End of variables declaration//GEN-END:variables

    void aggiornaListaProdotti(String id) {
        
        if (jLabelListinoSelezionato.getText().equals("-") || id.equals("") || jLabelIDListino.getText().equals("-") ) {
            return;
        }
        
        String idListino = jLabelIDListino.getText();
        
        //prendo id prodotto e inserisco nella tabella prezzi mettendo zero
        DbConn conn = new DbConn();
        conn.makeConn();
        
        try {
            String result = "";
            String query = "select count(*) "
                    + " from listini l,prezzi p"
                    + " where "
                    + " l.nome = '"+jLabelListinoSelezionato.getText()+"'"
                    + " and l.id = p.id_listino"
                    + " and p.id_articolo = '"+id+"'"
                    + " and l.attivo = 'S'"
                    + " and p.attivo = 'S'";
            ResultSet res = conn.selectSMS(query);
            int count = 0;
            if (res.next()) {
                count = res.getInt(1);
            }
            
            if (count > 0) {
                return;
            }
            
            query = "INSERT INTO PREZZI (ID_ARTICOLO,ID_LISTINO,PREZZO) VALUES ('"+id+"','"+idListino+"','0.0')";
            result = conn.insert(query);
            if(!result.equals(INSERT_OK)){
                JOptionPane.showMessageDialog(parentFrame, "errore nell'inserimento prodotto su listino", "Attenzione", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        popolaTabellaListino();        
    }
    
    private void impostaPrezzo(){
        
        String listino = jLabelListinoSelezionato.getText();
        String idListino = jLabelIDListino.getText();
        String idProdotto = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        String articolo = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString() ;
        String descrizione = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString() ;
        String prezzo = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3).toString() ;
        
        JDialogImpostaPrezzo dialog = new JDialogImpostaPrezzo(this.parentFrame,this,idListino,idProdotto,listino,articolo,descrizione,prezzo);    
        dialog.popolaCampi(idProdotto, idListino, listino, articolo, descrizione,prezzo);
    }
    
    private String getIDListino(String nomeListino, boolean attivo) {
        
        if (nomeListino.equals("") || nomeListino.equals("-")) {
            return "";
        }
        String idListino = "";
        String attivoQuery = "";
        
        if (attivo) {
            attivoQuery = " AND ATTIVO = 'S'";
        }
        
        DbConn conn = new DbConn();
        conn.makeConn();
        
        try {
            String query = "SELECT ID FROM LISTINI WHERE NOME = '"+ nomeListino +"'" + attivoQuery;
            ResultSet res = conn.selectSMS(query);
            
            if (res.next()) {
                idListino = res.getString("ID");
            }
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        return idListino;
    }

    private void disabilitaListino(String listinoScelto) {
        String idListino = getIDListino(listinoScelto, true);
        if (idListino.equals("") || idListino.equals("0")) {
            return;
        }
        String result = "";
        
        DbConn conn = new DbConn();
        conn.makeConn();
        try {
            
            String query = "UPDATE PREZZI "
                    + " SET ATTIVO = 'N',"
                    + " DATA_MODIFICA =  datetime('now', 'localtime')"
                    + " WHERE ID_LISTINO = '"+idListino+"'"
                    + " AND ATTIVO = 'S'";
            
            result = conn.update(query);
            if (result.equals(UPDATE_OK)) {
                
                query = "UPDATE LISTINI"
                        + " SET ATTIVO = 'N',"
                        + " DATA_MODIFICA =  datetime('now', 'localtime')"
                        + " WHERE ID='"+idListino+"'"
                        + " AND ATTIVO = 'S'";
                
                result = conn.update(query);
                if ( result.equals(UPDATE_OK)) {
                    JOptionPane.showMessageDialog(parentFrame.getFrame(), "Elaborazione avvenuta correttamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                    resettaTabellaListini();
                }
                
            }
            
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        conn.close();
        
    }

    private void disabilitaPrezzoProdotto() {
        
        String idListino = jLabelIDListino.getText();
        String idArticolo  = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        String result = "";
        
        DbConn conn = new DbConn();
        conn.makeConn();
        
        try {
            String query = "UPDATE PREZZI "
                    + " SET ATTIVO = 'N',"
                    + " DATA_MODIFICA =  datetime('now', 'localtime')"
                    + " WHERE ID_LISTINO = '"+idListino+"'"
                    + " AND ID_ARTICOLO = '"+idArticolo+"'"
                    + " AND ATTIVO = 'S'";
            
            result = conn.update(query);
            
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
        popolaTabellaListino();
    }

    private void copiaListino(String listinoSorgente) {
        String result = "";
        String idListinoDestinazione = jLabelIDListino.getText();
        if (idListinoDestinazione.equals("") || idListinoDestinazione.equals("-")) {
            return;
        }
        
        String idListinoSorgente = getIDListino(listinoSorgente, true);
        
        DbConn conn = new DbConn();
        conn.makeConn();
        
        try {
            String query2 ="";
            String query = "UPDATE PREZZI "
                    + " SET ATTIVO = 'N', "
                    + " DATA_MODIFICA =  datetime('now', 'localtime')"
                    + " WHERE ID_LISTINO = '"+idListinoDestinazione+"'"
                    + " AND ATTIVO = 'S'";
            conn.update(query);
            
            query = "SELECT * FROM PREZZI"
                    + " WHERE ID_LISTINO = '"+idListinoSorgente+"'"
                    + " AND ATTIVO = 'S'";
            
            ResultSet res = conn.selectSMS(query);
            while( res.next() ){
                query2 = "INSERT INTO PREZZI "
                        + "(ID_LISTINO,ID_ARTICOLO,PREZZO) VALUES ('"+idListinoDestinazione+"','"+res.getString("ID_ARTICOLO")+"','"+res.getString("PREZZO")+"')";
                conn.insert(query2);
            }
            
            
            
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        
        conn.close();
    }
    
    
    
    class popolaTabellaConListino implements Runnable {

        @Override
        public void run() {
            String query;

            query = "SELECT ID_ARTICOLO,"
                    + " A.NOME,"
                    + " A.DESCRIZIONE,"
                    + " P.PREZZO"
                    + " FROM ARTICOLI a,"
                    + " PREZZI P,"
                    + " LISTINI L "
                    + " where 1=1 "
                    + " AND P.ID_LISTINO = '"+jLabelIDListino.getText()+"' "
                    + " AND P.ID_ARTICOLO = A.ID"
                    + " and l.id='"+jLabelIDListino.getText()+"'"
                    + " and L.attivo='S' "
                    + " AND P.ATTIVO = 'S'";
            
            ResultSet rSet = null;

            jTable1.setVisible(false);

            DbConn conn = new DbConn();
            conn.makeConn();

            try {

                DefaultTableModel defaultModel = (DefaultTableModel) jTable1.getModel();

                while (defaultModel.getRowCount() > 0) {
                    defaultModel.removeRow(0);
                }
                rSet = conn.selectSMS(query);
                while (rSet.next()) {
                    Object[] cell = {rSet.getString("ID_ARTICOLO"),
                        rSet.getString("NOME"),
                        rSet.getString("DESCRIZIONE"),
                        rSet.getString("PREZZO")
                    };
                    defaultModel.addRow(cell);
                }

                jTable1.invalidate();
                jTable1.validate();
                jTable1.repaint();
                conn.close();
            } catch (Exception e) {
                erpgest.utils.Utils.logError(e, "", true);
                conn.close();
            }

            erpgest.db.Utils.ResultSetClose(rSet, null);

            jTable1.setVisible(true);
            parentFrame.waiting.dispose();
            parentFrame.waiting = null;
            validate();
            repaint();

            return;
        }
    }    
}
