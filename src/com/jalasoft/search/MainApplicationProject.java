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

/**
 *
 This class is the Main class that will allows to execute the code
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo  */
public class MainApplicationProject {

    public static void main(String[] args) {
        SearchProject vista = new SearchProject("Search Application");
        Search modelo = new Search();
        SearchController control = new SearchController(vista, modelo);
        vista.initializeDialog("Search Application");


    }
}
