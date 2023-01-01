package com.example.Fawry.Persistance;

import com.example.Fawry.Core.Discount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscountPersistance {
    public void insert(Discount discount){
        String sql = "INSERT INTO Discounts VALUES ('" + discount.getAmount() + "', '" + discount.getType() + "')";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:Fawry.db";
        try {
            conn = DriverManager.getConnection(url);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
