package com.example.login.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final CustomLoginSuccessHandler customLoginSuccessHandler;
    private final CustomLoginFailureHandler customLoginFailureHandler;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // csrf token
        http
            .csrf((csrf) -> csrf.disable());  // 비활성화
        
        // 인가
        http
            .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/", "/login", "/loginProc", "/join", "/joinProc").permitAll()  // 보안 검사 없이 접근을 허용 
                    .requestMatchers("/member/**").hasAnyRole("ADMIN", "USER")  // role - ADMIN, USER만 접근 허용
                    .requestMatchers("/admin").hasRole("ADMIN")  // role - ADMIN만 접근 허용
                    .anyRequest().authenticated()
            );
 
        // Custom Login
        http
            .formLogin((form) -> form
                    .loginPage("/login")
                    .usernameParameter("loginId")
                    .passwordParameter("loginPwd")
                    .loginProcessingUrl("/loginProc")
                    .successHandler(customLoginSuccessHandler)
                    .failureHandler(customLoginFailureHandler)
                    .permitAll()
            );
        
        // 다중 로그인
        /*http
            .sessionManagement(session -> session
                    .maximumSessions(1) // 다중 로그인 허용 개수
                    .maxSessionsPreventsLogin(true) // 새로운 로그인 차단
            );*/
        
        // 세션 고정 보호
        http
            .sessionManagement((session) -> session
                    .sessionFixation((sessionFixation) -> sessionFixation
                            //.newSession()   // 로그인 시 세션 신규 생성
                            .changeSessionId() // 로그인 시 세션은 그대로 두고 세션 아이디만 변경
                    )
            );
        
        // 로그아웃
        http
            .logout((logout) -> logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/")
            );
 
        return http.build();
    }
 
    /**
     * BCrypt 암호화
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
  
}