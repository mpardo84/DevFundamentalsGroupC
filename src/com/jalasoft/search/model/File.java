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

/**
 *
 * This class is going to represent a file object found.
 *
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
public class File extends FileObject{

    private String fileContains;
    private String fileType;

    public File()
    {
        super();
        this.fileType = "";
        this.fileContains = "";
    }

    public File(String fileType, String fileContains)
    {
        super();
        this.fileType = fileType;
        this.fileContains = fileContains;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileContains(String fileContains)
    {
        this.fileContains = fileContains;
    }

    public String getFileContains()
    {
        return fileContains;
    }
}