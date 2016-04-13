package erpgest.utils;

import erpgest.MainFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Waiting_1 extends javax.swing.JDialog {

    MainFrame frame;

    public Waiting_1(MainFrame frame) {
        super(frame, "Operazione in corso...", true);
        this.frame = frame;
        initComponents();

        setUndecorated(true);


        //jButton1.setVisible(false);

        //jPanel1.remove(jButton1);
        int xPos1 = (int) (frame.getLocation().getX()
                + (frame.getWidth() / 2) - (getWidth() / 2));
        if (xPos1 <= 0) {
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            final Dimension screenSize = toolkit.getScreenSize();
            final int x = (screenSize.width - this.getWidth()) / 2;
            final int y = (screenSize.height - this.getHeight()) / 2;
            this.setLocation(x, y);
        } else {
            // Centro la casella sul Frame chiamante***************************//
            int xPos = (int) (frame.getLocation().getX()
                    + (frame.getWidth() / 2) - (getWidth() / 2));
            int yPos = (int) (frame.getLocation().getY()
                    + (frame.getHeight() / 2) - (getHeight() / 2));
            setLocation(xPos, yPos);
            //*****************************************************************//             
        }
    }

    public Waiting_1(MainFrame frame, JDialog dialog) {
        super(dialog, "Operazione in corso...", true);
        this.frame = frame;
        initComponents();

        setUndecorated(true);


        //jButton1.setVisible(false);

        //jPanel1.remove(jButton1);
        int xPos1 = (int) (frame.getLocation().getX()
                + (frame.getWidth() / 2) - (getWidth() / 2));
        if (xPos1 <= 0) {
            final Toolkit toolkit = Toolkit.getDefaultToolkit();
            final Dimension screenSize = toolkit.getScreenSize();
            final int x = (screenSize.width - this.getWidth()) / 2;
            final int y = (screenSize.height - this.getHeight()) / 2;
            this.setLocation(x, y);
        } else {
            // Centro la casella sul Frame chiamante***************************//
            int xPos = (int) (frame.getLocation().getX()
                    + (frame.getWidth() / 2) - (getWidth() / 2));
            int yPos = (int) (frame.getLocation().getY()
                    + (frame.getHeight() / 2) - (getHeight() / 2));
            setLocation(xPos, yPos);
            //*****************************************************************//             
        }
    }

    public Waiting_1(MainFrame frame, JDialog dialog, String messaqe) {

        super(dialog, "Operazione in corso...", true);
        this.frame = frame;
        initComponents();

        loadingLabel.setText(messaqe);

        setUndecorated(true);

        //jPanel1.remove(jButton1);

        //jButton1.setVisible(false);

        validate();
        repaint();

        // Centro la casella sul Frame chiamante***************************//
        int xPos = (int) (frame.getLocation().getX()
                + (frame.getWidth() / 2) - (getWidth() / 2));
        int yPos = (int) (frame.getLocation().getY()
                + (frame.getHeight() / 2) - (getHeight() / 2));
        setLocation(xPos, yPos);
        //*****************************************************************//             

    }

    public Waiting_1(MainFrame frame, JDialog dialog, String messaqe, boolean bool) {

        super(dialog, "Operazione in corso...", true);
        this.frame = frame;
        initComponents();

        loadingLabel.setText(messaqe);

        setUndecorated(true);

        if( !bool ){
            jPanel1.remove(jButton1);
            jButton1.setVisible(false);
            validate();
            repaint();        
        
        }

        // Centro la casella sul Frame chiamante***************************//
        int xPos = (int) (frame.getLocation().getX()
                + (frame.getWidth() / 2) - (getWidth() / 2));
        int yPos = (int) (frame.getLocation().getY()
                + (frame.getHeight() / 2) - (getHeight() / 2));
        setLocation(xPos, yPos);
        //*****************************************************************//   


        jButton1.setVisible(true);

    }

    public void setLoadingLabel(String txt) {
        loadingLabel.setText(txt);
        this.validate();
        this.repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadingLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 100));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 3, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel1.setLayout(null);

        loadingLabel.setBackground(new java.awt.Color(255, 0, 51));
        loadingLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(255, 0, 51));
        loadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpgest/images/load.gif"))); // NOI18N
        loadingLabel.setText("Operazione in corso. Attendere Prego");
        jPanel1.add(loadingLabel);
        loadingLabel.setBounds(0, 40, 388, 20);

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setText("Chiudi");
        jButton1.setMaximumSize(new java.awt.Dimension(60, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(60, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(60, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(150, 70, 80, 20);

        getContentPane().add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    //System.exit(0);
    //frame.stopListening();
    if (frame.waiting != null) {
        frame.waiting.dispose();
    }
    frame.waiting = null;
    validate();
    repaint();       

}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loadingLabel;
    // End of variables declaration//GEN-END:variables
}