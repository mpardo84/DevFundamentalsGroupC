/*
 *     1 21/03/18
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
package com.jalasoft.search.view;

import com.jalasoft.search.commond.LoggerWrapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 This class represent the panel that will contains the results and search criteria options for the File
 *
 * @version
1.0 25 Mar 2018  * @author
Monica Pardo */

public class DirectoryPanel extends JPanel{
    private SearchDirectoryPanelCriteria searchDirectoryCriteria;
    private SearchPanelResults searchPanelResults;

    // Get loggerWrapper intance
    LoggerWrapper logger = LoggerWrapper.getInstance();

    public DirectoryPanel(){

        initializeDialog();
    }

    //This method allows to initialize the Panel
    public void initializeDialog(){
        logger.log.info("Creating panel to get directory data");
        this.setLayout(new GridLayout(1, 2));
        searchDirectoryCriteria=new SearchDirectoryPanelCriteria();
        searchPanelResults=new SearchPanelResults("Directory");
        this.add(searchDirectoryCriteria);
        this.add(searchPanelResults);
    }

    //Method that allows to get the name for the field from the SearchPanelCriteria class
    public String getDirName(){
        return searchDirectoryCriteria.getNameDirField();
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public String getDirPath(){
        return searchDirectoryCriteria.getDirPathValue();
    }

    //Method that allows to get the owner for the field from the SearchPanelCriteria class
    public String getDirOwner(){
        return searchDirectoryCriteria.getOwnerDirField();
    }

    //Method that allows to get the hidden option from the SearchPanelCriteria class
    public String getDirHidden(){
        return searchDirectoryCriteria.getHiddenDirOptions();
    }

    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public String getDirReadOnly(){
        return searchDirectoryCriteria.getReadOnlyDirOptions();
    }

   //Get method to get the created option selected from UI
    public String getCreatedDirOptions() {
        return searchDirectoryCriteria.getCreatedDirOptions();
    }

    //Get method to get the modified option selected from UI
    public String getModifiedDirOptions() {
        return searchDirectoryCriteria.getModifiedDirOptions();
    }

    //Get method to get the acessed option selected from UI
    public String getAccessedDirOptions() {
        return searchDirectoryCriteria.getAccessedDirOptions();
    }

    //Get method to get the  range for the created option selected from UI
    public Date getFromCreatedDirDate() {
        return searchDirectoryCriteria.getFromCreatedDirDate();
    }

    //Get method to get the range for the  created option selected from UI
    public Date getToCreatedDirDate() {
        return searchDirectoryCriteria.getToCreatedDirDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getFromModifiedDirDate() {
        return searchDirectoryCriteria.getFromModifiedDirDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getToModifiedDirDate() {
        return searchDirectoryCriteria.getToModifiedDirDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getFromAccessedDirDate() {
        return searchDirectoryCriteria.getFromAccessedDirDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getToAccessedDirDate() {
        return searchDirectoryCriteria.getToAccessedDirDate();
    }

    //Get method to get the size Option value
    public String getSizeDirOptions() {
        return searchDirectoryCriteria.getSizeDirOptions();
    }

    //Get method to get the size
    public String getSizeDirValue() {
        return searchDirectoryCriteria.getSizeDirValue();
    }

    //Method that allows to get the search button
    public JButton getSearchDir(){
        return searchDirectoryCriteria.getSearchDirButton();
    }

    //method to allows set the message value
    public void setMessage(String message) {
        searchDirectoryCriteria.setMessage(message);
        searchDirectoryCriteria.validateRequiredField();
    }
    //Method that allows to get the Table
    public DefaultTableModel getDirTable() {
        return searchPanelResults.getDirTableModel();
    }


    //Method that allows to get the Table
    public DefaultTableModel getTable() {
        return searchPanelResults.getTable();
    }

    //method to get the save button
    public JButton getDirSaveButton() {
        return searchDirectoryCriteria.getDirSaveButton();
    }

    //method to get the name criteria
    public String getdirNameCriteria(){
        return searchDirectoryCriteria.getDirNameCriteria();
    }
    // method to open the Save Criteria dialog
    public void openSaveDirCriteriaDialog(){
        searchDirectoryCriteria.saveDirCriteriaDialog();
    }

    //method to get the load button
    public JButton getDirLoadButton() {
        return searchDirectoryCriteria.getDirLoadButton();
    }

    // method to open the load Criteria dialog
    public void openLoadDirCriteriaDialog(){
        searchDirectoryCriteria.loadDirCriteriaDialog();
    }

    //method to get the load button
    public JButton getLoadDirCriteriaButton() {
        return searchDirectoryCriteria.getDirLoadCriteriaButton();
    }

        //Method that allows to get the Table for the criteria
    public DefaultTableModel getDirCriteriaTable() {
        return searchDirectoryCriteria.getdirCriteriaTable();
    }

    //Method that allows to get the Table for the criteria
    public JTable geTableCDir() {
        return searchDirectoryCriteria.getTableCDir();
    }

    //method to get the ID from the criteria table
    public String getCriteriaID() {
        return searchDirectoryCriteria.getCriteriaDirID();
    }


    //Method to set the Read only dir
    public void setReadOnlyDirOptions(String readOnlyDirOptions) {
        searchDirectoryCriteria.setReadOnlyDirOptions(readOnlyDirOptions);
    }

    //Get method to get the hidden value from UI
    public void setHiddenDirOptions(String hiddenDirOptions) {

        searchDirectoryCriteria.setHiddenDirOptions(hiddenDirOptions);
    }

    //Get method to get the created option value from UI
    public void setCreatedDirOptions(String createdDirOptions) {
        searchDirectoryCriteria.setCreatedDirOptions(createdDirOptions);
    }

    //Get method to set the modified dir value from UI
    public void setModifiedDirOptions(String modifiedDirOptions) {

        searchDirectoryCriteria.setModifiedDirOptions(modifiedDirOptions);
    }

    //Get method to set the accessed dir value from UI
    public void setAccessedDirOptions(String accessedDirOptions) {

        searchDirectoryCriteria.setAccessedDirOptions(accessedDirOptions);
    }

    //Get method to set the range for Created date value from UI
    public void setFromCreatedDirDate(Date fromCreatedDirDate) {

        searchDirectoryCriteria.setFromCreatedDirDate(fromCreatedDirDate);
    }

    //Get method to get the range for Created date value from UI
    public void setToCreatedDirDate(Date toCreatedDirDate) {

        searchDirectoryCriteria.setToCreatedDirDate(toCreatedDirDate);
    }

    //Get method to set the range for Modified date value from UI
    public void setFromModifiedDirDate(Date fromModifiedDirDate) {
        searchDirectoryCriteria.setFromModifiedDirDate(fromModifiedDirDate);
    }
    //Set method to set the range to modified date
    public void setToModifiedDirDate(Date toModifiedDirDate) {
        searchDirectoryCriteria.setToModifiedDirDate(toModifiedDirDate);
    }

    //Set method to set the range for Accessed date value from UI
    public void setFromAccessedDirDate(Date fromAccessedDirDate) {

        searchDirectoryCriteria.setFromAccessedDirDate(fromAccessedDirDate);
    }

    //set method to set the range for accessed date
    public void setToAccessedDirDate(Date toAccessedDirDate) {

        searchDirectoryCriteria.setToAccessedDirDate(toAccessedDirDate);
    }


    //method to allows set the size dir option value
    public void setSizeDirOptions(String sizeDirOptions) {

        searchDirectoryCriteria.setSizeDirOptions(sizeDirOptions);
    }

    //method to allows get the size  value
    public void setSizeDirValue(String sizeDirValue){
        searchDirectoryCriteria.setSizeDirValue(sizeDirValue);
    }
    //method to set the file owner value from UI
    public void setOwnerDirField(String ownerDirField) {
        searchDirectoryCriteria.setOwnerDirField(ownerDirField);
    }

    //Method for set the name directory field
    public void setNameDirField(String nameDirField) {
        searchDirectoryCriteria.setNameDirField(nameDirField);
    }

    //method for the fields that the user will insert data
    public void setPathDirValue(String pathDirValue) {
        searchDirectoryCriteria.setPathDirValue(pathDirValue);
    }
}
