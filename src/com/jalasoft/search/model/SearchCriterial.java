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
    private String owner;
    private String contains;
    private String fileType;
    private boolean isFile;
    private boolean hidden;
    private boolean readOnly;

    public SearchCriterial(){}

    public  SearchCriterial(String fileName, String filePath, String owner, boolean hidden, boolean readOnly){
        this.fileName = fileName;
        this.filePath = filePath;
        this.owner = owner;
        this.hidden = hidden;
        this.readOnly = readOnly;
    }
    // method to get fileName
    public String getFileName(){
        return this.fileName;
    }

    // method to get filePath
    public String getFilePath() {
        return this.filePath;
    }

    //method to get owner
    public String getOwner() {
        return this.owner;
    }

    //method to get the value of hidden property
    public boolean getHidden() {
        return this.hidden;
    }

    //method to get the value of read only property
    public boolean getReadOnly() {
        return this.readOnly;
    }

    //method to get the value of contains field
    public String getContains() {
        return this.contains;
    }

    //method to get informatimationabout type
    public boolean getIsFile() {
        return this.getIsFile();
    }

    //method to set the value fileName
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //method to set the value filePath
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    //method to set the value of owner
    public void setOwner(String owner) {
        this.owner = owner;
    }

    //method to set the value of hidden property
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    //method to set the value of read only property
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    //method to set the value of contains roperty
    public void setContains(String contains) {
        this.contains = contains;
    }

    //method to set the value isFile property
    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }

    //method to set the value of extension property
    public void setFileType() {
        this.fileType = "";
    }
}
