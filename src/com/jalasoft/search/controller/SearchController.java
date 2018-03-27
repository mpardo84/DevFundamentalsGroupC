/*
 *      26/03/18
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
package com.jalasoft.search.controller;

import com.jalasoft.search.model.Search;
import com.jalasoft.search.model.SearchCriterial;
import com.jalasoft.search.view.SearchProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 The SearchController class interacts with model and view classes.
 *
 * @version
        23 Mar 2018
 *
 *  @author
        Gretta Rocha
 */

public class SearchController implements ActionListener {
    private SearchProject vista;
    private Search modelo;

    /**
    *
    * Init method where link with View and Model is created
    *
    */
    public SearchController(SearchProject vista, Search modelo){
        this.vista = vista;
        this.modelo = modelo;
    }

    /**
    *
    * validateData method where all file data are validated in order to verify that they are valid
    *
    */
    public String validateData(){
        Validator validator = new Validator();
        if (validator.areRequiredFieldsFilled(vista.getFileName(), vista.getFilePath()) == true) {
            if (validator.isValidFileName(vista.getFileName()) == true) {
                if (validator.isValidPath(vista.getFilePath()) == true) {
                    return null;
                } else {
                    return "File path is invalid";
                }
            } else {
                return "File name is invalid";
            }
        }else { return "Required data should be filled";}
     }

    /*
     *
     * configureSearchCriterial method gets data view side and  set the same data in model side
     *
     */
     public void configureSearchCriterial(){
         SearchCriterial searchCriterial = new SearchCriterial();
         searchCriterial.setFileName(vista.getFileName());
         searchCriterial.setFilePath(vista.getFilePath());
         searchCriterial.setOwner(vista.getOwner());
         if (vista.getHidden().trim()=="yes"){
             searchCriterial.setHidden(true);
         }
         else {
             searchCriterial.setHidden(false);
         }
         if (vista.getReadOnly().trim()=="yes"){
             searchCriterial.setReadOnly(true);
         }
         else {
             searchCriterial.setReadOnly(false);
         }
     }

    /*
    *
    * actionPerformed method that listen action in UI from user and according to action send operation commands to model    *
    */
    public void actionPerformed(ActionEvent event) {
        String validateResult = validateData();
        if (validateResult == null) {
            configureSearchCriterial();
            // code to execute search in model side and get the results to be displayed in view side
        } else {
            vista.displayValidationResult(validateResult);
        }
    }
}
