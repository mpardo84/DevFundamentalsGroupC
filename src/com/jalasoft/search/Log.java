package com.jalasoft.search;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Log {
    public static final Logger searchLog = Logger.getLogger("Test");
    private static Log instance = null;

    public static Log getInstance() {
        if(instance == null) {
            prepareLog();
            instance = new Log ();
        }
        return instance;
    }

    private static void prepareLog() {
        try {
            FileHandler fileHandler = new FileHandler("./logFile.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            searchLog.addHandler(fileHandler);
            searchLog.setUseParentHandlers(false);
            searchLog.setLevel(Level.ALL);
        } catch (Exception e) {
            System.out.println("Error creating the log file");
        }
    }
}
