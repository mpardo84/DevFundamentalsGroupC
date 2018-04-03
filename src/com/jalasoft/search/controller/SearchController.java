/*
 *      26/03/18
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
package com.jalasoft.search.controller;

import com.jalasoft.search.model.FileObject;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.model.SearchCriterial;
import com.jalasoft.search.view.SearchProject;

import java.util.List;

/**
 *
 The SearchController class interacts with model and view classes.
 *
 * @version
        23 Mar 2018
 *
 *  @author
        Gretta Rocha
 */

public class SearchController {
    private SearchProject vista;
    private Search modelo;

    /**
    *
    * Init method where link with View and Model is created
    *
    */
    public SearchController(SearchProject vista, Search modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.getSearchButton().addActionListener(e -> searchButtonActionListener());
    }

    /**
    *
    * validateData method where all file data are validated in order to verify that they are valid
    *
    */
    public String validateData(){
        Validator validator = new Validator();
        if (validator.areRequiredFieldsFilled(vista.getPathName()) == true) {
            if (validator.isValidPath(vista.getPathName())){
                if ((validator.isValidFileName(vista.getFileName()) == true) ||(vista.getFileName().isEmpty())) {
                    return null;
                } else {
                    return "File name is invalid";
                }
            } else {
                return "Path name is invalid";

            }
        }else { return "Required data 'Search Path' should be filled";}
     }

    /*
     *
     * configureSearchCriterial method gets data view side and  set the same data in model side
     *
     */
     public void configureSearchCriterial(){
         SearchCriterial searchCriterial = new SearchCriterial();
         searchCriterial.setFileName(vista.getFileName());
         searchCriterial.setFilePath(vista.getPathName());
         searchCriterial.setOwner(vista.getOwnerValue());
         if (vista.getHidden().trim().toUpperCase()=="YES"){
             searchCriterial.setHidden(true);
         }
         else {
             searchCriterial.setHidden(false);
         }
         if (vista.getReadOnly().trim().toUpperCase()=="YES"){
             searchCriterial.setReadOnly(true);
         }
         else {
             searchCriterial.setReadOnly(false);
         }
     }

    /*
    *
    *  method that listen action in UI from user and according to action send operation commands to model    *
    */
    public void searchButtonActionListener() {
        String validateResult = validateData();
        if (validateResult == null) {
            // Configure SearchCriterial class with UI's data
            configureSearchCriterial();
            // Configure data for model side
            this.modelo.setFileName(vista.getFileName());
            this.modelo.setFileDirectory(vista.getPathName());
            this.modelo.setOwnerName(vista.getOwnerValue());
            // execute the search process
            this.modelo.getFileObjectList().clear();
            this.modelo.searchFile(vista.getPathName());
            // Display search result in UI
            this.vista.getTable().setRowCount(0);
            List<FileObject> searchResult = this.modelo.getFileObjectList();
            if (searchResult.isEmpty()) {
                this.vista.setMessage("No data found");
            }
            else{
                Object rowData[]=new Object[5];
                for (FileObject file : searchResult)
                {
                    rowData[0]=file.getFileName();
                    rowData[1]=file.getFileDirectory();
                    rowData[2]=file.getFileType();
                    rowData[3]="208-02-2";
                    rowData[4]="20Kb";
                    this.vista.getTable().addRow(rowData);
                }
            }
        } else {
            // Display validation error messages
            this.vista.setMessage(validateResult);
        }
    }
}
