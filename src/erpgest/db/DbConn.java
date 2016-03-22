/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erpgest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author sitziaimpianti
 */
public class DbConn {


    Connection connection;
    Statement statement;
    int num = 0, totale = 0;
    String user, pass;

    /**
     * Creates a new instance of dbConn
     */
    public DbConn() {
    }

    public String makeConn() {

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found!");
            }
            Properties props = new Properties();
            props.put("charSet", "latin1");
            
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinbaddb","root", "123456");

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            return "non riuscito";
        }
        return "riuscito";

    }

    public ResultSet select(String query, javax.swing.JLabel label) {
        ResultSet risultato;
        try {

            ResultSet ris = null;

            risultato = statement.executeQuery(query);
        } catch (Exception e) {
            return null;
        }
        return risultato;
    }

    public ResultSet selectSMS(String query) {

        ResultSet ris = null;
        String errMsg = "";
        try {
            if (statement == null) {
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            }
            if( statement == null ){
                errMsg = "Statement null.";
            }
            if( connection == null ){
                errMsg = "connessione null.";
            }            
            ris = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ris;
    }

    public String insert(String query) {

        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate(query);
            connection.commit();
//            System.out.println("fatta la commit");
        } catch (Exception e) {
            erpgest.db.Utils.ResultSetClose(null, statement);
            return "Errore (" + e + ")";
        }
        erpgest.db.Utils.ResultSetClose(null, statement);
        return "Inserimento effettuato.";
    }

    public String update(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            totale = statement.executeUpdate(query);
        } catch (Exception e) {
            erpgest.db.Utils.ResultSetClose(null, statement);
            return "Errore (" + e + ")";
        }
        if (totale > 0) {
            return "Aggiornamento effettuato.";
        } else {
            return "Aggiornamento non effettuato.";
        }
    }

    public String delete(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            if (statement.executeUpdate(query) > 0) {
                erpgest.db.Utils.ResultSetClose(null, statement);
                return "Rimozione effettuata.";
            } else {
                erpgest.db.Utils.ResultSetClose(null, statement);
                return "Rimozione non effettuata. Dati non trovati.";
            }

        } catch (Exception e) {
            erpgest.db.Utils.ResultSetClose(null, statement);
            return "Errore (" + e + ")";
        }

    }

    public String close() {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }

        } catch (Exception e) {
            return "Errore (" + e + ")";
        }
        return "Connessione chiusa.";
    }   
    
}
