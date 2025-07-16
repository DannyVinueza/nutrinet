package com.appweb.nutrinet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/index")
    public String adminDashboard() {
        //return "admin/dashboard";
        return "index";
    }
}
