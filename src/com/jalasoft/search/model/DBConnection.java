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

    private DBConnection() throws SQLException, ClassNotFoundException {
        init();
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbcon==null){
            dbcon=new DBConnection();
        }
        return dbcon;
    }

    private void init() throws ClassNotFoundException,SQLException
    {

        Class.forName("org.sqlite.JDBC");
        con= DriverManager.getConnection("jdbc:sqlite:search.db");
        Statement state=con.createStatement();
        state.execute("Create Table if not exists search(Id integer auto increment,name text,criteria varchar(256),primary Key(id))");
        System.out.println("BD creada");

    }
    public static Connection getConnection(){
        return con;
    }
}