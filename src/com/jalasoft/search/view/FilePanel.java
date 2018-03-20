package com.jalasoft.search.view;

import javax.swing.*;
import java.awt.*;


public class FilePanel extends JPanel{
    private JPanel searchPanelCriteria;
    private JPanel searchPanelResults;

    public FilePanel(){
        super();
        setBackground(Color.white);
        this.setLayout(new GridLayout(1,2));
        searchPanelCriteria=new SearchPanelCriteria();
        searchPanelResults=new SearchPanelResults();
        this.add(searchPanelCriteria);
        this.add(searchPanelResults);

    }



}
