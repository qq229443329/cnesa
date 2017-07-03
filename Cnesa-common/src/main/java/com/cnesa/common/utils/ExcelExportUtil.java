package com.cnesa.common.utils;

import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shangpeibao on 17/1/12.
 */
public class ExcelExportUtil {

    public static String exprot(List<JSONObject> list, String fileName, String filePath) {
        String path = filePath + "/" + fileName;
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        HSSFFont font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle.setFont(font);
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row;
        HSSFCell cell;
        for (int i=0; i<list.size(); i++) {
            JSONObject object = list.get(i);
            int n=0;
            if (i==0) {
                Iterator<String> keys = list.get(0).keys();
                row = sheet.createRow(i);
                while (keys.hasNext()) {
                    cell = row.createCell(n);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(keys.next());
                    n++;
                }
                n=0;
            }
            Iterator<String> keys = list.get(0).keys();
            row = sheet.createRow(i+1);
            while (keys.hasNext()) {
                row.createCell(n).setCellValue(object.getString(keys.next()));
                n++;
            }
        }
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(path);
            wb.write(fileOut);
            fileOut.close();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
