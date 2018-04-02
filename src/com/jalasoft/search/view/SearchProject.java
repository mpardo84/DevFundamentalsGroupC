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
        tabbedPane.addTab("File",fileIcon,filePanel);
        tabbedPane.addTab("Directory",directoryIcon,directoryPanel);
        tabbedPane.addTab("Multimedia",multimediaIcon,multimediaPanel);
        // add the tab panel to the frame
        this.add(tabbedPane);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        w = gd.getDisplayMode().getWidth();
        h = gd.getDisplayMode().getHeight();

        this.setBounds(0, 0,w,h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(w, h);
        this.setTitle(title);
        this.setVisible(true);
        this.setResizable(false);
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

    public DefaultTableModel getTable() {
        return filePanel.getTable();
    }
}

