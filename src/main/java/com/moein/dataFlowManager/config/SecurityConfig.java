package com.moein.dataFlowManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.   authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/objectdocuments/**", "/api/maintables/**", "/api/calculationtables/**").authenticated()
                .requestMatchers("/api/view/**").permitAll()
                .anyRequest()
                .authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf((csrf) -> csrf.disable()) ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
