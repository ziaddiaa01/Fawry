package com.example.Fawry.Application;

import com.example.Fawry.Core.Admin;
import com.example.Fawry.Core.Discount;

public interface IAdminService {
    public boolean setAdmin(Admin admin);
    public boolean register(Admin admin);
    public boolean login(Admin admin);
    public String listPendingRefundRequests();
    public String listTransactions();
    public String addDiscount(Discount discount);
    public String addServiceProvider(String providerName);
    public String approveRefund(int ID , int UserID , double amount);
    public String denyRefund(int refundId);
}
