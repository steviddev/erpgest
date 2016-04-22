/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.panels;

import erpgest.utils.fatturaAnaliticaPDF;

/**
 *
 * @author SteVid <www.stevid.it>
 */
public class JPanelResocontoTotaleOrdine extends javax.swing.JPanel {

    /**
     * Creates new form JPanelResocontoTotaleOrdine
     */
    public JPanelResocontoTotaleOrdine() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonStampa = new javax.swing.JButton();
        jButtonStampa1 = new javax.swing.JButton();

        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descrizione", "Tot. Colli", "Tot. "
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(240);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(320);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 810, 403);

        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(290, 30, 51, 15);

        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(400, 30, 51, 15);

        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(490, 30, 51, 15);

        jButtonStampa.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonStampa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/img/ico/printer.png"))); // NOI18N
        jButtonStampa.setText("Stampa");
        jButtonStampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStampaActionPerformed(evt);
            }
        });
        add(jButtonStampa);
        jButtonStampa.setBounds(300, 500, 120, 34);

        jButtonStampa1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButtonStampa1.setText("Annulla");
        add(jButtonStampa1);
        jButtonStampa1.setBounds(440, 500, 120, 34);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStampaActionPerformed
        fatturaAnaliticaPDF fap = new fatturaAnaliticaPDF();
        fap.stampa_pagina(0);
    }//GEN-LAST:event_jButtonStampaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStampa;
    private javax.swing.JButton jButtonStampa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}