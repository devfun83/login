package com.example.login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.login.dto.CustomUserDetails;

@Controller
public class MainController {

    /**
     * 메인
     * @param customUserDetails
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        
        // 로그인 여부 체크
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (!(principal instanceof String)) {
            // 로그인 아이디
            String id = SecurityContextHolder.getContext().getAuthentication().getName();
            System.out.println("========================");
            System.out.println("아이디 : " + id);
            System.out.println("========================");
            
            // Membars 정보
            System.out.println("========================");
            System.out.println("아이디 : " + customUserDetails.getMembers().getLoginId());
            System.out.println("닉네임 : " + customUserDetails.getMembers().getNickname());
            System.out.println("권한 : " + customUserDetails.getMembers().getRole());
            System.out.println("========================");
            
            model.addAttribute("isLogin", true);
            model.addAttribute("id", customUserDetails.getMembers().getLoginId());
            model.addAttribute("nickname", customUserDetails.getMembers().getNickname());
        }
        else {
            model.addAttribute("isLogin", false);
        }
        
        return "index";
    }

}
