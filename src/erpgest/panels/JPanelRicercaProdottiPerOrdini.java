/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import erpgest.db.DbConn;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTable;


/**
 *
 * @author Stefano Vidili <www.stevid.it>
 */
public class JPanelRicercaProdottiPerOrdini extends javax.swing.JDialog implements InterfaceCallBackListino{

    MainFrame parentFrame;
    JPanelOrdini parentPanel;

    String[] dati = new String[5];
    public String nominativo_cliente = "";
    int id = -2;
    int newID = -1;

    public String colonna_cognome = "";
    public String colonna_nome = "";
    public String colonna_CodiceFiscale = "";    
    public String colonna_ID = "";  
    public String colonna_id_bracciale = "";

    final ArrayList listaNomi    = new ArrayList();    
    final ArrayList listaCognomi = new ArrayList();    


    private static final String COMMIT_ACTION = "commit";   
    
    public JPanelRicercaProdottiPerOrdini(MainFrame parent,JPanelOrdini parentPanel) {
        super(parent, "Ricerca Azienda", true);

        this.parentFrame = parent;
        this.parentPanel = parentPanel;

        initComponents();
        
        tabella.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    jButtonSelezionaActionPerformed(null);
                }
            }
        });
        
        
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);

        /**
         * *******************************************************************************
         */
        KeyStroke invio = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jButtonSelezionaActionPerformed(null);
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(invio, "ENTER");
        getRootPane().getActionMap().put("ENTER", escapeAction);

        tabella.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                /*
                try {
                    //jButtonSelezionaActionPerformed(null);
                    
                    id = Integer.valueOf(tabella.getModel().getValueAt(tabella.getSelectedRow(), 0).toString());
                    nominativo_cliente = tabella.getModel().getValueAt(tabella.getSelectedRow(), 1).toString();
                    colonna_nome = tabella.getModel().getValueAt(tabella.getSelectedRow(), 3).toString();
                    colonna_cognome = tabella.getModel().getValueAt(tabella.getSelectedRow(), 2).toString();

                    if (newID == id) {
                        dispose();
                    } else {
                        newID = id;
                    }
                    
                } catch (Exception ex) {
                }
                */
            }
        });
        
        
        tabella.setAutoResizeMode(tabella.AUTO_RESIZE_OFF);
        tabella.setCellSelectionEnabled(false);
        tabella.setColumnSelectionAllowed(false);
        tabella.setRowSelectionAllowed(true);
        tabella.setSelectionMode(0);
        tabella.setGridColor(new java.awt.Color(239, 255, 212));
        tabella.setOpaque(false);
        //idDescOrder.setSelected(true);
        buttonGroup.setSelected(idDescOrder.getModel(), true);
                
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

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButtonChiudi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonSeleziona = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();
        jTextFieldUnitaMisura = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jButtonRicerca = new javax.swing.JButton();
        idAscOrder = new javax.swing.JRadioButton();
        nomeOrder = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextFieldNomeProdotto = new javax.swing.JTextField();
        buttonAzzeraCampi = new javax.swing.JButton();
        idDescOrder = new javax.swing.JRadioButton();
        idUnitaMisura = new javax.swing.JRadioButton();
        jTextFieldDescrizione = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(827, 620));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Ricerca in Anagrafica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 14))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 360));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 360));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 615));
        jPanel1.setLayout(null);

        jButtonChiudi.setBackground(new java.awt.Color(204, 204, 255));
        jButtonChiudi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonChiudi.setText("Chiudi");
        jButtonChiudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChiudiActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonChiudi);
        jButtonChiudi.setBounds(550, 540, 110, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 530, 760, 10);

        jButtonSeleziona.setBackground(new java.awt.Color(204, 204, 255));
        jButtonSeleziona.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSeleziona.setText("Seleziona");
        jButtonSeleziona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelezionaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSeleziona);
        jButtonSeleziona.setBounds(670, 540, 110, 30);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setOpaque(false);

        tabella.setBackground(new java.awt.Color(204, 204, 204));
        tabella.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrizione", "U.M.", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabella.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabella.setColumnSelectionAllowed(true);
        tabella.setMaximumSize(new java.awt.Dimension(452, 419));
        tabella.setOpaque(false);
        jScrollPane1.setViewportView(tabella);
        tabella.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabella.getColumnModel().getColumnCount() > 0) {
            tabella.getColumnModel().getColumn(0).setResizable(false);
            tabella.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabella.getColumnModel().getColumn(1).setResizable(false);
            tabella.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabella.getColumnModel().getColumn(2).setResizable(false);
            tabella.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabella.getColumnModel().getColumn(3).setResizable(false);
            tabella.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabella.getColumnModel().getColumn(4).setMinWidth(70);
            tabella.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabella.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jScrollPane1.setViewportView(tabella);

        tabella.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabella.getColumnModel().getColumnCount() > 0) {
            tabella.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabella.getColumnModel().getColumn(1).setPreferredWidth(215);
            tabella.getColumnModel().getColumn(2).setPreferredWidth(160);
            tabella.getColumnModel().getColumn(3).setPreferredWidth(120);
            tabella.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 780, 280);

        jTextFieldUnitaMisura.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldUnitaMisura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldUnitaMisura.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldUnitaMisura);
        jTextFieldUnitaMisura.setBounds(510, 50, 90, 30);

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel47.setText("Unita di Misura");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(510, 20, 100, 30);

        jButtonRicerca.setBackground(new java.awt.Color(204, 204, 255));
        jButtonRicerca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRicerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/drawer.png"))); // NOI18N
        jButtonRicerca.setText("<html>Ricerca</html>");
        jButtonRicerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRicercaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRicerca);
        jButtonRicerca.setBounds(650, 180, 130, 30);

        buttonGroup.add(idAscOrder);
        idAscOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        idAscOrder.setText("Ordinare per ID Ascendente");
        idAscOrder.setOpaque(false);
        jPanel1.add(idAscOrder);
        idAscOrder.setBounds(220, 130, 210, 30);

        buttonGroup.add(nomeOrder);
        nomeOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        nomeOrder.setSelected(true);
        nomeOrder.setText("Ordinare per Nome");
        nomeOrder.setOpaque(false);
        jPanel1.add(nomeOrder);
        nomeOrder.setBounds(220, 170, 200, 30);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Ordinamento risultati");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 110, 210, 20);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(170, 120, 610, 10);

        jLabel48.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel48.setText("ID");
        jPanel1.add(jLabel48);
        jLabel48.setBounds(20, 20, 90, 30);

        jTextFieldID.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldID.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldID);
        jTextFieldID.setBounds(20, 50, 100, 30);

        jLabel49.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel49.setText("Nome");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(140, 20, 120, 30);

        jTextFieldNomeProdotto.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldNomeProdotto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNomeProdotto.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldNomeProdotto);
        jTextFieldNomeProdotto.setBounds(140, 50, 170, 30);

        buttonAzzeraCampi.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        buttonAzzeraCampi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/sport_shuttlecock.png"))); // NOI18N
        buttonAzzeraCampi.setText(" Azzera");
        buttonAzzeraCampi.setToolTipText("Azzera tutti i dati");
        buttonAzzeraCampi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAzzeraCampiActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAzzeraCampi);
        buttonAzzeraCampi.setBounds(670, 50, 110, 34);

        buttonGroup.add(idDescOrder);
        idDescOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        idDescOrder.setText("Ordinare per ID Discendente ");
        idDescOrder.setOpaque(false);
        jPanel1.add(idDescOrder);
        idDescOrder.setBounds(20, 130, 210, 30);

        buttonGroup.add(idUnitaMisura);
        idUnitaMisura.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        idUnitaMisura.setText("Ordinare per U.M.");
        idUnitaMisura.setOpaque(false);
        jPanel1.add(idUnitaMisura);
        idUnitaMisura.setBounds(20, 170, 260, 30);

        jTextFieldDescrizione.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldDescrizione.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldDescrizione.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldDescrizione);
        jTextFieldDescrizione.setBounds(330, 50, 170, 30);

        jLabel50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel50.setText("Descrizione");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(330, 20, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChiudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChiudiActionPerformed

        dispose();

    }//GEN-LAST:event_jButtonChiudiActionPerformed

    private void jButtonSelezionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelezionaActionPerformed
        JDialogImpostaPrezzoPerOrdini uno = new JDialogImpostaPrezzoPerOrdini(parentFrame, this, "15", "pane", "pane e casu");
        
        String idArticolo = "";
        ResultSet res;
        try {
            int[] selection = tabella.getSelectedRows();
            idArticolo = tabella.getModel().getValueAt(tabella.getSelectedRow(), 0).toString() ;
            parentPanel.aggiornaListaArticoli(idArticolo);
            
            
        } catch (Exception e) {
            new javax.swing.JOptionPane().showMessageDialog(
                    jPanel1,
                    "Selezionare Un Elemento",
                    "Attenzione",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        if (!idArticolo.equals("")) {
            dispose();
        }
    }//GEN-LAST:event_jButtonSelezionaActionPerformed

    private void jButtonRicercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRicercaActionPerformed

        Thread t = new Thread(new erpgest.utils.ShowWaiting(parentFrame, this));
        t.start();
        while (parentFrame.waiting == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        //    Thread tt = new Thread(new esegui(aTest.myJD,aTest.actionStop));
        Thread tt = new Thread(new eseguiRicerca());
        tt.start();
    }//GEN-LAST:event_jButtonRicercaActionPerformed

    private void buttonAzzeraCampiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAzzeraCampiActionPerformed
        azzeraCampi();
    }//GEN-LAST:event_buttonAzzeraCampiActionPerformed

 //   Thread t = new Thread(new ShowWaiting(apigen,this));
    //   t.start();
    //      while(apigen.waiting == null) try { Thread.sleep(100); } catch(Exception e) {}
//    Thread tt = new Thread(new esegui(aTest.myJD,aTest.actionStop));
//    Thread tt = new Thread(new eseguiRicerca());
//    tt.start();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonAzzeraCampi;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButton idAscOrder;
    private javax.swing.JRadioButton idDescOrder;
    private javax.swing.JRadioButton idUnitaMisura;
    private javax.swing.JButton jButtonChiudi;
    private javax.swing.JButton jButtonRicerca;
    private javax.swing.JButton jButtonSeleziona;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel47;
    protected javax.swing.JLabel jLabel48;
    protected javax.swing.JLabel jLabel49;
    protected javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    protected javax.swing.JTextField jTextFieldDescrizione;
    protected javax.swing.JTextField jTextFieldID;
    protected javax.swing.JTextField jTextFieldNomeProdotto;
    protected javax.swing.JTextField jTextFieldUnitaMisura;
    private javax.swing.JRadioButton nomeOrder;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables

    private void azzeraCampi() {
        jTextFieldUnitaMisura.setText("");
        jTextFieldNomeProdotto.setText("");
        jTextFieldID.setText("");
        jTextFieldDescrizione.setText("");
    }

    @Override
    public void settaListino(String listino, String prezzo) {
        parentPanel.settaListino(listino, prezzo);
    }

    @Override
    public void settaListino(String idListino, String idPrezzo, String prezzo, String listino) {
        parentPanel.settaListino(idListino, idPrezzo, prezzo,listino);
    }

    class eseguiRicerca implements Runnable {

        @Override
        public void run() {
            String query;
            boolean ricercaDuplicati = false;

            query = "SELECT * FROM ARTICOLI a where 1=1 and a.attivo='S' ";
            
            ResultSet rSet = null;

            newID = 0;
            id = -1;

            tabella.setVisible(false);

            String filter = "";
            String order = "";
            DbConn conn = new DbConn();
            conn.makeConn();

            try {
                if(!ricercaDuplicati){


                    if (jTextFieldUnitaMisura.getText().trim().length() > 0) {
                        filter += "\n AND upper(a.UNITA_DI_MISURA) LIKE '%" + jTextFieldUnitaMisura.getText().toUpperCase().replace("'", "''") + "%' ";
                    }


                    if (jTextFieldNomeProdotto.getText().trim().length() > 0) {
                        filter += "\n AND a.NOME =" + jTextFieldNomeProdotto.getText().toUpperCase().replace("'", "''") + " ";
                    }

                    if (jTextFieldID.getText().trim().length() > 0) {
                        filter += "\n AND a.id =" + jTextFieldID.getText().toUpperCase().replace("'", "''") + " ";
                    }

                    if (jTextFieldDescrizione.getText().trim().length() > 0) {
                        filter += "\n AND upper(a.DESCRIZIONE) LIKE '%" + jTextFieldDescrizione.getText().trim().toUpperCase().replace("'", "''") + "%' ";
                    }                

                    if (idDescOrder.isSelected() == true) {
                        order += "\n ORDER BY a.ID  DESC ";
                    } else if (idAscOrder.isSelected() == true) {
                        order += "\n ORDER BY a.ID  ASC ";
                    } else if (nomeOrder.isSelected() == true && jTextFieldUnitaMisura.getText().trim().length() > 0) {
                        order += "\n and a.nome is not null ORDER BY upper(trim(a.cognome)), upper(trim(a.nome)) ";
                    } else if( idUnitaMisura.isSelected()){
                        order += "\n and a.unita_di_misura not null ORDER BY a.ragione_sociale DESC ";
                    }
                }

                DefaultTableModel defaultModel = (DefaultTableModel) tabella.getModel();

                while (defaultModel.getRowCount() > 0) {
                    defaultModel.removeRow(0);
                }
                
                rSet = conn.selectSMS(query + filter + order);
                        
//                        apigen.dbOP.select(
//                        DbQueryUser.selectUsers(filter, order, "")
//                );

                while (rSet.next()) {
                    Object[] cell = {rSet.getString("ID"),
                        rSet.getString("NOME"),
                        rSet.getString("DESCRIZIONE"),
                        rSet.getString("UNITA_DI_MISURA"),
                        rSet.getString("NOTE")
                    };
                    defaultModel.addRow(cell);
                }

                tabella.invalidate();
                tabella.validate();
                tabella.repaint();
                conn.close();
            } catch (Exception e) {
                erpgest.utils.Utils.logError(e, "", true);
                conn.close();
            }

            erpgest.db.Utils.ResultSetClose(rSet, null);

            tabella.setVisible(true);
            jButtonRicerca.setEnabled(true);
            parentFrame.waiting.dispose();
            parentFrame.waiting = null;
            validate();
            repaint();

            return;
        }
    }
    public void setParentPanel(JPanelOrdini parent){
        parentPanel = parent;
    }
}
