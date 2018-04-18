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

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 *
 This class represent the panel that will contains the results and search criteria options for the File
 *
 * @version
1.0 25 Mar 2018  * @author
Monica Pardo */

public class SearchDirectoryPanelCriteria extends JPanel {
    private JLabel title;
    private JLabel nameLabel;
    private JLabel ownerLabel;
    private JLabel attributesLabel;
    private JLabel readOnlyLabel;
    private JLabel pathLabel;
    private JLabel hiddenLabel;
    private JLabel directoryTimeLabel;
    private JLabel createdLabel;
    private JLabel modifiedLabel;
    private JLabel accessedLabel;
    private JLabel fromCreatedLabel;
    private JLabel toCreatedLabel;
    private JLabel fromModifiedLabel;
    private JLabel toModifedLabel;
    private JLabel fromAccessedLabel;
    private JLabel toAccessedLabel;
    private JLabel sizeDirLabel;
    private JLabel defaultDirSize;
    private JLabel criteriaDirLabel;
    private JLabel criteriaDirOptions;
    private JLabel detailsDirCriteria;
    private JLabel selectedDirCriteria;
    private JTextField  nameDirField;
    private JTextField ownerDirField;
    private JTextField pathDirValue;
    private JTextField sizeDirValue;
    private JFileChooser chooser;
    private JButton browseButton;
    private JButton saveDirButton;
    private JButton searchDirButton;
    private JButton closeDirButton;
    private JButton loadDirButton;
    private JButton loadDirCriteriaButton;
    private JSeparator separator;
    private JComboBox readOnlyDirOptions;
    private JComboBox hiddenDirOptions;
    private JComboBox createdDirOptions;
    private JComboBox modifiedDirOptions;
    private JComboBox accessedDirOptions;
    private JComboBox sizeDirOptions;
    private Font negritaFont;
    private JDateChooser fromCreatedDirDate;
    private JDateChooser toCreatedDirDate;
    private JDateChooser fromModifiedDirDate;
    private JDateChooser toModifiedDirDate;
    private JDateChooser fromAccessedDirDate;
    private JDateChooser toAccessedDirDate;
    private  String[] comboBoxTimeValues;
    private String message;
    private  ImageIcon saveIcon;
    private ImageIcon cancelIcon;
    private ImageIcon searchIcon;
    private ImageIcon browseIcon;
    private ImageIcon loadIcon;
    private ImageIcon updateIcon;
    private String nameDirCriteria;
    private String criteriaDirID;
    private DefaultTableModel criteriaDirTable;
    private JTable tableCDir;

    public SearchDirectoryPanelCriteria() {
         setLayout(null);
        comboBoxTimeValues = new String[] { "","All Time", "Time Range","Today","Yesterday" };
        generalSearchCriteria();
        searchAttributesSection();
        searchDirTimeSection();
        searchPanelButtons();
        initializeDirTable();
    }

    //Get method for the fields that the user will insert data
    public String getDirPathValue() {
        return pathDirValue.getText();
    }

    //Get method for the fields that the user will insert data
    public String getNameDirField() {
        return nameDirField.getText();
    }

    //Get method to get the file owner value from UI
    public String getOwnerDirField() {
        return ownerDirField.getText();
    }

    //Get method to get the read only value from UI
    public String getReadOnlyDirOptions() {
        return (String)readOnlyDirOptions.getSelectedItem();
    }

    //Get method to get the hidden value from UI
    public String getHiddenDirOptions() {
        return (String)hiddenDirOptions.getSelectedItem();
    }

    //Get method to get the created option value from UI
    public String getCreatedDirOptions() {
        return (String)createdDirOptions.getSelectedItem();
    }

    //Get method to get the modified dir value from UI
    public String getModifiedDirOptions() {
        return (String)modifiedDirOptions.getSelectedItem();
    }

    //Get method to get the accessed dir value from UI
    public String getAccessedDirOptions() {
        return (String)accessedDirOptions.getSelectedItem();
    }

    //Get method to get the range for Created date value from UI
    public Date getFromCreatedDirDate() {
        return fromCreatedDirDate.getDate();
    }

    //Get method to get the range for Created date value from UI
    public Date getToCreatedDirDate() {
        return toCreatedDirDate.getDate();
    }

    //Get method to get the range for Modified date value from UI
    public Date getFromModifiedDirDate() {
        return fromModifiedDirDate.getDate();
    }
    public Date getToModifiedDirDate() {
        return toModifiedDirDate.getDate();
    }

    //Get method to get the range for Accessed date value from UI
    public Date getFromAccessedDirDate() {
        return fromAccessedDirDate.getDate();
    }
    public Date getToAccessedDirDate() {
        return toAccessedDirDate.getDate();
    }


    //method to allows get the size dir option value
    public String getSizeDirOptions() {
        return (String)sizeDirOptions.getSelectedItem();
    }

    //method to allows get the size  value
    public String getSizeDirValue() {
        return (String)sizeDirValue.getText();
    }

    public JButton getSearchDirButton() {
        return searchDirButton;
    }

    //get method for the save criteria button
    public JButton getDirSaveButton() {
        return saveDirButton;
    }

    //set method for the save criteria button
    public void setDirSaveButton(JButton saveButton) {
        this.saveDirButton = saveButton;
    }

    //get method for the load criteria button
    public JButton getDirLoadButton() {
        return loadDirButton;
    }

    //set method for the load criteria button
    public void setDirLoadButton(JButton loadButton) {
        this.loadDirButton = loadButton;
    }

    //method to allows set the message value
    public void setMessage(String message) {
        this.message = message;
    }

    //method that allows to get the criteria Name
    public String getDirNameCriteria() {
        return nameDirCriteria;
    }

    //method that allows to get the load criteria button
    public JButton getDirLoadCriteriaButton() {
        return loadDirCriteriaButton;
    }

    //Set method  for the "Load Criteria" button that is located in the File search criteria panel
    public void setDirLoadCriteriaButton(JButton loadCriteriaButton) {
        this.loadDirCriteriaButton = loadCriteriaButton;
    }

      //get method for the criteria table located in the Load dialog
    public DefaultTableModel getdirCriteriaTable() {
        return criteriaDirTable;
    }

    //set method for the criteria table located in the Load dialog
    public void setCriteriaDirTable(DefaultTableModel criteriaTable) {
        this.criteriaDirTable = criteriaTable;
    }

    //get method for the table criteria
    public JTable getTableCDir() {
        return tableCDir;
    }

    //method to get the criteria ID from the table
    public String getCriteriaDirID() {
        return criteriaDirID;
    }


    //This method allows to select a directory
    public void browseDirectoryAction(){
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("c:"));
                chooser.setDialogTitle("Browse the folder to search");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String directoryPath=chooser.getSelectedFile().getPath();
                    pathDirValue.setText(directoryPath);
                }
            }
        });
    }

    //this method will contains the general components for the UI
    public void generalSearchCriteria(){
        title = new JLabel("SEARCH OPTIONS");
        negritaFont=new Font("ITALIC", Font.BOLD, 13);
        title.setFont(negritaFont);
        title.setBounds(0, 7, 200, 40);
        pathLabel = new JLabel(" Search Path:");
        pathLabel.setBounds(45, 50, 80, 20);
        pathDirValue = new JTextField();
        pathDirValue.setBounds(130, 50, 200, 25);
        pathDirValue.setBackground(new Color(255,255,204));
        browseIcon = new ImageIcon(
                this.getClass().getResource("/images/folder.png"));
        browseButton = new JButton("Browse",browseIcon);
        browseButton.setBounds(340,50,105,25);

        nameLabel = new JLabel("Directory Name:");
        nameLabel.setBounds(30, 90, 100, 20);
        nameDirField = new JTextField();
        nameDirField.setBounds(130, 90, 200, 25);
        nameDirField.setBackground(new Color(255,255,204));
        ownerLabel = new JLabel("Directory Owner:");
        ownerLabel.setBounds(30, 130, 100, 20);
        ownerDirField = new JTextField();
        ownerDirField.setBounds(130, 130, 100, 25);
        ownerDirField.setBackground(new Color(255,255,204));
        sizeDirLabel = new JLabel("Directory Size:");
        sizeDirLabel.setBounds(40, 170, 100, 20);
        String[] comboBoxSizesValues = { "","=", ">","<" };
        sizeDirOptions = new JComboBox(comboBoxSizesValues);
        sizeDirOptions.setBounds(130, 170, 40, 25);
        sizeDirValue=new JTextField();
        sizeDirValue.setBounds(175, 170, 80, 25);
        sizeDirValue.setBackground(new Color(224,224,224));
        sizeDirValue.setEnabled(false);
        defaultDirSize=new JLabel("Kb");
        defaultDirSize.setBounds(260, 170, 20, 25);
        sizeDirOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String option = (String) sizeDirOptions.getSelectedItem();
                if (option.equals("")) {
                    sizeDirValue.setEnabled(false);
                    sizeDirValue.setText("");
                    sizeDirValue.setBackground(new Color(224,224,224));
                }
                else
                {
                    sizeDirValue.setBackground(new Color(255,255,204));
                    sizeDirValue.setEnabled(true);
                }
            }
        });

        separator=new JSeparator();
        separator.setBounds(0, 240, 500, 20);

        add(title);
        add(pathLabel);
        add(pathDirValue);
        add(browseButton);
        add(nameLabel);
        add(nameDirField);
        add(ownerLabel);
        add(ownerDirField);
        add(sizeDirLabel);
        add(sizeDirOptions);
        add(sizeDirValue);
        add(defaultDirSize);
        add(separator);
        browseDirectoryAction();
    }

    //This method contains the components for the Attribute section in UI
    public void searchAttributesSection(){
        String[] comboBoxValues = { "False", "True" };
        attributesLabel=new JLabel("ATTRIBUTES");
        negritaFont=new Font("ITALIC", Font.BOLD, 13);
        attributesLabel.setFont(negritaFont);
        attributesLabel.setBounds(0,260,100,20);
        readOnlyLabel=new JLabel("Read Only:");
        readOnlyLabel.setBounds(30,290,80,20);
        readOnlyDirOptions= new JComboBox(comboBoxValues);
        readOnlyDirOptions.setBounds(120,290,100,20);

        hiddenLabel=new JLabel("Hidden:");
        hiddenLabel.setBounds(30,320,80,20);
        hiddenDirOptions= new JComboBox(comboBoxValues);
        hiddenDirOptions.setBounds(120,320,100,20);

        separator=new JSeparator();
        separator.setBounds(0, 360, 500, 20);

        add(attributesLabel);
        add(readOnlyLabel);
        add(readOnlyDirOptions);
        add(hiddenLabel);
        add(hiddenDirOptions);
        add(separator);
    }

    //This method contains the components for the Directory Time section in UI
    public void searchDirTimeSection(){

        directoryTimeLabel=new JLabel("DIRECTORY TIME");
        negritaFont=new Font("ITALIC", Font.BOLD, 13);
        directoryTimeLabel.setBounds(0,380,120,20);
        directoryTimeLabel.setFont(negritaFont);
        createdDateSection();
        modifiedDateSection();
        accessedDateSection();

        separator=new JSeparator();
        separator.setBounds(0, 540, 500, 20);

        add(directoryTimeLabel);
        add(createdLabel);
        add(createdDirOptions);
        add(fromCreatedLabel);
        add(fromCreatedDirDate);
        add(toCreatedLabel);
        add(toCreatedDirDate);
        add(modifiedLabel);
        add(modifiedDirOptions);
        add(fromModifiedLabel);
        add(fromModifiedDirDate);
        add(toModifedLabel);
        add(toModifiedDirDate);
        add(accessedLabel);
        add(accessedDirOptions);
        add(fromAccessedLabel);
        add(fromAccessedDirDate);
        add(toAccessedLabel);
        add(toAccessedDirDate);
        add(separator);
    }

    //This method allows to create the buttons
    public void searchPanelButtons(){
        loadIcon = new ImageIcon(
                this.getClass().getResource("/images/load.png"));
        loadDirCriteriaButton=new JButton("Load Criteria",loadIcon);
        loadDirCriteriaButton.setBounds(25,600,121,27);
        saveIcon = new ImageIcon(
                this.getClass().getResource("/images/save.png"));
        saveDirButton=new JButton("Save Criteria",saveIcon);
        saveDirButton.setBounds(150,600,119,27);
        searchIcon = new ImageIcon(
                this.getClass().getResource("/images/edit_find.png"));
        searchDirButton=new JButton("Search",searchIcon);
        searchDirButton.setBounds(275,600,100,27);
        cancelIcon = new ImageIcon(
                this.getClass().getResource("/images/close.png"));
        closeDirButton=new JButton("Close",cancelIcon);
        closeDirButton.setBounds(380,600,90,27);
        add(loadDirCriteriaButton);
        add(saveDirButton);
        add(searchDirButton);
        add(closeDirButton);
        closeDirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
    }

    //This method contains all the UI compoments for the createdDate section
    public void createdDateSection(){
        createdLabel=new JLabel("Created:");
        createdLabel.setBounds(15,410,80,20);
        createdDirOptions= new JComboBox(comboBoxTimeValues);
        createdDirOptions.setBounds(80,410,110,20);

        fromCreatedLabel= new JLabel("From:");
        fromCreatedLabel.setBounds(200,410,80,20);
        fromCreatedLabel.setVisible(false);
        fromCreatedDirDate = new JDateChooser();
        fromCreatedDirDate.setDate((Calendar.getInstance()).getTime());
        fromCreatedDirDate.setDateFormatString("dd/MM/yyyy");
        fromCreatedDirDate.setBounds(230, 410, 120, 22);
        fromCreatedDirDate.setVisible(false);

        toCreatedLabel= new JLabel("To:");
        toCreatedLabel.setBounds(350,410,80,20);
        toCreatedLabel.setVisible(false);
        toCreatedDirDate = new JDateChooser();
        toCreatedDirDate.setDate((Calendar.getInstance()).getTime());
        toCreatedDirDate.setDateFormatString("dd/MM/yyyy");
        toCreatedDirDate.setBounds(370, 410, 120, 22);
        toCreatedDirDate.setVisible(false);

        createdDirOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String selectedBook = (String) createdDirOptions.getSelectedItem();
                if(selectedBook!=("")) {
                    modifiedDirOptions.setEnabled(false);
                    accessedDirOptions.setEnabled(false);

                    if (selectedBook.equals("Time Range")) {
                        fromCreatedLabel.setVisible(true);
                        fromCreatedDirDate.setVisible(true);
                        toCreatedLabel.setVisible(true);
                        toCreatedDirDate.setVisible(true);
                    } else {
                        fromCreatedLabel.setVisible(false);
                        fromCreatedDirDate.setVisible(false);
                        toCreatedLabel.setVisible(false);
                        toCreatedDirDate.setVisible(false);
                    }
                }
                else{
                        modifiedDirOptions.setEnabled(true);
                        accessedDirOptions.setEnabled(true);
                        fromCreatedLabel.setVisible(false);
                        fromCreatedDirDate.setVisible(false);
                        toCreatedLabel.setVisible(false);
                        toCreatedDirDate.setVisible(false);
                    }
            }
        });
    }

    //This method contains all the UI components for the  modified Date section
    public void modifiedDateSection(){
        modifiedLabel=new JLabel("Modified:");
        modifiedLabel.setBounds(15,450,80,20);
        modifiedDirOptions= new JComboBox(comboBoxTimeValues);
        modifiedDirOptions.setBounds(80,450,110,20);

        fromModifiedLabel= new JLabel("From:");
        fromModifiedLabel.setBounds(200,450,80,20);
        fromModifiedLabel.setVisible(false);
        fromModifiedDirDate = new JDateChooser();
        fromModifiedDirDate.setDate((Calendar.getInstance()).getTime());
        fromModifiedDirDate.setDateFormatString("dd/MM/yyyy");
        fromModifiedDirDate.setBounds(230, 450, 120, 22);
        fromModifiedDirDate.setVisible(false);

        toModifedLabel= new JLabel("To:");
        toModifedLabel.setBounds(350,450,80,20);
        toModifedLabel.setVisible(false);
        toModifiedDirDate = new JDateChooser();
        toModifiedDirDate.setDate((Calendar.getInstance()).getTime());
        toModifiedDirDate.setDateFormatString("dd/MM/yyyy");
        toModifiedDirDate.setBounds(370, 450, 120, 22);
        toModifiedDirDate.setVisible(false);

        modifiedDirOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String selectedBook = (String) modifiedDirOptions.getSelectedItem();
                if(selectedBook!=("")) {
                    createdDirOptions.setEnabled(false);
                    accessedDirOptions.setEnabled(false);
                if (selectedBook.equals("Time Range")) {
                    fromModifiedLabel.setVisible(true);
                    fromModifiedDirDate.setVisible(true);
                    toModifedLabel.setVisible(true);
                    toModifiedDirDate.setVisible(true);
                }
                else
                {
                    fromModifiedLabel.setVisible(false);
                    fromModifiedDirDate.setVisible(false);
                    toModifedLabel.setVisible(false);
                    toModifiedDirDate.setVisible(false);
                }
                }
                else{
                    createdDirOptions.setEnabled(true);
                    accessedDirOptions.setEnabled(true);
                    fromModifiedLabel.setVisible(false);
                    fromModifiedDirDate.setVisible(false);
                    toModifedLabel.setVisible(false);
                    toModifiedDirDate.setVisible(false);
                }
            }
        });
    }

    //This method contains all the UI components for the  accessed Date section
    public void accessedDateSection(){
        accessedLabel=new JLabel("Accessed:");
        accessedLabel.setBounds(15,490,80,20);
        accessedDirOptions= new JComboBox(comboBoxTimeValues);
        accessedDirOptions.setBounds(80,490,110,20);

        fromAccessedLabel= new JLabel("From:");
        fromAccessedLabel.setBounds(200,490,80,20);
        fromAccessedLabel.setVisible(false);
        fromAccessedDirDate = new JDateChooser();
        fromAccessedDirDate.setDate((Calendar.getInstance()).getTime());
        fromAccessedDirDate.setDateFormatString("dd/MM/yyyy");
        fromAccessedDirDate.setBounds(230, 490, 120, 22);
        fromAccessedDirDate.setVisible(false);

        toAccessedLabel= new JLabel("To:");
        toAccessedLabel.setBounds(350,490,80,20);
        toAccessedLabel.setVisible(false);
        toAccessedDirDate = new JDateChooser();
        toAccessedDirDate.setDate((Calendar.getInstance()).getTime());
        toAccessedDirDate.setDateFormatString("dd/MM/yyyy");
        toAccessedDirDate.setBounds(370, 490, 120, 22);
        toAccessedDirDate.setVisible(false);


        accessedDirOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String selectedBook = (String) accessedDirOptions.getSelectedItem();
                if(selectedBook!=("")) {
                    createdDirOptions.setEnabled(false);
                    modifiedDirOptions.setEnabled(false);
                if (selectedBook.equals("Time Range")) {
                    fromAccessedLabel.setVisible(true);
                    fromAccessedDirDate.setVisible(true);
                    toAccessedLabel.setVisible(true);
                    toAccessedDirDate.setVisible(true);
                }
                else
                {
                    fromAccessedLabel.setVisible(false);
                    fromAccessedDirDate.setVisible(false);
                    toAccessedLabel.setVisible(false);
                    toAccessedDirDate.setVisible(false);
                }
                }
                else{
                    createdDirOptions.setEnabled(true);
                    modifiedDirOptions.setEnabled(true);
                    fromAccessedLabel.setVisible(false);
                    fromAccessedDirDate.setVisible(false);
                    toAccessedLabel.setVisible(false);
                    toAccessedDirDate.setVisible(false);
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
    public void saveDirCriteriaDialog(){
        nameDirCriteria=JOptionPane.showInputDialog(
                this,
                "Criteria Name:",
                "Save criteria",
                JOptionPane.PLAIN_MESSAGE);

    }

    //This method is used for open the Load criteria dialog that contains all the criterias in a table
    public void loadDirCriteriaDialog(){
        JFrame frame = new JFrame("Load Criteria");
        frame.setLayout(null);

        frame.setSize(new Dimension(500,500));
        frame.setBackground(new Color(204, 229, 255));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        selectedDirCriteria=new JLabel();
        selectedDirCriteria.setBounds(10,10,460,70);
        Border border=BorderFactory.createEtchedBorder();
        selectedDirCriteria.setBorder(BorderFactory.createTitledBorder(border,"SELECT CRITERIA"));
        criteriaDirLabel=new JLabel("Criteria Selected:");
        criteriaDirLabel.setBounds(40,40,110,25);
        criteriaDirOptions= new JLabel("No Selected value");
        criteriaDirOptions.setBounds(140,40,150,25);

        criteriaDirOptions.setForeground(Color.BLUE);
        updateIcon = new ImageIcon(
                this.getClass().getResource("/images/refresh.png"));
        loadDirButton=new JButton("Load",updateIcon);
        loadDirButton.setBounds(310,40,100,29);
        loadDirButton.setBorderPainted(true);
        detailsDirCriteria=new JLabel();
        detailsDirCriteria.setBounds(10,95,460,360);
        detailsDirCriteria.setBorder(BorderFactory.createTitledBorder(border,"DETAILS CRITERIAS"));

        tableCDir.setPreferredScrollableViewportSize(new Dimension(300, 70));
        tableCDir.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tableCDir);
        scrollPane.setBounds(18,118,445,330);

        tableCDir.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                criteriaDirID=tableCDir.getValueAt(tableCDir.getSelectedRow(), 0).toString();
                nameDirCriteria=tableCDir.getValueAt(tableCDir.getSelectedRow(), 1).toString();

                criteriaDirOptions.setText(nameDirCriteria);

            }
        });

        frame.add(selectedDirCriteria);
        frame.add(criteriaDirLabel);
        frame.add(criteriaDirOptions);
        frame.add(loadDirButton);
        frame.add(detailsDirCriteria);
        frame.add(scrollPane);
    }

    //This method initialze the criteria table located in the load dialog
    public void initializeDirTable(){
        String[] columnNames= {"ID",
                "NAME",
                "TYPE",
        };

        Object[][] data = { };
        criteriaDirTable = new DefaultTableModel(data, columnNames);
        tableCDir = new JTable(criteriaDirTable);
    }
}
