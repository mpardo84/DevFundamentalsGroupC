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

/**
 *
 * This class is going to represent a file object found.
 *
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
public class FileObject {
    private String fileName;
    private String fileType;
    private File fileDirectory;
    private String ownerName;
    private boolean readOnly;
    private boolean hidden;

    public FileObject()
    {
    }

    public void setFileName(String filename)
    {
        this.fileName = filename;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public void setFileDirectory(String fileDirectory)
    {
        this.fileDirectory = new File(fileDirectory);
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public void setHidden(boolean hidden)
    {
        this.hidden = hidden;
    }
}