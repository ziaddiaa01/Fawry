package com.example.Fawry.Persistance;
import com.example.Fawry.Core.RefundTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RefundTransactionPersistance {
    public void insert(RefundTransaction refund){
        String sql = "INSERT INTO RefundTransactions(ID,UserID,amount) VALUES ('" + refund.getID() + "', '"
                + refund.getUserID() + "', '" + refund.getamount()+ "')";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public void insert(String sql){
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public String listRefundTransactions(){
        String sql = "SELECT * FROM RefundTransactions";
        String result = "";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                result += rs.getString("Refund Transactions ");
                result += "\n";
            }
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return result;
    }

    public Connection connect(){
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