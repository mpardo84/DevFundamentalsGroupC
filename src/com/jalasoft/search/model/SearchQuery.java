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

import java.sql.*;

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

    public SearchQuery() throws SQLException, ClassNotFoundException {
        con = DBConnection.getInstance().getConnection();

    }


    /**
     *
     * addCriterial method to insert a search criterial into database
     *
     */
    public static void addCriterial( String name, String criterialJSON) throws SQLException, ClassNotFoundException  {

        String query = "insert into search values(?,?,?)";
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
        try (Statement statement = con.createStatement()) {
            result = statement.executeQuery("SELECT id, name, criteria FROM search");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}

