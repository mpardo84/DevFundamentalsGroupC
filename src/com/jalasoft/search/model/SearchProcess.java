package com.jalasoft.search.model;

import com.jalasoft.search.controller.Validator;

public class SearchProcess {
    public String search(String fileName){

        Validator validator = new Validator();

        if (validator.isValidFileName(fileName)) {
        return ("Invalid name");
    }
    else return "Valid name";
}
}
