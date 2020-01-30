package com.chrismark.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author chris
 */
@Controller
public class AuthenticateController {
    
    @GetMapping("/loginPage")
    public String showLoginForm() {

        return "form-login";
    }
    
    
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
    
    return "access-denied";
    
    }
    
}
