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
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
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
    private JPanel buttonsPanel;
    private JSeparator separator;
    private JLabel attributesLabel;
    private JLabel readOnlyLabel;
    private JComboBox readOnlyOptions;

    public SearchPanelCriteria() {
        super();
        setLayout(null);
        generalSearchCriteria();
        searchAttributes();

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

    //This method allows to create the panel buttons
    public JComponent searchPanelButtons(){
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        saveButton=new JButton("Save");
        searchButton=new JButton("Search");
        cancelButton=new JButton("Cancel");
        setLayout(new GridBagLayout());

        buttonsPanel.add(saveButton);
        buttonsPanel.add(searchButton);
        buttonsPanel.add(cancelButton);
        return buttonsPanel;
    }

    //this method will contains the general components for the UI
    public void generalSearchCriteria(){
        title = new JLabel("Search Options");
        title.setBounds(0, 7, 200, 40);
        pathLabel = new JLabel(" Search Path:");
        pathLabel.setBounds(30, 50, 80, 20);
        pathValue = new JTextField();
        pathValue.setBounds(120, 50, 350, 25);
        browseButton = new JButton("browse");
        browseButton.setBounds(480,50,80,25);

        nameLabel = new JLabel("File Name:");
        nameLabel.setBounds(30, 85, 80, 20);
        nameField = new JTextField();
        nameField.setBounds(120, 85, 350, 25);

        typeLabel =new JLabel("File Type:");
        typeLabel.setBounds(30, 120, 80, 20);
        typeField = new JTextField();
        typeField.setBounds(120, 120, 100, 25);

        containsLabel = new JLabel("File Contains:");
        containsLabel.setBounds(30, 155, 80, 20);
        containsField = new JTextField();
        containsField.setBounds(120, 155, 300, 25);

        ownerLabel = new JLabel("File Owner:");
        ownerLabel.setBounds(30, 190, 80, 20);
        ownerField = new JTextField();
        ownerField.setBounds(120, 190, 150, 25);

        separator=new JSeparator();
        separator.setBounds(0, 240, 700, 20);

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
    //This method contains the compoments for the Attribute section in UI
    public void searchAttributes(){
        String[] comboBoxValues = { "Yes", "No" };
        attributesLabel=new JLabel("Attributes");
        attributesLabel.setBounds(0,260,80,20);
        readOnlyLabel=new JLabel("Read Only:");
        readOnlyLabel.setBounds(30,290,80,20);
        readOnlyOptions= new JComboBox(comboBoxValues);
        readOnlyOptions.setBounds(120,290,100,20);

        add(attributesLabel);
        add(readOnlyLabel);
        add(readOnlyOptions);
    }

}

