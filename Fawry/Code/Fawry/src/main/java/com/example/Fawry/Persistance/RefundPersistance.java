package com.example.Fawry.Persistance;
import com.example.Fawry.Core.RefundTransaction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RefundPersistance {
    public void insert(RefundTransaction refund){
        String sql = "INSERT INTO RefundRequest(ID,UserID,amount,ServiceID) VALUES ('" + refund.getID() + "', '"
                + refund.getUserID() + "', '" + refund.getamount()+ + refund.getserviceId()+ "')";
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
    public void remove(int RefundId ){
        String sql = "DELETE FROM RefundRequest WHERE ID='" + RefundId +"'";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public String listPendingRefundRequests(){
        String sql = "SELECT * FROM RefundRequest";
        String result = "";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                result += rs.getString("Refund Request ID");
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
