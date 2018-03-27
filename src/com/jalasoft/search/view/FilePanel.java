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
1.0 21 Mar 2018  * @author
Monica Pardo */

public class FilePanel extends JPanel{
    private SearchPanelCriteria searchPanelCriteria;
    private SearchPanelResults searchPanelResults;

    public FilePanel(){
        //super();
        initializeDialog();

    }
    //This method allows to initialize the Panel
    public void initializeDialog(){
        setBackground(Color.white);
        this.setLayout(new GridLayout(1, 2));
        searchPanelCriteria=new SearchPanelCriteria();
        searchPanelResults=new SearchPanelResults();
        this.add(searchPanelCriteria);
        this.add(searchPanelResults);

    }

    //Method that allows to get the name for the field from the SearchPanelCriteria class
    public String getFileName(){
        return searchPanelCriteria.getNameField();
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public String getFilePath(){
        return searchPanelCriteria.getPathValue();
    }

    //Method that allows to get the owner for the field from the SearchPanelCriteria class
    public String getOwner(){
        return searchPanelCriteria.getOwnerField();
    }

    //Method that allows to get the hidden option from the SearchPanelCriteria class
    public String getHidden(){
        return searchPanelCriteria.getHiddenOptions();
    }

    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public String getReadOnly(){
        return searchPanelCriteria.getReadOnlyOptions();
    }

    //Method that allows to get the type option from the SearchPanelCriteria class
    public String getTypeFile(){
        return searchPanelCriteria.getTypeField();
    }

    //Method that allows to get the contains value from the SearchPanelCriteria class
    public String getContains(){
        return searchPanelCriteria.getContainsField();
    }

    //Method that allows to get if the type is a File from the SearchPanelCriteria class
    public String getIsFile(){
        return searchPanelCriteria.getTypeObject();
    }
}
