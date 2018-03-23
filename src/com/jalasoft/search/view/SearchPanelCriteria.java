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

/**
 *
 This class contains the fields that are part of the search criteria for a File
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo */

public class SearchPanelCriteria extends JPanel {
    private JLabel title;
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel containsLabel;
    private JLabel ownerLabel;
    private JTextField  nameField;
    private JTextField typeField;
    private JTextField containsField;
    private JTextField ownerField;
    private JLabel pathLabel;
    private  JTextField pathValue;
    private JFileChooser chooser;
    private JButton browseButton;
    private JButton saveButton;
    private JButton searchButton;
    private JButton cancelButton;
    private JSeparator separator;
    private JLabel attributesLabel;
    private JLabel readOnlyLabel;
    private JComboBox readOnlyOptions;
    private JLabel hiddenLabel;
    private JComboBox hiddenOptions;
    private JLabel fileTimeLabel;
    private JLabel createdLabel;
    private JLabel modifiedLabel;
    private JLabel accessedLabel;
    private JComboBox createdOptions;
    private JComboBox modifiedOptions;
    private JComboBox accessedOptions;
    private Font negritaFont;

    public SearchPanelCriteria() {
        super();
        setLayout(null);
        generalSearchCriteria();
        searchAttributesSection();
        searchFileTimeSection();
        searchPanelButtons();
    }
    //This method allows to select a file
    public void browseFileAction(){
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Browse the folder to search");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
                } else {
                    System.out.println("No Selection ");
                }
            }
        });
    }

    //this method will contains the general components for the UI
    public void generalSearchCriteria(){
        title = new JLabel("SEARCH OPTIONS");
        title.setBounds(0, 7, 200, 40);
        pathLabel = new JLabel(" Search Path:");
        pathLabel.setBounds(30, 50, 80, 20);
        pathValue = new JTextField();
        pathValue.setBounds(120, 50, 200, 25);
        browseButton = new JButton("browse");
        browseButton.setBounds(340,50,80,20);

        nameLabel = new JLabel("File Name:");
        nameLabel.setBounds(30, 85, 80, 20);
        nameField = new JTextField();
        nameField.setBounds(120, 85, 200, 25);

        typeLabel =new JLabel("File Type:");
        typeLabel.setBounds(30, 120, 80, 20);
        typeField = new JTextField();
        typeField.setBounds(120, 120, 100, 25);

        containsLabel = new JLabel("File Contains:");
        containsLabel.setBounds(30, 155, 80, 20);
        containsField = new JTextField();
        containsField.setBounds(120, 155, 200, 25);

        ownerLabel = new JLabel("File Owner:");
        ownerLabel.setBounds(30, 190, 80, 20);
        ownerField = new JTextField();
        ownerField.setBounds(120, 190, 150, 25);

        separator=new JSeparator();
        separator.setBounds(0, 240, 500, 20);

        add(title);
        add(pathLabel);
        add(pathValue);
        add(browseButton);
        add(nameLabel);
        add(nameField);
        add(typeLabel);
        add(typeField);
        add(containsLabel);
        add(containsField);
        add(ownerLabel);
        add(ownerField);
        add(separator);
         browseFileAction();
    }

    //This method contains the components for the Attribute section in UI
    public void searchAttributesSection(){
        String[] comboBoxValues = { "Yes", "No" };
        attributesLabel=new JLabel("ATTRIBUTES");

        attributesLabel.setBounds(0,260,80,20);
        readOnlyLabel=new JLabel("Read Only:");
        readOnlyLabel.setBounds(30,290,80,20);
        readOnlyOptions= new JComboBox(comboBoxValues);
        readOnlyOptions.setBounds(120,290,100,20);

        hiddenLabel=new JLabel("Hidden:");
        hiddenLabel.setBounds(30,320,80,20);
        hiddenOptions= new JComboBox(comboBoxValues);
        hiddenOptions.setBounds(120,320,100,20);

        separator=new JSeparator();
        separator.setBounds(0, 360, 500, 20);

        add(attributesLabel);
        add(readOnlyLabel);
        add(readOnlyOptions);
        add(hiddenLabel);
        add(hiddenOptions);
        add(separator);
    }

    //This method contains the components for the File Time section in UI
    public void searchFileTimeSection(){
        String[] comboBoxTimeValues = { "AllTime", "Time Range","Today","Yesterday" };
        fileTimeLabel=new JLabel("FILE TIME");
        negritaFont=new Font("ITALIC", Font.BOLD, 13);
        fileTimeLabel.setBounds(0,380,80,20);
        fileTimeLabel.setFont(negritaFont);

        createdLabel=new JLabel("Created:");
        createdLabel.setBounds(30,410,80,20);
        createdOptions= new JComboBox(comboBoxTimeValues);
        createdOptions.setBounds(120,410,100,20);

        modifiedLabel=new JLabel("Modified:");
        modifiedLabel.setBounds(30,440,80,20);
        modifiedOptions= new JComboBox(comboBoxTimeValues);
        modifiedOptions.setBounds(120,440,100,20);

        accessedLabel=new JLabel("Accessed:");
        accessedLabel.setBounds(30,470,80,20);
        accessedOptions= new JComboBox(comboBoxTimeValues);
        accessedOptions.setBounds(120,470,100,20);

        separator=new JSeparator();
        separator.setBounds(0, 520, 500, 20);

        add(fileTimeLabel);
        add(createdLabel);
        add(createdOptions);
        add(modifiedLabel);
        add(modifiedOptions);
        add(accessedLabel);
        add(accessedOptions);
        add(separator);
    }

    //This method allows to create the buttons
    public void searchPanelButtons(){

        saveButton=new JButton("Save");
        saveButton.setBounds(110,800,80,20);
        searchButton=new JButton("Search");
        searchButton.setBounds(210,800,80,20);
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(310,800,80,20);
        add(saveButton);
        add(searchButton);
        add(cancelButton);
    }

}


