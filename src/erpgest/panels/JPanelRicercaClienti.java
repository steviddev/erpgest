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
import javax.swing.JPanel;


/**
 *
 * @author Stefano Vidili <www.stevid.it>
 */
public class JPanelRicercaClienti extends javax.swing.JDialog {

    MainFrame parentFrame;
    JPanelAnagrafica parentPanel;
    

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
    
    public JPanelRicercaClienti(MainFrame parent) {
        super(parent, "Ricerca Azienda", true);

        this.parentFrame = parent;

        initComponents();
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

        // Without this, cursor always leaves text field
        //jTextFieldNome.setFocusTraversalKeysEnabled(false);

        /*
        // Our words to complete
        ArrayList<String> keywords = new ArrayList<String>(6);
                keywords.add("example");
                keywords.add("autocomplete");
                keywords.add("autocompleta");
                keywords.add("stackabuse");
                keywords.add("java");
        Autocomplete autoComplete = new Autocomplete(jTextFieldNome, keywords);
        jTextFieldNome.getDocument().addDocumentListener(autoComplete);

        // Maps the tab key to the commit action, which finishes the autocomplete
        // when given a suggestion
        jTextFieldNome.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
        jTextFieldNome.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());  */      
        
        /*
        AutoSuggestor autoSuggestor = new AutoSuggestor(jTextFieldNome, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.90f) {
            @Override
            public boolean wordTyped(String typedWord) {

                //create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
                ArrayList<String> words = new ArrayList<>();
                words.add("hello");
                words.add("heritage");
                words.add("happiness");
                words.add("goodbye");
                words.add("cruel");
                words.add("car");
                words.add("war");
                words.add("will");
                words.add("world");
                words.add("wall");                


                setDictionary(words);
                //addToDictionary("bye");//adds a single word

                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };
        */
        
        /*
        ArrayList<String> items = new ArrayList<String>();
        Locale[] locales = Locale.getAvailableLocales();
        for (int i = 0; i < locales.length; i++) {
            String item = locales[i].getDisplayName();
            items.add(item);
        }
        setupAutoComplete(jTextFieldNome, items);       
        */
        
        /*
        ArrayList<String> items = new ArrayList<String>();
        Locale[] locales = Locale.getAvailableLocales();
        for (int i = 0; i < locales.length; i++) {
            String item = locales[i].getDisplayName();
            items.add(item);
        }        
                if (autocompleteNome != null) {
                    autocompleteNome.uninstall();

                }

        jComboBoxNome.setBorder(null);
        autocompleteNome = AutoCompleteSupport.install(jComboBoxNome, GlazedLists.eventListOf(items.toArray()));        
        */
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
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCognome = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonRicerca = new javax.swing.JButton();
        idBraccialeAscOrder = new javax.swing.JRadioButton();
        idAscOrder = new javax.swing.JRadioButton();
        nomeOrder = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCodiceFiscale = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextFieldRagioneSociale = new javax.swing.JTextField();
        buttonAzzeraCampi = new javax.swing.JButton();
        idDescOrder = new javax.swing.JRadioButton();
        idRagioneSociale = new javax.swing.JRadioButton();
        jTextFieldPartitaIVA = new javax.swing.JTextField();
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
                "ID", "Rag.Soc.", "Nome Ref. Leg.", "Partita IVA", "Codice Fiscale"
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

        jTextFieldNome.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldNome);
        jTextFieldNome.setBounds(20, 120, 140, 30);

        jTextFieldCognome.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldCognome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCognome.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldCognome);
        jTextFieldCognome.setBounds(180, 120, 140, 30);

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel47.setText("Nome");
        jPanel1.add(jLabel47);
        jLabel47.setBounds(20, 90, 140, 30);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Cognome");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 90, 140, 30);

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

        buttonGroup.add(idBraccialeAscOrder);
        idBraccialeAscOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        idBraccialeAscOrder.setText("Ordinare per Rag. Soc. Ascendente");
        idBraccialeAscOrder.setOpaque(false);
        idBraccialeAscOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBraccialeAscOrderActionPerformed(evt);
            }
        });
        jPanel1.add(idBraccialeAscOrder);
        idBraccialeAscOrder.setBounds(250, 200, 240, 30);

        buttonGroup.add(idAscOrder);
        idAscOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        idAscOrder.setText("Ordinare per ID Ascendente");
        idAscOrder.setOpaque(false);
        jPanel1.add(idAscOrder);
        idAscOrder.setBounds(230, 170, 210, 30);

        buttonGroup.add(nomeOrder);
        nomeOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        nomeOrder.setSelected(true);
        nomeOrder.setText("Ordinare per nominativo");
        nomeOrder.setOpaque(false);
        jPanel1.add(nomeOrder);
        nomeOrder.setBounds(440, 170, 200, 30);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Ordinamento risultati");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 150, 210, 20);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(170, 160, 610, 10);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Codice Fiscale");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(340, 90, 160, 30);

        jTextFieldCodiceFiscale.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldCodiceFiscale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldCodiceFiscale.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldCodiceFiscale);
        jTextFieldCodiceFiscale.setBounds(340, 120, 160, 30);

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
        jLabel49.setText("Ragione Sociale");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(140, 20, 120, 30);

        jTextFieldRagioneSociale.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldRagioneSociale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldRagioneSociale.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldRagioneSociale);
        jTextFieldRagioneSociale.setBounds(140, 50, 170, 30);

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
        idDescOrder.setBounds(20, 170, 210, 30);

        buttonGroup.add(idRagioneSociale);
        idRagioneSociale.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        idRagioneSociale.setText("Ordinare per Rag. Soc. Discendente ");
        idRagioneSociale.setOpaque(false);
        jPanel1.add(idRagioneSociale);
        idRagioneSociale.setBounds(20, 200, 260, 30);

        jTextFieldPartitaIVA.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldPartitaIVA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldPartitaIVA.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jTextFieldPartitaIVA);
        jTextFieldPartitaIVA.setBounds(330, 50, 170, 30);

        jLabel50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel50.setText("Partita IVA");
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
        id = 0;
        ResultSet res;
        try {
            int[] selection = tabella.getSelectedRows();
            id = Integer.parseInt(tabella.getModel().getValueAt(tabella.getSelectedRow(), 0).toString() ) ;
            parentPanel.aggiornaFinestraInserimentoCliente(id);
            
            /*
            colonna_ID = tabella.getModel().getValueAt(tabella.getSelectedRow(), 0).toString();
            colonna_nome = tabella.getModel().getValueAt(tabella.getSelectedRow(), 2).toString();
            colonna_cognome = tabella.getModel().getValueAt(tabella.getSelectedRow(), 1).toString();
            try {
                colonna_CodiceFiscale = tabella.getModel().getValueAt(tabella.getSelectedRow(), 3).toString();
            } catch (Exception e) {
                colonna_CodiceFiscale = "";
            }
            
            try {
                colonna_id_bracciale = tabella.getModel().getValueAt(tabella.getSelectedRow(), 4).toString();
            } catch (Exception e) {
                colonna_id_bracciale = "";
            }
            
            parent.azzeraCampi();
            
            parent.setNome(colonna_nome);
            parent.setCognome(colonna_cognome);
            parent.setCodiceFiscale(colonna_CodiceFiscale);
            parent.setID(colonna_ID);
            parent.setCodiceBraccialetto(colonna_id_bracciale);
            
            String query = "select u.citta,u.indirizzo,u.telefono,u.id_transponder "
                        +"from plc.utenti AS u "
                        + " "
                        + "where u.id = " + colonna_ID ;
            
            //recupero gli altri dati
            try {
                DbConn conn = new DbConn();
                conn.makeConn();
                
                res = conn.selectSMS(query);
                
                while (res.next()) {
                    parent.setCitta( res.getString("citta") );
                    parent.setIndirizzo(res.getString("indirizzo") );
                    parent.setTelefono(res.getString("telefono") );
                    parent.setUUID(res.getString("id_transponder") );
                }
                
            } catch (Exception e) {
                System.out.println(query);
            }
            */
            
        } catch (Exception e) {
            new javax.swing.JOptionPane().showMessageDialog(
                    jPanel1,
                    "Selezionare Un Elemento",
                    "Attenzione",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        if (id >= 0) {
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

    private void idBraccialeAscOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBraccialeAscOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBraccialeAscOrderActionPerformed

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
    private javax.swing.JRadioButton idBraccialeAscOrder;
    private javax.swing.JRadioButton idDescOrder;
    private javax.swing.JRadioButton idRagioneSociale;
    private javax.swing.JButton jButtonChiudi;
    private javax.swing.JButton jButtonRicerca;
    private javax.swing.JButton jButtonSeleziona;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel47;
    protected javax.swing.JLabel jLabel48;
    protected javax.swing.JLabel jLabel49;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    protected javax.swing.JTextField jTextFieldCodiceFiscale;
    protected javax.swing.JTextField jTextFieldCognome;
    protected javax.swing.JTextField jTextFieldID;
    protected javax.swing.JTextField jTextFieldNome;
    protected javax.swing.JTextField jTextFieldPartitaIVA;
    protected javax.swing.JTextField jTextFieldRagioneSociale;
    private javax.swing.JRadioButton nomeOrder;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables

    private void azzeraCampi() {
        jTextFieldNome.setText("");
        jTextFieldRagioneSociale.setText("");
        jTextFieldCodiceFiscale.setText("");
        jTextFieldID.setText("");
        jTextFieldCognome.setText("");
        jTextFieldPartitaIVA.setText("");
    }

    class eseguiRicerca implements Runnable {

        @Override
        public void run() {
            String query;
            boolean ricercaDuplicati = false;
            /*
            if( jRadioButtonDuplicati.isSelected() ){
                query = "select * from\n" +
                        "plc.utenti u1\n" +
                        "where (u1.nome,u1.cognome) in \n" +
                        "(select u2.nome,u2.cognome from plc.utenti u2\n" +
                        "where 1=1\n" +
                        "and u2.attivo = 'S'\n" +
                        "group by u2.nome,u2.cognome\n" +
                        "having count(*) > 1)\n" +
                        "and u1.attivo = 'S'\n" +
                        "order by u1.nome, u1.cognome ";
                ricercaDuplicati = true;
            }else */
                query = "SELECT * FROM ANAGRAFICA a where 1=1 and a.attivo='S' ";
            
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
                    if (jTextFieldCognome.getText().trim().length() > 0) {
                            filter += "\n AND upper(a.cognome) LIKE '%" + jTextFieldCognome.getText().toUpperCase().replace("'", "''") + "%' ";
                    }

                    if (jTextFieldNome.getText().trim().length() > 0) {
                        filter += "\n AND upper(a.nome) LIKE '%" + jTextFieldNome.getText().toUpperCase().replace("'", "''") + "%' ";
                    }

                    if (jTextFieldCodiceFiscale.getText().trim().length() > 0) {
                        filter += "\n AND upper(a.codice_fiscale) LIKE '%" + jTextFieldCodiceFiscale.getText().toUpperCase().replace("'", "''") + "%' ";
                    }

                    if (jTextFieldRagioneSociale.getText().trim().length() > 0) {
                        filter += "\n AND a.id_transponder =" + jTextFieldRagioneSociale.getText().toUpperCase().replace("'", "''") + " ";
                    }

                    if (jTextFieldID.getText().trim().length() > 0) {
                        filter += "\n AND a.id =" + jTextFieldID.getText().toUpperCase().replace("'", "''") + " ";
                    }

                    if (jTextFieldPartitaIVA.getText().trim().length() > 0) {
                        filter += "\n AND upper(a.cabina) LIKE '%" + jTextFieldPartitaIVA.getText().trim().toUpperCase().replace("'", "''") + "%' ";
                    }                

                    if (idDescOrder.isSelected() == true) {
                        order += "\n ORDER BY a.ID  DESC ";
                    } else if (idAscOrder.isSelected() == true) {
                        order += "\n ORDER BY a.ID  ASC ";
                    } else if (nomeOrder.isSelected() == true && jTextFieldNome.getText().trim().length() > 0) {
                        order += "\n ORDER BY upper(trim(a.cognome)), upper(trim(a.nome)) ";
                    } else if( idRagioneSociale.isSelected()){
                        order += "\n and id_transponder is not null ORDER BY a.id_transponder DESC ";
                    }else if( idBraccialeAscOrder.isSelected()){
                        order += "\n and id_transponder is not null ORDER BY a.id_transponder ASC ";
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
                    Object[] cell = {rSet.getInt("id"),
                        rSet.getString("cognome"),
                        rSet.getString("nome"),
                        rSet.getString("id_transponder"),
                        rSet.getString("cabina"),
                        rSet.getString("codice_fiscale")
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

}
