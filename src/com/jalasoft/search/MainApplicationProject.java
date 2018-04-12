/*
 * 21/03/18
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

package com.jalasoft.search;

import com.jalasoft.search.controller.SearchController;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.view.SearchProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 *
 This class is the Main class that will allows to execute the code
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo  */
public class MainApplicationProject {

    //  Prepare a log for each package
    private final static Logger logMain = Logger.getLogger("com.jalasoft.search");
    private final static Logger logView = Logger.getLogger("com.jalasoft.search.view");
    private final static Logger logController = Logger.getLogger("com.jalasoft.search.controller");
    private final static Logger logModel = Logger.getLogger("com.jalasoft.search.model");

    // Prepare a log for this class
    private final static Logger log = Logger.getLogger("com.jalasoft.search.MainApplicationProject");

    public static void main(String[] args) {

        try {
            // Prepare file where  log records are going to be saved
            FileHandler fileHandler = new FileHandler("./logger.log", false);

            // Prepare the format for the file text format is going to be used
            SimpleFormatter simpleFormatter = new SimpleFormatter();

            // Link the fyep format to log file
            fileHandler.setFormatter(simpleFormatter);

            // Associate  the handles to root log
            logMain.addHandler(fileHandler);

            // Configure the level for logging
            fileHandler.setLevel(Level.ALL);

            log.log(Level.INFO, "Starting search application");


            try {
                throw new Exception("ERROR DE CONTROL DE FLUJO DE PROGRAMA");
            } catch (Exception e) {

                // Mediante el metodo getStack obtenemos el stackTrace de la excepcion en forma de un objecto String
                // de modo que podamos almacenarlo en bitacora para su analisis posterior
                log.log(Level.SEVERE, MainApplicationProject.getStackTrace(e));
            }



            // Create instances for View, Model and Controller
            SearchProject vista = new SearchProject();
            Search modelo = new Search();
            SearchController control = new SearchController(vista, modelo);

        } catch (IOException ex) {
            // Mediante el metodo getStack obtenemos el stackTrace de la excepcion en forma de un objecto String
            // de modo que podamos almacenarlo en bitacora para su analisis posterior
            log.log(Level.SEVERE, MainApplicationProject.getStackTrace(ex));
        }
    }
    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}
