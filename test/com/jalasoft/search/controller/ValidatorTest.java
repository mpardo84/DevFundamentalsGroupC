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

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 *
 ValidatorTest class provides positive and negative test for each validation method of Validator class.
 *
 * @version
23 Mar 2018
 *
 *  @author
Gretta Rocha
 *
 */
public class ValidatorTest {

    /*
     *
     * Test to validate File Name
     *
     */

    //Test to validate that alphanumeric chars are valid for file name
    @Test
    public void alphanumericCharsAreValidForFileName(){
        Validator validator = new Validator();
        String validName = "projecto de grado 55-25-45";
        assertTrue(validator.isValidFileName(validName));
    }

    //Test to validate that special char  * is not valid for file name
    @Test
    public void specialCharAsteriskIsNotValidForFileName(){
        Validator validator = new Validator();
        String invalidName = "hola*yt";
        assertFalse(validator.isValidFileName(invalidName));
    }

    //Test to validate that special char ? is not valid for file name
    @Test
    public void specialCharQuestionMarkIsNotValidForFileName(){
        Validator validator = new Validator();
        String invalidName = "Paas?e";
        assertFalse(validator.isValidFileName(invalidName));
    }

    //Test to validate that reserved word "aux" is not valid for file name
     @Test
    public  void reservedWordAUXisNotValidForFileName(){
        String invalidName = "aux";
        Validator validator = new Validator();
        assertFalse(validator.isValidFileName(invalidName));
    }

    //Test to validate that reserved word "LPT1" is not valid for file name
    @Test
    public  void reservedWordLPT1isNotValidForFileName(){
        String invalidName = "lpt1";
        Validator validator = new Validator();
        assertFalse(validator.isValidFileName(invalidName));
    }

    /*
    *
    * Tests to validate Path Name
    *
    */

    //Test to validate that relative path is valid for pathname
    @Test
    public  void relativePhatIsValidForPathName(){
        String validName = "./";
        Validator validator = new Validator();
        assertTrue(validator.isValidPath(validName));
    }

    //Test to validate that absolute path is valid for pathname
    @Test
    public  void absolutePhatIsValidForPathName(){
        String validName = "c:\\tmp";
        Validator validator = new Validator();
        assertTrue(validator.isValidPath(validName));
    }

    //Test to validate that special char ":"  is not valid for path name
    @Test
    public  void specialCharTwoPointIsNotValidForPathName(){
        String invalidName = "s:/raiz:under";
        Validator validator = new Validator();
        assertFalse(validator.isValidPath(invalidName));
    }

    //Test to validate that special chars "/" and "\" at the same time are not valid for path name
    @Test
    public  void specialCharSlashAndBacksalashAreNotValidForPathName(){
        String invalidName = "http:\\\\host/path/file";
        Validator validator = new Validator();
        assertFalse(validator.isValidPath(invalidName));
    }

    /*
     *
     * Test to validate file size value
     *
     */

    //Test to validate that decimal number is valid  for size value
    @Test
    public  void decimalNumberIsValidForSizeValue(){
        String validSize = "3.5";
        Validator validator = new Validator();
        assertTrue(validator.isValidateSizeValue(validSize));
    }

    //Test to validate that integer number is valid  for size value
    @Test
    public  void integerNumberIsValidForSizeValue(){
        String validSize = "15";
        Validator validator = new Validator();
        assertTrue(validator.isValidateSizeValue(validSize));
    }

    //Test to validate that decimal number with comma is invalid  for size value
    @Test
    public  void decimalNumberWithCommaIsNotValidForSizeValue(){
        String invalidSize = "1,6";
        Validator validator = new Validator();
        assertFalse(validator.isValidateSizeValue(invalidSize));
    }

    //Test to validate that letters are not valid for size value
    @Test
    public  void lettersAreNotValidForSizeValue(){
        String invalidSize = "4hu.2";
        Validator validator = new Validator();
        assertFalse(validator.isValidateSizeValue(invalidSize));
    }

    //Test to validate that special chars are not valid for size value
    @Test
    public  void specialCharsAreNotValidForSizeValue(){
        String invalidSize = "2(5)";
        Validator validator = new Validator();
        assertFalse(validator.isValidateSizeValue(invalidSize));
    }
 }
