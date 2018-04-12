package com.jalasoft.search;

import java.util.logging.Logger;

public class LoggerManager {

    private static LoggerManager instance = null;
    private static Logger logger;


    private LoggerManager() {
        logger = Logger.getLogger(LoggerManager.class.getName());
    }

    public static LoggerManager getInstance(){
        if(instance==null){
            instance = new LoggerManager();
        }
        return instance;
    }

    public void addInfoLog(String className, String message){
        logger.info("|| Class: "+ className+ " || Message: "+ message);
    }

    public void addWarnLog(String className, String message, Throwable errorMessage){
        logger.info("|| Class: "+ className+ " || Message: "+ message);
        logger.info("|| Error: " + errorMessage);
    }

    public void addErrorLog(String className, String message, Throwable errorMessage){
        logger.info("|| Class: "+ className+ " || Message: "+ message);
        logger.info("|| Error: " + errorMessage);
    }

    public void addFatalLog(String className, String message, Throwable errorMessage){
        logger.info("|| Class: "+ className+ " || Message: "+ message);
        logger.info("|| Error: " + errorMessage);
    }

    public void addTraceLog(String className, String message, Throwable errorMessage){
        logger.info("|| Class: "+ className+ " || Message: "+ message);
        logger.info("|| Error: " + errorMessage);
    }

    public void addDebugLog(String className, String message, Throwable errorMessage){
        logger.info("|| Class: "+ className+ " || Message: "+ message);
        logger.info("|| Error: " + errorMessage);
    }
}
