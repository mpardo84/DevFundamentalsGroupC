package com.jalasoft.search.model;

import com.jalasoft.search.controller.Validator;

public class SearchProcess {

    public String search(String string){

        Validator validator = new Validator();

        //if (validator.isValidFileName(string)== true) {
        if (validator.isValidPath(string)) {
            return ("valid data");
         }
         else {
            return "inValid data";
        }
}
}
