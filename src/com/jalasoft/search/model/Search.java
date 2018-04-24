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


import com.google.gson.Gson;
import com.jalasoft.search.commond.Functions;
import com.jalasoft.search.commond.LoggerWrapper;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private SearchCriterial searchCriterial;
    private FactoryFileObject factoryFileObject;

    // Get loggerWrapper instance
    LoggerWrapper logger = LoggerWrapper.getInstance();
    Functions functions = new Functions();

    public Search()
    {
        this.searchCriterial = new SearchCriterial();
    }

    public SearchCriterial getSearchCriterial() {
        return searchCriterial;
    }

    public void setSearchCriterial(SearchCriterial searchCriterial) {
        this.searchCriterial = searchCriterial;
    }

    /**
     * This method is going to search a file in a given folder
     *
     * @param fileDir  the name of the directory to search the file
     * */
    public void searchFile(String fileDir)
    {
        searchCriterial.setFileDirectory(fileDir);
        File[] list = searchCriterial.getFileDirectory().listFiles();

        if(list!=null)
            for (File file : list)
            {
                if (file.isDirectory())
                {
                    searchFile(file.getAbsolutePath());
                }
                else if (file.getName().toLowerCase().contains((searchCriterial.getFileName() +"."+searchCriterial.getFileType()).toLowerCase()))
                {

                    if (file.isHidden() == searchCriterial.isHidden())
                    {
                        if (file.canWrite() != searchCriterial.isReadOnly())
                        {
                            try {
                                if (Files.getOwner(Paths.get(file.getAbsolutePath())).getName().toLowerCase()
                                        .contains(searchCriterial.getOwnerName().toLowerCase())) {

                                    if (searchCriterial.getSizeOption() == "" )
                                    {
                                        if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                            if (isStringContainedInFile(file) || searchCriterial.getFileContains().isEmpty())
                                                setFoundFileObject(file);
                                    }
                                    else{
                                         if(searchCriterial.getSizeOption()==">" &&(Files.size(Paths.get(file.getAbsolutePath()))) > searchCriterial.getSize()) {
                                             if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                                 if (isStringContainedInFile(file) || searchCriterial.getFileContains().isEmpty())
                                                     setFoundFileObject(file);
                                        }
                                        else {
                                            if (searchCriterial.getSizeOption() == "<" && (Files.size(Paths.get(file.getAbsolutePath()))) < searchCriterial.getSize()) {
                                                if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                                    if (isStringContainedInFile(file) || searchCriterial.getFileContains().isEmpty())
                                                        setFoundFileObject(file);
                                            }
                                            else {

                                                if (searchCriterial.getSizeOption() == "=" && (Files.size(Paths.get(file.getAbsolutePath()))) == searchCriterial.getSize()) {
                                                    if (isWithinModifiedRange(file) && isWithinCreatedRange(file) && isWithinAccessedRange(file))
                                                        if (isStringContainedInFile(file) || searchCriterial.getFileContains().isEmpty())
                                                            setFoundFileObject(file);
                                                }
                                            }
                                        }
                                }

                                }
                            } catch (IOException e) {
                                logger.log.severe( functions.getStackTrace(e));
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
    }

    /**
     * This method is going to search a directory in a given folder
     *
     * @param fileDir  the name of the directory to search the file
     * */
    public void searchDirectory(String fileDir)
    {
        searchCriterial.setFileDirectory(fileDir);
        File[] list = searchCriterial.getFileDirectory().listFiles();

        if(list!=null)
            for (File dir : list) {

                if (dir.isDirectory()) {
                    if (dir.getName().toLowerCase().toLowerCase().contains((searchCriterial.getFileName()).toLowerCase())) {
                        Path filePath = dir.toPath();
                        if (dir.isHidden() == searchCriterial.isHidden()) {
                            if (dir.canWrite() != searchCriterial.isReadOnly()) {
                                try {

                                    if (Files.getOwner(Paths.get(dir.getAbsolutePath())).getName().toLowerCase()
                                            .contains(searchCriterial.getOwnerName().toLowerCase())) {

                                        if (searchCriterial.getSizeOption() == "") {
                                            if (isWithinModifiedRange(dir) && isWithinCreatedRange(dir) && isWithinAccessedRange(dir))
                                                setFoundDirectoryObject(dir);
                                        } else {
                                            if (searchCriterial.getSizeOption() == ">" && (Files.size(Paths.get(dir.getAbsolutePath()))) > searchCriterial.getSize()) {
                                                if (isWithinModifiedRange(dir) && isWithinCreatedRange(dir) && isWithinAccessedRange(dir))
                                                    setFoundDirectoryObject(dir);
                                            } else {
                                                if (searchCriterial.getSizeOption() == "<" && (Files.size(Paths.get(dir.getAbsolutePath()))) < searchCriterial.getSize()) {
                                                    if (isWithinModifiedRange(dir) && isWithinCreatedRange(dir) && isWithinAccessedRange(dir))
                                                        setFoundDirectoryObject(dir);
                                                } else {

                                                    if (searchCriterial.getSizeOption() == "=" && (Files.size(Paths.get(dir.getAbsolutePath()))) == searchCriterial.getSize()) {
                                                        if (isWithinModifiedRange(dir) && isWithinCreatedRange(dir) && isWithinAccessedRange(dir))
                                                            setFoundDirectoryObject(dir);

                                                    }

                                                }
                                            }
                                        }

                                    }
                                } catch (IOException e) {
                                    logger.log.severe( functions.getStackTrace(e));
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }

    }

    /**
     * This method is going to save the Criteria given the criteria object and the name for the criteria
     *
     * @param cri  the criterial object
     * @param nameCriteria  the name for the criterial saved by the user
     * */

   public String saveCriteria(SearchCriterial cri, String nameCriteria)
    {
        logger.log.info( "It is starting saving data for the Criteria .......");
        SearchQuery db = null;
        try {
            db = new SearchQuery();
            Gson gson=new Gson();
            String criteriaJson=gson.toJson(cri);
            db.addCriterial(nameCriteria, criteriaJson,cri.getTypeObject());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.log.info( "Failed to save the data in the databse .......");
            return "Fail";
        }
        logger.log.info( "Completed to save the data in the databse .......");
        return "Success";
    }

    /**
     * This method is going to get All the data from the database
     *
     * * */
    public Map<Integer,SearchCriterial> getAllData(){
        logger.log.info( "Its in the Get All data method  .......");
    Map<Integer,SearchCriterial> scMap= new HashMap<>();

        try {
            SearchQuery  db = new SearchQuery();
            Gson gson=new Gson();
            ResultSet set=db.getAllCriterialSearch();


            while(set.next()){

                SearchCriterial crijson=gson.fromJson(set.getString("criteria"),SearchCriterial.class);

                int id=set.getInt("Id");
                String name=set.getString(2);
                scMap.put(id,crijson);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.log.info( "complete to obtain All data from DB .......");
        return scMap;
    }

    /**
     * This method is going to set in the SearhcCriteria the files found in the system
     *@param file this is the File object
     * * */
    private void setFoundFileObject(File file)
    {
        try {
            Date dateModified = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            Date dateCreated = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            Date dateAccessed = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            String ownerName = Files.getOwner(Paths.get(file.getAbsolutePath())).getName();
            long size = Files.size(Paths.get(file.getAbsolutePath()));

            factoryFileObject.setFileObjectFound(this.searchCriterial, "file", file.getName(),
                    file.getParent(), !file.canWrite(), file.isHidden(), ownerName,
                    dateModified, size, dateCreated, dateAccessed,
                    searchCriterial.getFileContains(), 0);

        } catch (IOException e) {
            logger.log.severe( functions.getStackTrace(e));
            e.printStackTrace();
        }
    }

    /**
     * This method is going to check if the file is in the modified range selected by the user
     *@param file this is the File object
     * * */
    private boolean isWithinModifiedRange(File file)
    {
        Date testDate = new Date(file.lastModified());

        return !(testDate.before(searchCriterial.getModifiedStartDate()) || testDate.after(searchCriterial.getModifiedEndDate()));
    }

    /**
     * This method is going to check if the file is in the created range selected by the user
     *@param file this is the File object
     * * */
    private boolean isWithinCreatedRange(File file)
    {
        String istoday=searchCriterial.getTimeOption();
        boolean isInRange=false;
        BasicFileAttributes fileAttributes;
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        switch(istoday) {
            case "Today":
                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.creationTime().toMillis()));

                    String startDate = dateFormat.format(searchCriterial.getTodayDate());
                    String formatDate = (dateFormat.format(fileAttributes.creationTime().toMillis()));

                    isInRange = ((formatDate.equals(startDate)));

                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "Yesterday":
                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.creationTime().toMillis()));

                    String startDate = dateFormat.format(searchCriterial.getYesterdayDate());
                    String formatDate = (dateFormat.format(fileAttributes.creationTime().toMillis()));

                    isInRange = ((formatDate.equals(startDate)));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "All Time":

                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.creationTime().toMillis()));
                    isInRange = !(testDate.before(searchCriterial.getCreatedStartDate()) || testDate.after(searchCriterial.getCreatedEndDate()));

                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "Time Range":

                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.creationTime().toMillis()));
                    isInRange = !(testDate.before(searchCriterial.getCreatedStartDate()) || testDate.after(searchCriterial.getCreatedEndDate()));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "":

                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.creationTime().toMillis()));
                    isInRange = !(testDate.before(searchCriterial.getCreatedStartDate()) || testDate.after(searchCriterial.getCreatedEndDate()));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
        return isInRange;
    }

    /**
     * This method is going to check if the file is in the acccessed range selected by the user
     *@param file this is the File object
     * * */
    private boolean isWithinAccessedRange(File file)
    {

        String istoday=searchCriterial.getTimeOption();
        boolean isInRangeAccess=false;
        BasicFileAttributes fileAttributes;
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        switch(istoday) {
            case "Today":


                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.lastAccessTime().toMillis()));

                    String startDate = dateFormat.format(searchCriterial.getTodayDate());
                    String formatDate = (dateFormat.format(fileAttributes.lastAccessTime().toMillis()));

                    isInRangeAccess = ((formatDate.equals(startDate)));

                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "Yesterday":
                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.lastAccessTime().toMillis()));

                    String startDate = dateFormat.format(searchCriterial.getYesterdayDate());
                    String formatDate = (dateFormat.format(fileAttributes.lastAccessTime().toMillis()));
                    isInRangeAccess = ((formatDate.equals(startDate)));


                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "All Time":
                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.lastAccessTime().toMillis()));
                    isInRangeAccess= !(testDate.before(searchCriterial.getAccessedStartDate()) || testDate.after(searchCriterial.getAccessedEndDate()));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                break;
            case "Time Range":
                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.lastAccessTime().toMillis()));
                    isInRangeAccess= !(testDate.before(searchCriterial.getAccessedStartDate()) || testDate.after(searchCriterial.getAccessedEndDate()));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                break;
            case "":
                try {
                    fileAttributes = Files.readAttributes(Paths.get(file.getAbsolutePath()), BasicFileAttributes.class);
                    Date testDate = dateFormat.parse(dateFormat.format(fileAttributes.lastAccessTime().toMillis()));
                    isInRangeAccess= !(testDate.before(searchCriterial.getAccessedStartDate()) || testDate.after(searchCriterial.getAccessedEndDate()));
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

                break;
        }
        return isInRangeAccess;

    }

    /**
     * This method is going to check if a string is contains into the file
     *@param file this is the File object
     * * */
    private boolean isStringContainedInFile(File file)
    {
        try {
            Scanner scanner = new Scanner(file);

            //now read the file line by line...
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if(line.toLowerCase().contains(searchCriterial.getFileContains().toLowerCase())) {
                    return true;
                }
            }
        } catch(FileNotFoundException e) {
            logger.log.severe( functions.getStackTrace(e));
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is going to check if the directory was found in the system
     *@param file this is the File object
     * * */
    private void setFoundDirectoryObject(File file)
    {
        int numberOfFiles = 0;

        if (file.listFiles() != null)
            numberOfFiles = file.listFiles().length;

        try {
            Date dateModified = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            Date dateCreated = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            Date dateAccessed = new Date(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            String ownerName = Files.getOwner(Paths.get(file.getAbsolutePath())).getName();
            long size = Files.size(Paths.get(file.getAbsolutePath()));

            factoryFileObject.setFileObjectFound(this.searchCriterial, "directory", FilenameUtils.getBaseName(file.getName()),
                    file.getParent(), !file.canWrite(), file.isHidden(), ownerName,
                    dateModified, size, dateCreated, dateAccessed,
                    searchCriterial.getFileContains(), numberOfFiles);

        } catch (IOException e) {
            logger.log.severe( functions.getStackTrace(e));
            e.printStackTrace();
        }
    }
}
