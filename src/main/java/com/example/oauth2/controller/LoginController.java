package com.example.oauth2.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class LoginController {
 
    /**
     * 로그인 페이지
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
 
}