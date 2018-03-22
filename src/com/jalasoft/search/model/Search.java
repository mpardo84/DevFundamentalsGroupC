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

/**
 *
 Class description goes here.
 *
 * @version 1 22 Mar 2018  * @author Marco Mendieta
 */
class Search
{

    /**
     *
     * This method is going to search a file in one path location.
     *
     * @param name String with the file name
     * @param file String with the file path
     * @param readOnly boolean that shows weather the file is read only
     * @param hidden boolean that shows weather the file is hidden
     */
    public void searchFile(String name,String file, boolean readOnly, boolean hidden)
    {
    File directory = new File(file);
    File[] list = directory.listFiles();
    if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                searchFile(name,fil.getPath(), readOnly, hidden);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                if (fil.isHidden() == hidden)
                {
                    if (fil.canWrite() != readOnly)
                    {
                        System.out.println("Found");
                        System.out.println("File found at : "+fil.getParentFile());
                        System.out.println("Path directory: "+fil.getAbsolutePath());
                    }
                }
            }
        }
    }

    /**
     *
     * This method is going to search a file in one path location by onwer.
     *
     * @param name String with the file name
     * @param file String with the file path
     * @param owner String with the owner name
     * @param readOnly boolean that shows weather the file is read only
     * @param hidden boolean that shows weather the file is hidden
     */
    public void searchFileByOwner(String name,String file, String owner, boolean readOnly, boolean hidden)
    {
        File directory = new File(file);
        File[] list = directory.listFiles();
        if(list!=null)
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    searchFileByOwner(name,fil.getPath(), owner, readOnly, hidden);
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    if (fil.isHidden() == hidden)
                    {
                        if (fil.canWrite() != readOnly)
                        {
                            try {
                                if (owner.equals(Files.getOwner(Paths.get(fil.getAbsolutePath())).getName()))
                                {
                                    System.out.println("Found");
                                    System.out.println("File found at : "+fil.getParentFile());
                                    System.out.println("Path directory: "+fil.getAbsolutePath());
                                    System.out.println("Owner: "+Files.getOwner(Paths.get(fil.getAbsolutePath())));
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
