package com.jalasoft.search.commond;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerWrapper {

    public static final Logger log = Logger.getLogger("");

    private static LoggerWrapper instance = null;

    public static LoggerWrapper getInstance() {
        if(instance == null) {
            //prepareLogger();
            instance = new LoggerWrapper ();
        }
        return instance;
    }

    private static void  prepareLogger() {
        try{
            FileHandler myFileHandler = new FileHandler("./logger.txt");
            myFileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(myFileHandler);
            log.setUseParentHandlers(false);
            log.setLevel(Level.FINEST);
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
}