package org.ieti.KolyaAttila;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {

	private final XSSFWorkbook workbook;

	public ExcelService(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public String[] getHeaders() {
		XSSFSheet sheet = workbook.getSheet("sheet1");

		XSSFRow headerRow = sheet.getRow(0);
		short numberOfCells = headerRow.getLastCellNum();
		String[] headerColumns = new String[numberOfCells];

		for (int i = 0; i < numberOfCells; i++) {
			headerColumns[i] = headerRow.getCell(i).getStringCellValue();
		}
		return headerColumns;
	}

	public String[][] getContent() {
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum();
		short numberOfCells = sheet.getRow(0).getLastCellNum();

		String[][] content = new String[lastRowNum][numberOfCells];

		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < numberOfCells; j++) {

				if (row.getCell(j).getCellType().equals(CellType.NUMERIC)) {
					content[i - 1][j] = String.valueOf(row.getCell(j).getNumericCellValue());
				} else if (row.getCell(j).getCellType().equals(CellType.BOOLEAN)) {
					content[i - 1][j] = String.valueOf(row.getCell(j).getBooleanCellValue());
				} else {

					content[i - 1][j] = row.getCell(j).getStringCellValue();
				}
			}
		}
		return content;
	}
}
