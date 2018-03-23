package com.jalasoft.search.controller;

import com.jalasoft.search.view.InterfazGui;
import com.jalasoft.search.model.SearchProcess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 The SearchController class that interacts with model  and view classes.
 *
 * @version
        23 Mar 2018
 *
 *  @author
        Gretta Rocha
 */

public class SearchController implements ActionListener {
    private InterfazGui vista;
    private  SearchProcess modelo;

    public SearchController(InterfazGui vista, SearchProcess modelo){
        this.vista = vista;
        this.modelo = modelo;
    }

    public void actionPerformed(ActionEvent event){
        String fileName= vista.getQuery();
        vista.displayResult(modelo.search(fileName));
    }
}