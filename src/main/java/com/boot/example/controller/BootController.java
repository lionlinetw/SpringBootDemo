package com.boot.example.controller;

import com.boot.example.service.BootService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BootController {
    
    @Autowired
    BootService bootService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("in controll index");
        return "index";
    }

}
