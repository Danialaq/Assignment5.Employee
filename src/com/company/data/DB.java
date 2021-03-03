package com.company.data;

import com.company.data.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements IDB{
    @Override
    public Connection con() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/danial";
        try {
            Class.forName("org.postgresql.Driver");
            Connection y = DriverManager.getConnection(url, "postgres", "0000");
            return y;
        } catch (Exception e){
            System.out.println("No connection!");
            return null;
        }
    }
}
