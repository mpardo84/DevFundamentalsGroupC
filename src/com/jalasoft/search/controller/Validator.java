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

import com.jalasoft.search.commond.Functions;
import com.jalasoft.search.commond.LoggerWrapper;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    // Get loggerWrapper instance
    LoggerWrapper logger = LoggerWrapper.getInstance();
    Functions functions = new Functions();

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
        logger.log.info( "Validating file name .....");
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
        logger.log.info( "Validating path name ......");
         try {
               Path path1 = Paths.get(path);
         }
         catch (InvalidPathException | NullPointerException ex) {
             logger.log.severe( functions.getStackTrace(ex));
               return false;
         }
         return true;
        }

    /**
    *
    * areRequiredFieldsFilled method checks if requiered data were filled by the user in UI.
    *
    */
   public boolean areRequiredFieldsFilled( String pathName){
       logger.log.info( "Validating required fields .....");
       if ( pathName.isEmpty()){
           return false;
       }
       else return true;
   }

    /**
     *
     * validSizeValue method checks value entered for size is a valid format, it can be integer or decimal value
     *
     */
   public boolean isValidateSizeValue(String size){
       logger.log.info( "Validating size value .....");
       if (size.isEmpty() == false){
           try {
               Double doubleSize = Double.parseDouble(size);
           }
           catch (NullPointerException npe) {
               logger.log.info( functions.getStackTrace(npe));
               return false;
           }
           catch (NumberFormatException nfe){
               logger.log.severe( functions.getStackTrace(nfe));
                return false;}
           return true;
       }
       return true;
   }

    /**
     *
     * isValidExtension method checks if value entered in extenssion field is valid
     *
     */
    public boolean isValidExtension( String extension) {
        logger.log.info("Validating extension value .....");
        if (extension.isEmpty() == false) {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher((extension));
            boolean isValid = matcher.matches();
            return isValid;
        }
        return true;
    }
}
