package erpgest.utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class ChooseData extends JDialog implements ActionListener {

  public static final int OK_OPTION = 1;
  
  public static final int CANCEL_OPTION = 2;

  private static final ArrayList nomi_dei_mesi;
  
  private String return_date;
  
  //dichiaro o nomi dei mesi
  static {
    nomi_dei_mesi = new ArrayList(12);
    nomi_dei_mesi.add("Gennaio");
    nomi_dei_mesi.add("Febbraio");
    nomi_dei_mesi.add("Marzo");
    nomi_dei_mesi.add("Aprile");
    nomi_dei_mesi.add("Maggio");
    nomi_dei_mesi.add("Giugno");
    nomi_dei_mesi.add("Luglio");
    nomi_dei_mesi.add("Agosto");
    nomi_dei_mesi.add("Settembre");
    nomi_dei_mesi.add("Ottobre ");
    nomi_dei_mesi.add("Novembre");
    nomi_dei_mesi.add("Dicembre");
  };


  public ChooseData (JFrame owner, GregorianCalendar d) {
    
    super(owner, "                   Scegliere la data ", true);
    
    setTitle("Scegli la data");
    
    
    
    date = d;
    
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);   
        
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    JPanel yearPane = new JPanel();
    JPanel monthPane = new JPanel();
    yearPane.setLayout(new BoxLayout(yearPane, BoxLayout.X_AXIS));
    monthPane.setLayout(new BoxLayout(monthPane, BoxLayout.X_AXIS));

    
    
    JButton[] navButton = new JButton[4];

    /*
     * Imposto il pannello con il nome del mese e i pulsanti di navigazione
     */
    monthPane.add(navButton[0] = new JButton("<"));
    monthPane.add(labelMese =
        new JLabel(String.valueOf(nomi_dei_mesi.get(
        date.get(GregorianCalendar.MONTH))), JLabel.CENTER));
    labelMese.setMinimumSize(new Dimension(80, 17));
    labelMese.setMaximumSize(new Dimension(80, 17));
    labelMese.setPreferredSize(new Dimension(80, 17));
    monthPane.add(navButton[1] = new JButton(">"));

   /*
     * Imposto il pannello con il nome dell'anno e i pulsanti di navigazione
     */
    yearPane.add(navButton[2] = new JButton("<<"));
    yearPane.add(labelAnno =
        new JLabel(String.valueOf(
        date.get(GregorianCalendar.YEAR)),
        JLabel.CENTER), BorderLayout.CENTER);
    labelAnno.setMinimumSize(new Dimension(50, 17));
    labelAnno.setMaximumSize(new Dimension(50, 17));
    labelAnno.setPreferredSize(new Dimension(50, 17));
    yearPane.add(navButton[3] = new JButton(">>"));


    /*
     * imposto il listener per il pulsanti
     */    
    for (int i=0; i<4; i++) {
      navButton[i].addActionListener(this);
    }

    /*
     * imposto il tool tip text sui pulsanti di navigazione
     */      
    navButton[0].setToolTipText("Mese Precedente");
    navButton[1].setToolTipText("Prossimo Mese");
    navButton[2].setToolTipText("Anno Precedente");
    navButton[3].setToolTipText("Prossimo Anno");


    /*
     * imposto il pannello per mesi e anno insieme e aggiungo la formattazione
     */      
    JPanel topPane = new JPanel();
    topPane.setLayout(new BoxLayout(topPane, BoxLayout.X_AXIS));
    topPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
    topPane.add(monthPane);
    topPane.add(Box.createRigidArea(new Dimension(20, 0)));
    topPane.add(yearPane);


    
    /*
     * Avvio il pannello per i giorni del mese
     */      
    griglia = new JPanel(new GridLayout(7, 7));
    griglia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    //griglia.setBackground( new java.awt.Color(239,255,212));
    griglia.setBackground(new java.awt.Color(220, 220, 220));
    updategriglia();

    contentPane.add(topPane, BorderLayout.NORTH);
    contentPane.add(griglia, BorderLayout.CENTER);
//        //----------------------------------------------------------------------------------//
//        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
//        Action escapeAction = new AbstractAction()
//        {
//            public void actionPerformed(ActionEvent e)
//            {
//                dispose();
//            }
//        };
//        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
//        getRootPane().getActionMap().put("ESCAPE", escapeAction);      
//        //----------------------------------------------------------------------------------//
    setResizable(false);
    pack();
    
    
    
    // Centro la casella sul Frame chiamante
    int xPos = (int) (owner.getLocation().getX() + 
      (owner.getWidth() / 2) - (getWidth() / 2));
    int yPos =  (int) (owner.getLocation().getY() +
      (owner.getHeight() / 2) - (getHeight() / 2));
    setLocation(xPos, yPos);
    
    setVisible(true);
    
  }

    /*
     * Imposto un metodo esplicito per restituirmi la data selezionata
     */    
  public String getDate () {
      
      if(return_date == null || return_date.trim().equals(""))
          return_date = "";
      if(return_date.indexOf("X") > -1)
          return_date = "";
      return return_date; 
      
  }


  
    /*
     * E' il metodo core della classe; valuta l'azione eseguita sulla
     * JDialog ed effettua le operazioni richieste
     */  
  public void actionPerformed (ActionEvent evt) {
      
      //ricerco la provenienza dell'azione'
    String label = ((JButton) evt.getSource()).getText();

    
    /*
     * Mando indietro i mesi se l'azione corrisponde alla pressione del tasto
     * indietro "<"
     */ 
    if (label.equals("<")) {
      int m = nomi_dei_mesi.indexOf(labelMese.getText());
      m = prevMonth(m);
      labelMese.setText((String) nomi_dei_mesi.get(m));
      updategriglia();
    }
    /*
     * Mando avanti i mesi se l'azione corrisponde alla pressione del tasto
     * avanti ">"
     */     
    else if (label.equals(">")) {
      int m = nomi_dei_mesi.indexOf(labelMese.getText());
      m = nextMonth(m);
      labelMese.setText((String) nomi_dei_mesi.get(m));
      updategriglia();
    }
    /*
     * Mando indietro gli anni se l'azione corrisponde alla pressione del tasto
     * indietro "<<"
     */       
    else if (label.equals("<<")) {
      int y = 0;
      try {
        y = Integer.parseInt(labelAnno.getText());
      }
      catch (NumberFormatException e) {
        System.err.println(e.toString());
      }
      labelAnno.setText(String.valueOf(--y));
      updategriglia();
    }
    /*
     * Mando avanti gli anni se l'azione corrisponde alla pressione del tasto
     * avanti ">>"
     */       
    else if (label.equals(">>")) {
      int y = 0;
      try {
        y = Integer.parseInt(labelAnno.getText());
      }
      catch (NumberFormatException e) {
        System.err.println(e.toString());
      }
      labelAnno.setText(String.valueOf(++y));
      updategriglia();
    }
    else {
      String m = String.valueOf(nomi_dei_mesi.indexOf(labelMese.getText()) +1);
      String y = "0";
      String d = "0";
      try {
          //y = Integer.parseInt(labelAnno.getText());
          y = labelAnno.getText();
          d = label;
      }
      catch (NumberFormatException e) {
        System.err.println(e.toString());
      }
      
      //Per essere piu' leggibile esplicito l'aggiunta di uno 0
      //serve per la data finale
      if(d.equals("1")) d = "01";
      else if(d.equals("2")) d = "02";
      else if(d.equals("3")) d = "03";
      else if(d.equals("4")) d = "04";
      else if(d.equals("5")) d = "05";
      else if(d.equals("6")) d = "06";
      else if(d.equals("7")) d = "07";
      else if(d.equals("8")) d = "08";
      else if(d.equals("9")) d = "09";

      if(m.equals("1")) m = "01";
      else if(m.equals("2")) m = "02";
      else if(m.equals("3")) m = "03";
      else if(m.equals("4")) m = "04";
      else if(m.equals("5")) m = "05";
      else if(m.equals("6")) m = "06";
      else if(m.equals("7")) m = "07";
      else if(m.equals("8")) m = "08";
      else if(m.equals("9")) m = "09";
      
      return_date = d + "/" + m + "/" + y;
      date.setLenient(false);
      this.setVisible(false);
      
    }
  }


  private void updategriglia () {
    griglia.removeAll();


    int m = nomi_dei_mesi.indexOf(labelMese.getText());
    int y = 0;
    try {
      y = Integer.parseInt(labelAnno.getText());
    }
    catch (NumberFormatException e) {
      System.err.println(e.toString());
    }

    GregorianCalendar temp = new GregorianCalendar(y, m, 1);
    temp.setLenient(false);
    int offset = 0;

    // decido quale giorno della settimana e' il primo giorno di questo mese
    switch(temp.get(GregorianCalendar.DAY_OF_WEEK)) {
      case GregorianCalendar.MONDAY  : offset = 0; break;
      case GregorianCalendar.TUESDAY   : offset = 1; break;
      case GregorianCalendar.WEDNESDAY : offset = 2; break;
      case GregorianCalendar.THURSDAY  : offset = 3; break;
      case GregorianCalendar.FRIDAY  : offset = 4; break;
      case GregorianCalendar.SATURDAY  : offset = 5; break;
      case GregorianCalendar.SUNDAY  : offset = 6; break;
    }

    // Visualizza i giorni della settimana
    griglia.add(new JLabel("Lun", JLabel.CENTER));
    griglia.add(new JLabel("Mar", JLabel.CENTER));
    griglia.add(new JLabel("Mer", JLabel.CENTER));
    griglia.add(new JLabel("Gio", JLabel.CENTER));
    griglia.add(new JLabel("Ven", JLabel.CENTER));
    griglia.add(new JLabel("Sab", JLabel.CENTER));
    griglia.add(new JLabel("Dom", JLabel.CENTER));

    // salta al primo giorno corretto della settimana 
    for (int i=1; i<=offset; i++) {
      griglia.add(new JLabel(""));
    }

    // Mostra i giorni del mese
    JButton day;

    for (int i=1; i<=getLastDay(); i++) {
        
      griglia.add(day = new JButton(String.valueOf(i)));
      
      day.setToolTipText("Cliccare sul giorno desiderato");
      day.addActionListener(this);

    day.setMinimumSize(new Dimension(20, 20));
    day.setMaximumSize(new Dimension(20, 20));
    day.setPreferredSize(new Dimension(20, 20));
    day.setSize(new Dimension(20, 20));      
      
    day.setBackground(new java.awt.Color(239,255,212));
    day.setFont(new java.awt.Font("Arial", 1, 12));  
      
    GregorianCalendar gregoriancalendar = new GregorianCalendar(y, m, i );
    
    

      if ((i == date.get(Calendar.DATE) &&
        m == date.get(Calendar.MONTH) &&
        y == date.get(Calendar.YEAR))  || gregoriancalendar.get(Calendar.DAY_OF_WEEK) == gregoriancalendar.SUNDAY) {
          day.setForeground(Color.red);
      }
      if (gregoriancalendar.get(Calendar.DAY_OF_WEEK) == gregoriancalendar.SATURDAY) {
          day.setForeground(Color.BLUE);
      }    
    }
    
       
    
    
    for (int i=(offset+getLastDay()+1); i<=42; i++) {
      griglia.add(new JLabel(""));
    }

    
    
    repaint();
    validate();
  }


  
  private int nextMonth (int month) {
    if (month == 11) {
      return(0);
    }
    return(++month);
  }

  
  private int prevMonth (int month) {
    if (month == 0) {
      return(11);
    }
    return(--month);
  }



  private int getLastDay () {
    int m = (nomi_dei_mesi.indexOf(labelMese.getText()) + 1);
    int y = 0;
    try {
      y = Integer.parseInt(labelAnno.getText());
    }
    catch (NumberFormatException e) {
      System.err.println(e.toString());
    }

    if ((m==4) || (m==6) || (m==9) || (m==11)) {
      return(30);
    }
    else if (m==2) {
      if (date.isLeapYear(y)) {
        return(29);
      }
      return(28);
    }
    return(31);
  }

  private JPanel griglia;
  private JLabel labelAnno;  
  private GregorianCalendar date;
  private JLabel labelMese;  
}