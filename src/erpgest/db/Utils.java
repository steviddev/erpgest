/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erpgest.db;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sitziaimpianti
 */
public class Utils {
    public static void ResultSetClose(ResultSet rSet, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e1) {
        }
        try {
            statement = null;
        } catch (Exception e1) {
        }
        try {
            if (rSet != null) {
                rSet.getStatement().close();
            }
        } catch (Exception e1) {
        }
        try {
            if (rSet != null) {
                rSet.close();
            }
        } catch (Exception e1) {
        }
        try {
            rSet = null;
        } catch (Exception e1) {
        }
    }         
}
