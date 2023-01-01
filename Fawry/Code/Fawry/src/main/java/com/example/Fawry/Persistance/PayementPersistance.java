package com.example.Fawry.Persistance;
import com.example.Fawry.Core.PaymentTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PayementPersistance {
    public void insert(PaymentTransaction payment){
        String sql = "INSERT INTO PaymentTransaction(ID,UserID,amount) VALUES ('" + payment.getID() + "', '"
                + payment.getUserID() + "', '" + payment.getamount()+ "')";
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

    public String listPaymentTransactions(){
        String sql = "SELECT * FROM PaymentTransactions";
        String result = "";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                result += rs.getString("Payment Transactions ID");
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