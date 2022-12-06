package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVip() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        ResultSet rs = statement.executeQuery(sqlCheckTable);

        //Then
        int howMany = -1;
        if(rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
    }

    @Test
    void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //When
        String sqlProcUpdateBookStatus = "CALL UpdateBestsellerStatus()";
        statement.execute(sqlProcUpdateBookStatus);
        String resultSet = "SELECT COUNT(*) AS BESTSELLERS FROM BOOKS WHERE BESTSELLER = 1";
        ResultSet rs = statement.executeQuery(resultSet);
        //Then
        int count = -1;
        while(rs.next()) {
            count = rs.getInt("BESTSELLERS");
        }
        assertEquals(2, count);
    }
}
