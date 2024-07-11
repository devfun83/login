package com.example.login.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
 
@Controller
public class LoginController {
 
    /**
     * 로그인
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error
                        , @RequestParam(value = "exception", required = false) String exception
                        , HttpServletRequest request, Model model) {
        
        String prevPage     = request.getHeader("Referer");
        HttpSession session = request.getSession();

        if(prevPage != null && !prevPage.contains("/login")) {
            session.setAttribute("prevPage", prevPage); // 이전 페이지 세션으로 저장
        }
        
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        
        return "login";
    }
 
}