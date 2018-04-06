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
package com.jalasoft.search.model;

import java.util.Date;

/**
 *
 The SearchCriterial class with getter  and setter methods to get data from view side and sent them to model side
 *
 * @version
26 Mar 2018
 *
 *  @author
Gretta Rocha
 */

public class SearchCriterial {

    private String fileName;
    private String filePath;
    private String fileType;
    private String contains;
    private String owner;
    private String sizeOption;
    private Long size;
    private boolean readOnly;
    private boolean hidden;
    private String createdStartDate;
    private String createdEndDate;
    private String modifiedStartDate;
    private String modifiedEndDate;
    private String accessedStartDate;
    private String accessedEndDate;

    public SearchCriterial(){}

    public  SearchCriterial(String fileName, String filePath, String fileType, String contains, String owner,
                            String sizeOption, Long size,  boolean hidden, boolean readOnly, String createdStartDate,
                            String createdEndDate, String  modifiedStartDate, String modifiedEndDate,
                            String accessedStartDate, String accessedEndDate ){
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.contains = contains;
        this.owner = owner;
        this.sizeOption=sizeOption;
        this.size = size;
        this.hidden = hidden;
        this.readOnly = readOnly;
        this.createdStartDate = createdStartDate;
        this.createdEndDate = createdEndDate;
        this.modifiedStartDate = modifiedStartDate;
        this.modifiedEndDate = modifiedEndDate;
        this.accessedStartDate = accessedStartDate;
        this.accessedEndDate = accessedEndDate;

    }
    // Method to get fileName
    public String getFileName(){
        return this.fileName;
    }

    // Method to get filePath
    public String getFilePath() {
        return this.filePath;
    }

    // Method to get owner
    public String getOwner() {
        return this.owner;
    }

    // Method to get the file extencion
    public String getFileType() { return this.fileType; }

    // Method to get the string contained in the file
    public String getContains(){ return this.contains;}

    // Method to get the option for size
    public String  getSizeOption(){return this.sizeOption; }

    // Method to get the size of file
    public  Long  getSize(){return this.size; }

    // Method to get the value of hidden property
    public boolean getHidden() {
        return this.hidden;
    }

    // Method to get the value of read only property
    public boolean getReadOnly() {
        return this.readOnly;
    }

    // Method to get start date of created date of file
    public String getCreatedDateStart(){return this.createdStartDate;}

    // Method to get end date of created date of file
    public String getCreatedDateEnd(){return this.createdEndDate;}

    // Method to get start date of modified date of file
    public String getModifiedDateStart(){return this.modifiedStartDate;}

    // Method to get end date of modified date of file
    public String getModifiedDateEnd(){return this.modifiedEndDate;}

    // Method to get start date of accessed date of file
    public String getAccessedDateStart(){return this.accessedStartDate;}

    // Method to get end date of accessed date of file
    public String getAccessedDateEnd(){return this.accessedEndDate;}

    // Method to set the value fileName
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // Method to set the value filePath
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Method to set the value of owner
    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Method to set the value of hidden property
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    // Method to set the value of read only property
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    // Method to set the value of contains roperty
    public void setContains(String contains) {
        this.contains = contains;
    }

    // Method to set the value of extension property
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    // Method  to set the size option for the search
    public void setSizeOption(String sizeOption) {
        this.sizeOption = sizeOption;
    }
    // Method  to set the value of  file size
    public void setSize( Long size) {
        this.size = size;
    }

    // Method  to set the value of start date of created date of file
    public void setCreatedStartDate( String createdStartDate) {
        this.createdStartDate = createdStartDate;
    }

    // Method  to set the value of end date of created date of file
    public void setCreatedEndDate(String createdEndDate) {
        this.createdEndDate = createdEndDate;
    }

    // Method  to set the value of start date of modified date of file
    public void setModifiedStartDate(String modifiedStartDate) {
        this.modifiedStartDate = modifiedStartDate;
    }

    // Method  to set the value of start date of modified date of file
    public void setModifiedEndDate(String modifiedEndDate) {
        this.modifiedEndDate = modifiedEndDate;
    }

    // Method  to set the value of start date of accessed date of file
    public void setAccessedStartDate(String accessedStartDate) {
        this.accessedStartDate = accessedStartDate;
    }

    // Method  to set the value of end date of accessed date of file
    public void setAccessedEndDate(String accessedEndDate) {
        this.accessedEndDate = accessedEndDate;
    }
}
