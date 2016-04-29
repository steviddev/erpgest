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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JDialogImpostaPrezzoPerOrdini extends javax.swing.JDialog implements InterfaceCallBackListino{

    MainFrame parentFrame;
    InterfaceCallBackListino parentPanel;    
    String idArticolo = "";
    String idListino = "";
    private Map<String, String> listiniMap = new HashMap<String, String>();
    /**
     * Creates new form JDialogImpostaPrezzo
     */
    public JDialogImpostaPrezzoPerOrdini(MainFrame parent,InterfaceCallBackListino parentPanel,String idArticolo,String nomeArticolo,
            String descrizioneArticolo) {
        super(parent, "Imposta Prezzo Articolo", true);
        this.parentFrame = parent;
        this.parentPanel = parentPanel;        
        initComponents();

        this.idArticolo = idArticolo;
        this.idListino = idListino;
        jLabelNomeArticolo.setText(nomeArticolo);
        jLabelPrezzoArticolo.setText("");        
        jLabelDescrizioneArticolo.setText(descrizioneArticolo);
        
        popolaComboListini();
        jComboBoxListini.addItemListener(new ItemChangeListener());
        
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);        

        jTextFieldColli.setDocument(new erpgest.utils.JTextFieldLimit(4) );
        jTextFieldColli.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char vChar = e.getKeyChar();
                if (!(Character.isDigit(vChar)
                        || (vChar == KeyEvent.VK_BACK_SPACE)
                        || (vChar == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });  
        
        
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
        jButtonOK = new javax.swing.JButton();
        jButtonCancella = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxListini = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabelNomeArticolo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelDescrizioneArticolo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldColli = new javax.swing.JTextField();
        jLabelprezzo = new javax.swing.JLabel();
        jLabelPrezzoArticolo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(441, 340));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Scegli Prezzo Articolo"));
        jPanel1.setLayout(null);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOK);
        jButtonOK.setBounds(70, 250, 90, 32);

        jButtonCancella.setText("Cancella");
        jButtonCancella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancellaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancella);
        jButtonCancella.setBounds(170, 250, 83, 32);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Listino: ");

        jComboBoxListini.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jComboBoxListini.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        jComboBoxListini.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxListiniItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Nome Articolo:");

        jLabelNomeArticolo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelNomeArticolo.setText("-");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Descrizione:");

        jLabelDescrizioneArticolo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelDescrizioneArticolo.setText("-");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Colli:");

        jTextFieldColli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldColli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldColliActionPerformed(evt);
            }
        });

        jLabelprezzo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelprezzo.setText("Prezzo :");

        jLabelPrezzoArticolo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabelPrezzoArticolo.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelprezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxListini, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeArticolo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescrizioneArticolo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldColli, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrezzoArticolo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxListini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelNomeArticolo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelDescrizioneArticolo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldColli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelprezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrezzoArticolo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 30, 320, 210);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 370, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancellaActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancellaActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if (((String)jComboBoxListini.getSelectedItem()).equals("-")) {
            JOptionPane.showMessageDialog(parentFrame.getFrame(), "Nessun listino selezionato", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (jLabelPrezzoArticolo.getText().equals("-")) {
            JOptionPane.showMessageDialog(parentFrame.getFrame(), "Il prodotto non ha un prezzo in quel listino. settare il prezzo nel listino e riprovare", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        idListino = Utils.getKeyByValue(listiniMap, (String)jComboBoxListini.getSelectedItem());
        parentPanel.settaListino(idListino, idArticolo,jLabelPrezzoArticolo.getText(),(String)jComboBoxListini.getSelectedItem(),jTextFieldColli.getText());
        dispose();
        
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jComboBoxListiniItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxListiniItemStateChanged
        
    }//GEN-LAST:event_jComboBoxListiniItemStateChanged

    private void jTextFieldColliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldColliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldColliActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancella;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox jComboBoxListini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDescrizioneArticolo;
    private javax.swing.JLabel jLabelNomeArticolo;
    private javax.swing.JLabel jLabelPrezzoArticolo;
    private javax.swing.JLabel jLabelprezzo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldColli;
    // End of variables declaration//GEN-END:variables

    public void popolaCampi(String idProdotto ,String idListino,String listino, String articolo, String descrizione, String prezzo){
        this.idArticolo = idProdotto;
        this.idListino = idListino;
        jLabelNomeArticolo.setText(articolo);
        jLabelPrezzoArticolo.setText(descrizione);
    
    }
    
    private void popolaComboListini(){
        DbConn conn = new DbConn();
        conn.makeConn();
        jComboBoxListini.removeAllItems();
        jComboBoxListini.addItem("-");
        listiniMap.clear();
        try {
            String query = "SELECT * FROM LISTINI WHERE ATTIVO = 'S'";
            ResultSet res = conn.selectSMS(query);
            while( res.next() ){
                jComboBoxListini.addItem(res.getString("NOME"));
                listiniMap.put(res.getString("ID"), res.getString("NOME"));
            }
        } catch (Exception e) {
            Utils.logError(e, "", true);
        }
        conn.close();        
    
    }
    
    @Override
    public void settaListino(String listino, String prezzo) {
        parentPanel.settaListino(idListino, prezzo);
    }

    @Override
    public void settaListino(String idListino, String idPrezzo, String prezzo,String listino) {
        parentPanel.settaListino(idListino, idPrezzo, prezzo,listino);
    }

    @Override
    public void settaListino(String idListino, String idPrezzo, String prezzo, String listino, String colli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    class ItemChangeListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent event) {
           if (event.getStateChange() == ItemEvent.SELECTED) {
              String item = (String)event.getItem();
               if (item.equals("-")) {
                   return;
               }
              String prezzo = "-";
              String idListino = erpgest.utils.Utils.getKeyByValue(listiniMap, item);
               if (!idListino.equals("") || idListino != null) {
                    DbConn conn = new DbConn();
                    conn.makeConn();

                      try {
                          String query = "SELECT P.PREZZO FROM"
                                  + " PREZZI P,LISTINI L"
                                  + " WHERE "
                                  + " L.ID = " + idListino
                                  + " AND L.ATTIVO = 'S'"
                                  + " AND L.ID = P.ID_LISTINO"
                                  + " AND P.ID_ARTICOLO = " + idArticolo
                                  + " AND P.ATTIVO = 'S'";
                          ResultSet res = conn.selectSMS(query);
                          if (res.next()) {
                              prezzo = res.getString("PREZZO");
                          }

                      } catch (Exception e) {
                          Utils.logError(e, "", true);
                      }

                    conn.close();                   
               }

              
              jLabelPrezzoArticolo.setText(prezzo);
           }
        }       
    }    
    
}
