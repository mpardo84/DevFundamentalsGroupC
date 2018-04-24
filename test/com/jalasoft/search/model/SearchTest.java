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
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
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
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        for (FileObject file : searchResult)
        {
            String name=file.getFileName();
        }
        assertFalse(searchResult.isEmpty());

    }

    //Negative test-check with empty path for the directory
    @Test
    public void searchFileByEmptyPath(){
        Search searchFile=new Search();
        String directory="";
        //searchFile.
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        for (FileObject file : searchResult)
        {
            String name=file.getFileName();
        }
        assertTrue(searchResult.isEmpty());

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
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
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

        searchFile.getSearchCriterial().setReadOnly(readOnly);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
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

        searchFile.getSearchCriterial().setReadOnly(readOnly);
        searchFile.getSearchCriterial().setFileName(nameFile);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
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
        searchFile.getSearchCriterial().setHidden(hidden);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
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

        String directory="./test/com/jalasoft/search/resourceTest";
        String nameFile="FileHidden";
        boolean hidden=true;

        searchFile.getSearchCriterial().setHidden(hidden);
        searchFile.getSearchCriterial().setFileName(nameFile);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
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

        searchFile.getSearchCriterial().setFileType(extention);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String extensionFile= ((File)file).getFileType();
            String name=file.getFileName();

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

        searchFile.getSearchCriterial().setFileType(extention);
        searchFile.getSearchCriterial().setFileName(name);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
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

    //This test allows to search files by extension,name,read Only, hidden and path
    @Test
    public void searchFileByPathAndExtensionAndNameAndReadOnlyAndHidden(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        String extention="txt";
        String name="FileNameReadOnlyAndHidden";
        boolean hidden=true;
        boolean readOnly=true;

        searchFile.getSearchCriterial().setFileType(extention);
        searchFile.getSearchCriterial().setFileName(name);
        searchFile.getSearchCriterial().setReadOnly(true);
        searchFile.getSearchCriterial().setHidden(hidden);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            String extensionFile= ((File)file).getFileType();
            String nameFile=file.getFileName();
            boolean readOnlyFile=file.isReadOnly();
            boolean hiddenFile=file.isHidden();

            if(extensionFile.equals(extention) && nameFile.equals(name) && readOnlyFile==readOnly && hiddenFile==hidden){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files by name,read Only, hidden and path
    @Test
    public void searchFileByPathAndNameAndReadOnlyAndHidden() {
        Search searchFile = new Search();
        SearchCriterial searchCriterial = new SearchCriterial();
        String directory = "./test/com/jalasoft/search/resourceTest";
        String name = "FileNameReadOnlyAndHidden";
        boolean hidden = true;
        boolean readOnly = true;

        searchFile.getSearchCriterial().setFileName(name);
        searchFile.getSearchCriterial().setHidden(hidden);
        searchFile.getSearchCriterial().setReadOnly(readOnly);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        boolean fileFound = false;
        for (FileObject file : searchResult) {

            String nameFile = file.getFileName();
            boolean readOnlyFile = file.isReadOnly();
            boolean hiddenFile = file.isHidden();
            if (nameFile.equals(name) && readOnlyFile == readOnly && hiddenFile == hidden) {
                fileFound = true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files by size that are greater than 1.1 KB
    @Test
    public void searchFileByPathAndSizeGreaterCondition(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        double size=1.1;
        String condition=">";
        searchCriterial.setSize(size);
        searchFile.getSearchCriterial().setSizeOption(condition);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            double fileSize = file.getSize();
            double sizeFile= fileSize/1024;

            if(sizeFile >size){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files by size that are less than 5
    @Test
    public void searchFileByPathAndSizeLessCondition(){
        Search searchFile=new Search();
        SearchCriterial searchCriterial=new SearchCriterial();
        String directory="./test/com/jalasoft/search/resourceTest";
        double size=5;
        String condition="<";
        searchFile.getSearchCriterial().setSizeOption(condition);
        searchFile.getSearchCriterial().setSize(size);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            double fileSize = file.getSize();
            double sizeFile= fileSize/1024;
            if(sizeFile <size){
                fileFound=true;
            }
        }
        assertTrue(fileFound);
    }

    //This test allows to search files by size that are equals to 1.18
    @Test
    public void searchFileByPathAndSizeEqualsCondition(){
        Search searchFile=new Search();

        String directory="./test/com/jalasoft/search/resourceTest";
        double size=26.0;
        String condition="=";


        searchFile.getSearchCriterial().setSizeOption(condition);
        searchFile.getSearchCriterial().setSize(size);
        searchFile.searchFile(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        boolean fileFound=false;
        for (FileObject file : searchResult)
        {
            double fileSize = file.getSize();

            double sizeFile= fileSize/1024;

            if(sizeFile == size){
                fileFound=true;
            }
        }
        assertFalse(fileFound);
    }


    //Test that allows to search directory by name
    @Test
    public void searchDirectoryByName(){
        Search searchFile=new Search();
        String directory="./test/com/jalasoft/search/resourceTest";
        String dirName="DirectoryName2";
        boolean dirFound=false;
        searchFile.getSearchCriterial().setDirectoryName(dirName);
        searchFile.getSearchCriterial().setDirectoryPath(directory);
        searchFile.searchDirectory(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        for (FileObject dir : searchResult)
        {
            String name=dir.getFileName();
            if(dirName.equals(name)){
                dirFound=true;
            }
        }
        assertTrue(dirFound);

    }

    //Test that allows to search directory by hidden
    @Test
    public void searchDirectoryByHidden(){
        Search searchFile=new Search();
        String directory="./test/com/jalasoft/search/resourceTest";
        boolean hidden=true;
        boolean dirFound=false;
        searchFile.getSearchCriterial().setHidden(hidden);
        searchFile.getSearchCriterial().setDirectoryPath(directory);
        searchFile.searchDirectory(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        for (FileObject dir : searchResult)
        {
            boolean hiddenDir=dir.isHidden();
            if(hiddenDir==hidden){
                dirFound=true;
            }
        }
        assertTrue(dirFound);
    }

    //Test that allows to search directory by hidden and Name
    @Test
    public void searchDirectoryByHiddenAndName(){
        Search searchFile=new Search();
        String directory="./test/com/jalasoft/search/resourceTest";
        boolean hidden=true;
        String dirName="DirectoryHidden";
        boolean dirFound=false;
        searchFile.getSearchCriterial().setHidden(hidden);
        searchFile.getSearchCriterial().setDirectoryName(dirName);
        searchFile.getSearchCriterial().setDirectoryPath(directory);
        searchFile.searchDirectory(directory);
        List<FileObject> searchResult = searchFile.getSearchCriterial().getFileObjectList();
        for (FileObject dir : searchResult)
        {
            boolean hiddenDir=dir.isHidden();
            String name=dir.getFileName();
            if(hiddenDir==hidden && name.equals(dirName)){
                dirFound=true;
            }
        }
        assertTrue(dirFound);
    }

    @BeforeClass
    public static void setupTestFiles()
    {
        String directory="./test/com/jalasoft/search/resourceTest";
        try {
            Runtime.getRuntime().exec("attrib +R "+directory+"/FileReadOnly.txt");
            Runtime.getRuntime().exec("attrib +H "+directory+"/FileHidden.txt");
            Runtime.getRuntime().exec("attrib +R "+directory+"/FileNameReadOnlyAndHidden.txt");
            Runtime.getRuntime().exec("attrib +H "+directory+"/FileNameReadOnlyAndHidden.txt");
            Runtime.getRuntime().exec("attrib -R "+directory+"/DirectoryName2");
            Runtime.getRuntime().exec("attrib -R "+directory+"/DirectoryHidden");
            Runtime.getRuntime().exec("attrib +H "+directory+"/DirectoryHidden");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
