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

import com.jalasoft.search.commond.Functions;
import com.jalasoft.search.commond.LoggerWrapper;
import com.jalasoft.search.controller.SearchController;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.view.SearchProject;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 This class is the Main class that will allows to execute the code
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo  */
public class MainApplicationProject {

      public static void main(String[] args) {

        // Configure the properties for logger
        System.setProperty("java.util.logging.config.file","resource\\config\\log.properties");

        // Get instance of logger
        LoggerWrapper logger = LoggerWrapper.getInstance();
        logger.log.info( "Starting search application....." );

        // Create instances for View, Model and Controller
        SearchProject view = new SearchProject();
        Search model = new Search();
        SearchController controller = new SearchController(view, model);
    }

}
