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

import com.jalasoft.search.commond.LoggerWrapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 This class represent the panel that will contains the results and search criteria options for the File
 *
 * @version
1.0 25 Mar 2018  * @author
Monica Pardo */

public class DirectoryPanel extends JPanel{
    private SearchDirectoryPanelCriteria searchDirectoryCriteria;
    private SearchPanelResults searchPanelResults;

    // Get loggerWrapper intance
    LoggerWrapper logger = LoggerWrapper.getInstance();

    public DirectoryPanel(){

        initializeDialog();
    }

    //This method allows to initialize the Panel
    public void initializeDialog(){
        logger.log.info("Creating panel to get directory data");
        this.setLayout(new GridLayout(1, 2));
        searchDirectoryCriteria=new SearchDirectoryPanelCriteria();
        searchPanelResults=new SearchPanelResults("Directory");
        this.add(searchDirectoryCriteria);
        this.add(searchPanelResults);
    }

    //Method that allows to get the name for the field from the SearchPanelCriteria class
    public String getDirName(){
        return searchDirectoryCriteria.getNameDirField();
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public String getDirPath(){
        return searchDirectoryCriteria.getDirPathValue();
    }

    //Method that allows to get the owner for the field from the SearchPanelCriteria class
    public String getDirOwner(){
        return searchDirectoryCriteria.getOwnerDirField();
    }

    //Method that allows to get the hidden option from the SearchPanelCriteria class
    public String getDirHidden(){
        return searchDirectoryCriteria.getHiddenDirOptions();
    }

    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public String getDirReadOnly(){
        return searchDirectoryCriteria.getReadOnlyDirOptions();
    }

   //Get method to get the created option selected from UI
    public String getCreatedDirOptions() {
        return searchDirectoryCriteria.getCreatedDirOptions();
    }

    //Get method to get the modified option selected from UI
    public String getModifiedDirOptions() {
        return searchDirectoryCriteria.getModifiedDirOptions();
    }

    //Get method to get the acessed option selected from UI
    public String getAccessedDirOptions() {
        return searchDirectoryCriteria.getAccessedDirOptions();
    }

    //Get method to get the  range for the created option selected from UI
    public Date getFromCreatedDirDate() {
        return searchDirectoryCriteria.getFromCreatedDirDate();
    }

    //Get method to get the range for the  created option selected from UI
    public Date getToCreatedDirDate() {
        return searchDirectoryCriteria.getToCreatedDirDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getFromModifiedDirDate() {
        return searchDirectoryCriteria.getFromModifiedDirDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getToModifiedDirDate() {
        return searchDirectoryCriteria.getToModifiedDirDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getFromAccessedDirDate() {
        return searchDirectoryCriteria.getFromAccessedDirDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getToAccessedDirDate() {
        return searchDirectoryCriteria.getToAccessedDirDate();
    }

    //Get method to get the size Option value
    public String getSizeDirOptions() {
        return searchDirectoryCriteria.getSizeDirOptions();
    }

    //Get method to get the size
    public String getSizeDirValue() {
        return searchDirectoryCriteria.getSizeDirValue();
    }

    //Method that allows to get the search button
    public JButton getSearchDir(){
        return searchDirectoryCriteria.getSearchDirButton();
    }

    //method to allows set the message value
    public void setMessage(String message) {
        searchDirectoryCriteria.setMessage(message);
        searchDirectoryCriteria.validateRequiredField();
    }
    //Method that allows to get the Table
    public DefaultTableModel getDirTable() {
        return searchPanelResults.getDirTableModel();
    }
}
