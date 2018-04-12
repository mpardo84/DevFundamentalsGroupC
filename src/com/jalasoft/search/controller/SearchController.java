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

import com.jalasoft.search.model.*;
import com.jalasoft.search.view.SearchProject;

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

     public void configureSearchCriterial(){
         SearchCriterial searchCriterial = new SearchCriterial();
         searchCriterial.setFileName(view.getFileName());
         searchCriterial.setFilePath(view.getPathName());
         searchCriterial.setOwner(view.getOwnerValue());
         searchCriterial.setHidden(Boolean.valueOf(view.getHidden()));
         searchCriterial.setReadOnly(Boolean.valueOf(view.getReadOnly()));
         searchCriterial.setContains(view.getContains());
         searchCriterial.setSizeOption(view.getSizeOptions());
         searchCriterial.setCreatedOption(view.getCreatedOptions());
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
                 this.model.setCreatedOption("All Time");
                 this.model.setCreatedStartDate(new Date(1900-1900,01,01));
                 this.model.setCreatedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.setCreatedOption("Time Range");
                 searchCriterial.setCreatedStartDate(view.getFromCreatedDate());
                 searchCriterial.setCreatedEndDate(view.getToCreatedDate());
                 break;
             case "Today" :
                  this.model.setCreatedOption("Today");
                 searchCriterial.setCreatedStartDate(today);
                 searchCriterial.setCreatedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.setCreatedOption("Yesterday");
                 searchCriterial.setCreatedStartDate(yesterday);
                 searchCriterial.setCreatedEndDate(yesterday);
                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         switch(modifiedOption) {
             case "All Time" :
                 this.model.setModifiedEndDate(new Date(1900-1900,01,01));
                 this.model.setModifiedEndDate(new Date(2099-1900,12,12));
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
                 searchCriterial.setAccessedStartDate(new Date(1900-1900,01,01));
                 searchCriterial.setAccessedEndDate(new Date(2099-1900,12,12));
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
     */
    /*
    *
     *  method that listen action in UI from user and according to action send operation commands to model
     *
     */
     public void configureModelData(){
         this.model.getSearchCriterial().setFileName(view.getFileName());
         this.model.getSearchCriterial().setFileDirectory(view.getPathName());
         this.model.getSearchCriterial().setOwnerName(view.getOwnerValue());
         this.model.getSearchCriterial().setHidden(Boolean.valueOf(view.getHidden()));
         this.model.getSearchCriterial().setReadOnly(Boolean.valueOf(view.getReadOnly()));
         this.model.getSearchCriterial().setFileType(view.getTypeFile());
         this.model.getSearchCriterial().setFileContains(view.getContains());
         this.model.getSearchCriterial().setSizeOption(view.getSizeOptions());
         if (view.getSizeValue().isEmpty()){
             this.model.getSearchCriterial().setSize(0);
         } else {
             this.model.getSearchCriterial().setSize((Long.parseLong(view.getSizeValue()))*1024);
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
                 this.model.getSearchCriterial().setCreatedStartDate(new Date(1900-1900,01,01));
                 this.model.getSearchCriterial().setCreatedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.getSearchCriterial().setCreatedStartDate(view.getFromCreatedDate());
                 this.model.getSearchCriterial().setCreatedEndDate(view.getToCreatedDate());
                 break;
             case "Today" :
                 this.model.getSearchCriterial().setCreatedStartDate(today);
                 this.model.getSearchCriterial().setCreatedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setCreatedStartDate(yesterday);
                 this.model.getSearchCriterial().setCreatedEndDate(yesterday);
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
                 this.model.getSearchCriterial().setModifiedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setModifiedStartDate(yesterday);
                 this.model.getSearchCriterial().setModifiedEndDate(yesterday);
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
                 this.model.getSearchCriterial().setAccessedEndDate(today);
                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setAccessedStartDate(yesterday);
                 this.model.getSearchCriterial().setAccessedEndDate(yesterday);
                 break;
         }

     }
    /*
     *
     *  method that listen action in UI from user and according to action send operation commands to model
     *
     */
    public void configureModelDataDirectory(){
        this.model.getSearchCriterial().setFileName(view.getDirName());
        this.model.getSearchCriterial().setFileDirectory(view.getDirPath());
        this.model.getSearchCriterial().setOwnerName(view.getDirOwner());
        this.model.getSearchCriterial().setHidden(Boolean.valueOf(view.getDirHidden()));
        this.model.getSearchCriterial().setReadOnly(Boolean.valueOf(view.getDirReadOnly()));
        this.model.getSearchCriterial().setSizeOption(view.getSizeDirOptions());
        if (view.getSizeDirValue().isEmpty()){
            this.model.getSearchCriterial().setSize(0);
        } else {
            this.model.getSearchCriterial().setSize(Long.parseLong(view.getSizeDirValue())*1024);
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
            //configureSearchCriterial();
            // Configure data for model side
            configureModelData();
            // execute the search process
            this.model.getSearchCriterial().getFileObjectList().clear();
            this.model.searchFile(view.getPathName());
            // Display search result in UI
            this.view.getTable().setRowCount(0);
            List<FileObject> searchResult = this.model.getSearchCriterial().getFileObjectList();
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
                    rowData[2]=((File)file).getFileType();
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
             // Configure data for model side
            configureModelDataDirectory();
            // execute the search process
            this.model.getSearchCriterial().getFileObjectList().clear();
            this.model.searchDirectory(view.getPathName());
            // Display search result in UI
            this.view.getDirTable().setRowCount(0);
            List<FileObject> searchResult = this.model.getSearchCriterial().getFileObjectList();
            if (searchResult.isEmpty()) {
                this.view.setMessage("Directory not found with the selected criteria");
            }
            else{
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
            this.view.setMessage(validateResult);
        }
    }
}
