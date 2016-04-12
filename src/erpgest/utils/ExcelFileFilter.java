/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erpgest.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author pino
 */
public class ExcelFileFilter extends FileFilter {

    private String ext = ".xls";
    private String desc = "File Excel";
    private final String[] okFileExtensions =
            new String[]{".xls", ".xlsx", "gif"};

    public ExcelFileFilter() {
    }

    public ExcelFileFilter(String ext, String desc) {
        this.ext = ext;
        this.desc = desc;
    }

    public boolean accept(File f) {

        for (String extension : okFileExtensions) {
            if (f.getName().toLowerCase().endsWith(extension) || f.isDirectory()) {
                return true;
            }else return false;
        }
        return false;
        

//        return f.getName().toLowerCase().endsWith(ext)
//                || f.isDirectory();
    }

    public String getDescription() {
        return desc;
    }

    public void setExtension(String ext) {
        this.ext = ext;
    }
}
