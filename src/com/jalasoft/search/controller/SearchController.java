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
    private SearchProject view;
    private Search model;

    /**
    *
    * Init method where link with View and Model is created
    *
    */
    public SearchController(SearchProject view, Search model){
        this.view = view;
        this.model = model;
        this.view.getSearchButton().addActionListener(e -> searchButtonActionListener());
    }

    /**
    *
    * validateData method where all file data are validated in order to verify that they are valid
    *
    */
    public String validateData(){
        Validator validator = new Validator();
        if (validator.areRequiredFieldsFilled(view.getPathName()) == true) {
            if (validator.isValidPath(view.getPathName())){
                if ((validator.isValidFileName(view.getFileName()) == true) ||(view.getFileName().isEmpty())) {
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
         searchCriterial.setFileName(view.getFileName());
         searchCriterial.setFilePath(view.getPathName());
         searchCriterial.setOwner(view.getOwnerValue());
         if (view.getHidden().trim().toUpperCase()=="YES"){
             searchCriterial.setHidden(true);
         }
         else {
             searchCriterial.setHidden(false);
         }
         if (view.getReadOnly().trim().toUpperCase()=="YES"){
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
            this.model.setFileName(view.getFileName());
            this.model.setFileDirectory(view.getPathName());
            this.model.setOwnerName(view.getOwnerValue());
            this.model.setHidden(Boolean.valueOf(view.getHidden()));
            this.model.setReadOnly(Boolean.valueOf(view.getReadOnly()));
            this.model.setFileType(view.getTypeFile());
            // execute the search process
            this.model.getFileObjectList().clear();
            this.model.searchFile(view.getPathName());
            // Display search result in UI
            this.view.getTable().setRowCount(0);
            List<FileObject> searchResult = this.model.getFileObjectList();
            if (searchResult.isEmpty()) {
                this.view.setMessage("File not found with the selected criteria");
            }
            else{
                Object rowData[]=new Object[5];
                for (FileObject file : searchResult)
                {
                    rowData[0]=file.getFileName();
                    rowData[1]=file.getFileDirectory();
                    rowData[2]=file.getFileType();
                    rowData[3]=file.getDateModified();
                    rowData[4]=file.getSize();
                    this.view.getTable().addRow(rowData);
                }
            }
        } else {
            // Display validation error messages
            this.view.setMessage(validateResult);
        }
    }
}
