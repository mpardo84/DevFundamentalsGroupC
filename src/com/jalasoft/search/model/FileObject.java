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
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
public class FileObject {
    private String fileName;
    private File fileDirectory;
    private String ownerName;
    private boolean readOnly;
    private boolean hidden;
    private Long size;
    private Date dateModified;
    private Date dateCreated;
    private Date dateAccessed;

    public FileObject()
    {
    }

    public void setFileName(String filename)
    {
        this.fileName = filename;
    }

    public String  getFileName()
    {
        return this.fileName;
    }

    public void setFileDirectory(String fileDirectory)
    {
        this.fileDirectory = new File(fileDirectory);
    }

    public File getFileDirectory() {
        return fileDirectory;
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public boolean isReadOnly()
    {
        return readOnly;
    }

    public void setHidden(boolean hidden)
    {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public Long getSize() {
        return size;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateAccessed() {
        return dateAccessed;
    }

    public void setDateAccessed(Date dateAccessed) {
        this.dateAccessed = dateAccessed;
    }
}