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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.file.attribute.*;


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
    private FileObject fileFound;
    private FileObject directoryFound;
    private Double size;
    private String dateModified;
    private String sizeOption;
    private String fileContains;
    private String createdOption;
    private Date createdStartDate;
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
    public void setSize(Double size) {
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
    public void setDateModified(String dateModified) {
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
                else if (file.getName().toLowerCase().contains((fileName + fileType).toLowerCase()))
                {

                    if (file.isHidden() == hidden)
                    {
                        if (file.canWrite() != readOnly)
                        {
                            try {
                                if (Files.getOwner(Paths.get(file.getAbsolutePath())).getName().toLowerCase()
                                        .contains(ownerName.toLowerCase())) {

                                    if (sizeOption == "" )
                                    {
                                        if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                            if (isStringContainedInFile(file) || this.fileContains.isEmpty())
                                                setFoundFileObject(file);
                                    }
                                    else{
                                         if(sizeOption==">" &&(Files.size(Paths.get(file.getAbsolutePath()))) > this.size) {
                                             if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                                 if (isStringContainedInFile(file) || this.fileContains.isEmpty())
                                                     setFoundFileObject(file);
                                        }
                                        else {
                                            if (sizeOption == "<" && (Files.size(Paths.get(file.getAbsolutePath()))) < this.size) {
                                                if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                                    if (isStringContainedInFile(file) || this.fileContains.isEmpty())
                                                        setFoundFileObject(file);
                                            }
                                            else {

                                                if (sizeOption == "=" && (Files.size(Paths.get(file.getAbsolutePath()))) == this.size) {
                                                    if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                                        if (isStringContainedInFile(file) || this.fileContains == "" || this.fileContains == null)
                                                            setFoundFileObject(file);
                                                }
                                            }
                                        }
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

    public void searchDirectory(String fileDir)
    {
        setFileDirectory(fileDir);
        File[] list = directoryPath.listFiles();

        if(list!=null)
            for (File dir : list) {

                if (dir.isDirectory()) {
                    if (dir.getName().toLowerCase().toLowerCase().contains((directoryName).toLowerCase())) {
                        Path filePath = dir.toPath();
                        if (dir.isHidden() == hiddenDir) {
                            if (dir.canWrite() != readOnlyDir) {
                                try {
                                    BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
                                    if (Files.getOwner(Paths.get(dir.getAbsolutePath())).getName().toLowerCase()
                                            .contains(ownerDirName.toLowerCase())) {

                                        if (sizeDirOption == "") {
                                            setFoundDirectoryObject(dir);
                                        } else {
                                            if (sizeDirOption == ">" && (Files.size(Paths.get(dir.getAbsolutePath()))) > this.sizeDir) {
                                                setFoundDirectoryObject(dir);
                                            } else {
                                                if (sizeDirOption == "<" && (Files.size(Paths.get(dir.getAbsolutePath()))) < this.sizeDir) {
                                                    setFoundDirectoryObject(dir);
                                                } else {

                                                    if (sizeDirOption == "=" && (Files.size(Paths.get(dir.getAbsolutePath()))) == this.sizeDir) {
                                                        setFoundDirectoryObject(dir);

                                                    }

                                                }
                                            }
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

    }

    private void setFoundFileObject(File file)
    {
        fileFound = new com.jalasoft.search.model.File(FilenameUtils.getExtension(file.getName()), this.fileContains);
        fileFound.setFileName(FilenameUtils.getBaseName(file.getName()));
        fileFound.setFileDirectory(file.getParent());
        fileFound.setReadOnly(readOnly);
        fileFound.setHidden(hidden);
        try {

            Date date = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            fileFound.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
            fileFound.setDateModified(date);
            fileFound.setSize(Files.size(Paths.get(file.getAbsolutePath())));
            fileFound.setDateCreated(date);
            fileFound.setDateAccessed(date);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileObjectList.add(fileFound);
    }

    private boolean isWithinModifiedRange(File file)
    {
        Date testDate = new Date(file.lastModified());
        return !(testDate.before(modifiedStartDate) || testDate.after(modifiedEndDate));
    }

    private boolean isWithinCreatedRange(File file)
    {
        BasicFileAttributes fileAttributes;
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        try {
            fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
            Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.creationTime().toMillis()));
            return !(testDate.before(createdStartDate) || testDate.after(createdEndDate));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isWithinAccessedRange(File file)
    {
        BasicFileAttributes fileAttributes;
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        try {
            fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
            Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.lastAccessTime().toMillis()));
            return !(testDate.before(accessedStartDate) || testDate.after(accessedEndDate));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isStringContainedInFile(File file)
    {
        try {
            Scanner scanner = new Scanner(file);

            //now read the file line by line...
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if(line.toLowerCase().contains(this.fileContains.toLowerCase())) {
                    return true;
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void setFoundDirectoryObject(File file)
    {
        directoryFound = new Directory(file.listFiles().length);
        directoryFound.setFileName(FilenameUtils.getBaseName(file.getName()));
        directoryFound.setFileDirectory(file.getPath());
        directoryFound.setReadOnly(readOnlyDir);
        directoryFound.setHidden(hiddenDir);
        try {

            Date date = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            directoryFound.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
            directoryFound.setDateModified(date);
            directoryFound.setSize(Files.size(Paths.get(file.getAbsolutePath())));
            directoryFound.setDateCreated(date);
            directoryFound.setDateAccessed(date);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileObjectList.add(directoryFound);
    }
}
