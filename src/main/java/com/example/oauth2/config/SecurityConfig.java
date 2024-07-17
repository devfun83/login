package com.example.oauth2.config;
 
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
 
import com.example.oauth2.service.CustomOAuth2UserService;
 
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final CustomOAuth2UserService customOAuth2UserService;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // csrf token
        http
            .csrf((csrf) -> csrf.disable());  // 비활성화
        
        // 인가
        http
            .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()   // resources의 static(정적파일) 모두 허용
                    .requestMatchers("/", "/login", "/login/oauth2/code/*").permitAll()  // 보안 검사 없이 접근을 허용
                    //.requestMatchers("/member/**").hasAnyRole("ADMIN", "USER")  // role - ADMIN, USER만 접근 허용
                    //.requestMatchers("/admin").hasRole("ADMIN")  // role - ADMIN만 접근 허용
                    .anyRequest().authenticated()
            );
        
        // Custom oauth2Login
        http
            .oauth2Login((oauth2) -> oauth2
                .loginPage("/login")
                .userInfoEndpoint((userInfoEndpointConfig) ->
                        userInfoEndpointConfig.userService(customOAuth2UserService))
            );
        
        // 로그아웃
        http
            .logout((logout) -> logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/")
            );
 
        return http.build();
    }
  
}