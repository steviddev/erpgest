/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.db;

/**
 *
 * @author Sitzia Impianti <sitiziaimpianti.eu>
 */
public class CreateDB {
    
    DbConn conn ;
    
    
    public CreateDB(){
        try {
            conn = new DbConn();
            conn.makeConn();
            createAnagrafica();            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public void createAnagrafica(){
    
        String create = "CREATE TABLE ANAGRAFICA(\n" +
"   ID INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
"   TIPO varchar(1),\n" +
"   LISTINO integer DEFAULT 0 NOT NULL,\n" +
"   RAGIONE_SOCIALE varchar(50) DEFAULT NULL,\n" +
"   RAGIONE_SOCIALE_2 varchar(50) DEFAULT '',\n" +
"   PARTITA_IVA varchar(11) DEFAULT NULL,\n" +
"   CODICE_FISCALE varchar(16) DEFAULT NULL,\n" +
"   ID_QUALIFICA integer DEFAULT NULL,\n" +
"   ID_TITOLO integer DEFAULT NULL,\n" +
"   NOME varchar(50) DEFAULT NULL,\n" +
"   COGNOME varchar(50) DEFAULT NULL,\n" +
"   DATA_DI_NASCITA varchar(10),\n" +
"   ID_LUOGO_DI_NASCITA integer,\n" +
"   TELEFONO varchar(60) DEFAULT '' NOT NULL,\n" +
"   FAX varchar(25) DEFAULT NULL,\n" +
"   EMAIL varchar(60) DEFAULT NULL,\n" +
"   ID_TIPO_DOCUMENTO integer,\n" +
"   NUMERO_DOCUMENTO varchar(50) DEFAULT NULL,\n" +
"   DATA_E_LUOGO_RILASCIO varchar(50) DEFAULT NULL,\n" +
"   INVIO_MAIL_PUBBLICITARIA varchar(1) DEFAULT NULL,\n" +
"   INVIA_SMS_PUBBLICITARIO varchar(1) DEFAULT NULL,\n" +
"   INVIA_VOLANTINO_SU_CARTA varchar(1) DEFAULT NULL,\n" +
"   PROPOSTE_TELEFONICHE varchar(1) DEFAULT NULL,\n" +
"   INVIA_FATTURA_VIA_MAIL varchar(1) DEFAULT NULL,\n" +
"   CELLULARE_PRIVATO varchar(25) DEFAULT '',\n" +
"   CELLULARE_AZIENDALE varchar(25) DEFAULT '',\n" +
"   NOTE clob DEFAULT '',\n" +
"   ID_MIGRAZIONE integer DEFAULT 0,\n" +
"   PROVENIENZA_MIGRAZIONE varchar(50) DEFAULT '',\n" +
"   DATA_CREAZIONE timestamp DEFAULT NULL,\n" +
"   DATA_ULTIMA_MODIFICA timestamp DEFAULT NULL\n" +
")\n" +
";";
        /*
        create = "CREATE TABLE [ANAGRAFICA] (\n" +
"[ID] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
"[TIPO] varchar(1)  NULL,\n" +
"[LISTINO] integer DEFAULT '0' NOT NULL,\n" +
"[RAGIONE_SOCIALE] varchar(50) DEFAULT 'NULL' NULL,\n" +
"[RAGIONE_SOCIALE_2] varchar(50) DEFAULT '''''' NULL,\n" +
"[PARTITA_IVA] varchar(11) DEFAULT 'NULL' NULL,\n" +
"[CODICE_FISCALE] varchar(16) DEFAULT 'NULL' NULL,\n" +
"[ID_QUALIFICA] integer DEFAULT 'NULL' NULL,\n" +
"[ID_TITOLO] integer DEFAULT 'NULL' NULL,\n" +
"[NOME] varchar(50) DEFAULT 'NULL' NULL,\n" +
"[COGNOME] varchar(50) DEFAULT 'NULL' NULL,\n" +
"[DATA_DI_NASCITA] varchar(10)  NULL,\n" +
"[ID_LUOGO_DI_NASCITA] integer  NULL,\n" +
"[TELEFONO] varchar(60) DEFAULT '''''' NOT NULL,\n" +
"[FAX] varchar(25) DEFAULT 'NULL' NULL,\n" +
"[EMAIL] varchar(60) DEFAULT 'NULL' NULL,\n" +
"[ID_TIPO_DOCUMENTO] integer  NULL,\n" +
"[NUMERO_DOCUMENTO] varchar(50) DEFAULT 'NULL' NULL,\n" +
"[DATA_E_LUOGO_RILASCIO] varchar(50) DEFAULT 'NULL' NULL,\n" +
"[INVIO_MAIL_PUBBLICITARIA] varchar(1) DEFAULT 'NULL' NULL,\n" +
"[INVIA_SMS_PUBBLICITARIO] varchar(1) DEFAULT 'NULL' NULL,\n" +
"[INVIA_VOLANTINO_SU_CARTA] varchar(1) DEFAULT 'NULL' NULL,\n" +
"[PROPOSTE_TELEFONICHE] varchar(1) DEFAULT 'NULL' NULL,\n" +
"[INVIA_FATTURA_VIA_MAIL] varchar(1) DEFAULT 'NULL' NULL,\n" +
"[CELLULARE_PRIVATO] varchar(25) DEFAULT '''''' NULL,\n" +
"[CELLULARE_AZIENDALE] varchar(25) DEFAULT '''''' NULL,\n" +
"[NOTE] clob DEFAULT '''''' NULL,\n" +
"[ID_MIGRAZIONE] integer DEFAULT '0' NULL,\n" +
"[PROVENIENZA_MIGRAZIONE] varchar(50) DEFAULT '''''' NULL,\n" +
"[DATA_CREAZIONE] timestamp DEFAULT 'NULL' NULL,\n" +
"[DATA_ULTIMA_MODIFICA] timestamp DEFAULT 'NULL' NULL\n" +
")";*/
        conn.update(create);
        conn.close();
    
    }
    
}
