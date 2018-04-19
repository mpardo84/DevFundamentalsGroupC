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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 This class represent the panel that will contains the results and search criteria options for the File
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo */

public class FilePanel extends JPanel{
    private SearchPanelCriteria searchPanelCriteria;
    private SearchPanelResults searchPanelResults;

    // Get loggerWrapper intance
    LoggerWrapper logger = LoggerWrapper.getInstance();


    public FilePanel(){
        initializeDialog();

    }
    //This method allows to initialize the Panel
    public void initializeDialog(){
        logger.log.info("Creating panel to get file data");
        setBackground(Color.white);
        this.setLayout(new GridLayout(1, 2));
        searchPanelCriteria=new SearchPanelCriteria();
        searchPanelResults=new SearchPanelResults("File");
        this.add(searchPanelCriteria);
        this.add(searchPanelResults);

    }

    //Method that allows to get the name for the field from the SearchPanelCriteria class
    public String getFileName(){
        return searchPanelCriteria.getNameField();
    }

    //Method that allows to get the name for the field from the SearchPanelCriteria class
    public void setFileName(String fileName){
         searchPanelCriteria.setNameField(fileName);
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public void setFilePath(String filePath){
         searchPanelCriteria.setPathValue(filePath);
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public String getFilePath(){
        return searchPanelCriteria.getPathValue();
    }

    //Method that allows to get the owner for the field from the SearchPanelCriteria class
    public String getOwner(){
        return searchPanelCriteria.getOwnerField();
    }
    //Method that allows to get the owner for the field from the SearchPanelCriteria class
    public void setOwner(String owner){
         searchPanelCriteria.setOwnerField(owner);
    }

    //Method that allows to get the hidden option from the SearchPanelCriteria class
    public String getHidden(){
        return searchPanelCriteria.getHiddenOptions();
    }
    //Method that allows to get the hidden option from the SearchPanelCriteria class
    public void setHidden(String hiddenOption){
         searchPanelCriteria.setHiddenOptions(hiddenOption);
    }

    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public String getReadOnly(){
        return searchPanelCriteria.getReadOnlyOptions();
    }

    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public void setReadOnly(String readOnly){
         searchPanelCriteria.setReadOnlyOptions(readOnly);
    }
    //Method that allows to get the type option from the SearchPanelCriteria class
    public String getTypeFile(){
        return searchPanelCriteria.getTypeField();
    }

    //Method that allows to get the type option from the SearchPanelCriteria class
    public void setTypeFile(String typeField){
         searchPanelCriteria.setTypeField(typeField);
    }

    //Method that allows to get the contains value from the SearchPanelCriteria class
    public String getContains(){
        return searchPanelCriteria.getContainsField();
    }

    //Method that allows to get the contains value from the SearchPanelCriteria class
    public void setContains(String contains){
         searchPanelCriteria.setContainsField(contains);
    }

    //Method that allows to get if the type is a File from the SearchPanelCriteria class
    public String getIsFile(){
        return searchPanelCriteria.getTypeObject();
    }

    //Get method to get the created option selected from UI
    public void setCreatedOptions(String createdOptions) {
         searchPanelCriteria.setCreatedOptions(createdOptions);
    }

    //Get method to get the created option selected from UI
    public String getCreatedOptions() {
        return searchPanelCriteria.getCreatedOptions();
    }

    //Get method to get the modified option selected from UI
    public String getModifiedOptions() {
        return searchPanelCriteria.getModifiedOptions();
    }

    //Get method to get the modified option selected from UI
    public void setModifiedOptions(String modifiedOptions) {
         searchPanelCriteria.setModifiedOptions(modifiedOptions);
    }

    //Get method to get the acessed option selected from UI
    public String getAccessedOptions() {
        return searchPanelCriteria.getAccessedOptions();
    }

    //Get method to get the acessed option selected from UI
    public void setAccessedOptions(String accessedOptions) {
         searchPanelCriteria.setAccessedOptions(accessedOptions);
    }

    //Get method to get the  range for the created option selected from UI
    public Date getFromCreatedDate() {
        return searchPanelCriteria.getFromCreatedDate();
    }

    //Get method to get the  range for the created option selected from UI
    public void setFromCreatedDate(Date fromCreatedDate) {
         searchPanelCriteria.setFromCreatedDate(fromCreatedDate);
    }

    //Get method to get the range for the  created option selected from UI
    public Date getToCreatedDate() {
        return searchPanelCriteria.getToCreatedDate();
    }

    //Get method to get the range for the  created option selected from UI
    public void setToCreatedDate(Date toCreatedDate) {
         searchPanelCriteria.setToCreatedDate(toCreatedDate);
    }

    //Get method to get the range for the modified option selected from UI
    public Date getFromModifiedDate() {
        return searchPanelCriteria.getFromModifiedDate();
    }

    //Get method to get the range for the modified option selected from UI
    public void setFromModifiedDate(Date fromModifiedDate) {
         searchPanelCriteria.setFromModifiedDate(fromModifiedDate);
    }

    //Get method to get the range for the modified option selected from UI
    public Date getToModifiedDate() {
        return searchPanelCriteria.getToModifiedDate();
    }

    //Get method to get the range for the modified option selected from UI
    public void setToModifiedDate(Date toModifiedDate) {
         searchPanelCriteria.setToModifiedDate(toModifiedDate);
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getFromAccessedDate() {
        return searchPanelCriteria.getFromAccessedDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public void setFromAccessedDate(Date fromAccessDate) {
         searchPanelCriteria.setFromAccessedDate(fromAccessDate);
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getToAccessedDate() {
        return searchPanelCriteria.getToAccessedDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public void setToAccessedDate(Date toAccessedDate) {
         searchPanelCriteria.setToAccessedDate(toAccessedDate);
    }

    //Get method to get the size Option value
    public String getSizeOptions() {
        return searchPanelCriteria.getSizeOptions();
    }


    //Get method to get the size Option value
    public void setSizeOptions(String sizeOptions) {
         searchPanelCriteria.setSizeOptions(sizeOptions);
    }

    //Get method to get the size
    public String getSizeValue() {
        return searchPanelCriteria.getSizeValue();
    }

    //Get method to get the size
    public void setSizeValue(String sizeValue) {
         searchPanelCriteria.setSizeValue(sizeValue);
    }

    //Method that allows to get the search button
    public JButton getButtonSearch(){
        return searchPanelCriteria.getSearchButton();
    }

    //method to allows set the message value
    public void setMessage(String message) {
        searchPanelCriteria.setMessage(message);
        searchPanelCriteria.validateRequiredField();
    }

    //Method that allows to get the Table
    public DefaultTableModel getTable() {
        return searchPanelResults.getTable();
    }

    //method to get the save button
    public JButton getSaveButton() {
        return searchPanelCriteria.getSaveButton();
    }

    //method to get the name criteria
    public String getNameCriteria(){
        return searchPanelCriteria.getNameCriteria();
    }
    // method to open the Save Criteria dialog
    public void openSaveCriteriaDialog(){
        searchPanelCriteria.saveCriteriaDialog();
    }

    //method to get the load button
    public JButton getLoadButton() {
        return searchPanelCriteria.getLoadButton();
    }

    // method to open the load Criteria dialog
    public void openLoadCriteriaDialog(){
       searchPanelCriteria.loadCriteriaDialog();
    }

    //method to get the load button
    public JButton getLoadCriteriaButton() {
        return searchPanelCriteria.getLoadCriteriaButton();
    }

    public void setCriteriaValues(String[] criteriaValues) {
        searchPanelCriteria.setCriteriaValues(criteriaValues);
    }

    //Method that allows to get the Table for the criteria
    public DefaultTableModel getCriteriaTable() {
        return searchPanelCriteria.getCriteriaTable();
    }

    //Method that allows to get the Table for the criteria
    public JTable geTableC() {
        return searchPanelCriteria.getTableC();
    }

    //method to get the ID from the criteria table
    public String getCriteriaID() {
        return searchPanelCriteria.getCriteriaID();
    }

}


