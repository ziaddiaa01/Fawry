package com.example.Fawry;

import com.example.Fawry.Application.UserService;
import com.example.Fawry.Application.IUserService;
import com.example.Fawry.Core.RefundTransaction;
import com.example.Fawry.Core.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private IUserService userService;

    public UserController() {
        userService = new UserService();
    }

    @PostMapping("/setUser")
    public boolean setUser(@RequestBody User user) {
        return userService.setUser(user);
    }

    @PostMapping("/UserRegister")
    public boolean register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/userLogin")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/checkDiscount/{ServiceName}")
    public String checkDiscount(@PathVariable String ServiceName) {
        return userService.checkDiscount(ServiceName);
    }
    @PostMapping("/requestRefund/")
    public String requestRefund(@RequestBody RefundTransaction transaction) {
        return userService.requestRefund(transaction);
    }
    @PostMapping("/searchService/{ServiceName}")
    public String searchService(@PathVariable String ServiceName) {
        return userService.SearchService(ServiceName);
    }

}

