package com.example.Fawry.Application;

import com.example.Fawry.Core.Admin;
import com.example.Fawry.Core.RefundTransaction;
import com.example.Fawry.Core.ServiceProvider;
import com.example.Fawry.Persistance.AddToWalletPersistance;
import com.example.Fawry.Persistance.PayementPersistance;
import com.example.Fawry.Persistance.AdminPersistance;
import com.example.Fawry.Persistance.RefundPersistance;
import com.example.Fawry.Persistance.RefundTransactionPersistance;
import com.example.Fawry.Persistance.ServiceProviderPersistance;
import com.example.Fawry.Persistance.DiscountPersistance;
import com.example.Fawry.Core.Discount;


public class AdminService implements IAdminService{
    private AdminPersistance model;
    private Admin admin;
    private RefundPersistance pendingRequest;
    private RefundTransactionPersistance transactions1;
    private AddToWalletPersistance transactions2;
    private PayementPersistance transactions3;
    private DiscountPersistance discountService;
    private ServiceProviderPersistance provider;




    public AdminService(){
        this.admin = new Admin();
        this.model = new AdminPersistance();
        transactions1 = new RefundTransactionPersistance();
        transactions3 = new PayementPersistance();
        transactions2 = new AddToWalletPersistance();
        pendingRequest = new RefundPersistance();
        discountService = new DiscountPersistance();
        provider = new ServiceProviderPersistance();

    }
    @Override
    public boolean setAdmin(Admin admin){
        this.admin = admin;
        return true;
    }
    @Override
    public boolean register(Admin admin){
        model.insert(admin);
        return true;
    }
    @Override
    public boolean login(Admin admin){
        if(model.check(admin)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String listPendingRefundRequests(){
        String message = pendingRequest.listPendingRefundRequests();
        return message;
    }

    @Override
    public String listTransactions(){

        String message1 = transactions1.listRefundTransactions();
        String message2 = transactions2.listWalletTransactions();
        String message3 = transactions3.listPaymentTransactions();

        return message1+message2+message3;
    }

    @Override
    public String approveRefund(int RefundId , int userID , double amount){
        RefundTransaction refund = new RefundTransaction();
        pendingRequest.insert("UPDATE RefundRequest SET isApproved = true where ID='" + RefundId +"'");
        refund.setID(RefundId);
        refund.setUserID(userID);
        refund.setamount(amount);
        transactions1.insert(refund);
        return ("Refund no. "+ RefundId + " is approved successfully");
    }
    @Override
    public String denyRefund(int RefundId){
        pendingRequest.remove(RefundId);
        return ("Refund no. "+ RefundId + " is denied successfully");
    }
    @Override
    public String addDiscount(Discount discount){
        discountService.insert(discount);
        return ("Discount . "+ discount.getAmount() + " is added  "+"'");
    }

    @Override
    public String addServiceProvider(String providerName){
        provider.insert(providerName);
        return ("Provider . "+ providerName + " is added  "+"'");
    }
}
