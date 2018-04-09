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

import java.io.File;
import java.util.Date;

/**
 *
 * This class is going to represent a file object found.
 *
 * @version 1 22 Mar 2018  * @author Monica Pardo
 */

public class DirectoryObject {
    private String directoryName;
    private File directoryPath;
    private String ownerDirName;
    private boolean readOnlyDir;
    private boolean hiddenDir;
    private Long sizeDir;
    private Date dateModifiedDir;

    public DirectoryObject(){

    }

    //Method that allows to set the Directory Name
    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    //Method that allows to get the Directory Name
    public String getDirectoryName() {
        return directoryName;
    }

    //Method that allows to set the Directory Path
    public void setDirectoryPath(String directoryPath) {
        this.directoryPath =  new File(directoryPath);
    }

    //Method that allows to get the Directory Path
    public File getDirectoryPath() {
        return directoryPath;
    }

    //Method that allows to set the Directory date modified
    public void setDateModifiedDir(Date dateModifiedDir) {
        this.dateModifiedDir = dateModifiedDir;
    }

    //Method that allows to get the Directory date modified
    public Date getDateModifiedDir() {
        return dateModifiedDir;
    }

    //Method that allows to set the Directory hidden value
    public void setHiddenDir(boolean hiddenDir) {
        this.hiddenDir = hiddenDir;
    }

    //Method that allows to get the Directory hidden value
    public Boolean getHiddenDir() {
        return hiddenDir;
    }

    //Method that allows to get the Directory owner value
    public String getOwnerDirName() {
        return ownerDirName;
    }

    //Method that allows to set the Directory owner value
    public void setOwnerDirName(String ownerDirName) {
        this.ownerDirName = ownerDirName;
    }

    //Method that allows to set the Directory read only value
    public void setReadOnlyDir(boolean readOnlyDir) {
        this.readOnlyDir = readOnlyDir;
    }

    //Method that allows to get the Directory read only value
    public Boolean getReadOnlyDir() {
        return readOnlyDir;
    }

    //Method that allows to get the Directory size value
    public Long getSizeDir() {
        return sizeDir;
    }

    //Method that allows to set the Directory size value
    public void setSizeDir(Long sizeDir) {
        this.sizeDir = sizeDir;
    }
}
