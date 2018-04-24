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

import com.jalasoft.search.commond.Functions;
import com.jalasoft.search.commond.LoggerWrapper;

import com.jalasoft.search.model.Search;
import com.jalasoft.search.model.SearchQuery;
import com.jalasoft.search.model.FileObject;
import com.jalasoft.search.model.Directory;
import com.jalasoft.search.model.File;
import com.jalasoft.search.model.SearchCriterial;
import com.jalasoft.search.view.SearchProject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
    Functions functions = new Functions();

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
        this.view.getSaveCriteriaButton().addActionListener(e -> saveButtonActionListener());
        this.view.getLoadCriteriaButton().addActionListener(e -> loadCriteriaButtonActionListener());
        this.view.getDirSaveButton().addActionListener(e -> saveDirButtonActionListener());
        this.view.getLoadDirCriteriaButton().addActionListener(e -> loadDirCriteriaButtonActionListener());
    }

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
         calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR)- 12);
         Date today = calendar.getTime();
         calendar.add(Calendar.DATE,-1);
         Date yesterday = calendar.getTime();
         calendar.add(Calendar.DATE,2);
         Date tomorrow = calendar.getTime();
         String createdOption = view.getCreatedOptions();
         this.model.getSearchCriterial().setCreatedOption(createdOption);
         switch(createdOption) {
             case "All Time" :
                 this.model.getSearchCriterial().setTimeOption("All Time");
                 this.model.getSearchCriterial().setCreatedStartDate(new Date(1900-1900,01,01));
                 this.model.getSearchCriterial().setCreatedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.getSearchCriterial().setTimeOption("Time Range");
                 this.model.getSearchCriterial().setCreatedStartDate(view.getFromCreatedDate());
                 this.model.getSearchCriterial().setCreatedEndDate(view.getToCreatedDate());
                 break;
             case "Today" :
                 this.model.getSearchCriterial().setTimeOption("Today");
                 this.model.getSearchCriterial().setTodayDate(today);

                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setTimeOption("Yesterday");
                 this.model.getSearchCriterial().setYesterdayDate(yesterday);

                 break;
         }
         String modifiedOption = view.getModifiedOptions();
         this.model.getSearchCriterial().setModifiedOption(modifiedOption);
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
         this.model.getSearchCriterial().setAccessedOption(accessedOption);
         switch(accessedOption) {
             case "All Time" :
                 this.model.getSearchCriterial().setTimeOption("All Time");
                 this.model.getSearchCriterial().setAccessedStartDate(new Date(1900-1900,01,01));
                 this.model.getSearchCriterial().setAccessedEndDate(new Date(2099-1900,12,12));
                 break;
             case "Time Range" :
                 this.model.getSearchCriterial().setTimeOption("Time Range");
                 this.model.getSearchCriterial().setAccessedStartDate(view.getFromAccessedDate());
                 this.model.getSearchCriterial().setAccessedEndDate(view.getToAccessedDate());
                 break;
             case "Today" :
                 this.model.getSearchCriterial().setTimeOption("Today");
                 this.model.getSearchCriterial().setTodayDate(today);

                 break;
             case "Yesterday" :
                 this.model.getSearchCriterial().setTimeOption("Yesterday");
                 this.model.getSearchCriterial().setYesterdayDate(yesterday);
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
        String createdOptionDir = view.getCreatedDirOptions();
        this.model.getSearchCriterial().setCreatedOption(createdOptionDir);
        switch(createdOptionDir) {
            case "All Time" :
                this.model.getSearchCriterial().setTimeOption("All Time");
                this.model.getSearchCriterial().setCreatedStartDate(new Date(1900-1900,01,01));
                this.model.getSearchCriterial().setCreatedEndDate(new Date(2099-1900,12,12));
                break;
            case "Time Range" :
                this.model.getSearchCriterial().setTimeOption("Time Range");
                this.model.getSearchCriterial().setCreatedStartDate(view.getFromCreatedDirDate());
                this.model.getSearchCriterial().setCreatedEndDate(view.getToCreatedDirDate());
                break;
            case "Today" :
                this.model.getSearchCriterial().setTimeOption("Today");
                this.model.getSearchCriterial().setTodayDate(today);
                break;
            case "Yesterday" :
                this.model.getSearchCriterial().setTimeOption("Yesterday");
                this.model.getSearchCriterial().setYesterdayDate(yesterday);
                break;
        }
        String modifiedOptionDir = view.getModifiedDirOptions();
        this.model.getSearchCriterial().setModifiedOption(modifiedOptionDir);
        switch(modifiedOptionDir) {
            case "All Time" :
                this.model.getSearchCriterial().setModifiedStartDate(new Date(1900-1900,01,01));
                this.model.getSearchCriterial().setModifiedEndDate(new Date(2099-1900,12,12));
                break;
            case "Time Range" :
                this.model.getSearchCriterial().setModifiedStartDate(view.getFromModifiedDirDate());
                this.model.getSearchCriterial().setModifiedEndDate(view.getToModifiedDirDate());
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
        String accessedOptionDir = view.getAccessedDirOptions();
        this.model.getSearchCriterial().setAccessedOption(accessedOptionDir);
        switch(accessedOptionDir) {
            case "All Time" :
                this.model.getSearchCriterial().setTimeOption("All Time");
                this.model.getSearchCriterial().setAccessedStartDate(new Date(1900-1900,01,01));
                this.model.getSearchCriterial().setAccessedEndDate(new Date(2099-1900,12,12));
                break;
            case "Time Range" :
                this.model.getSearchCriterial().setTimeOption("Time Range");
                this.model.getSearchCriterial().setAccessedStartDate(view.getFromAccessedDirDate());
                this.model.getSearchCriterial().setAccessedEndDate(view.getToAccessedDirDate());
                break;
            case "Today" :
                this.model.getSearchCriterial().setTimeOption("Today");
                this.model.getSearchCriterial().setTodayDate(today);
                break;
            case "Yesterday" :
                this.model.getSearchCriterial().setTimeOption("Yesterday");
                this.model.getSearchCriterial().setYesterdayDate(yesterday);
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
        this.model.setSearchCriterial(new SearchCriterial());
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
                    rowData[5]=((Directory)dir).getNumberOfFiles();
                    this.view.getDirTable().addRow(rowData);
                 }
            }
        } else {
            // Display validation error messages
            logger.log.warning( "Entered data for directory are invalid : " + validateResult);
            this.view.setMessage(validateResult);
        }
        this.model.setSearchCriterial(new SearchCriterial());
    }

    /*
     *
     *  Method that implements actions that will be executed after clicking on Save button
     *
     */
    public void saveButtonActionListener(){
        logger.log.info( "Starting saving the criteria data process .......");
        this.view.openSaveCriteriaDialog();
        String nameCri=this.view.getNameCriteria();
        if(nameCri==null){
            logger.log.info( "Name criteria dialog was closed .......");
        }
        else {
            if (nameCri.isEmpty()) {
                this.view.setMessage("Please insert a criteria Name");
                logger.log.info("Name criteria is missing .......");
            } else {
                configureModelData();
                this.model.getSearchCriterial().setCriteriaName(nameCri);
                this.model.getSearchCriterial().setTypeObject("file");
                this.model.saveCriteria(this.model.getSearchCriterial(), nameCri);
                logger.log.info("Criteria was saved in the DB .......");
            }
        }
    }

    /*
     *
     *  Method that implements actions that will be executed after clicking on Save button for Directory
     *
     */
    public void saveDirButtonActionListener(){
        this.view.openSaveDirCriteriaDialog();
        String nameCriDir=this.view.getdirNameCriteria();
        if(nameCriDir==null){
            logger.log.info( "Name criteria dialog was closed .......");
        }else {
            if (nameCriDir.isEmpty()) {
                this.view.setMessage("Please insert a criteria Name");
                logger.log.info("Name criteria was not inserted for directory panel .......");
            } else {
                configureModelDataDirectory();
                this.model.getSearchCriterial().setCriteriaName(nameCriDir);
                this.model.getSearchCriterial().setTypeObject("directory");
                this.model.saveCriteria(this.model.getSearchCriterial(), nameCriDir);
                logger.log.info("Criteria was saved in the DB for directory .......");
            }
        }
    }

    /*
     *
     *  Method that implements actions that will be executed after clicking on Load button from the Criteria dialog for File
     *  This will get the criteria saved for file and will load this in UI
     *
     */
    public void loadButtonActionListener() {
        logger.log.info("Loading selected search criteria for file in UI ........");
        Map<Integer, SearchCriterial> map = this.model.getAllData();
        int position = Integer.parseInt(this.view.getCriteriaID());
        view.setFileName(map.get(position).getFileName());
        view.setFilePath(map.get(position).getFileDirectory().toString());
        view.setOwner(map.get(position).getOwnerName());
        view.setHidden(String.valueOf(map.get(position).isHidden()));
        view.setReadOnly(String.valueOf(map.get(position).isReadOnly()));
        view.setTypeFile(map.get(position).getFileType());
        view.setContains(map.get(position).getFileContains());
        view.setSizeOptions(map.get(position).getSizeOption());
        if (map.get(position).getSize() == 0D) {
            view.setSizeValue("");
        } else {
            Double size = (map.get(position).getSize() / 1024);
            view.setSizeValue(Double.toString(size));
        }
        view.setCreatedOptions(map.get(position).getCreatedOption());
        if (map.get(position).getCreatedOption().equals("Time Range")){
            view.setFromCreatedDate(map.get(position).getCreatedStartDate());
            view.setToCreatedDate(map.get(position).getCreatedEndDate());
        }
        view.setModifiedOptions(map.get(position).getModifiedOption());
        if (map.get(position).getModifiedOption().equals("Time Range")){
            view.setFromModifiedDate(map.get(position).getModifiedStartDate());
            view.setToModifiedDate(map.get(position).getModifiedEndDate());
        }
        view.setAccessedOptions(map.get(position).getAccessedOption());
        if (map.get(position).getAccessedOption().equals("Time Range")){
            view.setFromAccessedDate(map.get(position).getAccessedStartDate());
            view.setToAccessedDate(map.get(position).getAccessedEndDate());
        }
    }

    /*
     *
     *  Method that implements actions that will be executed after clicking on Load Criteria button
     *This will get all the criteria data and will display this in the Criteria dialog
     */
    public void loadCriteriaButtonActionListener(){
        logger.log.info( "The Load was open and display the data from the database .......");
        this.view.getCriteriaTable().setRowCount(0);
        Map<Integer,SearchCriterial> map = this.model.getAllData();
        if (map.isEmpty()) {
            this.view.setMessage("There are no saved criteria");
            logger.log.info( "there is not data in the database .......");
        }
        else {
                Object rowData[]=new Object[3];
                for (Map.Entry<Integer,SearchCriterial> entry : map.entrySet())
                {
                    String typeObject=entry.getValue().getTypeObject();

                    if(typeObject.equals("file")) {

                        rowData[0] = entry.getKey();
                        rowData[1] = entry.getValue().getCriteriaName();
                        rowData[2] = entry.getValue().getTypeObject();
                        this.view.getCriteriaTable().addRow(rowData);
                    }
                }
                this.view.openLoadCriteriaDialog();
                this.view.getLoadButton().addActionListener(e -> loadButtonActionListener());
            }
        logger.log.info( "The Load dialog completed to load all the data from the database .......");
    }
    /*
     *
     *  Method that implements actions that will be executed after clicking on Load Criteria button for directory panel
     *This will get all the criteria data and will display this in the Criteria dialog
     */
    public void loadDirCriteriaButtonActionListener(){
        logger.log.info( "The Load was open and display the data from the database for the directory panel .......");
        this.view.getDirCriteriaTable().setRowCount(0);
        Map<Integer,SearchCriterial> map = this.model.getAllData();
        if (map.isEmpty()) {
            this.view.setMessage("There are no saved criteria");
            logger.log.info( "there is not data in the database .......");
        }
        else {
            Object rowData[]=new Object[3];
            for (Map.Entry<Integer,SearchCriterial> entry : map.entrySet())
            {
                String typeObject=entry.getValue().getTypeObject();

                if(typeObject.equals("directory")) {

                    rowData[0] = entry.getKey();
                    rowData[1] = entry.getValue().getCriteriaName();
                    rowData[2] = entry.getValue().getTypeObject();
                    this.view.getDirCriteriaTable().addRow(rowData);
                }
            }
            this.view.openLoadDirCriteriaDialog();
            this.view.getDirLoadButton().addActionListener(e -> loadDirButtonActionListener());
        }
        logger.log.info( "The Load dialog completed to load all the data from the database for directory panel .......");
    }

    /*
     *
     *  Method that implements actions that will be executed after clicking on Load button from the Criteria dialog for Directory
     *  This will get the criteria saved for directory and will load this in UI
     *
     */
    private void loadDirButtonActionListener() {
        logger.log.info("Loading selected search criteria for directory in UI ........");
        Map<Integer, SearchCriterial> map = this.model.getAllData();
        int criteriaID = Integer.parseInt(this.view.getDirCriteriaID());
        view.setPathDirValue(map.get(criteriaID).getFileDirectory().toString());
        view.setNameDirField(map.get(criteriaID).getFileName());
        view.setOwnerDirField(map.get(criteriaID).getOwnerName());
        view.setReadOnlyDirOptions(toString().valueOf(map.get(criteriaID).isReadOnly()));
        view.setHiddenDirOptions(toString().valueOf(map.get(criteriaID).isHidden()));
        view.setSizeDirOptions(map.get(criteriaID).getSizeOption());
        if (map.get(criteriaID).getSize()== 0D) {
            view.setSizeDirValue("");
        } else {
            Double size = (map.get(criteriaID).getSize() / 1024);
            view.setSizeDirValue(Double.toString(size));
        }
        view.setCreatedDirOptions(map.get(criteriaID).getCreatedOption());
        if (map.get(criteriaID).getCreatedOption().equals("Time Range")){
            view.setFromCreatedDirDate(map.get(criteriaID).getCreatedStartDate());
            view.setToCreatedDirDate(map.get(criteriaID).getCreatedEndDate());
        }
        view.setModifiedDirOptions(map.get(criteriaID).getModifiedOption());
        if (map.get(criteriaID).getModifiedOption().equals("Time Range")){
            view.setFromModifiedDirDate(map.get(criteriaID).getModifiedStartDate());
            view.setToModifiedDirDate(map.get(criteriaID).getModifiedEndDate());
        }
        view.setAccessedDirOptions(map.get(criteriaID).getAccessedOption());
        if (map.get(criteriaID).getAccessedOption().equals("Time Range")){
            view.setFromAccessedDirDate(map.get(criteriaID).getAccessedStartDate());
            view.setToAccessedDirDate(map.get(criteriaID).getAccessedEndDate());
        }
    }
}
