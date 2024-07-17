package com.example.oauth2.controller;
 
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.example.oauth2.dto.CustomOAuth2User;
 
@Controller
public class MainController {
 
    /**
     * 메인 페이지
     * @param customOAuth2User
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(@AuthenticationPrincipal CustomOAuth2User customOAuth2User, Model model) {
        
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
            System.out.println("아이디 : " + customOAuth2User.getMembers().getUserid());
            System.out.println("이메일 : " + customOAuth2User.getMembers().getEmail());
            System.out.println("이름 : " + customOAuth2User.getMembers().getUsername());
            System.out.println("권한 : " + customOAuth2User.getMembers().getRole());
            System.out.println("========================");
            
            model.addAttribute("isLogin", true);
            model.addAttribute("userid", customOAuth2User.getMembers().getUserid());
            model.addAttribute("username", customOAuth2User.getMembers().getUsername());
        }
        else {
            model.addAttribute("isLogin", false);
        }
        
        return "index";
    }
 
}