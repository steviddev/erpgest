/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.MainFrame;
import erpgest.db.DbConn;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JPanelArticoli extends javax.swing.JPanel{

    /**
     * Creates new form JPanelArticoli
     */
    
    MainFrame parentFrame = null;
    String lastSearchQuery = "";
    
    public void setParentFrame(MainFrame parent){
        parentFrame = parent;
    }
    
    public JPanelArticoli() {
        initComponents();
        
        //TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTableArticoli.getModel());
        //jTableArticoli.setRowSorter(sorter);
        //jTableArticoli.setAutoCreateRowSorter(true);
        jTableArticoli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableArticoli.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                String id,nome,descrizione,um,note;
             int[] selection = jTableArticoli.getSelectedRows();
                try {
                    id = jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 0).toString() ;
                    nome = jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 1).toString() ;
                    descrizione = jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 2).toString() ;
                    um = jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 3).toString() ;
                    note = jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 4).toString() ;

                    jTextFieldID.setText(id);
                    jTextFieldNomeArticolo.setText(nome);
                    jTextFieldDescrizioneArt.setText(descrizione);
                    jTextFieldUnitaMisura.setText(um);
                    jTextFieldNoteArticolo.setText(note);                    
                } catch (Exception e1) {
                }

             
            }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArticoli = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jTextFieldNomeArticolo = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextFieldDescrizioneArt = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextFieldUnitaMisura = new javax.swing.JTextField();
        jButtonCercaArticoli = new javax.swing.JButton();
        jButtonAzzera = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jTextFieldNoteArticolo = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jButtonSalvaArticolo = new javax.swing.JButton();
        jButtonEliminaArticolo = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Gestione Articoli"));
        setLayout(null);

        jTableArticoli.setBackground(new java.awt.Color(204, 204, 204));
        jTableArticoli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrizione", "U.M.", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTableArticoli);
        if (jTableArticoli.getColumnModel().getColumnCount() > 0) {
            jTableArticoli.getColumnModel().getColumn(0).setMinWidth(40);
            jTableArticoli.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableArticoli.getColumnModel().getColumn(0).setMaxWidth(45);
            jTableArticoli.getColumnModel().getColumn(1).setMinWidth(220);
            jTableArticoli.getColumnModel().getColumn(1).setPreferredWidth(220);
            jTableArticoli.getColumnModel().getColumn(1).setMaxWidth(230);
            jTableArticoli.getColumnModel().getColumn(2).setMinWidth(250);
            jTableArticoli.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTableArticoli.getColumnModel().getColumn(2).setMaxWidth(251);
            jTableArticoli.getColumnModel().getColumn(3).setMinWidth(40);
            jTableArticoli.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTableArticoli.getColumnModel().getColumn(3).setMaxWidth(45);
            jTableArticoli.getColumnModel().getColumn(4).setMinWidth(250);
            jTableArticoli.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 170, 830, 230);

        jLabel49.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel49.setText("Nome");
        add(jLabel49);
        jLabel49.setBounds(70, 30, 90, 20);

        jTextFieldNomeArticolo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNomeArticolo.setForeground(new java.awt.Color(0, 0, 204));
        add(jTextFieldNomeArticolo);
        jTextFieldNomeArticolo.setBounds(70, 50, 230, 30);

        jLabel50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel50.setText("Descrizione");
        add(jLabel50);
        jLabel50.setBounds(310, 30, 90, 20);

        jTextFieldDescrizioneArt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldDescrizioneArt.setForeground(new java.awt.Color(0, 0, 204));
        add(jTextFieldDescrizioneArt);
        jTextFieldDescrizioneArt.setBounds(310, 50, 280, 30);

        jLabel51.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel51.setText("Unita Misura");
        add(jLabel51);
        jLabel51.setBounds(600, 30, 100, 20);

        jTextFieldUnitaMisura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldUnitaMisura.setForeground(new java.awt.Color(0, 0, 204));
        add(jTextFieldUnitaMisura);
        jTextFieldUnitaMisura.setBounds(600, 50, 80, 30);

        jButtonCercaArticoli.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonCercaArticoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/find.png"))); // NOI18N
        jButtonCercaArticoli.setText("Ricerca");
        jButtonCercaArticoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCercaArticoliActionPerformed(evt);
            }
        });
        add(jButtonCercaArticoli);
        jButtonCercaArticoli.setBounds(700, 90, 110, 40);

        jButtonAzzera.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonAzzera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/sport_shuttlecock.png"))); // NOI18N
        jButtonAzzera.setText("Azzera");
        jButtonAzzera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAzzeraActionPerformed(evt);
            }
        });
        add(jButtonAzzera);
        jButtonAzzera.setBounds(570, 90, 110, 40);

        jLabel52.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel52.setText("Note");
        add(jLabel52);
        jLabel52.setBounds(70, 80, 90, 20);

        jTextFieldNoteArticolo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldNoteArticolo.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldNoteArticolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNoteArticoloActionPerformed(evt);
            }
        });
        add(jTextFieldNoteArticolo);
        jTextFieldNoteArticolo.setBounds(70, 100, 230, 30);

        jTextFieldID.setEditable(false);
        jTextFieldID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldID.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jTextFieldID);
        jTextFieldID.setBounds(10, 50, 50, 30);

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel53.setText("ID");
        add(jLabel53);
        jLabel53.setBounds(10, 30, 50, 20);

        jButtonSalvaArticolo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonSalvaArticolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/disk.png"))); // NOI18N
        jButtonSalvaArticolo.setText(" Salva");
        jButtonSalvaArticolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvaArticoloActionPerformed(evt);
            }
        });
        add(jButtonSalvaArticolo);
        jButtonSalvaArticolo.setBounds(700, 50, 110, 40);

        jButtonEliminaArticolo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonEliminaArticolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/cross_octagon.png"))); // NOI18N
        jButtonEliminaArticolo.setText("Elimina Selezionato");
        jButtonEliminaArticolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminaArticoloActionPerformed(evt);
            }
        });
        add(jButtonEliminaArticolo);
        jButtonEliminaArticolo.setBounds(40, 420, 220, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNoteArticoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNoteArticoloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNoteArticoloActionPerformed

    private void jButtonSalvaArticoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvaArticoloActionPerformed
        String nome = jTextFieldNomeArticolo.getText().trim().toUpperCase().replaceAll("'", "''");
        String descrizione = jTextFieldDescrizioneArt.getText().trim().toUpperCase().replaceAll("'", "''");
        String note = jTextFieldNoteArticolo.getText().trim().toUpperCase().replaceAll("'", "''");
        String um   = jTextFieldUnitaMisura.getText().trim().toUpperCase().replaceAll("'", "''");
        String id   = jTextFieldID.getText().trim().toUpperCase().replaceAll("'", "''");
        
        String query = "SELECT * FROM ARTICOLI ";
        
        if( nome.equals("") || descrizione.equals("") || um.equals("")){
            JOptionPane.showMessageDialog(parentFrame.getFrame(), "Errore Nome,Descrizione e U.M. sono obbligatori", "Attenzione", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        query = query + " WHERE "
                + " NOME = '"+ nome +"' "
                + " AND DESCRIZIONE = '"+descrizione+"'"
                + " AND UNITA_DI_MISURA = '"+um+"'"
                + " AND ATTIVO = 'S'";
        
        DbConn conn = new DbConn();
        conn.makeConn();
        ResultSet res;
        try {          
            //controllo se l articolo è gia presente
            res = conn.selectSMS(query);
            
            try {
                if( res.next() ){
                    String id2 = res.getString("ID");
                    JOptionPane.showMessageDialog(parentFrame.getFrame(), "Elemento gia presente con ID="+id2, "Attenzione", JOptionPane.ERROR_MESSAGE);
                    conn.close();
                    return;        
                };
            } catch (Exception e) {
            }
            
            if( id.equals("") ){
                query = "INSERT INTO ARTICOLI (NOME,DESCRIZIONE,UNITA_DI_MISURA,NOTE) VALUES "
                        + " ('"+nome+"','"+descrizione+"','"+um+"','"+note+"');";   
                String result = conn.insert(query);
                if( !result.equals("Inserimento effettuato.") ){
                        JOptionPane.showMessageDialog(parentFrame.getFrame(), "Errore nell inserimento nuovo articolo", "Attenzione", JOptionPane.ERROR_MESSAGE);
                        conn.close();
                        return;              
                }                
            }else{
            
                query = "UPDATE ARTICOLI "
                        + " SET NOME='"+nome+"', "
                        + " DESCRIZIONE ='"+descrizione+"',"
                        + " UNITA_DI_MISURA = '"+um+"',"
                        + " NOTE='"+note+"' "
                        + " WHERE ID = '"+id+"'";
                String result = conn.update(query);
                if( !result.equals("Aggiornamento effettuato.") ){
                        JOptionPane.showMessageDialog(parentFrame.getFrame(), "Errore nell aggiornamento articolo", "Attenzione", JOptionPane.ERROR_MESSAGE);
                        conn.close();
                        return;              
                }                  
                
            }
            
            query = "SELECT * FROM ARTICOLI WHERE "
                + " NOME = '"+ nome +"' "
                + " AND DESCRIZIONE = '"+descrizione+"'"
                + " AND UNITA_DI_MISURA = '"+um+"'"
                + " AND ATTIVO = 'S'"
                + " AND NOTE = '"+note+"'"
                + " ORDER BY ID DESC";
            
            res = conn.selectSMS(query);
            
            if( res.next() ){
                //inserimento avvenuto correttamente
                jTextFieldID.setText(res.getString("ID"));
                JOptionPane.showMessageDialog(parentFrame.getFrame(), "Operazione avvenuta correttamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                lanciaThreadRicerca();
            }
            
            
        } catch (Exception e) {
            //conn.close();
        }
        
        conn.close();
    }//GEN-LAST:event_jButtonSalvaArticoloActionPerformed

    private void jButtonAzzeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAzzeraActionPerformed
        jTextFieldDescrizioneArt.setText("");
        jTextFieldID.setText("");
        jTextFieldNomeArticolo.setText("");
        jTextFieldNoteArticolo.setText("");
        jTextFieldUnitaMisura.setText("");
    }//GEN-LAST:event_jButtonAzzeraActionPerformed

    private void jButtonEliminaArticoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminaArticoloActionPerformed
        try {
            int[] selection = jTableArticoli.getSelectedRows();
            String id = jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 0).toString() ;   
            
            int n = JOptionPane.showConfirmDialog(null,
                    "ATTENZIONE!! Si vuole cancellare l'articolo "+ jTableArticoli.getModel().getValueAt(jTableArticoli.getSelectedRow(), 1).toString() +"?",
                    "",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                disabilitaArticolo(id);
            } else {            
                return;
            }               
            
            
        } catch (Exception e) {
            
            new javax.swing.JOptionPane().showMessageDialog(
                    this,
                    "Nessun Articolo Selezionato",
                    "Attenzione",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;            
        }
    
        
       
        

    }//GEN-LAST:event_jButtonEliminaArticoloActionPerformed

    private void jButtonCercaArticoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCercaArticoliActionPerformed
        lastSearchQuery = "";
        lanciaThreadRicerca();
    }//GEN-LAST:event_jButtonCercaArticoliActionPerformed

    private void lanciaThreadRicerca(){
        Thread t = new Thread(new erpgest.utils.ShowWaiting(parentFrame, null));
        t.start();
        while (parentFrame.waiting == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }

        Thread tt = new Thread(new JPanelArticoli.eseguiRicerca());
        tt.start();    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAzzera;
    private javax.swing.JButton jButtonCercaArticoli;
    private javax.swing.JButton jButtonEliminaArticolo;
    private javax.swing.JButton jButtonSalvaArticolo;
    public javax.swing.JLabel jLabel49;
    public javax.swing.JLabel jLabel50;
    public javax.swing.JLabel jLabel51;
    public javax.swing.JLabel jLabel52;
    public javax.swing.JLabel jLabel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableArticoli;
    public javax.swing.JTextField jTextFieldDescrizioneArt;
    public javax.swing.JTextField jTextFieldID;
    public javax.swing.JTextField jTextFieldNomeArticolo;
    public javax.swing.JTextField jTextFieldNoteArticolo;
    public javax.swing.JTextField jTextFieldUnitaMisura;
    // End of variables declaration//GEN-END:variables

    private void disabilitaArticolo(String id) {
        DbConn conn = new DbConn();
        conn.makeConn();
        
        try {
            String query = "UPDATE ARTICOLI SET ATTIVO = 'N' WHERE ID = '"+id+"'";
            
            String result = conn.delete(query);
            if( result.equals("Rimozione effettuata.") ){
                    JOptionPane.showMessageDialog(parentFrame.getFrame(), "Articolo cancellato correttamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                    if( id.equals(jTextFieldID.getText()) ){
                        jButtonAzzeraActionPerformed(null);
                    }
                    lanciaThreadRicerca();
                    
            }else{
                JOptionPane.showMessageDialog(parentFrame.getFrame(), "Non è stato possibile cancellare l'elemento", "Attenzione", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
        }
        conn.close();
    }
    
    
    class eseguiRicerca implements Runnable {

        @Override
        public void run() {
            String query;
            boolean ricercaDuplicati = false;

            System.out.println("QUERY RICERCA : " + lastSearchQuery);
            
            System.out.println("**************************");
            System.out.println("\n");
            
            ResultSet rSet = null;

            jTableArticoli.setVisible(false);

            String filter = "";
            String order = "";
            DbConn conn = new DbConn();
            conn.makeConn();

            try {
                
                if( lastSearchQuery.equals("") ){
                    query = "SELECT * FROM ARTICOLI a where 1=1 and a.attivo='S' ";
                    if(!ricercaDuplicati){
                        if (jTextFieldNomeArticolo.getText().trim().length() > 0) {
                                filter += "\n AND upper(a.nome) LIKE '%" + jTextFieldNomeArticolo.getText().toUpperCase().replace("'", "''") + "%' ";
                        }

                        if (jTextFieldDescrizioneArt.getText().trim().length() > 0) {
                            filter += "\n AND upper(a.descrizione) LIKE '%" + jTextFieldDescrizioneArt.getText().toUpperCase().replace("'", "''") + "%' ";
                        }

                        if (jTextFieldNoteArticolo.getText().trim().length() > 0) {
                            filter += "\n AND upper(a.note) LIKE '%" + jTextFieldNoteArticolo.getText().toUpperCase().replace("'", "''") + "%' ";
                        }

                        if (jTextFieldUnitaMisura.getText().trim().length() > 0) {
                            filter += "\n AND upper(a.unita_di_misura) LIKE '%" + jTextFieldUnitaMisura.getText().toUpperCase().replace("'", "''") + "%' ";
                        }

                        if (jTextFieldID.getText().trim().length() > 0) {
                            filter += "\n AND a.id =" + jTextFieldID.getText().toUpperCase().replace("'", "''") + " ";
                        }              

                        order += "\n ORDER BY a.ID  DESC ";
                        query = query + filter + order;
                        lastSearchQuery = query;
                    }
                }else{
                    query = lastSearchQuery;
                }

                DefaultTableModel defaultModel = (DefaultTableModel) jTableArticoli.getModel();
                
                /*
                while (defaultModel.getRowCount() > 0) {
                    defaultModel.removeRow(defaultModel.getRowCount()-1);
                    
                }*/
                try {
                    if( defaultModel.getRowCount() > 0 ){
                        //defaultModel.setRowCount(0);   

                        defaultModel.getDataVector().removeAllElements();
                        defaultModel.fireTableDataChanged();                    
                    }                    
                } catch (Exception e) {
                }


                
                rSet = conn.selectSMS(query);
                        
//                        apigen.dbOP.select(
//                        DbQueryUser.selectUsers(filter, order, "")
//                );

                while (rSet.next()) {
                    Object[] cell = {rSet.getInt("id"),
                        rSet.getString("nome"),
                        rSet.getString("descrizione"),
                        rSet.getString("unita_di_misura"),
                        rSet.getString("note"),
                    };
                    defaultModel.addRow(cell);
                }

                jTableArticoli.invalidate();
                jTableArticoli.validate();
                jTableArticoli.repaint();
                conn.close();
            } catch (Exception e) {
                erpgest.utils.Utils.logError(e, "", true);
                conn.close();
            }

            erpgest.db.Utils.ResultSetClose(rSet, null);

            jTableArticoli.setVisible(true);
            parentFrame.waiting.dispose();
            parentFrame.waiting = null;
            validate();
            repaint();

            return;
        }
    }


}

