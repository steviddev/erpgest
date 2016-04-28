package erpgest.utils;

import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.*;
//import com.satcon.gest.database.query.dbQueryAnagraficaAzienda;

import java.io.FileOutputStream;
import java.util.Vector;
import java.awt.Color;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.Calendar;

public class fatturaAnaliticaPDF extends PdfPageEventHelper
{

        //ApiGen apigen;

        String[] cmd = new String[5];

        PdfWriter writer;
        Document document = new Document();
        Vector fontVector = new Vector();

        String header = "";
        String footer = "";

        boolean resetPageNumber = false;

        boolean pageNum = false;
        int pageCount = 0;

        int up = 0;
        int dw = 0;
        int sx = 0;
        int dx = 0;

    String ID               = "";
    String Ragione_Sociale  = "ORTOFRUTTA DI ETZI RAFFAELE";
    String Indirizzo        = "Via Is Sannas";
    String Localita         = "San Giovanni Suergiu (CI)";
    String CAPCOMUNE        = "";
    String PivaCF           = "03316270929";
    String ReaAltro         = "";
    String Telefoni         = "";
    String SitoEmail        = "";
    String Abilitato        = "";
    String Note             = "";

//   public fatturaAnaliticaPDF(ApiGen apigen) {
//
//       this.apigen = apigen;
//
//    }

//    public fatturaAnaliticaPDF() {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

   public void runFile(String path) {

      try {
           cmd[0] = "cmd.exe";
           cmd[1] = "/C";
           cmd[2] = "rundll32";
           cmd[3] = "url.dll,FileProtocolHandler";
           cmd[4] = path;

           Runtime.getRuntime().exec( cmd );
       } catch( Exception e) {}
   }






   public void stampa_pagina(int idDocumento)
   {
    String strData = ((Calendar.getInstance()).getTime()).toString();
    String path = ".\\allegati\\fatturaAnalitica_" + idDocumento + ".pdf";
    path = "./Documenti/fatturaAnalitica_" + idDocumento + ".pdf";

    Paragraph p;

    document.open();

    ResultSet rSet = null;
    

    /*
    try
     {
        rSet = null;//apigen.dbOP.select( dbQueryAnagraficaAzienda.selectAzienda(" AND ID = 0", "", ""));
          while(rSet.next())
          {
                Ragione_Sociale  = rSet.getString("RagioneSociale");
                Indirizzo        = rSet.getString("Indirizzo");
                Localita         = rSet.getString("Localita");
                CAPCOMUNE        = rSet.getString("CapComune");
                PivaCF           = rSet.getString("PivaCF");
                ReaAltro         = rSet.getString("ReaAltro");
                Telefoni         = rSet.getString("Telefoni");
                SitoEmail        = rSet.getString("SitoEmail");
                Abilitato        = rSet.getString("Abilitato");
          }
     } catch(Exception e) {
                                System.out.println("(160) Errore: " + e);
                              }*/

    try
     {
        pageNum = true;

         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
         writer.setPageEvent(this);
         document.open();

             document.add(header());
             document.add(new Paragraph("\n"));

             PdfPTable pTable = new PdfPTable(new float[] {0.48f,.02f,0.5f} );
             pTable.setWidthPercentage(100);
             pTable.addCell(new PdfPCell( minitabella() ));

             pTable.getDefaultCell().setBorder(0);

             PdfPCell noBordCell = new PdfPCell();
             noBordCell.setBorder(0);
             pTable.addCell(new PdfPCell(noBordCell));
             
             pTable.addCell(new PdfPCell( destinatario() ));

             document.add(pTable);
             document.add(new Paragraph("\n"));


             pTable = new PdfPTable(1);
             pTable.setWidthPercentage(100);
             pTable.addCell(new PdfPCell( HeadArticoli() ));

             document.add(pTable);


             pTable = new PdfPTable(1);
             pTable.setWidthPercentage(100);

             for(int i=0; i<55; i++)
              pTable.addCell(new PdfPCell( impostaArticolo( "10","uno","dd","ttt","qqq","555","666","000")  ));

             document.add(pTable);

             /*********************************************/

             document.add(new Paragraph("\n"));




             float[] widths = {0.35f,0.05f,   0.35f,0.05f,   0.1f,0.1f};

               PdfPTable PDFtable = new PdfPTable(widths);
               PDFtable.getDefaultCell().setBorder(0);
               PDFtable.setWidthPercentage(100);

               PdfPCell PDFcell;


                   PDFcell = new PdfPCell();
                   p = new Paragraph("Vettore", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   PDFcell.setBackgroundColor(new Color(230,230,230));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);

                     PDFtable.addCell(new PdfPCell(noBordCell));


                   PDFcell = new PdfPCell();
                   p = new Paragraph("Apetto dei beni", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   PDFcell.setBackgroundColor(new Color(230,230,230));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);

                     PDFtable.addCell(noBordCell);

                   PDFcell = new PdfPCell();
                   p = new Paragraph("Imponibile", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   PDFcell.setBackgroundColor(new Color(230,230,230));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);

                   PDFcell = new PdfPCell();
                   p = new Paragraph("::::::::", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);

        
                   /* DATI */
        
                   PDFcell = new PdfPCell();
                   p = new Paragraph("POSTE ITALIANE", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);
        
                     PDFtable.addCell(new PdfPCell(noBordCell));
        
                   PDFcell = new PdfPCell();
                   p = new Paragraph("Scatole + vista", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);
        
                     PDFtable.addCell(new PdfPCell(noBordCell));
        
                   PDFcell = new PdfPCell();
                   p = new Paragraph("IVA", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   PDFcell.setBackgroundColor(new Color(230,230,230));
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);
        
                   PDFcell = new PdfPCell();
                   p = new Paragraph("8033.33", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL));
                   p.setAlignment(2);
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);







                   /*Totale*/
                   noBordCell.setColspan(4);
                   PDFtable.addCell(noBordCell);
        
                   PDFcell = new PdfPCell();
                   p = new Paragraph("Totale", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
                   p.setAlignment(2);
                   p.setLeading(8);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);
        
                   PDFcell = new PdfPCell();
                   p = new Paragraph("213.33", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL));
                   p.setLeading(8);
                   p.setAlignment(2);
                   PDFcell.addElement(p);
                   PDFtable.addCell(PDFcell);


        document.add(PDFtable);


        /*********************************************/
        document.add(new Paragraph("\n"));

        pTable = new PdfPTable(1);
        pTable.setWidthPercentage(100);
        pTable.addCell(new PdfPCell( footer() ));

        document.add(pTable);
        document.add(new Paragraph("\nContributo CONAI assolto ove dovuto"
                                   , FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD)));

     } catch(Exception e) {
                            System.out.println("(161) Errore: " + e);
                          }


          try { document.close(); } catch(Exception e) { System.out.println("(166) fatturaAnaliticaPDF::stampa_pagina: " + e); }

         runFile(path);

        return;
    }



   public PdfPTable header()
   {

       PdfPTable PDFtable = null;
       Paragraph p;

          try
          {
           float[] widths_diagnosi = {.5f,.5f};

           PDFtable = new PdfPTable(2);
           PDFtable.setWidthPercentage(100f);
           PDFtable.setWidths(widths_diagnosi);
           PDFtable.getDefaultCell().setBorder(2);

           PdfPCell PDFcell;

            try {
                

                System.err.println(Paths.get(".").toAbsolutePath().normalize().toString());


               com.lowagie.text.Image jpg = com.lowagie.text.Image.getInstance("./system/utility/page_white_paintbrush.png");
               Chunk ch = new Chunk(jpg, 0, -15, true);

               PdfPCell logoCell = new PdfPCell();
               logoCell.addElement(ch);
               logoCell.setBorder(0);

               //[ AGGIUNGO CELLA LOGO ]
               PDFtable.addCell(logoCell);
            } catch(Exception e) { System.out.println("Errore x: " + e ); }


           PDFcell = new PdfPCell();
           p = new Paragraph();
           p.add(new Phrase(Ragione_Sociale + "\n"
                            , FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD)));

           p.add(
              new Phrase(
                    (Indirizzo.length()         > 0 ? Indirizzo         + "\n" : "") +
                    (Localita.length()          > 0 ? Localita          + "\n" : "") +
                    (CAPCOMUNE.length()         > 0 ? CAPCOMUNE         + "\n" : "") +
                    (PivaCF.length()            > 0 ? PivaCF            + "\n" : "") +
                    (ReaAltro.length()          > 0 ? ReaAltro          + "\n" : "") +
                    (Telefoni.length()          > 0 ? Telefoni          + "\n" : "") +
                    (SitoEmail.length()         > 0 ? SitoEmail         + "\n" : "")
                , FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL)));

           p.setLeading(10);

           PDFcell.addElement(p);

           PDFtable.addCell(PDFcell);

      } catch(Exception e) {
                            System.out.println("fatturaAnalitica::tabellaDatiAzienda: " + e);
                            return null;
                           }

    return PDFtable;
   }


   public PdfPTable minitabella()
   {
   PdfPTable PDFtable = null;

    try
     {
       float[] widths = {.25f, .5f, .25f};

       PDFtable = new PdfPTable(widths);
       PDFtable.setWidthPercentage(100);


       PdfPCell PDFcell;
       Paragraph p;



           /************************/


           PDFcell = new PdfPCell();
           p = new Paragraph("Documento n.", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Tipo Documento", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("data", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           /*************  DATI ***************/
           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("111111", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );

           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("DOCUMENTO DI TRASPORTO", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );

           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("10/10/0000", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );


           /************************************************************************************************/


           PDFcell = new PdfPCell();
           p = new Paragraph("Codice Cliente", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Partita IVA/Codice Fiscale", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Valuta", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           /*************  DATI ***************/
           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("Codice Cliente", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.setVerticalAlignment(PDFcell.ALIGN_MIDDLE);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );
           
           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("0123456789", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.setVerticalAlignment(PDFcell.ALIGN_MIDDLE);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );
           
           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("EUR", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.setVerticalAlignment(PDFcell.ALIGN_MIDDLE);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );


           
           /*************  BANCA D'APPOGGIO ***************/
           /*
           PDFcell = new PdfPCell();
           PDFcell.setColspan(3);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p = new Paragraph("Banca d'appoggio", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );
                  /* dato */
           /*
           PDFcell = new PdfPCell();
           PDFcell.setColspan(3);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("BANCA*********\nIBANIT*******************************", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );
           */

           /*************  MODALITA' DI PAGAMENTO ***************/
           /*
           PDFcell = new PdfPCell();
           PDFcell.setColspan(3);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p = new Paragraph("Modalita' pagamento:  ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );
           */
           /* Dato MODALITA' DI PAGAMENTO */
           /*
           PDFcell = new PdfPCell();
           PDFcell.setColspan(3);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("BONIFICO\n", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );
           */

           /*************  SCADENZA' DI PAGAMENTO e NUM. PAGINA ***************/
           PDFcell = new PdfPCell();
           PDFcell.setColspan(2);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p = new Paragraph("Modalità di pagamento", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );

           PDFcell = new PdfPCell();
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p = new Paragraph("Numero Pagina", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );

           
           
           /* Dato SCADENZA PAGAMENTO */
           PDFcell = new PdfPCell();
           PDFcell.setColspan(2);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("BONIFICO", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );

           /* Dato NUM. PAGINA */
           PDFcell = new PdfPCell();
           PDFcell.setColspan(1);
           PDFcell.setHorizontalAlignment(PDFcell.ALIGN_CENTER);
           p = new Paragraph("1/1", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell( PDFcell );


           
       } catch(Exception e) {
                                System.out.println("(162) Errore: " + e);
                              }
     return PDFtable;
    }


   public PdfPTable destinatario()
   {
   PdfPTable PDFtable = null;

    try
     {
       PDFtable = new PdfPTable(1);
       PDFtable.setWidthPercentage(100);

       PdfPCell PDFcell;
       Paragraph p;

           PDFcell = new PdfPCell();
           p = new Paragraph("Cliente", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("::\n::\n::\n::\n::\n::", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.setVerticalAlignment(PDFcell.ALIGN_MIDDLE);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Destinazine::", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL));
           p.setLeading(8);
           PDFcell.setVerticalAlignment(PDFcell.ALIGN_MIDDLE);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

         } catch(Exception e) {
                                System.out.println("(163) Errore: " + e);
                              }
     return PDFtable;
    }


   public PdfPTable HeadArticoli()
   {
   PdfPTable PDFtable = null;

    try
     {
       float[] widths = {0.40f,0.05f,0.05f,0.05f,0.05f,0.1f,0.1f,0.1f,0.05f};

       PDFtable = new PdfPTable(widths);
       PDFtable.setWidthPercentage(100);


       PdfPCell PDFcell;
       Paragraph p;



           PDFcell = new PdfPCell();
           p = new Paragraph("    Articolo", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Cat.", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Orig.", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Colli", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("U.M.", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Quantita", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Prezzo", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Imponibile", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);
           
           PDFcell = new PdfPCell();
           p = new Paragraph("IVA", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);           

         } catch(Exception e) {
                                System.out.println("(164) Errore: " + e);
                              }
     return PDFtable;
    }



   public PdfPTable impostaArticolo(String campo_1_codice,
                                    String campo_2_descr,
                                    String campo_3_um,
                                    String campo_4_qt,
                                    String campo_5_prezzo,
                                    String campo_6_sconto,
                                    String campo_7_imponibile,
                                    String campo_8_iva
  )
   {
   PdfPTable PDFtable = null;

    try
     {
       float[] widths = {0.40f,0.05f,0.05f,0.05f,0.05f,0.1f,0.1f,0.1f,0.05f};

       PDFtable = new PdfPTable(widths);
       PDFtable.setWidthPercentage(100);


       PdfPCell PDFcell;
       Paragraph p;



           PDFcell = new PdfPCell();
           p = new Paragraph(campo_1_codice, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_2_descr, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_3_um, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_4_qt, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_5_prezzo, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_6_sconto, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_7_imponibile, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_8_iva, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(campo_8_iva, FontFactory.getFont(FontFactory.COURIER, 6, Font.NORMAL));
           p.setLeading(4);
           p.setAlignment(1);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);           
           
         } catch(Exception e) {
                                System.out.println("(167) Errore: " + e);
                              }
     return PDFtable;
    }






// @Override
//    public void onEndPage(PdfWriter writer, Document document)
//    {
//
//     PdfPCell cell = new PdfPCell();
//     Paragraph p = new Paragraph();
//
//        try
//         {
//            Rectangle page = document.getPageSize();
//
//
//            PdfPTable head = minitabella();
//
//            head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
//            head.writeSelectedRows(0,
//                                   -1,
//                                   document.leftMargin(),
//                                   page.getHeight() - document.topMargin() + head.getTotalHeight(),
//
//            writer.getDirectContent());
//
//            float[] widths = {0.9f, 0.1f};
//            PdfPTable foot = new PdfPTable(widths);
//
//            p = new Paragraph();
//                    p.setFont(FontFactory.getFont(FontFactory.TIMES, 10, Font.ITALIC));
//                    p.add(footer);
//
//                cell = new PdfPCell();
//
//                    cell.setBorder(0);
//                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//                    cell.setVerticalAlignment(Element.ALIGN_TOP);
//                    cell.addElement(p);
//
//                    foot.addCell(cell);
//
//             p = new Paragraph();
//
//                 cell = new PdfPCell();
//
//                 if(pageNum == true) {
//                    p.setFont(FontFactory.getFont("HELVETICA", 8, Font.NORMAL));
//
//                    if(resetPageNumber == true )
//                    {
//                        pageCount = 0;
//                        resetPageNumber = false;
//                    }
//                    p.add("Pag. " + ++pageCount);
//                    p.setAlignment(2);
//                 }
//
//                    cell.setBorder(0);
//                    cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//                    cell.setVerticalAlignment(Element.ALIGN_TOP);
//                    cell.addElement(p);
//
//                    foot.addCell(cell);
//
//            foot.setTotalWidth(0+page.getWidth() - document.leftMargin() - document.rightMargin());
//            foot.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(),
//
//            writer.getDirectContent());
//        }
//        catch (Exception e) {
//            throw new ExceptionConverter(e);
//        }
//    }







   public PdfPTable footer()
   {
   PdfPTable PDFtable = null;

    try
     {


       float[] widths = {0.25f,0.05f,   0.25f,0.05f,   0.25f,0.05f,   0.25f};

       PdfPCell PDFcell;
       Paragraph p;

       widths = new float[] {0.1f,0.9f};

       PDFtable = new PdfPTable(widths);
       PDFtable.setWidthPercentage(100);


        //Vettore
        //Beni
        //Imponibile
        //IVA
        //Totale


        //Modalita di pagamento
        //Diciture
        //Privacy



           PDFcell = new PdfPCell();
           p = new Paragraph("Note", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph("Privacy", FontFactory.getFont(FontFactory.HELVETICA, 7, Font.BOLD));
           PDFcell.setBackgroundColor(new Color(230,230,230));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);

           PDFcell = new PdfPCell();
           p = new Paragraph(
                   "La informiamo ai sensi dell'attuale normativa sulla privacy, " +
                   "che i suoi dati sono depositati nel territorio italiano in " +
                   "una nostra banca dati e che vengono utilizzati esclusivamente " +
                   "per adempimenti ed obblighi amministrativi di legge, salvo " +
                   "ulteriori trattamenti effettuati in seguito a Vostro consenso." +
                   "Il ricevimento della presente, redatta attraverso dati da Voi " +
                   "indicati, costituisce assenso al trattamento dei dati cui sopra. " +
                   "Si prega di verificare la correttezza dei dati riportati di cui " +
                   "non si risponde in caso di errori.",
                   FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL));
           p.setLeading(8);
           PDFcell.addElement(p);
           PDFtable.addCell(PDFcell);





         } catch(Exception e) {
                                System.out.println("(166) Errore: " + e);
                              }
     return PDFtable;
    }


} //fine classe


























