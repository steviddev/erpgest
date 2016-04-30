/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erpgest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
//import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author pino
 */
public class ExcelManager {

    private File excelOutputFile ;
    private File excelFile;
    private String excelPath = "";
    FileOutputStream fileOut = null;
    
    public void setExcelFilePath(String path){
        excelPath = path;
    }
    public void setExcelFile(File file){
        excelOutputFile = file;
    }
    public ArrayList getExcelStrDataListFromColumn(int column){
        excelFile = excelOutputFile;
        int row = 0;
        Row aRow;
        Cell cell;
        
        if( excelFile == null ){
            return null;
        }
        
        //controllo esistenza file
        if (!excelFile.exists() || !excelFile.isFile() || !excelFile.canRead() || excelFile.length() == 0) {
            return null;
        }
        
        ArrayList list = new ArrayList();
        FileInputStream inputStreamExcel = null;
        try {
            inputStreamExcel = new FileInputStream(excelFile);
            org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(inputStreamExcel);            
            Sheet sheet = wb.getSheetAt(0);
            
            try {
                while( row >= 0 ){
                    aRow = sheet.getRow(row++);
                    cell = aRow.getCell(column);
                    list.add( cell.getStringCellValue() );
                }
                
            } catch (Exception e) {
            }
            
        } catch (Exception e) {
        }finally{
            if( inputStreamExcel != null ){
                try {
                    inputStreamExcel.close();
                } catch (Exception e) {
                }
                
            }
        }
        return list;
    }
    
    public void makeExcelFile(TableModel model,Vector columns){
        HSSFSheet   sheet;
        HSSFRow     row;
        HSSFCell    cell;
        String      str;
        try {
            fileOut = new FileOutputStream(excelOutputFile);
            HSSFWorkbook workbook = new HSSFWorkbook();
            sheet = workbook.createSheet("Appuntamenti");
            //scrivo le colonne
            int k = 0;

            row = sheet.createRow( 0 );
            for( int i=0; i<columns.size();i++ ){
                cell = row.createCell( (short)i );
                str = (String)columns.get(i);
                str = str.toUpperCase();
                cell.setCellValue(str);
            }
            for(int i=0; i<model.getRowCount(); ++i){
                row = sheet.createRow( (short)( i + 1) );
                for(int j=0; j<model.getColumnCount(); ++j){
                    str = model.getValueAt(i,j).toString();
                    cell = row.createCell( (short)j );
                    cell.setCellValue(str);
                }
                //ogni 500 scrivo i dati e libero risorse
//                if( ((i % 500) == 0) ){
//                        workbook.write(fOut);
//                fOut.flush();
//                fOut.close();
//                FileInputStream inputStream = new FileInputStream(file1);
//                workbook = new HSSFWorkbook(inputStream);
//                sheet = workbook.getSheet("Pagina");
//                fOut = new FileOutputStream(file1);
//                inputStream.close();
//                }
                //System.out.println(i);
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

            JOptionPane.showMessageDialog(null, "File Excel Creato con successo");
        } catch (Exception ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
