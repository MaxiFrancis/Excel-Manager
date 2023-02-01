package org.ieti.KolyaAttila;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectionListenerImpl implements ListSelectionListener {

	private final JTable table;
	private int selectedRowIndex;

	public ListSelectionListenerImpl(JTable table) {

		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] selectedRows = table.getSelectedRows();
		int[] selectedColumns = table.getSelectedColumns();
		StringBuilder value = new StringBuilder();
		for (int selectedRow : selectedRows) {
			for (int selectedColumn : selectedColumns) {
				value.append(table.getValueAt(selectedRow, selectedColumn));
			}
		}
		System.out.println("Table element selected is: " + value);


		selectedRowIndex = table.getSelectedRow();
		System.out.println("Selected row index: " + selectedRowIndex);
	}
}


