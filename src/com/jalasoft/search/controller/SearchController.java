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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        this.view.getSearchDir().addActionListener(e -> searchButtonDirectoryActionListener());
    }

    /**
    *
    * validateData method where all file data are validated in order to verify that they are valid
    *
    */
    public String validateData(String type) {
        Validator validator = new Validator();

        if (type == "File") {

            if (validator.areRequiredFieldsFilled(view.getPathName()) == true) {
                if (validator.isValidPath(view.getPathName())) {
                    if ((validator.isValidFileName(view.getFileName()) == true) || (view.getFileName().isEmpty())) {
                        return null;
                    } else {
                        return "File name is invalid";
                    }
                } else {
                    return "Path name is invalid";

                }
            } else {
                return "Required data 'Search Path' should be filled";
            }

        } else {

            if (validator.areRequiredFieldsFilled(view.getDirPath()) == true) {
                if (validator.isValidPath(view.getDirPath())) {
                    if ((validator.isValidFileName(view.getDirName()) == true) || (view.getDirName().isEmpty())) {
                        return null;
                    } else {
                        return "Directory name is invalid";
                    }
                } else {
                    return "Path name is invalid";

                }
            } else {
                return "Required data 'Search Path' should be filled";
            }
        }
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
         searchCriterial.setHidden(Boolean.valueOf(view.getHidden()));
         searchCriterial.setReadOnly(Boolean.valueOf(view.getReadOnly()));
         searchCriterial.setContains(view.getContains());
         searchCriterial.setSizeOption(view.getSizeOptions());
         searchCriterial.setSize((Long.valueOf(view.getSizeValue()))*1024);
         searchCriterial.setFileType(view.getTypeFile());
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         Calendar calendar = Calendar.getInstance();
         Date today = calendar.getTime();
         calendar.add(Calendar.DATE,-1);
         Date yesterday = calendar.getTime();
         String createdOption = view.getCreatedOptions();
         switch(createdOption) {
             case "All Time" :
                 searchCriterial.setCreatedStartDate("");
                 searchCriterial.setCreatedEndDate("");
                 break;
             case "Time Range" :
                 searchCriterial.setCreatedStartDate(dateFormat.format(view.getFromCreatedDate()));
                 searchCriterial.setCreatedEndDate(dateFormat.format(view.getToCreatedDate()));
                 break;
             case "Today" :
                 searchCriterial.setCreatedStartDate(dateFormat.format(today));
                 searchCriterial.setCreatedEndDate(dateFormat.format(today));
                 break;
             case "Yesterday" :
                 searchCriterial.setCreatedStartDate(dateFormat.format(yesterday));
                 searchCriterial.setCreatedEndDate(dateFormat.format(yesterday));
                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 searchCriterial.setModifiedStartDate("");
                 searchCriterial.setModifiedEndDate("");
                 break;
             case "Time Range" :
                 searchCriterial.setModifiedStartDate(dateFormat.format(view.getFromModifiedDate()));
                 searchCriterial.setModifiedEndDate(dateFormat.format(view.getToModifiedDate()));
                 break;
             case "Today" :
                 searchCriterial.setModifiedStartDate(dateFormat.format(today));
                 searchCriterial.setModifiedEndDate(dateFormat.format(today));
                 break;
             case "Yesterday" :
                 searchCriterial.setModifiedStartDate(dateFormat.format(yesterday));
                 searchCriterial.setModifiedEndDate(dateFormat.format(yesterday));
                 break;
         }
         String accessedOption = view.getAccessedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 searchCriterial.setAccessedStartDate("");
                 searchCriterial.setAccessedEndDate("");
                 break;
             case "Time Range" :
                 searchCriterial.setAccessedStartDate(dateFormat.format(view.getFromModifiedDate()));
                 searchCriterial.setAccessedEndDate(dateFormat.format(view.getToModifiedDate()));
                 break;
             case "Today" :
                 searchCriterial.setAccessedStartDate(dateFormat.format(today));
                 searchCriterial.setAccessedEndDate(dateFormat.format(today));
                 break;
             case "Yesterday" :
                 searchCriterial.setAccessedStartDate(dateFormat.format(yesterday));
                 searchCriterial.setAccessedEndDate(dateFormat.format(yesterday));
                 break;
         }
     }

    /*
    *
     *  method that listen action in UI from user and according to action send operation commands to model
     *
     */
     public void configureModelData(){
         this.model.setFileName(view.getFileName());
         this.model.setFileDirectory(view.getPathName());
         this.model.setOwnerName(view.getOwnerValue());
         this.model.setHidden(Boolean.valueOf(view.getHidden()));
         this.model.setReadOnly(Boolean.valueOf(view.getReadOnly()));
         this.model.setFileType(view.getTypeFile());
         this.model.setContains(view.getContains());
         this.model.setSizeOption(view.getSizeOptions());
         this.model.setSize((Long.valueOf(view.getSizeValue()))*1024);
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         Calendar calendar = Calendar.getInstance();
         Date today = calendar.getTime();
         calendar.add(Calendar.DATE,-1);
         Date yesterday = calendar.getTime();
         String createdOption = view.getCreatedOptions();
         switch(createdOption) {
             case "All Time" :
                 this.model.setCreatedStartDate("");
                 this.model.setCreatedEndDate("");
                 break;
             case "Time Range" :
                 this.model.setCreatedStartDate(dateFormat.format(view.getFromCreatedDate()));
                 this.model.setCreatedEndDate(dateFormat.format(view.getToCreatedDate()));
                 break;
             case "Today" :
                 this.model.setCreatedStartDate(dateFormat.format(today));
                 this.model.setCreatedEndDate(dateFormat.format(today));
                 break;
             case "Yesterday" :
                 this.model.setCreatedStartDate(dateFormat.format(yesterday));
                 this.model.setCreatedEndDate(dateFormat.format(yesterday));
                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.setModifiedStartDate("");
                 this.model.setModifiedEndDate("");
                 break;
             case "Time Range" :
                 this.model.setModifiedStartDate(dateFormat.format(view.getFromModifiedDate()));
                 this.model.setModifiedEndDate(dateFormat.format(view.getToModifiedDate()));
                 break;
             case "Today" :
                 this.model.setModifiedStartDate(dateFormat.format(today));
                 this.model.setModifiedEndDate(dateFormat.format(today));
                 break;
             case "Yesterday" :
                 this.model.setModifiedStartDate(dateFormat.format(yesterday));
                 this.model.setModifiedEndDate(dateFormat.format(yesterday));
                 break;
         }
         String accessedOption = view.getAccessedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.setAccessedStartDate("");
                 this.model.setAccessedEndDate("");
                 break;
             case "Time Range" :
                 this.model.setAccessedStartDate(dateFormat.format(view.getFromModifiedDate()));
                 this.model.setAccessedEndDate(dateFormat.format(view.getToModifiedDate()));
                 break;
             case "Today" :
                 this.model.setAccessedStartDate(dateFormat.format(today));
                 this.model.setAccessedEndDate(dateFormat.format(today));
                 break;
             case "Yesterday" :
                 this.model.setAccessedStartDate(dateFormat.format(yesterday));
                 this.model.setAccessedEndDate(dateFormat.format(yesterday));
                 break;
         }

     }

    /*
    *
    *  method that listen action in UI from user and according to action send operation commands to model    *
    *
    */
    public void searchButtonActionListener() {
        String validateResult = validateData("File");
        if (validateResult == null) {
            // Configure SearchCriterial class with UI's data
            configureSearchCriterial();
            // Configure data for model side
            configureModelData();
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
    /*
     *
     *  method that listen action in UI for Directory from user and according to action send operation commands to model    *
     */
    public void searchButtonDirectoryActionListener() {
        String validateResult = validateData("Directory");
        if (validateResult == null) {
            System.out.println("Is in the Search Directory");
        } else {
            // Display validation error messages
            this.view.setMessage(validateResult);
        }
    }
}
