package org.ieti.KolyaAttila;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.table.DefaultTableModel;

public class TableModifier {

    private final DefaultTableModel tableModel;
    private String[] newRowData;

    public TableModifier(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    public void addRow(String[] newRowData) {
        this.newRowData = newRowData;
        tableModel.addRow(newRowData);
    }

    public void removeRow(int selectedRowIndex) {
        tableModel.removeRow(selectedRowIndex);
    }

    public String[] getNewRowData() {
        return newRowData;
    }

    public void saveOnExit() {
        ExcelWriterService excelWriter = new ExcelWriterService(new XSSFWorkbook());
        String[] headers = new String[tableModel.getColumnCount()];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = tableModel.getColumnName(i);
        }
        String[][] data = new String[tableModel.getRowCount()][tableModel.getColumnCount()];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = (String) tableModel.getValueAt(i, j);
            }
        }
        excelWriter.writeToExcel(data, headers);
    }
}
