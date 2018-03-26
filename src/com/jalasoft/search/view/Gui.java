package com.jalasoft.search.view;

import com.jalasoft.search.controller.SearchController;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame implements InterfazGui{


    private JTextField query;
    private  JTextField result;
    private JButton startSearch;
    private JPanel boton;
    private SearchController control;

    public Gui(){
        super("Search files");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20,50));


        query = new JTextField(30);
        JPanel panelaux = new JPanel();
        panelaux.add(query);
        mainPanel.add(panelaux, BorderLayout.NORTH);


        result = new JTextField(30);
        JPanel panelaux2 = new JPanel();
        panelaux2.add(result);
        mainPanel.add(panelaux2, BorderLayout.CENTER);

        startSearch = new JButton("Search");
        JPanel boton = new JPanel();
        boton.add(startSearch);
        mainPanel.add(boton, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);

    }

    public void display(){
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void displayValidationResult(String res) {
        result.setText(res);
    }

    public  String getFileName(){
        return query.getText();
    }

    public  String getFilePath(){
        return query.getText();
    }

    public String getOowner(){
        return  query.getText();
    }

    public String getIsHidden() {
        return "yes";
    }

    public String  getIsReadOnly() {
        return "yes";
    }

    public void setControler(SearchController controler){
        this.control = controler;
        startSearch.addActionListener(this.control);
    }

}