package com.jalasoft.search.model;

import com.jalasoft.search.controller.Validator;

public class SearchProcess {

    public String search(String string){

        Validator validator = new Validator();

        //if (validator.isValidPath(string)) {
        if (validator.isValidFileName(string)) {
        return ("Invalid data");
    }
    else return "Valid data";
}
}
