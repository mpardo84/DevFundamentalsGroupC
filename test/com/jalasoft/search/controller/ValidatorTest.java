package com.jalasoft.search.controller;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    @Test
    public void specialCharAsteriskIsNotValidForFileName(){
        Validator validator = new Validator();
        String invalidName = "hola*yt";
        assertFalse(validator.isValidFileName(invalidName));
    }

    @Test
    public  void reservedWordAUXisNotValidForFileName(){
        String invalidName = "aux";
        Validator validator = new Validator();
        assertFalse(validator.isValidFileName(invalidName));
    }


}
