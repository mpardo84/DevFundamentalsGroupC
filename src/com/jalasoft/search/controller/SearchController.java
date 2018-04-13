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

import com.jalasoft.search.commond.LoggerWrapper;
import com.jalasoft.search.model.File;
import com.jalasoft.search.model.FileObject;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.model.SearchCriterial;
import com.jalasoft.search.view.SearchProject;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    // Get loggerWrapper intance
    LoggerWrapper logger = LoggerWrapper.getInstance();

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

    //Log log = Log.getInstance();
    //log.searchLog.severe("SearchController class");

    /**
    *
    * validateData method where all file data are validated in order to verify that they are valid
    *
    */
    public String validateData(String type) {
        Validator validator = new Validator();
        logger.log.info( "Starting validation data process .......");
        if (type == "File") {
            if (validator.areRequiredFieldsFilled(view.getPathName()) == true) {
                if (validator.isValidPath(view.getPathName())) {
                    if ((validator.isValidFileName(view.getFileName()) == true) || (view.getFileName().isEmpty())) {
                        if (validator.isValidateSizeValue(view.getSizeValue()) || view.getSizeValue().isEmpty()){
                            if (validator.isValidExtension(view.getTypeFile()) == true){
                                logger.log.info( "Data entered to search files are valid");
                                return null;
                            }else{
                                return "File type is invalid";
                            }
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
                            logger.log.info("Data entered to search a directory are valid");
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
     *  method that listen action in UI from user and according to action send operation commands to model
     *
     */
     public void configureModelData(){
         logger.log.info("Configuring file data for model side");
         this.model.getSearchCriterial().setFileName(view.getFileName());
         this.model.getSearchCriterial().setFileDirectory(view.getPathName());
         this.model.getSearchCriterial().setOwnerName(view.getOwnerValue());
         this.model.getSearchCriterial().setHidden(Boolean.valueOf(view.getHidden()));
         this.model.getSearchCriterial().setReadOnly(Boolean.valueOf(view.getReadOnly()));
         this.model.getSearchCriterial().setFileType(view.getTypeFile());
         this.model.getSearchCriterial().setFileContains(view.getContains());
         this.model.getSearchCriterial().setSizeOption(view.getSizeOptions());
         if (view.getSizeValue().isEmpty()){
             this.model.getSearchCriterial().setSize(0D);
         } else {
             this.model.getSearchCriterial().setSize((Double.parseDouble(view.getSizeValue()))*1024);
         }
         Calendar calendar = Calendar.getInstance();
         calendar.set(Calendar.HOUR, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date today = calendar.getTime();
         calendar.add(Calendar.DATE,-1);
         Date yesterday = calendar.getTime();
         calendar.add(Calendar.DATE,2);
         Date tomorrow = calendar.getTime();
         String createdOption = view.getCreatedOptions();
         switch(createdOption) {
             case "All Time" :
                 this.model.getSearchCriterial().setCreatedStartDate(new Date(1900-1900,01,01));
                 this.model.getSearchCriterial().setCreatedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.getSearchCriterial().setCreatedStartDate(view.getFromCreatedDate());
                 this.model.getSearchCriterial().setCreatedEndDate(view.getToCreatedDate());
                 break;
             case "Today" :
                 this.model.getSearchCriterial().setCreatedStartDate(today);
                 this.model.getSearchCriterial().setCreatedEndDate(tomorrow);
                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setCreatedStartDate(yesterday);
                 this.model.getSearchCriterial().setCreatedEndDate(today);
                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.getSearchCriterial().setModifiedStartDate(new Date(1900-1900,01,01));
                 this.model.getSearchCriterial().setModifiedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.getSearchCriterial().setModifiedStartDate(view.getFromModifiedDate());
                 this.model.getSearchCriterial().setModifiedEndDate(view.getToModifiedDate());
                 break;
             case "Today" :
                 this.model.getSearchCriterial().setModifiedStartDate(today);
                 this.model.getSearchCriterial().setModifiedEndDate(tomorrow);
                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setModifiedStartDate(yesterday);
                 this.model.getSearchCriterial().setModifiedEndDate(today);
                 break;
         }
         String accessedOption = view.getAccessedOptions();
         switch(accessedOption) {
             case "All Time" :
                 this.model.getSearchCriterial().setAccessedStartDate(new Date(1900-1900,01,01));
                 this.model.getSearchCriterial().setAccessedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.getSearchCriterial().setAccessedStartDate(view.getFromModifiedDate());
                 this.model.getSearchCriterial().setAccessedEndDate(view.getToModifiedDate());
                 break;
             case "Today" :
                 this.model.getSearchCriterial().setAccessedStartDate(today);
                 this.model.getSearchCriterial().setAccessedEndDate(tomorrow);
                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setAccessedStartDate(yesterday);
                 this.model.getSearchCriterial().setAccessedEndDate(today);
                 break;
         }
     }

    /*
     *
     *  method that listen action in UI from user and according to action send operation commands to model
     *
     */
    public void configureModelDataDirectory(){
        logger.log.info("Configuring directory data for model side.....");
        this.model.getSearchCriterial().setFileName(view.getDirName());
        this.model.getSearchCriterial().setFileDirectory(view.getDirPath());
        this.model.getSearchCriterial().setOwnerName(view.getDirOwner());
        this.model.getSearchCriterial().setHidden(Boolean.valueOf(view.getDirHidden()));
        this.model.getSearchCriterial().setReadOnly(Boolean.valueOf(view.getDirReadOnly()));
        this.model.getSearchCriterial().setSizeOption(view.getSizeDirOptions());
        if (view.getSizeDirValue().isEmpty()){
            this.model.getSearchCriterial().setSize(0D);
        } else {
            this.model.getSearchCriterial().setSize(Double.parseDouble(view.getSizeDirValue())*1024);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date today = calendar.getTime();
        calendar.add(Calendar.DATE,-1);
        Date yesterday = calendar.getTime();
        calendar.add(Calendar.DATE,2);
        Date tomorrow = calendar.getTime();
        String createdOption = view.getCreatedDirOptions();
        switch(createdOption) {
            case "All Time" :
                this.model.getSearchCriterial().setCreatedStartDate(new Date(1900-1900,01,01));
                this.model.getSearchCriterial().setCreatedEndDate(new Date(2099-1900,12,12));
                break;
            case "Time Range" :
                this.model.getSearchCriterial().setCreatedStartDate(view.getFromCreatedDate());
                this.model.getSearchCriterial().setCreatedEndDate(view.getToCreatedDate());
                break;
            case "Today" :
                this.model.getSearchCriterial().setCreatedStartDate(today);
                this.model.getSearchCriterial().setCreatedEndDate(tomorrow);
                break;
            case "Yesterday" :
                this.model.getSearchCriterial().setCreatedStartDate(yesterday);
                this.model.getSearchCriterial().setCreatedEndDate(today);
                break;
        }
        String modifiedOption = view.getModifiedOptions();
        switch(modifiedOption) {
            case "All Time" :
                this.model.getSearchCriterial().setModifiedStartDate(new Date(1900-1900,01,01));
                this.model.getSearchCriterial().setModifiedEndDate(new Date(2099-1900,12,12));
                break;
            case "Time Range" :
                this.model.getSearchCriterial().setModifiedStartDate(view.getFromModifiedDate());
                this.model.getSearchCriterial().setModifiedEndDate(view.getToModifiedDate());
                break;
            case "Today" :
                this.model.getSearchCriterial().setModifiedStartDate(today);
                this.model.getSearchCriterial().setModifiedEndDate(tomorrow);
                break;
            case "Yesterday" :
                this.model.getSearchCriterial().setModifiedStartDate(yesterday);
                this.model.getSearchCriterial().setModifiedEndDate(today);
                break;
        }
        String accessedOption = view.getAccessedOptions();
        switch(accessedOption) {
            case "All Time" :
                this.model.getSearchCriterial().setAccessedStartDate(new Date(1900-1900,01,01));
                this.model.getSearchCriterial().setAccessedEndDate(new Date(2099-1900,12,12));
                break;
            case "Time Range" :
                this.model.getSearchCriterial().setAccessedStartDate(view.getFromModifiedDate());
                this.model.getSearchCriterial().setAccessedEndDate(view.getToModifiedDate());
                break;
            case "Today" :
                this.model.getSearchCriterial().setAccessedStartDate(today);
                this.model.getSearchCriterial().setAccessedEndDate(tomorrow);
                break;
            case "Yesterday" :
                this.model.getSearchCriterial().setAccessedStartDate(yesterday);
                this.model.getSearchCriterial().setAccessedEndDate(today);
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
            // Configure data for model side
            configureModelData();
            // execute the search process
            logger.log.info( "Searching by files ......");
            this.model.getSearchCriterial().getFileObjectList().clear();
            this.model.searchFile(view.getPathName());
            logger.log.info( "Successfully search process");
            // Display search result in UI
            this.view.getTable().setRowCount(0);
            List<FileObject> searchResult = this.model.getSearchCriterial().getFileObjectList();
            if (searchResult.isEmpty()) {
                logger.log.info( "File not found with the selected criteria");
                this.view.setMessage("File not found with the selected criteria");
            }
            else{
                logger.log.info( "Displaying search result to final user....");
                Object rowData[]=new Object[5];
                for (FileObject file : searchResult)
                {
                    double fileSize = file.getSize();
                    rowData[0]=file.getFileName();
                    rowData[1]=file.getFileDirectory();
                    rowData[2]=((File)file).getFileType();
                    rowData[3]=file.getDateModified();
                    rowData[4]= String.format("%.2f", fileSize/1024);
                    this.view.getTable().addRow(rowData);
                }
            }
        } else {
            // Display validation error messages
            logger.log.warning( "Entered data are invalid : " + validateResult);
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
             // Configure data for model side
            configureModelDataDirectory();
            // execute the search process
            logger.log.info( "Searching  a directory......");
            this.model.getSearchCriterial().getFileObjectList().clear();
            this.model.searchDirectory(view.getDirPath());
            logger.log.info( "Successfully search process");
            // Display search result in UI
            this.view.getDirTable().setRowCount(0);
            List<FileObject> searchResult = this.model.getSearchCriterial().getFileObjectList();
            if (searchResult.isEmpty()) {
                logger.log.info( "Directory not found with the selected criteria");
                this.view.setMessage("Directory not found with the selected criteria");
            }
            else{
                logger.log.info( "Displaying search result to final user ......");
                Object rowData[]=new Object[6];
                for (FileObject dir : searchResult)
                {
                    double dirSize = dir.getSize();
                    rowData[0]=dir.getFileName();
                    rowData[1]=dir.getFileDirectory();
                    rowData[2]=dir.isHidden();
                    rowData[3]=dir.getDateModified();
                    rowData[4]=String.format("%.2f", dirSize/1024);
                    rowData[5]="10";
                    this.view.getDirTable().addRow(rowData);
                 }
            }
        } else {
            // Display validation error messages
            logger.log.warning( "Entered data for directory are invalid : " + validateResult);
            this.view.setMessage(validateResult);
        }
    }
}
