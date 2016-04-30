/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteXLSX {
	public static void main(String[] args) throws IOException {
            makeit();
	}
        private static void makeit(){
		//FileInputStream fis = new FileInputStream(new File("./Documenti/Test32.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook();
		//XSSFSheet sheet = workbook.getSheetAt(0);
                XSSFSheet sheet = wb.createSheet("sheet");
		//Create First Row
		XSSFRow row1 = sheet.createRow(0);
		XSSFCell r1c1 = row1.createCell(0);
		r1c1.setCellValue("Emd Id");
		XSSFCell r1c2 = row1.createCell(1);
		r1c2.setCellValue("NAME");
		XSSFCell r1c3 = row1.createCell(2);
		r1c3.setCellValue("AGE");
		//Create Second Row
		XSSFRow row2 = sheet.createRow(1);
		XSSFCell r2c1 = row2.createCell(0);
		r2c1.setCellValue("1");
		XSSFCell r2c2 = row2.createCell(1);
		r2c2.setCellValue("Ram");
		XSSFCell r2c3 = row2.createCell(2);
		r2c3.setCellValue("20");		
		//Create Third Row
		XSSFRow row3 = sheet.createRow(2);
		XSSFCell r3c1 = row3.createCell(0);
		r3c1.setCellValue("2");
		XSSFCell r3c2 = row3.createCell(1);
		r3c2.setCellValue("Shyam");

XSSFCellStyle style1 = wb.createCellStyle();
    style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(200, 200, 200)));
    style1.setFillPattern(CellStyle.SOLID_FOREGROUND);  
    //style1.setVerticalAlignment(CellStyle.VERTICAL_TOP);
    style1.setAlignment(CellStyle.ALIGN_CENTER);
    Short ib = 90;
    style1.setRotation(ib);

                r3c2.setCellStyle(style1);
		XSSFCell r3c3 = row3.createCell(2);
		r3c3.setCellValue("25");
		//fis.close();
                try {
		FileOutputStream fos =new FileOutputStream(new File("./Documenti/writetest3.xlsx"));
	    wb.write(fos);
	    fos.close();                
            } catch (Exception e) {
                e.printStackTrace();
            }

		System.out.println("Done");        
        }
} 
