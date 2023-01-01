package com.example.Fawry.Core;

public abstract class Discount {
    protected double amount;
    protected String Type;

    public void setAmount(float value){
        amount = value;
    }
    public String getType(){
        return Type;
    }

    public void setType(String name){
        Type = name;
    }
    public double getAmount(){
        return amount;
    }


    public double calculateDiscount(double price){
        return (amount * price);
    }



}
