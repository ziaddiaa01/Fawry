package com.example.Fawry.Application;

import com.example.Fawry.Core.Admin;
import com.example.Fawry.Core.RefundTransaction;
import com.example.Fawry.Core.User;
import com.example.Fawry.Persistance.*;

public class UserService implements IUserService{
    private UserPersistance model;
    private User user;


    private RefundPersistance pendingRequest;
    private RefundTransactionPersistance transactions1;
    private AddToWalletPersistance transactions2;
    private PayementPersistance transactions3;
    private ServicesPersistance service;
    private ServiceProviderPersistance provider;

    public UserService(){
        this.user = new User();
        this.model = new UserPersistance();
        transactions1 = new RefundTransactionPersistance();
        transactions3 = new PayementPersistance();
        transactions2 = new AddToWalletPersistance();
        pendingRequest = new RefundPersistance();
        provider = new ServiceProviderPersistance();
        service = new ServicesPersistance();

    }
    @Override
    public boolean setUser(User user){
        this.user = user;
        return true;
    }
    @Override
    public boolean register(User user){
        model.insert(user);
        return true;
    }
    @Override
    public User login(User user){
        if(model.check(user)){
            user = model.getInfo(user.getUserName());
            return user;
        }else{
            return null;
        }
    }
    @Override
    public String requestRefund(RefundTransaction refund){
        pendingRequest.insert(refund);
        return ("Refund request no. "+ refund.getID() + " is requested successfully");
    }
    @Override
    public String SearchService(String ServiceName){
        return service.retrieve(ServiceName);
    }
    @Override
    public String checkDiscount(String ServiceName){
        return service.checkDiscount(ServiceName);
    }


}
