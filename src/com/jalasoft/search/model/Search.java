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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 Class description goes here.
 *
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
public class Search
{
    private String fileName;
    private String fileType;
    private File fileDirectory;
    private String ownerName;
    private boolean readOnly;
    private boolean hidden;
    private FileObject fileObject;

    public void Search()
    {
        this.fileName = null;
        this.fileType = null;
        this.fileDirectory = new File("c:\\");
        this.readOnly = false;
        this.hidden = false;
        this.ownerName = " ";
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
                else if ((fileName + fileType).equalsIgnoreCase(file.getName()))
                {
                    if (file.isHidden() == hidden)
                    {
                        if (file.canWrite() != readOnly)
                        {
                            try {
                                if (ownerName == null)
                                {
                                    fileObject = new FileObject();
                                    fileObject.setFileName(file.getName());
                                    fileObject.setFileDirectory(file.getParent());
                                    fileObject.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
                                    fileObject.setReadOnly(readOnly);
                                    fileObject.setHidden(hidden);
                                    System.out.println("Found :" + file.getParent());
                                    System.out.println("File found at : "+file.getParentFile());
                                    System.out.println("Path directory: "+file.getAbsolutePath());
                                    System.out.println("Owner: "+Files.getOwner(Paths.get(file.getAbsolutePath())));
                                }
                                else if (ownerName.equals(Files.getOwner(Paths.get(file.getAbsolutePath())).getName()))
                                {
                                    fileObject = new FileObject();
                                    fileObject.setFileName(file.getName());
                                    fileObject.setFileDirectory(file.getParent());
                                    fileObject.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
                                    fileObject.setReadOnly(readOnly);
                                    fileObject.setHidden(hidden);
                                    System.out.println("Found");
                                    System.out.println("File found at : "+file.getParentFile());
                                    System.out.println("Path directory: "+file.getAbsolutePath());
                                    System.out.println("Owner: "+Files.getOwner(Paths.get(file.getAbsolutePath())));
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
