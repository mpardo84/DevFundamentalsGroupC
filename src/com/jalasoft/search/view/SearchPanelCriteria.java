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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

/**
 *
 This class contains the fields that are part of the search criteria for a File
 *
 * @version
1.1 25 Mar 2018  * @author
Monica Pardo */


public class SearchPanelCriteria extends JPanel {
    private JLabel title;
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel containsLabel;
    private JLabel ownerLabel;
    private JLabel attributesLabel;
    private JLabel readOnlyLabel;
    private JLabel pathLabel;
    private JLabel hiddenLabel;
    private JLabel fileTimeLabel;
    private JLabel createdLabel;
    private JLabel modifiedLabel;
    private JLabel accessedLabel;
    private JLabel fromCreatedLabel;
    private JLabel toCreatedLabel;
    private JLabel fromModifiedLabel;
    private JLabel toModifedLabel;
    private JLabel fromAccessedLabel;
    private JLabel toAccessedLabel;
    private JLabel extensionLabel;
    private JLabel sizeLabel;
    private JLabel defaultSize;
    private JLabel criteriaLabel;
    private JLabel detailsCriteria;
    private JLabel selectedCriteria;
    private JTextField  nameField;
    private JTextField typeField;
    private JTextArea containsField;
    private JTextField ownerField;
    private JTextField pathValue;
    private JTextField sizeValue;
    private JFileChooser chooser;
    private JButton browseButton;
    private JButton saveButton;
    private JButton searchButton;
    private JButton cancelButton;
    private JButton loadButton;
    private JButton loadCriteriaButton;
    private JSeparator separator;
    private JComboBox readOnlyOptions;
    private JComboBox hiddenOptions;
    private JComboBox createdOptions;
    private JComboBox modifiedOptions;
    private JComboBox accessedOptions;
    private JComboBox sizeOptions;
    private JLabel criteriaOptions;
    private Font negritaFont;
    private JDateChooser fromCreatedDate;
    private JDateChooser toCreatedDate;
    private JDateChooser fromModifiedDate;
    private JDateChooser toModifiedDate;
    private JDateChooser fromAccessedDate;
    private JDateChooser toAccessedDate;
    private  String[] comboBoxTimeValues;
    private String typeObject;
    private String message;
    private  ImageIcon saveIcon;
    private ImageIcon cancelIcon;
    private ImageIcon searchIcon;
    private ImageIcon browseIcon;
    private ImageIcon loadIcon;
    private ImageIcon updateIcon;
    private String nameCriteria;
    private DefaultTableModel criteriaTable;
    private JTable tableC;
    private  String[] criteriaValues;
    private Object[][] data;



    public SearchPanelCriteria() {
        setLayout(null);
        comboBoxTimeValues = new String[] { "","All Time", "Time Range","Today","Yesterday" };

        this.setBackground(new Color(224, 224, 224));
        generalSearchCriteria();
        searchAttributesSection();
        searchFileTimeSection();
        searchPanelButtons();
        initializeTable();


    }

    //Get method to get the path value from UI
    public String getPathValue() {
        return pathValue.getText();
    }

    //Get method to get the file name value from UI
    public String getNameField() {
        return nameField.getText();
    }

    //Get method to get the file owner value from UI
    public String getOwnerField() {
        return ownerField.getText();
    }

    //Get method to get the file type value from UI
    public String getTypeField() {
        return typeField.getText();
    }

    //Get method to get the file contains value from UI
    public String getContainsField() {
        return containsField.getText();
    }

    //Get method to get if te file is read only value from UI
    public String getReadOnlyOptions() {
        return (String)readOnlyOptions.getSelectedItem();
    }

    //Get method to get if te file is hidden value from UI
    public String getHiddenOptions() {
        return (String)hiddenOptions.getSelectedItem();
    }

    //Get Method to set the type of the objetct is this is a File or not
    public String getTypeObject(){
        return typeObject="File";
    }

    //Get method to get the created option selected from UI
    public String getCreatedOptions() {
        return (String)createdOptions.getSelectedItem();
    }

    //Get method to get the modified option selected from UI
    public String getModifiedOptions() {
        return (String)modifiedOptions.getSelectedItem();
    }

    //Get method to get the acessed option selected from UI
    public String getAccessedOptions() {
        return (String)accessedOptions.getSelectedItem();
    }

    //Get method to get the  range for the created option selected from UI
    public Date getFromCreatedDate() {
        return fromCreatedDate.getDate();
    }

    //Get method to get the range for the  created option selected from UI
    public Date getToCreatedDate() {
        return toCreatedDate.getDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getFromModifiedDate() {
        return fromModifiedDate.getDate();
    }

    //Get method to get the range for the modified option selected from UI
    public Date getToModifiedDate() {
        return toModifiedDate.getDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getFromAccessedDate() {
        return fromAccessedDate.getDate();
    }

    //Get method to get the range for the accessed option selected from UI
    public Date getToAccessedDate() {
        return toAccessedDate.getDate();
    }

    //Get method to get the size Option value
    public String getSizeOptions() {
        return (String)sizeOptions.getSelectedItem();
    }

    //Get method to get the size
    public String getSizeValue() {
        return sizeValue.getText();
    }

    //Get the search button
    public JButton getSearchButton() {
        return searchButton;
    }

    //Get the Cancel button
    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setHiddenOptions(JComboBox hiddenOptions) {
        this.hiddenOptions = hiddenOptions;
    }

    public void setReadOnlyLabel(JLabel readOnlyLabel) {
        this.readOnlyLabel = readOnlyLabel;
    }

    //get method for the save criteria button
    public JButton getSaveButton() {
        return saveButton;
    }

    //set method for the save criteria button
    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    //get method for the load criteria button
    public JButton getLoadButton() {
        return loadButton;
    }

    //set method for the load criteria button
    public void setLoadButton(JButton loadButton) {
        this.loadButton = loadButton;
    }

    //method to allows set the message value
    public void setMessage(String message) {
        this.message = message;
    }

    //method that allows to get the criteria Name
    public String getNameCriteria() {
        return nameCriteria;
    }

    public JButton getLoadCriteriaButton() {
        return loadCriteriaButton;
    }

    public void setLoadCriteriaButton(JButton loadCriteriaButton) {
        this.loadCriteriaButton = loadCriteriaButton;
    }

    public void setCriteriaValues(String[] criteriaValues) {
        this.criteriaValues = criteriaValues;
        System.out.println("leego al ui los criterias ");
        String rowData[]=new String[1];
        for (String dir : criteriaValues)
        {

            rowData[0]=dir;
            System.out.println("el valor en UI"+dir);


        }
    }

    public DefaultTableModel getCriteriaTable() {
        return criteriaTable;
    }

    public void setCriteriaTable(DefaultTableModel criteriaTable) {
        this.criteriaTable = criteriaTable;
    }

    //This method allows to select a file
    public void browseFileAction(){
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("c:"));
                chooser.setDialogTitle("Browse the folder to search");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String filePath=chooser.getSelectedFile().getPath();
                    pathValue.setText(filePath);
                }
            }
        });
    }

    //this method will contains the general components for the UI
    public void generalSearchCriteria(){
        title = new JLabel("SEARCH OPTIONS");
        title.setBounds(0, 7, 200, 40);
        negritaFont=new Font("ITALIC", Font.BOLD, 12);
        title.setFont(negritaFont);
        pathLabel = new JLabel(" Search Path:");
        pathLabel.setBounds(30, 50, 80, 20);
        pathValue = new JTextField();
        pathValue.setBounds(120, 50, 200, 25);
        pathValue.setBackground(new Color(240,248,255));
        browseIcon = new ImageIcon(
                this.getClass().getResource("/images/folder.png"));
        browseButton = new JButton("Browse",browseIcon);
        browseButton.setBounds(325,50,105,25);

        nameLabel = new JLabel("File Name:");
        nameLabel.setBounds(30, 85, 80, 20);
        nameField = new JTextField();
        nameField.setBounds(120, 85, 200, 25);
        nameField.setBackground(new Color(240,248,255));

        typeLabel =new JLabel("File Type:");
        typeLabel.setBounds(30, 120, 80, 20);
        typeField = new JTextField();
        typeField.setBounds(120, 120, 40, 25);
        typeField.setBackground(new Color(240,248,255));

        extensionLabel = new JLabel("(Extension)");
        extensionLabel.setBounds(165, 120, 80, 25);
        extensionLabel.setFont(new java.awt.Font("Century", 0, 11));

        containsLabel = new JLabel("File Contains:");
        containsLabel.setBounds(30, 155, 80, 20);
        containsField = new JTextArea();
        JScrollPane scrollContains=new JScrollPane(containsField);
        scrollContains.setBounds(120, 155, 300, 35);
        containsField.setBackground(new Color(240,248,255));

        ownerLabel = new JLabel("File Owner:");
        ownerLabel.setBounds(30, 200, 80, 20);
        ownerField = new JTextField();
        ownerField.setBounds(120, 200, 150, 25);
        ownerField.setBackground(new Color(240,248,255));

        sizeLabel = new JLabel("File Size:");
        sizeLabel.setBounds(30, 240, 80, 20);
        String[] comboBoxSizesValues = { "","=", ">","<" };
        sizeOptions = new JComboBox(comboBoxSizesValues);
        sizeOptions.setBounds(120, 240, 40, 25);
        sizeValue = new JTextField();
        sizeValue.setBounds(165, 240, 80, 25);
        sizeValue.setBackground(new Color(224,224,224));
        sizeValue.setEnabled(false);
        defaultSize = new JLabel("Kb");
        defaultSize.setBounds(250, 240, 20, 25);
        sizeOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String option = (String) sizeOptions.getSelectedItem();
                if (option.equals("")) {
                    sizeValue.setEnabled(false);
                    sizeValue.setText("");
                    sizeValue.setBackground(new Color(224,224,224));
                }
                else
                {
                    sizeValue.setEnabled(true);
                    sizeValue.setBackground(new Color(240, 248, 255));
                }
            }
        });
        separator=new JSeparator();
        separator.setBounds(0, 275, 500, 20);

        add(title);
        add(pathLabel);
        add(pathValue);
        add(browseButton);
        add(nameLabel);
        add(nameField);
        add(typeLabel);
        add(typeField);
        add(extensionLabel);
        add(containsLabel);
        add(scrollContains);
        add(ownerLabel);
        add(ownerField);
        add(sizeLabel);
        add(sizeOptions);
        add(sizeValue);
        add(defaultSize);
        add(separator);
        browseFileAction();
    }

    //This method contains the components for the Attribute section in UI
    public void searchAttributesSection(){
        String[] comboBoxValues = { "False", "True" };
        attributesLabel=new JLabel("ATTRIBUTES");
        negritaFont=new Font("ITALIC", Font.BOLD, 12);
        attributesLabel.setFont(negritaFont);
        attributesLabel.setBounds(0,280,80,20);
        readOnlyLabel=new JLabel("Read Only:");
        readOnlyLabel.setBounds(30,305,80,20);
        readOnlyOptions= new JComboBox(comboBoxValues);
        readOnlyOptions.setBounds(120,305,100,20);

        hiddenLabel=new JLabel("Hidden:");
        hiddenLabel.setBounds(30,335,80,20);
        hiddenOptions= new JComboBox(comboBoxValues);
        hiddenOptions.setBounds(120,335,100,20);

        separator=new JSeparator();
        separator.setBounds(0, 370, 500, 20);

        add(attributesLabel);
        add(readOnlyLabel);
        add(readOnlyOptions);
        add(hiddenLabel);
        add(hiddenOptions);
        add(separator);
    }

    //This method contains the components for the File Time section in UI
    public void searchFileTimeSection(){

        fileTimeLabel=new JLabel("FILE TIME");
        negritaFont=new Font("ITALIC", Font.BOLD, 12);
        fileTimeLabel.setBounds(0,380,80,20);
        fileTimeLabel.setFont(negritaFont);
        //Created Date section method
        createdDateSection();
        //Modified Date section method
        modifiedDateSection();
        // accessed Date section methof
        accessedDateSection();

        separator=new JSeparator();
        separator.setBounds(0, 540, 500, 20);

        add(fileTimeLabel);
        add(createdLabel);
        add(createdOptions);
        add(fromCreatedLabel);
        add(fromCreatedDate);
        add(toCreatedLabel);
        add(toCreatedDate);
        add(modifiedLabel);
        add(modifiedOptions);
        add(fromModifiedLabel);
        add(fromModifiedDate);
        add(toModifedLabel);
        add(toModifiedDate);
        add(accessedLabel);
        add(accessedOptions);
        add(fromAccessedLabel);
        add(fromAccessedDate);
        add(toAccessedLabel);
        add(toAccessedDate);
        add(separator);
    }

    //This method allows to create the buttons
    public void searchPanelButtons(){
        loadIcon = new ImageIcon(
                this.getClass().getResource("/images/load.png"));
        loadCriteriaButton=new JButton("Load Criteria",loadIcon);
        loadCriteriaButton.setBounds(25,600,121,27);
        saveIcon = new ImageIcon(
                this.getClass().getResource("/images/save.png"));
        saveButton=new JButton("Save Criteria",saveIcon);
        saveButton.setBounds(150,600,119,27);
        searchIcon = new ImageIcon(
                this.getClass().getResource("/images/edit_find.png"));
        searchButton=new JButton("Search",searchIcon);
        searchButton.setBounds(275,600,100,27);
        cancelIcon = new ImageIcon(
                this.getClass().getResource("/images/close.png"));
        cancelButton=new JButton("Close",cancelIcon);
        cancelButton.setBounds(380,600,90,27);
        add(loadCriteriaButton);
        add(saveButton);
        add(searchButton);
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

    }

    //This method contains all the UI compoments for the createdDate section
    public void createdDateSection(){
        createdLabel=new JLabel("Created:");
        createdLabel.setBounds(15,410,80,20);
        createdOptions= new JComboBox(comboBoxTimeValues);
        createdOptions.setBounds(80,410,110,20);

        fromCreatedLabel= new JLabel("From:");
        fromCreatedLabel.setBounds(200,410,80,20);
        fromCreatedLabel.setVisible(false);
        fromCreatedDate = new JDateChooser();
        fromCreatedDate.setDate((Calendar.getInstance()).getTime());
        fromCreatedDate.setDateFormatString("dd/MM/yyyy");
        fromCreatedDate.setBounds(230, 410, 120, 22);
        fromCreatedDate.setVisible(false);

        toCreatedLabel= new JLabel("To:");
        toCreatedLabel.setBounds(350,410,80,20);
        toCreatedLabel.setVisible(false);
        toCreatedDate = new JDateChooser();
        toCreatedDate.setDate((Calendar.getInstance()).getTime());
        toCreatedDate.setDateFormatString("dd/MM/yyyy");
        toCreatedDate.setBounds(370, 410, 120, 22);
        toCreatedDate.setVisible(false);

        createdOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String selectedBook = (String) createdOptions.getSelectedItem();
                if(selectedBook.equals("")) {
                    modifiedOptions.setEnabled(true);
                    accessedOptions.setEnabled(true);
                    fromCreatedLabel.setVisible(false);
                    fromCreatedDate.setVisible(false);
                    toCreatedLabel.setVisible(false);
                    toCreatedDate.setVisible(false);
                }else{

                    modifiedOptions.setEnabled(false);
                    accessedOptions.setEnabled(false);

                    if (selectedBook.equals("Time Range")) {
                        fromCreatedLabel.setVisible(true);
                        fromCreatedDate.setVisible(true);
                        toCreatedLabel.setVisible(true);
                        toCreatedDate.setVisible(true);
                    } else {
                        fromCreatedLabel.setVisible(false);
                        fromCreatedDate.setVisible(false);
                        toCreatedLabel.setVisible(false);
                        toCreatedDate.setVisible(false);
                    }

                }

            }
        });
    }

    //This method contains all the UI components for the  modified Date section
    public void modifiedDateSection(){
        modifiedLabel=new JLabel("Modified:");
        modifiedLabel.setBounds(15,450,80,20);
        modifiedOptions= new JComboBox(comboBoxTimeValues);
        modifiedOptions.setBounds(80,450,110,20);

        fromModifiedLabel= new JLabel("From:");
        fromModifiedLabel.setBounds(200,450,80,20);
        fromModifiedLabel.setVisible(false);
        fromModifiedDate = new JDateChooser();
        fromModifiedDate.setDate((Calendar.getInstance()).getTime());
        fromModifiedDate.setDateFormatString("dd/MM/yyyy");
        fromModifiedDate.setBounds(230, 450, 120, 22);
        fromModifiedDate.setVisible(false);

        toModifedLabel= new JLabel("To:");
        toModifedLabel.setBounds(350,450,80,20);
        toModifedLabel.setVisible(false);
        toModifiedDate = new JDateChooser();
        toModifiedDate.setDate((Calendar.getInstance()).getTime());
        toModifiedDate.setDateFormatString("dd/MM/yyyy");
        toModifiedDate.setBounds(370, 450, 120, 22);
        toModifiedDate.setVisible(false);

        modifiedOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String selectedBook = (String) modifiedOptions.getSelectedItem();
                if(selectedBook!=("")) {
                    createdOptions.setEnabled(false);
                    accessedOptions.setEnabled(false);
                    if (selectedBook.equals("Time Range")) {
                        fromModifiedLabel.setVisible(true);
                        fromModifiedDate.setVisible(true);
                        toModifedLabel.setVisible(true);
                        toModifiedDate.setVisible(true);
                    } else {
                        fromModifiedLabel.setVisible(false);
                        fromModifiedDate.setVisible(false);
                        toModifedLabel.setVisible(false);
                        toModifiedDate.setVisible(false);
                    }
                }else {
                    createdOptions.setEnabled(true);
                    accessedOptions.setEnabled(true);
                    fromModifiedLabel.setVisible(false);
                    fromModifiedDate.setVisible(false);
                    toModifedLabel.setVisible(false);
                    toModifiedDate.setVisible(false);
                }
            }
        });
    }

    //This method contains all the UI components for the  accessed Date section
    public void accessedDateSection(){
        accessedLabel=new JLabel("Accessed:");
        accessedLabel.setBounds(15,490,80,20);
        accessedOptions= new JComboBox(comboBoxTimeValues);
        accessedOptions.setBounds(80,490,110,20);

        fromAccessedLabel= new JLabel("From:");
        fromAccessedLabel.setBounds(200,490,80,20);
        fromAccessedLabel.setVisible(false);
        fromAccessedDate = new JDateChooser();
        fromAccessedDate.setDate((Calendar.getInstance()).getTime());
        fromAccessedDate.setDateFormatString("dd/MM/yyyy");
        fromAccessedDate.setBounds(230, 490, 120, 22);
        fromAccessedDate.setVisible(false);

        toAccessedLabel= new JLabel("To:");
        toAccessedLabel.setBounds(350,490,80,20);
        toAccessedLabel.setVisible(false);
        toAccessedDate = new JDateChooser();
        toAccessedDate.setDate((Calendar.getInstance()).getTime());
        toAccessedDate.setDateFormatString("dd/MM/yyyy");
        toAccessedDate.setBounds(370, 490, 120, 22);
        toAccessedDate.setVisible(false);


        accessedOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String selectedBook = (String) accessedOptions.getSelectedItem();
                if(selectedBook!=("")) {
                    createdOptions.setEnabled(false);
                    modifiedOptions.setEnabled(false);
                    if (selectedBook.equals("Time Range")) {
                        fromAccessedLabel.setVisible(true);
                        fromAccessedDate.setVisible(true);
                        toAccessedLabel.setVisible(true);
                        toAccessedDate.setVisible(true);
                    } else {
                        fromAccessedLabel.setVisible(false);
                        fromAccessedDate.setVisible(false);
                        toAccessedLabel.setVisible(false);
                        toAccessedDate.setVisible(false);
                    }
                }else {
                    createdOptions.setEnabled(true);
                    modifiedOptions.setEnabled(true);
                    fromAccessedLabel.setVisible(false);
                    fromAccessedDate.setVisible(false);
                    toAccessedLabel.setVisible(false);
                    toAccessedDate.setVisible(false);
                }
            }
        });
    }

    //Method to allows validate if the required field is empty
    public void validateRequiredField() {
        if (message!="") {
            JOptionPane.showMessageDialog(null,message);
        }
    }

    //this is used for save the criteria dialog
    public void saveCriteriaDialog(){
        nameCriteria=JOptionPane.showInputDialog(
                this,
                "Criteria Name:",
                "Save criteria",
                JOptionPane.PLAIN_MESSAGE);

    }

    public void loadCriteriaDialog(){
        JFrame frame = new JFrame("Load Criteria");
        frame.setLayout(null);

        frame.setSize(new Dimension(500,500));
        frame.setBackground(new Color(204, 229, 255));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        selectedCriteria=new JLabel();
        selectedCriteria.setBounds(10,10,460,70);
        Border border=BorderFactory.createEtchedBorder();
        selectedCriteria.setBorder(BorderFactory.createTitledBorder(border,"SELECT CRITERIA"));
        criteriaLabel=new JLabel("Criteria Selected:");
        criteriaLabel.setBounds(60,40,110,25);
       criteriaOptions= new JLabel();
        criteriaOptions.setBounds(120,40,150,27);
        updateIcon = new ImageIcon(
                this.getClass().getResource("/images/refresh.png"));
        loadButton=new JButton("Load",updateIcon);
        loadButton.setBounds(290,40,100,29);
        loadButton.setBorderPainted(true);
        detailsCriteria=new JLabel();
        detailsCriteria.setBounds(10,95,460,360);
        detailsCriteria.setBorder(BorderFactory.createTitledBorder(border,"DETAILS CRITERIAS"));

        tableC.setPreferredScrollableViewportSize(new Dimension(300, 70));
        tableC.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tableC);
        scrollPane.setBounds(18,118,445,330);
        frame.add(selectedCriteria);
        frame.add(criteriaLabel);
        frame.add(criteriaOptions);
        frame.add(loadButton);
        frame.add(detailsCriteria);
        frame.add(scrollPane);
    }

    public void initializeTable(){
        String[] columnNames= {"ID",
                "NAME",
                "CRITERIA",
                "TYPE",
        };

        Object[][] data = { };
        criteriaTable = new DefaultTableModel(data, columnNames);
        tableC = new JTable(criteriaTable);
    }

}
