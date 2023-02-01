package org.ieti.KolyaAttila;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		String path = "src/main/resources/data.xlsx";
		XSSFWorkbook workbook = FileUtils.readFile(path);

		ExcelService excelService = new ExcelService(workbook);
		String[] headers = excelService.getHeaders();
		String[][] content = excelService.getContent();

		TableBuilder tableBuilder = new TableBuilder();
		tableBuilder.buildTable(content, headers);
	}

}
