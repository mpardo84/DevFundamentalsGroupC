package com.jalasoft.search.view;
import javax.swing.*;


public class SearchProject extends JFrame{

    private JPanel filePanel;
    private JPanel directoryPanel;
    private JPanel multimediaPanel;
    private JTabbedPane tabbedPane;


    public SearchProject(String title){
        super(title);
        //initialize variables for tab panel
        tabbedPane = new JTabbedPane();
        filePanel=new FilePanel();
        directoryPanel=new JPanel();
        multimediaPanel=new JPanel();

        //Add tabs to the tab panel
        tabbedPane.add("File",filePanel);
        tabbedPane.add("Directory",directoryPanel);
        tabbedPane.add("Multimedia",multimediaPanel);
        // add the tab panel to the frame
        this.add(tabbedPane);

    }


    public static void main(String[] args) {

        JFrame window= new SearchProject("Search Application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 1550);
        window.setVisible(true);

    }
}