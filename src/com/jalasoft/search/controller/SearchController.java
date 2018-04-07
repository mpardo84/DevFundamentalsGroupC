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
                        if (validator.isValidateSizeValue(view.getSizeValue()) || view.getSizeValue().isEmpty()){
                            return null;
                        }else{
                            return "Size value is invalid";
                        }
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
                        if((validator.isValidateSizeValue(view.getSizeDirValue())) || (view.getSizeDirValue().isEmpty())){
                            return null;
                        }else{
                            return "Directory size value is invalid";
                        }
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
         searchCriterial.setFileType(view.getTypeFile());
         if (view.getSizeValue().isEmpty()){
             searchCriterial.setSize(0D);
         } else {
         searchCriterial.setSize((Double.parseDouble(view.getSizeValue()))*1024);
         }
         Calendar calendar = Calendar.getInstance();
         calendar.set(Calendar.HOUR, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date today = calendar.getTime();
         calendar.add(Calendar.DATE,-1);
         Date yesterday = calendar.getTime();
         String createdOption = view.getCreatedOptions();
         switch(createdOption) {
             case "All Time" :
                 this.model.setCreatedStartDate(new Date(1900,01,01));
                 this.model.setCreatedEndDate(new Date(2099,12,12));
                 break;
             case "Time Range" :
                 searchCriterial.setCreatedStartDate(view.getFromCreatedDate());
                 searchCriterial.setCreatedEndDate(view.getToCreatedDate());
                 break;
             case "Today" :
                 searchCriterial.setCreatedStartDate(today);
                 searchCriterial.setCreatedEndDate(today);
                 break;
             case "Yesterday" :
                 searchCriterial.setCreatedStartDate(yesterday);
                 searchCriterial.setCreatedEndDate(yesterday);
                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.setModifiedEndDate(new Date(1900,01,01));
                 this.model.setModifiedEndDate(new Date(2099,12,12));
                 break;
             case "Time Range" :
                 searchCriterial.setModifiedStartDate(view.getFromModifiedDate());
                 searchCriterial.setModifiedEndDate(view.getToModifiedDate());
                 break;
             case "Today" :
                 searchCriterial.setModifiedStartDate(today);
                 searchCriterial.setModifiedEndDate(today);
                 break;
             case "Yesterday" :
                 searchCriterial.setModifiedStartDate(yesterday);
                 searchCriterial.setModifiedEndDate(yesterday);
                 break;
         }
         String accessedOption = view.getAccessedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 searchCriterial.setAccessedStartDate(new Date(1900,01,01));
                 searchCriterial.setAccessedEndDate(new Date(2099,12,12));
                 break;
             case "Time Range" :
                 searchCriterial.setAccessedStartDate(view.getFromModifiedDate());
                 searchCriterial.setAccessedEndDate(view.getToModifiedDate());
                 break;
             case "Today" :
                 searchCriterial.setAccessedStartDate(today);
                 searchCriterial.setAccessedEndDate(today);
                 break;
             case "Yesterday" :
                 searchCriterial.setAccessedStartDate(yesterday);
                 searchCriterial.setAccessedEndDate(yesterday);
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
         if (view.getSizeValue().isEmpty()){
             this.model.setSize(0D);
         } else {
             this.model.setSize((Double.parseDouble(view.getSizeValue()))*1024);
             System.out.println(((Double.parseDouble(view.getSizeValue()))*1024));
         }
         Calendar calendar = Calendar.getInstance();
         calendar.set(Calendar.HOUR, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date today = calendar.getTime();
         calendar.add(Calendar.DATE,-1);
         Date yesterday = calendar.getTime();
         String createdOption = view.getCreatedOptions();
         switch(createdOption) {
             case "All Time" :
                 this.model.setCreatedStartDate(new Date(1900,01,01));
                 this.model.setCreatedEndDate(new Date(2099,12,12));
                 break;
             case "Time Range" :
                 this.model.setCreatedStartDate(view.getFromCreatedDate());
                 this.model.setCreatedEndDate(view.getToCreatedDate());
                 break;
             case "Today" :
                 this.model.setCreatedStartDate(today);
                 this.model.setCreatedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.setCreatedStartDate(yesterday);
                 this.model.setCreatedEndDate(yesterday);
                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.setModifiedStartDate(new Date(1900,01,01));
                 this.model.setModifiedEndDate(new Date(2099,12,12));
                 break;
             case "Time Range" :
                 this.model.setModifiedStartDate(view.getFromModifiedDate());
                 this.model.setModifiedEndDate(view.getToModifiedDate());
                 break;
             case "Today" :
                 this.model.setModifiedStartDate(today);
                 this.model.setModifiedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.setModifiedStartDate(yesterday);
                 this.model.setModifiedEndDate(yesterday);
                 break;
         }
         String accessedOption = view.getAccessedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.setAccessedStartDate(new Date(1900,01,01));
                 this.model.setAccessedEndDate(new Date(2099,12,12));
                 break;
             case "Time Range" :
                 this.model.setAccessedStartDate(view.getFromModifiedDate());
                 this.model.setAccessedEndDate(view.getToModifiedDate());
                 break;
             case "Today" :
                 this.model.setAccessedStartDate(today);
                 this.model.setAccessedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.setAccessedStartDate(yesterday);
                 this.model.setAccessedEndDate(yesterday);
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
                    double fileSize = file.getSize();
                    rowData[0]=file.getFileName();
                    rowData[1]=file.getFileDirectory();
                    rowData[2]=file.getFileType();
                    rowData[3]=file.getDateModified();
                    rowData[4]= String.format("%.2f", fileSize/1024);
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
