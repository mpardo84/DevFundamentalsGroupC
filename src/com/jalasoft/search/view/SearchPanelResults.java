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

/**
 *
 This class represent the panel that will contains the results for search Files
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo */
public class SearchPanelResults extends JPanel {
    private JTable table;

    public SearchPanelResults() {
        //super();
        super(new GridLayout(1,0));
        setBackground(Color.white);
        addTableResult();
    }

    public void addTableResult(){
        String[] columnNames = {"Name",
                "Location",
                "Extension",
                "Date Modified",
                "Size"};

        Object[][] data = {
                {"File1", "Directory1",
                        "txt", "22-05-2018", "20 MB"},
                {"File1", "Directory1",
                        "txt", "22-05-2018", "20 MB"},
                {"File1", "Directory1",
                        "txt", "22-05-2018", "20 MB"},
                {"File1", "Directory1",
                        "txt", "22-05-2018", "20 MB"},
                {"File1", "Directory1",
                        "txt", "22-05-2018", "20 MB"}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);
    }

}
