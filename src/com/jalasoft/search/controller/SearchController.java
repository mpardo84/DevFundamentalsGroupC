package com.jalasoft.search.controller;

import com.jalasoft.search.model.SearchCriterial;
import com.jalasoft.search.view.InterfazGui;
import com.jalasoft.search.model.SearchProcess;

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
    private InterfazGui vista;
    private  SearchProcess modelo;

    /**
    *
    * Init method where link with View and Model is created
    *
    */
    public SearchController(InterfazGui vista, SearchProcess modelo){
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
        if (validator.areRequiredFieldsFilled(vista.getFileName())){
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
     * getDataFromViewAndSentToModel method that listen action in UI from user and according to action send operation commands to model
     *
     */
     public void configureSearchCriterial(){
         SearchCriterial searchCriterial = new SearchCriterial();
         searchCriterial.setFileName(vista.getFileName());
         searchCriterial.setFilePath(vista.getFilePath());
         searchCriterial.setOwner(vista.getOowner());
         if (vista.getIsHidden() =="yes"){
             searchCriterial.setIsHidden(true);
         }
         else{
             searchCriterial.setIsHidden(false);
         }
         if (vista.getIsReadOnly() =="yes"){
             searchCriterial.setIsReadOnly(true);
         }
         else{
             searchCriterial.setIsReadOnly(false);
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
            //vista.displayValidationResult(modelo.search(string));
            vista.displayValidationResult("Data were sent to model");
        } else {
            vista.displayValidationResult(validateResult);
        }
    }
}