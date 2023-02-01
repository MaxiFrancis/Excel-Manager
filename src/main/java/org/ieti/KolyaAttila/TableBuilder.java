package org.ieti.KolyaAttila;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TableBuilder {
	private JTable table;
	private TableModifier tableModifier;
	private ListSelectionListenerImpl listSelectionListener;

	public void buildTable(String[][] content, String[] headers) {
		JFrame container = new JFrame("Table");
		container.setDefaultCloseOperation(EXIT_ON_CLOSE);

		table = new JTable(content, headers);

		table.setCellSelectionEnabled(true);

		ListSelectionListenerImpl listSelectionListener = new ListSelectionListenerImpl(table);

		ListSelectionModel select = table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		select.addListSelectionListener(listSelectionListener);

		JScrollPane scrollPane = new JScrollPane(table);


		TableModel tableModel = table.getModel();
		if (tableModel instanceof DefaultTableModel) {
			DefaultTableModel defaultTableModel = (DefaultTableModel) tableModel;

			TableModifier tableModifier = new TableModifier((DefaultTableModel) table.getModel());
			listSelectionListener = new ListSelectionListenerImpl(table);
			table.getSelectionModel().addListSelectionListener(listSelectionListener);

			String[] newRowData = {"new row data 1", "new row data 2", "new row data 3"};
			tableModifier.addRow(newRowData);
		}

		//tableModifier = new tableModifier((DefaultTableModel) table.getModel());

		// Create "Exit and Save" button
		JButton exitSaveButton = new JButton("Exit and Save");
		exitSaveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Code to save the table's content and exit the program here
			}
		});

		// Create "Add" button
		JLabel label = new JLabel();
		container.add(label);
		JTextField textField = new JTextField(20);
		container.add(textField);
		JButton addButton = new JButton("Add");
		container.add(addButton);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] newRowData = new String[0];
				tableModifier.addRow(newRowData);
			}
		});

		// Create "remove" button
		JLabel label1 = new JLabel();
		container.add(label1);
		JTextField textField1 = new JTextField(20);
		container.add(textField1);
		JButton removeButton = new JButton("remove");
		container.add(removeButton);
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = 0;
				tableModifier.removeRow(selectedRowIndex);
			}
		});

		container.add(scrollPane);
		container.setLayout(new BorderLayout());
		container.add(table.getTableHeader(), BorderLayout.PAGE_START);
		container.add(table, BorderLayout.CENTER);
		container.setVisible(true);
		container.pack();
		container.setSize(800, 400);



	}

}
