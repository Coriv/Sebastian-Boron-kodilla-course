package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbMengerTestSuite {

    @Test
    void testConnect() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUser() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " + rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(6, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POST_COUNTER" +
        " FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID" +
        " GROUP BY U.ID" +
        " HAVING COUNT(*) >= 2";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);


        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME"));
            counter++;
        }
        statement.close();
        rs.close();

        assertEquals(2, counter);
    }

    @Test
    void testAddingNewRecordToDatabase() throws SQLException {

        DbManager dbManager = DbManager.getInstance();

        String sqlInsert = "INSERT INTO USERS (ID, FIRSTNAME, LASTNAME)" +
                                " VALUES (6, \"Sebastian\", \"Boron\")";

        String sqlQueryGet = "SELECT FIRSTNAME, LASTNAME FROM USERS" +
                             " WHERE FIRSTNAME = \"Sebastian\" AND LASTNAME = \"Boron\"";

        Statement statement = dbManager.getConnection().createStatement();

        dbManager.getConnection().setAutoCommit(false);

        try {
            statement.execute(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbManager.getConnection().commit();

        ResultSet rsGet = statement.executeQuery(sqlQueryGet);

        int counter = 0;
        while (rsGet.next()) {
            System.out.println(rsGet.getString("FIRSTNAME") + " " + rsGet.getNString("LASTNAME"));
            counter++;
        }

        statement.close();
        rsGet.close();

        assertEquals(1, counter);
    }
}

