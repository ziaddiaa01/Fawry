package com.example.Fawry;

import com.example.Fawry.Application.AdminService;
import com.example.Fawry.Application.IAdminService;
import com.example.Fawry.Core.Admin;
import com.example.Fawry.Core.Discount;
import org.springframework.web.bind.annotation.*;

@RestController
public class  AdminController {
    private IAdminService adminService;

    public AdminController(){
        adminService = new AdminService();
    }

    @PostMapping("/setAdmin")
    public boolean setAdmin(@RequestBody Admin admin){
        return adminService.setAdmin(admin);
    }

    @PostMapping("/registerAdmin")
    public boolean register(@RequestBody Admin admin){
        return adminService.register(admin);
    }

    @PostMapping("/loginAdmin")
    public boolean login(@RequestBody Admin admin){
        return adminService.login(admin);
    }

    @PostMapping("/listPendingRefundRequests")
    public String listPendingRefundRequests(){return adminService.listPendingRefundRequests();}

    @PostMapping("/listTransactions")
    public String listTransactions(){
        return adminService.listTransactions();
    }

    @PostMapping("/addDiscount")
    public String addDiscount(@RequestBody Discount discount){return adminService.addDiscount(discount);}


    @PostMapping("/addServiceProvider")
    public String addServiceProvider(@RequestBody String providerName){return adminService.addServiceProvider(providerName);}

    @PostMapping("/approveRefund//{ID}/{UserID}/{amount}")
    public String approveRefund(@PathVariable int ID , @PathVariable int UserID , @PathVariable double amount){return adminService.approveRefund(ID,UserID,amount);}

    @PostMapping("/denyRefund/{ID}")
    public String denyDriver(@PathVariable int refundId){return adminService.denyRefund(refundId);}
}
