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

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 The Valitor class provides methods to validate the different properties of a file.
 *
 * @version
           23 Mar 2018
 *
 *  @author
           Gretta Rocha
 */

    public class Validator {

    /*
    *
    isValidFileName Method to validate if a name is valid for a file
    *
    Some words are reserved and can not be used as filenames.
    CON, PRN, AUX, CLOCK$, NUL
    COM0, COM1, COM2, COM3, COM4, COM5, COM6, COM7, COM8, COM9
    LPT0, LPT1, LPT2, LPT3, LPT4, LPT5, LPT6, LPT7, LPT8, and LPT9.
    *
    Also some symbols are not allowed in file names :  " * / : < > ? \ |
    */

    public boolean isValidFileName(String fileName){
        Pattern pattern = Pattern.compile("^(?!(COM[0-9]|LPT[0-9]|CON|PRN|AUX|CLOCK\\$|NUL)$)[^./\\:*?\"<>|]+$",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher((fileName));
        boolean isValid = matcher.matches();
        return isValid;
    }

    /**
    *
    * isValidPath method checks if a string is a valid path.
    *
    */
    public boolean isValidPath(String path) {

           try {
               Path path1 = Paths.get(path);
           }
           catch (InvalidPathException | NullPointerException ex) {

               return false;
           }
            return true;
        }

    /**
    *
    * areRequiredFieldsFilled method checks if requiered data were filled by the user in UI.
    *
    */
   public boolean areRequiredFieldsFilled( String filePath){
       if ( filePath.trim() == null){
           return false;
       }
       else return true;
   }
}
