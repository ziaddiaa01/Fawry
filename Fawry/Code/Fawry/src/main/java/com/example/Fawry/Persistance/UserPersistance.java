package com.example.Fawry.Persistance;
import com.example.Fawry.Core.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserPersistance {
    public void insert(User user){
        String sql = "INSERT INTO User (UserID, email, password, mobileNumber, isRegistered) VALUES ('" + user.getUserName() + "', '" + user.getEmail() +
                "', '" + user.getPassword() + "', '" + user.getMobileNo() + "', true)";
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
            user.registered();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    public boolean check(User user){
        String sql = "SELECT * FROM User WHERE UserID='" + user.getUserName() + "' AND password='" + user.getPassword() +"'";
        boolean check = false;
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next() == false){
                check = false;
            }else{
                check = true;
            }
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return check;
    }
    public User getInfo(String username){
        String sql = "SELECT * FROM User WHERE UserID='" + username + "'";
        User user = new User();
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            String password = rs.getString("password");
            String email = rs.getString("email");
            user.setUserName(username);
            user.setEmail(email);
            user.setPwd(password);
            user.registered();
            conn.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return user;
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
