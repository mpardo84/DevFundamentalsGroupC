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
package com.jalasoft.search.model;

import com.jalasoft.search.commond.Functions;
import com.jalasoft.search.commond.LoggerWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 The DBConnection to create a connection to embedded database.
 *
 * @version
15 Apr 2018
 *
 *  @author
Gretta Rocha
 */
public class DBConnection {

    private static DBConnection dbcon;
    private static Connection con;
    LoggerWrapper logger = LoggerWrapper.getInstance();
    Functions functions = new Functions();

    private DBConnection() {
        init();
    }

    public static DBConnection getInstance()  {
        if(dbcon==null){
            dbcon=new DBConnection();
        }
        return dbcon;
    }

    private void init() {
        try {


            Class.forName("org.sqlite.JDBC");

            con = DriverManager.getConnection("jdbc:sqlite:SEARCH.db");
            Statement state = con.createStatement();
            String sql= "CREATE TABLE IF NOT EXISTS CRITERIA (\n"
                    + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + "	name text ,\n"
                    + "	CRITERIA text,\n"
                    + "	type text \n"
                    + ");";
            state.execute(sql);
            System.out.println("tabla creada");


        } catch (ClassNotFoundException ex) {
            logger.log.severe( functions.getStackTrace(ex));
        } catch (SQLException e) {
            logger.log.severe(functions.getStackTrace(e));
        }
    }
    public static Connection getConnection(){
        return con;
    }


}