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

import com.sun.java.browser.plugin2.liveconnect.v1.Result;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 The SearchQuery class that implements CRUD operations on database.
 *
 * @version
15 Apr 2018
 *
 *  @author
Gretta Rocha
 */

public class SearchQuery {

    private static Connection con;
    private  ArrayList<String> ListCriteriaName = new ArrayList<String>();

    public SearchQuery() throws SQLException, ClassNotFoundException {
        con = DBConnection.getInstance().getConnection();

    }

    public void setListCriteriaName(ArrayList<String> listCriteriaName) {
        ListCriteriaName = listCriteriaName;
    }

    public ArrayList<String> getListCriteriaName() {
        return ListCriteriaName;
    }

    /**
     *
     * addCriterial method to insert a search criterial into database
     *
     */
    public static void addCriterial( String name, String criterialJSON) throws SQLException, ClassNotFoundException  {

        String query = "insert into CRITERIA values(?,?,?)";
        try (PreparedStatement statement = con.prepareStatement(query)){
                statement.setString(2, name);
                statement.setString(3, criterialJSON);
                statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * getAllCriterial method to get all criterial saved from database
     *
     */
    public ResultSet getAllCriterialSearch() throws SQLException, ClassNotFoundException  {
        ResultSet result = null;
        System.out.println("entro al get All method");
        try (Statement statement = con.createStatement()) {
            System.out.println("entro a ejecutar el query");
            result = statement.executeQuery("SELECT id, name, criteria FROM CRITERIA");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String criteria = result.getString("criteria");


                System.out.println("ID from controller = " + id);
                System.out.println("NAME from controller = " + name);
                System.out.println("criteria from controller = " + criteria);

            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     *
     * getAllCriterial method to get all criterial saved from database
     *
     */
    public ResultSet getNameCriterialSearch() throws SQLException, ClassNotFoundException  {
        ResultSet result = null;
        try (Statement statement = con.createStatement()) {
            result = statement.executeQuery("SELECT  name FROM CRITERIA");
            while (result.next()) {

                String name = result.getString("name");
                System.out.println("NAME from search query = " + name);
                ListCriteriaName.add(name);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void setListCriteriaNameData( String name){

        ListCriteriaName.add(name);

    }
}

