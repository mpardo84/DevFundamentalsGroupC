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

public class Directory extends FileObject{
    private int numberOfFiles;

    public Directory()
    {
        super();
        this.numberOfFiles=0;
    }

    public Directory(int numberOfFiles)
    {
        super();
        this.numberOfFiles=0;
    }

    public void setNumberOfFiles(int numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }
}
