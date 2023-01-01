package com.example.Fawry.Core;

public abstract class Transactions {
    public int ID;
    public int userID;
    public boolean isCompleted;
    public double amount;
    public int serviceId;

    public String date;

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setserviceId(int serviceId) {
        this.serviceId = serviceId;
    }
    public double getserviceId() {
        return this.serviceId;
    }


    public void setamount(double amount) {
        this.amount = amount;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
    public void setUserID(int userID) {
        this.userID=userID;
    }
    public int getID() {
        return this.ID;
    }
    public String getDate() {
        return this.date;
    }

    public double getamount() {
        return this.amount ;
    }

    public boolean getCompleted() {
        return this.isCompleted ;
    }
    public int getUserID() {
        return this.userID;
    }
}
