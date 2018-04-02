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
import java.util.ArrayList;
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

    public Search()
    {
        this.fileName = "";
        this.fileType = "";
        this.fileDirectory = new File("c:\\");
        this.readOnly = false;
        this.hidden = false;
        this.ownerName = "";
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

    public List<FileObject> getFileObjectList()
    {
        return this.fileObjectList;
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
                                if (ownerName == "")
                                {
                                    fileObject = new FileObject();
                                    fileObject.setFileName(file.getName());
                                    fileObject.setFileDirectory(file.getParent());
                                    fileObject.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
                                    fileObject.setReadOnly(readOnly);
                                    fileObject.setHidden(hidden);
                                    fileObjectList.add(fileObject);
                                    System.out.println("Found :" + file.getParent());
                                    System.out.println("File found at : "+file.getParentFile());
                                    System.out.println("Path directory: "+file.getAbsolutePath());
                                    System.out.println("Owner: "+Files.getOwner(Paths.get(file.getAbsolutePath())));
                                }
                                else if (Files.getOwner(Paths.get(file.getAbsolutePath())).getName().toLowerCase()
                                        .contains(ownerName.toLowerCase()))
                                {
                                    fileObject = new FileObject();
                                    fileObject.setFileName(file.getName());
                                    fileObject.setFileDirectory(file.getParent());
                                    fileObject.setOwnerName(Files.getOwner(Paths.get(file.getAbsolutePath())).getName());
                                    fileObject.setReadOnly(readOnly);
                                    fileObject.setHidden(hidden);
                                    fileObjectList.add(fileObject);
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
