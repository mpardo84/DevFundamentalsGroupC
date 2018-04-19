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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 This class is the main dialog that contains the tabs for each type of ObjectFile that we could have in the application
 *
 * @version
1.1 25 Mar 2018  * @author
Monica Pardo */
public class SearchProject extends JFrame{
    private FilePanel filePanel;
    private DirectoryPanel directoryPanel;
    private JPanel multimediaPanel;
    private JTabbedPane tabbedPane;
    private  ImageIcon fileIcon;
    private  ImageIcon directoryIcon;
    private  ImageIcon multimediaIcon;
    private static int w;
    private static int h;

    public SearchProject(){
        initializeDialog("Search Application");
    }

    //Define the parameters for the dialog
    public void initializeDialog(String title){
        //initialize variables for tab panel
        try {

            
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);

            tabbedPane = new JTabbedPane();
            filePanel=new FilePanel();
            directoryPanel=new DirectoryPanel();
            multimediaPanel=new JPanel();

            //add icons to the tabs
            fileIcon = new ImageIcon(
                    this.getClass().getResource("/images/file.jpg"));
            directoryIcon = new ImageIcon(
                    this.getClass().getResource("/images/directory.jpg"));
            multimediaIcon = new ImageIcon(
                    this.getClass().getResource("/images/multimedia.png"));

            //Add tabs to the panel
            tabbedPane.addTab("File ",fileIcon,filePanel);
            tabbedPane.addTab("Directory ",directoryIcon,directoryPanel);
            tabbedPane.addTab("Multimedia ",multimediaIcon,multimediaPanel);
            // add the tab panel to the frame
            this.add(tabbedPane);
            /*GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice();
            w = gd.getDisplayMode().getWidth();
            h = gd.getDisplayMode().getHeight();*/



            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(1020, 800);
            this.setBounds(300, 50,1050,750);
            this.setTitle(title);
            this.setVisible(true);
            this.setResizable(false);
        } catch(Exception e){
            e.printStackTrace();
        }
       
    }

    //Method that allows to get the name for the field from UI
    public String getFileName(){
        String fileName=filePanel.getFileName();
        return fileName;

    }

    //Method that allows to get the path for the field from UI
    public String getPathName(){
        return filePanel.getFilePath();

    }

    //Method that allows to get the readOnly for the field from UI
    public String getReadOnly(){

        return filePanel.getReadOnly();
    }

    //Method that allows to get the hidden option for the field from UI
    public String getHidden(){
        return filePanel.getHidden();
    }

    //Method that allows to get the owner value for the field from UI
    public String getOwnerValue(){
        return filePanel.getOwner();
    }

    //Method that allows to get the contains value for the field from UI
    public String getContains(){
        return filePanel.getContains();
    }

    //Method that allows to get if the type is a File
    public String getIsFile(){
        return filePanel.getIsFile();
    }

    //Method that allows to get the search button
    public JButton getSearchButton(){
       return filePanel.getButtonSearch();
    }

    //method to allows set the message value
    public void setMessage(String message) {
        filePanel.setMessage(message);
    }

    //Method that allows to get the Table result
    public DefaultTableModel getTable() {
        return filePanel.getTable();
    }

    //Get method to get the created option selected from UI
    public String getCreatedOptions() {
        return filePanel.getCreatedOptions();
    }

    //Get method to get the modified option selected from UI
    public String getModifiedOptions() {
        return filePanel.getModifiedOptions();
    }

    //Get method to get the acessed option selected from UI
    public String getAccessedOptions() {
        return filePanel.getAccessedOptions();
    }

    //Get method to get the  range for the created option selected from UI
    public Date getFromCreatedDate() {
        return filePanel.getFromCreatedDate();
    }

    //Get method to get the range for the  created option selected from UI
    public Date getToCreatedDate() {
        return filePanel.getToCreatedDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getFromModifiedDate() {
        return filePanel.getFromModifiedDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getToModifiedDate() {
        return filePanel.getToModifiedDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getFromAccessedDate() {
        return filePanel.getFromAccessedDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getToAccessedDate() {
        return filePanel.getToAccessedDate();
    }

    //Method that allows to get the type option from the SearchPanelCriteria class
    public String getTypeFile(){
        return filePanel.getTypeFile();
    }
    //Get method to get the size Option value
    public String getSizeOptions() {
        return filePanel.getSizeOptions();
    }

    //Get method to get the size
    public String getSizeValue() {
        return filePanel.getSizeValue();
    }

    //Method that allows to get the name for the field from the SearchPanelCriteria class
    public String getDirName(){
        return directoryPanel.getDirName();
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public String getDirPath(){
        return directoryPanel.getDirPath();
    }

    //Method that allows to get the owner for the field from the SearchPanelCriteria class
    public String getDirOwner(){
        return directoryPanel.getDirOwner();
    }

    //Method that allows to get the hidden option from the SearchPanelCriteria class
    public String getDirHidden(){
        return directoryPanel.getDirHidden();
    }

    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public String getDirReadOnly(){
        return directoryPanel.getDirReadOnly();
    }

    //Get method to get the created option selected from UI
    public String getCreatedDirOptions() {
        return directoryPanel.getCreatedDirOptions();
    }

    //Get method to get the modified option selected from UI
    public String getModifiedDirOptions() {
        return directoryPanel.getModifiedDirOptions();
    }

    //Get method to get the acessed option selected from UI
    public String getAccessedDirOptions() {
        return directoryPanel.getAccessedDirOptions();
    }

    //Get method to get the  range for the created option selected from UI
    public Date getFromCreatedDirDate() {
        return directoryPanel.getFromCreatedDirDate();
    }

    //Get method to get the range for the  created option selected from UI
    public Date getToCreatedDirDate() {
        return directoryPanel.getToCreatedDirDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getFromModifiedDirDate() {
        return directoryPanel.getFromModifiedDirDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getToModifiedDirDate() {
        return directoryPanel.getToModifiedDirDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getFromAccessedDirDate() {
        return directoryPanel.getFromAccessedDirDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getToAccessedDirDate() {
        return directoryPanel.getToAccessedDirDate();
    }

    //Get method to get the size Option value for Directory panel
    public String getSizeDirOptions() {
        return directoryPanel.getSizeDirOptions();
    }

    //Get method to get the size for Directory panel
    public String getSizeDirValue() {
        return directoryPanel.getSizeDirValue();
    }

    //Method that allows to get the search button for Directory panel
    public JButton getSearchDir(){
        return directoryPanel.getSearchDir();
    }


    //method to get the save button
    public JButton getSaveCriteriaButton() {
        return filePanel.getSaveButton();
    }

    //method to get the name criteria
    public String getNameCriteria(){
        return filePanel.getNameCriteria();
    }

    // method to open the Save Criteria dialog
    public void openSaveCriteriaDialog(){
        filePanel.openSaveCriteriaDialog();
    }

    //method to get the load button
    public JButton getLoadButton() {
        return filePanel.getLoadButton();
    }

    // method to open the Load Criteria dialog
    public void openLoadCriteriaDialog(){
        filePanel.openLoadCriteriaDialog();
    }

    //method to get the load button
    public JButton getLoadCriteriaButton() {
        return filePanel.getLoadCriteriaButton();
    }

    //method to set the criteria values
    public void setCriteriaValues(String[] criteriaValues) {

                filePanel.setCriteriaValues(criteriaValues);
    }
    //Method that allows to get the Table for the criteria
    public DefaultTableModel getCriteriaTable() {
        return filePanel.getCriteriaTable();
    }

    //Method that allows to get the Table for the criteria
    public JTable geTableC() {
        return filePanel.geTableC();
    }

    //method to get the ID from the criteria table
    public String getCriteriaID() {
        return filePanel.getCriteriaID();
    }

    //Method that allows to get the Table
    public DefaultTableModel getDirTable() {
        return directoryPanel.getDirTable();
    }



    //method to get the save button
    public JButton getDirSaveButton() {
        return directoryPanel.getDirSaveButton();
    }

    //method to get the name criteria
    public String getdirNameCriteria(){
        return directoryPanel.getdirNameCriteria();
    }
    // method to open the Save Criteria dialog
    public void openSaveDirCriteriaDialog(){
        directoryPanel.openSaveDirCriteriaDialog();
    }

    //method to get the load button
    public JButton getDirLoadButton() {
        return directoryPanel.getDirLoadButton();
    }

    // method to open the load Criteria dialog
    public void openLoadDirCriteriaDialog(){
        directoryPanel.openLoadDirCriteriaDialog();
    }

    //method to get the load button
    public JButton getLoadDirCriteriaButton() {
        return directoryPanel.getLoadDirCriteriaButton();
    }

    //Method that allows to get the Table for the criteria
    public DefaultTableModel getDirCriteriaTable() {
        return directoryPanel.getDirCriteriaTable();
    }

    //Method that allows to get the Table for the criteria
    public JTable geTableCDir() {
        return directoryPanel.geTableCDir();
    }

    //method to get the ID from the criteria table
    public String getDirCriteriaID() {
        return directoryPanel.getCriteriaID();
    }

    public void setFileName(String fileName){
        filePanel.setFileName(fileName);
    }

    //Method that allows to get the path for the field from the SearchPanelCriteria class
    public void setFilePath(String filePath){
        filePanel.setFilePath(filePath);
    }
    public void setOwner(String owner){
        filePanel.setOwner(owner);
    }
    public void setHidden(String hiddenOption){
        filePanel.setHidden(hiddenOption);
    }
    //Method that allows to get the readOnly option from the SearchPanelCriteria class
    public void setReadOnly(String readOnly){
        filePanel.setReadOnly(readOnly);
    }
    //Method that allows to get the type option from the SearchPanelCriteria class
    public void setTypeFile(String typeField){
        filePanel.setTypeFile(typeField);
    }
    //Method that allows to get the contains value from the SearchPanelCriteria class
    public void setContains(String contains){
        filePanel.setContains(contains);
    }

    //Get method to get the created option selected from UI
    public void setCreatedOptions(String createdOptions) {
        filePanel.setCreatedOptions(createdOptions);
    }
    //Get method to get the modified option selected from UI
    public void setModifiedOptions(String modifiedOptions) {
        filePanel.setModifiedOptions(modifiedOptions);
    }
    //Get method to get the acessed option selected from UI
    public void setAccessedOptions(String accessedOptions) {
        filePanel.setAccessedOptions(accessedOptions);
    }
    //Get method to get the  range for the created option selected from UI
    public void setFromCreatedDate(Date fromCreatedDate) {
        filePanel.setFromCreatedDate(fromCreatedDate);
    }
    //Get method to get the range for the  created option selected from UI
    public void setToCreatedDate(Date toCreatedDate) {
        filePanel.setToCreatedDate(toCreatedDate);
    }
    //Get method to get the range for the modified option selected from UI
    public void setFromModifiedDate(Date fromModifiedDate) {
        filePanel.setFromModifiedDate(fromModifiedDate);
    }
    //Get method to get the range for the modified option selected from UI
    public void setToModifiedDate(Date toModifiedDate) {
        filePanel.setToModifiedDate(toModifiedDate);
    }
    //Get method to get the range for the accessed option selected from UI
    public void setFromAccessedDate(Date fromAccessDate) {
        filePanel.setFromAccessedDate(fromAccessDate);
    }
    //Get method to get the range for the accessed option selected from UI
    public void setToAccessedDate(Date toAccessedDate) {
        filePanel.setToAccessedDate(toAccessedDate);
    }
    //Get method to get the size Option value
    public void setSizeOptions(String sizeOptions) {
        filePanel.setSizeOptions(sizeOptions);
    }
    //Get method to get the size
    public void setSizeValue(String sizeValue) {
        filePanel.setSizeValue(sizeValue);
    }

    //Method to set the Read only dir
    public void setReadOnlyDirOptions(String readOnlyDirOptions) {
        directoryPanel.setReadOnlyDirOptions(readOnlyDirOptions);
    }

    //Get method to get the hidden value from UI
    public void setHiddenDirOptions(String hiddenDirOptions) {

        directoryPanel.setHiddenDirOptions(hiddenDirOptions);
    }

    //Get method to get the created option value from UI
    public void setCreatedDirOptions(String createdDirOptions) {
        directoryPanel.setCreatedDirOptions(createdDirOptions);
    }

    //Get method to set the modified dir value from UI
    public void setModifiedDirOptions(String modifiedDirOptions) {

        directoryPanel.setModifiedDirOptions(modifiedDirOptions);
    }

    //Get method to set the accessed dir value from UI
    public void setAccessedDirOptions(String accessedDirOptions) {

        directoryPanel.setAccessedDirOptions(accessedDirOptions);
    }

    //Get method to set the range for Created date value from UI
    public void setFromCreatedDirDate(Date fromCreatedDirDate) {

        directoryPanel.setFromCreatedDirDate(fromCreatedDirDate);
    }

    //Get method to get the range for Created date value from UI
    public void setToCreatedDirDate(Date toCreatedDirDate) {

        directoryPanel.setToCreatedDirDate(toCreatedDirDate);
    }

    //Get method to set the range for Modified date value from UI
    public void setFromModifiedDirDate(Date fromModifiedDirDate) {
        directoryPanel.setFromModifiedDirDate(fromModifiedDirDate);
    }
    //Set method to set the range to modified date
    public void setToModifiedDirDate(Date toModifiedDirDate) {
        directoryPanel.setToModifiedDirDate(toModifiedDirDate);
    }

    //Set method to set the range for Accessed date value from UI
    public void setFromAccessedDirDate(Date fromAccessedDirDate) {

        directoryPanel.setFromAccessedDirDate(fromAccessedDirDate);
    }

    //set method to set the range for accessed date
    public void setToAccessedDirDate(Date toAccessedDirDate) {

        directoryPanel.setToAccessedDirDate(toAccessedDirDate);
    }


    //method to allows set the size dir option value
    public void setSizeDirOptions(String sizeDirOptions) {

        directoryPanel.setSizeDirOptions(sizeDirOptions);
    }

    //method to allows get the size  value
    public void setSizeDirValue(String sizeDirValue){
        directoryPanel.setSizeDirValue(sizeDirValue);
    }
    //method to set the file owner value from UI
    public void setOwnerDirField(String ownerDirField) {
        directoryPanel.setOwnerDirField(ownerDirField);
    }

    //Method for set the name directory field
    public void setNameDirField(String nameDirField) {
        directoryPanel.setNameDirField(nameDirField);
    }

    //method for the fields that the user will insert data
    public void setPathDirValue(String pathDirValue) {
        directoryPanel.setPathDirValue(pathDirValue);
    }
}

