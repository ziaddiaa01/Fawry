package com.example.Fawry.Application;

import com.example.Fawry.Core.RefundTransaction;
import com.example.Fawry.Core.User;

public interface IUserService {
    public boolean setUser(User user);
    public boolean register(User user);
    public User login(User user);

    public String requestRefund(RefundTransaction refund);
    public String SearchService(String ServiceName);
    public String checkDiscount(String ServiceName);

}
