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
import java.util.Date;

/**
 *
 * This class is going to represent a file object found.
 *
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
public class FactoryFileObject {

    public static void setFileObjectFound(SearchCriterial searchCriterial, String typeOfFile, String fileName,
                                          String fileDirectory, boolean readOnly, boolean hidden, String ownerName,
                                          Date dateModified, long size, Date dateCreated, Date dateAccessed,
                                          String fileContains, int numberOfFiles)
    {
        if (typeOfFile.equalsIgnoreCase("file"))
        {
            searchCriterial.setFileFound(new com.jalasoft.search.model.File(FilenameUtils.getExtension(fileName), fileContains));
            searchCriterial.getFileFound().setFileName(FilenameUtils.getBaseName(fileName));
            searchCriterial.getFileFound().setFileDirectory(fileDirectory);
            searchCriterial.getFileFound().setReadOnly(readOnly);
            searchCriterial.getFileFound().setHidden(hidden);
            searchCriterial.getFileFound().setOwnerName(ownerName);
            searchCriterial.getFileFound().setDateModified(dateModified);
            searchCriterial.getFileFound().setSize(size);
            searchCriterial.getFileFound().setDateCreated(dateCreated);
            searchCriterial.getFileFound().setDateAccessed(dateAccessed);
            searchCriterial.getFileObjectList().add(searchCriterial.getFileFound());
        }
        else if (typeOfFile.equalsIgnoreCase("directory"))
        {
            searchCriterial.setDirectoryFound(new Directory(numberOfFiles));
            searchCriterial.getDirectoryFound().setFileName(FilenameUtils.getBaseName(fileName));
            searchCriterial.getDirectoryFound().setFileDirectory(fileDirectory);
            searchCriterial.getDirectoryFound().setReadOnly(readOnly);
            searchCriterial.getDirectoryFound().setHidden(hidden);
            searchCriterial.getDirectoryFound().setOwnerName(ownerName);
            searchCriterial.getDirectoryFound().setDateModified(dateModified);
            searchCriterial.getDirectoryFound().setSize(size);
            searchCriterial.getDirectoryFound().setDateCreated(dateCreated);
            searchCriterial.getDirectoryFound().setDateAccessed(dateAccessed);
            searchCriterial.getFileObjectList().add(searchCriterial.getDirectoryFound());
        }


    }
}