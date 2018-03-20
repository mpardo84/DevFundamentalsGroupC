package com.jalasoft.search.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanelCriteria extends JPanel {
    private Label pathLabel;
    private  TextField pathValue;
    private JFileChooser chooser;
    private JButton browseButton;
    private JButton saveButton;
    private JButton searchButton;
    private JButton cancelButton;
    private JPanel buttonsPanel;


    public SearchPanelCriteria() {
        super();

        this.setLayout(new GridLayout(4,1));
        this.add(SearchOptions());
        this.add(searchPanelButtons());

    }
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

    public JComponent SearchOptions(){
        JPanel options = new JPanel(new FlowLayout());
        pathLabel=new Label("Path:");
        pathValue=new TextField();
        browseButton = new JButton("browse");


        options.add(pathLabel);
        options.add(pathValue);
        options.add(browseButton);

        browseFileAction();
        return options;

    }


}
