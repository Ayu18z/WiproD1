package com.example.SpringSecurity.spBoot26._1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	


    @GetMapping("/public/welcome")
    public String getWelcome() {
        return "Welcome to our Hotel";
    }

    @GetMapping("/api/user/userinfo")
    public String getUserInfo() {
        return "Your voucher code is generated";
    }

    @GetMapping("/api/admin/admininfo")
    public String getAdminInfo() {
        return "Admin dashboard will get open";
    }

	

}
