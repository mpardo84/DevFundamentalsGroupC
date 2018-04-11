/*
 *      26/03/18
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
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 SearchTest class provides positive and negative test for each combination of search criteria.
 *
 * @version
10 April 2018
 *
 *  @author
Monica Pardo
 */
public class SearchTest {

    //Test that allows to search files by path, if the result is not empty this means the method was able  to search by the path value
    @Test
    public void searchFileByPath(){
        Search searchFile=new Search();
        String directory="./test/com/jalasoft/search/resourceTest";
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        for (FileObject file : searchResult)
        {
            String name=file.getFileName();
            System.out.println("name "+name);
        }
        assertFalse(searchResult.isEmpty());

    }

    //Test that allows to search files by file name, if the result found the file this means the method was able  to search by the name value
    @Test
    public void searchFileByPathAndName(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        String nameFile="FileName";
        searchCriterial.setFileName(nameFile);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String name=file.getFileName();

            if(name.equals(nameFile)){
                fileFound=true;
            }
        }
       assertTrue(fileFound);
    }

    //This test allows to search files that are read only
    @Test
    public void searchFileByPathAndReadOnly(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        boolean readOnly=true;
        //searchCriterial.setReadOnly(readOnly);
        searchFile.setReadOnly(readOnly);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            boolean fileReadOnly=file.isReadOnly();

            if(fileReadOnly==readOnly){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //Test that allows to search files by read only file, file name and directory path
    @Test
    public void searchFileByPathAndNameAndReadOnly(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        String nameFile="FileReadOnly";
        boolean readOnly=true;
        //searchCriterial.setFileName(nameFile);
        //searchCriterial.setReadOnly(readOnly);
        searchFile.setReadOnly(readOnly);
        searchFile.setFileName(nameFile);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String name=file.getFileName();
            String dir=file.getFileDirectory().toString();
            boolean fileReadOnly=file.isReadOnly();

            if(name.equals(nameFile) && fileReadOnly==readOnly){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files that are hidden
    @Test
    public void searchFileByPathAndHidden(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        boolean hidden=true;
        //searchCriterial.setHidden(hidden);
        searchFile.setHidden(hidden);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            boolean fileHidden=file.isHidden();

            if(fileHidden==hidden){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //Test that allows to search files by hidden file, file name and directory path
    @Test
    public void searchFileByPathAndNameAndHidden(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        String nameFile="FileHidden";
        boolean hidden=true;
        //searchCriterial.setFileName(nameFile);
        //searchCriterial.setHidden(hidden);
        searchFile.setHidden(hidden);
        searchFile.setFileName(nameFile);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String name=file.getFileName();
            boolean fileHidden=file.isHidden();
            if(name.equals(nameFile) && fileHidden==hidden){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files that by extension
    @Test
    public void searchFileByPathAndExtension(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        String extention="docx";
        //searchCriterial.setFileType(extention);
        searchFile.setFileType(extention);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String extensionFile= ((File)file).getFileType();
            String name=file.getFileName();
            System.out.println("file name "+name);
            System.out.println("file extension "+extensionFile);

            if(extensionFile.equals(extention)){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files by extension,name and path
    @Test
    public void searchFileByPathAndExtensionAndName(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        String extention="docx";
        String name="FileName";
        //searchCriterial.setFileType(extention);
        //searchCriterial.setFileName(name);
        searchFile.setFileType(extention);
        searchFile.setFileName(name);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String extensionFile= ((File)file).getFileType();
            String nameFile=file.getFileName();

            if(extensionFile.equals(extention) && nameFile.equals(name)){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }
}
