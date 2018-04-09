/*
 *     1 21/03/18
 *
 * Copyright (c) 2018 Sun Microsystems, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 *  with Sun.
 *
 */

package com.jalasoft.search.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 This class represent the panel that will contains the results for search Files
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo */
public class SearchPanelResults extends JPanel {
    private JTable table;
    private JTable dirTable;
    private Object[][] data;
    private String[] columnNames;
    private DefaultTableModel tableModel;
    private DefaultTableModel dirTableModel;

    public SearchPanelResults(String typeObect) {
        super(new GridLayout(1,0));
        setBackground(Color.white);
        initializeTableResult(typeObect);
    }

    //Method that allows to set the table value
    public void setTable(Object[][] data) {
        this.data = data;

    }

    public void setDirTable(JTable dirTable) {
        this.dirTable = dirTable;
    }

    //Method that allow to get the Table model
    public DefaultTableModel getTable() {
        return tableModel;
    }

    public DefaultTableModel getDirTableModel() {
        return dirTableModel;
    }


    //Method that allows to set the Columns for the table
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    //Method that initialize the Table
    public void initializeTableResult(String typeObect) {

        if (typeObect == "File") {
            String[] columnNames = {"Name",
                    "Location",
                    "Extension",
                    "Date Modified",
                    "Size (KB)"};

            Object[][] data = {
                    {"", "", "", "", ""}};
            tableModel = new DefaultTableModel(data, columnNames);
            table = new JTable(tableModel);
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);
        } else {
            String[] columnNames = {"Name",
                    "Location",
                    "Hidden",
                    "Date Modified",
                    "Size",
                    "# Files"};

            Object[][] data = {
                    {"", "", "", "", "",""}};
            dirTableModel = new DefaultTableModel(data, columnNames);
            dirTable = new JTable(dirTableModel);
            dirTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
            dirTable.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(dirTable);
            add(scrollPane);
        }
    }

}
