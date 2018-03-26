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
import java.awt.Color;
import java.awt.GridLayout;

/**
 *
 This class represent the panel that will contains the results and search criteria options for the File
 *
 * @version
1.0 25 Mar 2018  * @author
Monica Pardo */

public class DirectoryPanel extends JPanel{
    private JPanel searchDirectoryCriteria;
    private JPanel searchPanelResults;

    public DirectoryPanel(){
        super();
        initializeDialog();
    }

    //This method allows to initialize the Panel
    public void initializeDialog(){
        setBackground(Color.white);
        this.setLayout(new GridLayout(1, 2));
        searchDirectoryCriteria=new SearchDirectoryPanelCriteria();
        searchPanelResults=new SearchPanelResults();
        this.add(searchDirectoryCriteria);
        this.add(searchPanelResults);
    }
}
