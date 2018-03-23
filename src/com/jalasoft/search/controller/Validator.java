package com.jalasoft.search.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 The Valitor class provides methos to validate the different properties of a file.
 *
 * @version
           23 Mar 2018
 *
 *  @author
           Gretta Rocha
 */

public class Validator {

    public boolean isValidFileName(String fileName){
        /*
        *
        Class to validate if a name is valid for a file
        *
        Some words are reserved and can not be used as filenames.
        CON, PRN, AUX, CLOCK$, NUL
        COM0, COM1, COM2, COM3, COM4, COM5, COM6, COM7, COM8, COM9
        LPT0, LPT1, LPT2, LPT3, LPT4, LPT5, LPT6, LPT7, LPT8, and LPT9.
        *
        Also some symbols are not allowed in file names :  " * / : < > ? \ |
        */
        Pattern pattern = Pattern.compile("^(?!(COM[0-9]|LPT[0-9]|CON|PRN|AUX|CLOCK\\$|NUL)$)[^./\\:*?\"<>|]+$",Pattern.CASE_INSENSITIVE);
        return !pattern.matcher(fileName).find();
    }

    public boolean isValidPath(String path){
        return  true;

    }

    public boolean isValidExtension(String extension){
        return true;
    }
}
