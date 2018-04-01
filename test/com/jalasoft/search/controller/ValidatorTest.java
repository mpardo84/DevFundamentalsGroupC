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


/**
 *
 ValidatorTest class provides positive and negative test for each validation method og Validator class.
 *
 * @version
23 Mar 2018
 *
 *  @author
Gretta Rocha
 */
public class ValidatorTest {

    //Test to validate that special char  * is not valid for file name
    @Test
    public void specialCharAsteriskIsNotValidForFileName(){
        Validator validator = new Validator();
        String invalidName = "hola*yt";
        assertFalse(validator.isValidFileName(invalidName));
    }

    //Test to validate that reserved word "aux" is not valid for file name
     @Test
    public  void reservedWordAUXisNotValidForFileName(){
        String invalidName = "aux";
        Validator validator = new Validator();
        assertFalse(validator.isValidFileName(invalidName));
    }
 }
