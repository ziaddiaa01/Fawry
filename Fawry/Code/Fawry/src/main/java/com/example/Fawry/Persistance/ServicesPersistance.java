package com.example.Fawry.Persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicesPersistance {
    public String retrieve(String ServiceName){
        String sql = "SELECT * FROM Services WHERE ServiceName ='" + ServiceName +"'";
        String message = "";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                message += rs.getString("message");
                message += "\n";
            }
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return message;
    }

    public String checkDiscount(String ServiceName){
        String sql = "SELECT DiscountAmount FROM Services WHERE ServiceName ='" + ServiceName +"'";
        String message = "";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                message += rs.getString("message");
                message += "\n";
            }
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return message;
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
