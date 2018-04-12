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

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class SearchCriterial
{
    private List<FileObject> fileObjectList = new ArrayList<FileObject>();
    private String fileName;
    private String fileType;
    private java.io.File fileDirectory;
    private String ownerName;
    private boolean readOnly;
    private boolean hidden;
    private FileObject fileFound;
    private FileObject directoryFound;
    private long size;
    private Date dateModified;
    private String sizeOption;
    private String fileContains;
    private String createdOption;
    private Date createdStartDate;
    private Date dateCreated;
    private Date dateAccessed;
    private Date createdEndDate;
    private Date modifiedStartDate;
    private Date modifiedEndDate;
    private Date accessedStartDate;
    private Date accessedEndDate;
    private String directoryName;
    private File directoryPath;
    private String ownerDirName;
    private boolean readOnlyDir;
    private boolean hiddenDir;
    private Double sizeDir;
    private String dateModifiedDir;
    private String sizeDirOption;

    public SearchCriterial()
    {
        this.fileName = "";
        this.fileType = "";
        this.fileDirectory = new File("c:\\");
        this.readOnly = false;
        this.hidden = false;
        this.ownerName = "";
        this.dateModified = new Date();
        this.dateCreated = new Date();
        this.dateAccessed = new Date();
        this.sizeOption = "";
        this.size = 0;
        this.fileContains = "";
        this.createdOption="";
        this.createdStartDate = new Date(1900-1900,01,01);
        this.createdEndDate = new Date(2099-1900,12,12);
        this.modifiedStartDate = new Date(1900-1900,01,01);
        this.modifiedEndDate = new Date(2099-1900,12,12);
        this.accessedStartDate = new Date(1900-1900,01,01);
        this.accessedEndDate = new Date(2099-1900,12,12);
        Calendar calendar = Calendar.getInstance();
        this.directoryName="";
        this.directoryPath=new File("c:\\");
        this.ownerDirName="";
        this.readOnlyDir=false;
        this.hiddenDir=false;
        this.sizeDir=0D;
        this.dateModifiedDir="";
        this.sizeDirOption = "";
    }

    /**
     * This method is going to set the file name to search
     *
     * @param filename  the name of the file to search
     *
     */
    public void setFileName(String filename)
    {
        this.fileName = filename;
    }

    /**
     * This method is going to set the file extension
     *
     * @param fileType  the name of the file extension
     */
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    /**
     * This method is going to set the file directiory
     *
     * @param fileDirectory  the name of the directory to search the file
     */
    public void setFileDirectory(String fileDirectory)
    {
        this.fileDirectory = new File(fileDirectory);
    }

    /**
     * This method is going to set the file owner name
     *
     * @param ownerName  the owner name of the file
     */
    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    /**
     * This method is going to set the file readOnly option
     *
     * @param readOnly  the readOnly file option
     */
    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    /**
     * This method is going to set the file hidden option
     *
     * @param hidden  the hidden file option
     */
    public void setHidden(boolean hidden)
    {
        this.hidden = hidden;
    }

    /**
     * This method is going to set the size option
     *
     * @param sizeOption  the hidden file option
     */
    public void setSizeOption(String sizeOption) {
        this.sizeOption = sizeOption;
    }
    /**
     * This method is going to set the Created option
     *
     * @param createdOption  the hidden file option
     */
    public void setCreatedOption(String createdOption) {
        this.createdOption = createdOption;
    }
    /**
     * This method is going to set the size of file
     *
     * @param size  the hidden file option
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * This method is going to set the contained string in the file
     *
     * @param fileContains  the hidden file option
     */
    public void setFileContains(String fileContains) {
        this.fileContains = fileContains;
    }


    /**
     * This method is going to set the start date of created date range
     *
     * @param createdStartDate  the hidden file option
     */
    public void setCreatedStartDate(Date createdStartDate) {
        this.createdStartDate = createdStartDate;
    }

    /**
     * This method is going to set the end date of created date range
     *
     * @param createdEndDateDate  the hidden file option
     */
    public void setCreatedEndDate(Date createdEndDateDate) {
        this.createdEndDate = createdEndDateDate;
    }

    /**
     * This method is going to set the start date of modified date range
     *
     * @param modifiedStartDate  the hidden file option
     */
    public void setModifiedStartDate(Date modifiedStartDate) {
        this.modifiedStartDate = modifiedStartDate;
    }

    /**
     * This method is going to set the end date of modified date range
     *
     * @param modifiedEndDate  the hidden file option
     */
    public void setModifiedEndDate(Date modifiedEndDate) {
        this.modifiedEndDate = modifiedEndDate;
    }

    /**
     * This method is going to set the start date of accessed date range
     *
     * @param accessedStartDate the hidden file option
     */
    public void setAccessedStartDate(Date accessedStartDate) {
        this.accessedStartDate = accessedStartDate;
    }

    /**
     * This method is going to set the end date of accessed date range
     *
     * @param accessedEndDate the hidden file option
     */
    public void setAccessedEndDate(Date accessedEndDate) {
        this.accessedEndDate = accessedEndDate;
    }

    /**
     * This method is going to get the files objects
     */
    public List<FileObject> getFileObjectList()
    {
        return this.fileObjectList;
    }

    /**
     * This method is going to set the date modified for the file
     *
     * @param dateModified the date modified option
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * This method is going to set the directory path
     *
     * @param directoryPath the path value
     */
    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = new File(directoryPath);
    }

    /**
     * This method is going to set the directory name
     *
     * @param directoryName the name value
     */
    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    /**
     * This method is going to set the hidden directory value
     *
     * @param hiddenDir the hidden value
     */
    public void setHiddenDir(boolean hiddenDir) {
        this.hiddenDir = hiddenDir;
    }

    /**
     * This method is going to set the read only directory value
     *
     * @param readOnlyDir the read only value
     */
    public void setReadOnlyDir(boolean readOnlyDir) {
        this.readOnlyDir = readOnlyDir;
    }

    /**
     * This method is going to set the date modified for the Directory
     *
     * @param dateModifiedDir the modified date value
     */
    public void setDateModifiedDir(String dateModifiedDir) {
        this.dateModifiedDir = dateModifiedDir;
    }

    /**
     * This method is going to set the size for the Directory
     *
     * @param sizeDir the size value
     */
    public void setSizeDir(Double sizeDir) {
        this.sizeDir = sizeDir;
    }

    /**
     * This method is going to set the options size for the Directory
     *
     * @param sizeDirOption the size options value
     */
    public void setSizeDirOption(String sizeDirOption) {
        this.sizeDirOption = sizeDirOption;
    }

    /**
     * This method is going to set the owner for the Directory
     *
     * @param ownerDirName the owner value
     */
    public void setOwnerDirName(String ownerDirName) {
        this.ownerDirName = ownerDirName;
    }

    public void setDirectoryFound(FileObject directoryFound) {
        this.directoryFound = directoryFound;
    }

    public void setFileDirectory(File fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public void setFileObjectList(List<FileObject> fileObjectList) {
        this.fileObjectList = fileObjectList;
    }

    public void setFileFound(FileObject fileFound) {
        this.fileFound = fileFound;
    }

    public void setDirectoryPath(File directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public File getFileDirectory() {
        return this.fileDirectory;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getFileContains() {
        return this.fileContains;
    }

    public long getSize() {
        return this.size;
    }

    public FileObject getDirectoryFound() {
        return this.directoryFound;
    }

    public FileObject getFileFound() {
        return this.fileFound;
    }

    public Date getDateModified() {
        return this.dateModified;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getCreatedOption() {
        return this.createdOption;
    }

    public String getSizeOption() {
        return this.sizeOption;
    }

    public Date getCreatedEndDate() {
        return this.createdEndDate;
    }

    public Date getCreatedStartDate() {
        return this.createdStartDate;
    }

    public Date getModifiedStartDate() {
        return this.modifiedStartDate;
    }

    public Date getAccessedEndDate() {
        return this.accessedEndDate;
    }

    public Date getAccessedStartDate() {
        return this.accessedStartDate;
    }

    public Date getModifiedEndDate() {
        return this.modifiedEndDate;
    }

    public Double getSizeDir() {
        return this.sizeDir;
    }

    public File getDirectoryPath() {
        return this.directoryPath;
    }

    public String getDateModifiedDir() {
        return this.dateModifiedDir;
    }

    public String getDirectoryName() {
        return this.directoryName;
    }

    public String getOwnerDirName() {
        return this.ownerDirName;
    }

    public String getSizeDirOption() {
        return this.sizeDirOption;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateAccessed(Date dateAccessed) {
        this.dateAccessed = dateAccessed;
    }

    public Date getDateAccessed() {
        return dateAccessed;
    }
}
