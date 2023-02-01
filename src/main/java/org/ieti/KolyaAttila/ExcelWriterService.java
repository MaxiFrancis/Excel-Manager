package org.ieti.KolyaAttila;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriterService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelWriterService(XSSFWorkbook workbook) {
        this.workbook = workbook;
        this.sheet = workbook.createSheet("sheet1");
    }

    public void writeToExcel(String[][] data, String[] headers) {
        // Create the header row
        XSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // Create the data rows
        for (int i = 0; i < data.length; i++) {
            XSSFRow dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                dataRow.createCell(j).setCellValue(data[i][j]);
            }
        }try {
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/data.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}



