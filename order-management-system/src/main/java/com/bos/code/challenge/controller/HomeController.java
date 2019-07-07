package com.bos.code.challenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Atul on 6/7/19.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String launch(){
        return "Welcome to Order Book Management API";
    }


    @RequestMapping("*")
    public String error(){
        return "An error occurred, please contact TECH SUPPORT at techsupport@bos.com.sg";
    }


}
