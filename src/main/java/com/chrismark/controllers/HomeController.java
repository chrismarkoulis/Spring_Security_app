/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chris
 */

@Controller
@RequestMapping("/")
public class HomeController {

    // <editor-fold defaultstate="collapsed" desc=" return home.jsp ">
    @GetMapping
    public String home() {

        return "home";

    }

// </editor-fold>

   

    @GetMapping("/user")
    public String userHome() {

        return "user";

    }

    @GetMapping("/admin")
    public String adminHome() {

        return "admin";

    }

}
