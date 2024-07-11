package com.example.login.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.RedirectStrategy;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache            = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy    = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("==================");
        System.out.println("로그인 성공");
        System.out.println("==================");
        
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        // 접근 권한 없는 경로로 접근해서 스프링 시큐리티가 인터셉트 후 로그인 페이지로 이동 한 경우
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetUrl);
        }
        // 로그인 버튼 눌러서 로그인 페이지로 이동 한 경우
        else {
            HttpSession session = request.getSession();
            String prevPage     = (String) session.getAttribute("prevPage");
            
            redirectStrategy.sendRedirect(request, response, prevPage);
        }

    }
}
