/*
 *     1 22/03/18
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

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * This class is going to perform the file search
 *
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
public class Search
{
    private List<FileObject> fileObjectList = new ArrayList<FileObject>();
    private String fileName;
    private String fileType;
    private File fileDirectory;
    private String ownerName;
    private boolean readOnly;
    private boolean hidden;
    private FileObject fileObject;
    private Double size;
    private String dateModified;
    private String sizeOption;
    private String contains;
    private Date createdStartDate;
    private Date createdEndDate;
    private Date modifiedStartDate;
    private Date modifiedEndDate;
    private Date accessedStartDate;
    private Date accessedEndDate;

    public Search()
    {
        this.fileName = "";
        this.fileType = "";
        this.fileDirectory = new File("c:\\");
        this.readOnly = false;
        this.hidden = false;
        this.ownerName = "";
        this.dateModified = "";
        this.sizeOption = "";
        this.size = 0D;
        this.contains = "";
        this.createdStartDate = new Date(1900,01,01);
        this.createdEndDate = new Date(2099,12,12);
        this.modifiedStartDate = new Date(1900,01,01);
        this.modifiedEndDate = new Date(2099,12,12);
        this.accessedStartDate = new Date(1900,01,01);
        this.accessedEndDate = new Date(2099,12,12);
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
     * This method is going to set the size of file
     *
     * @param size  the hidden file option
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     * This method is going to set the contained string in the file
     *
     * @param contains  the hidden file option
     */
    public void setContains(String contains) {
        this.contains = contains;
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

    public List<FileObject> getFileObjectList()
    {
        return this.fileObjectList;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * This method is going to search a file in a given folder
     *
     * @param fileDir  the name of the directory to search the file
     * */
    public void searchFile(String fileDir)
    {
        setFileDirectory(fileDir);
        File[] list = fileDirectory.listFiles();
        if(list!=null)
            for (File file : list)
            {
                if (file.isDirectory())
                {
                    searchFile(file.getAbsolutePath());
                }
                else if (file.getName().toLowerCase().toLowerCase().contains((fileName + fileType).toLowerCase()))
                {

                    if (file.isHidden() == hidden)
                    {
                        if (file.canWrite() != readOnly)
                        {
                            try {
                                if (Files.getOwner(Paths.get(file.getAbsolutePath())).getName().toLowerCase()
                                        .contains(ownerName.toLowerCase()))
                                {
                                    switch(sizeOption) {
                                        case "":
                                            setFoundFileObject(file);
                                            break;
                                        case ">":
                                            if (Files.size(Paths.get(file.getAbsolutePath())) > this.size)
                                                setFoundFileObject(file);
                                            break;
                                        case "<":
                                            if (Files.size(Paths.get(file.getAbsolutePath())) < this.size)
                                                setFoundFileObject(file);
                                            break;
                                        case "=":
                                            if (Files.size(Paths.get(file.getAbsolutePath())) == this.size)
                                                setFoundFileObject(file);
                                            break;
                                    }

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
    }

    private void setFoundFileObject(File file)
    {
        fileObject = new FileObject();
        fileObject.setFileName(FilenameUtils.getBaseName(file.getName()));
        fileObject.setFileType(FilenameUtils.getExtension(file.getName()));
        fileObject.setFileDirectory(file.getParent());

        fileObject.setReadOnly(readOnly);
        fileObject.setHidden(hidden);
        fileObjectList.add(fileObject);
        try {
            Date date = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            fileObject.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
            fileObject.setDateModified(date);
            fileObject.setSize(Files.size(Paths.get(file.getAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
