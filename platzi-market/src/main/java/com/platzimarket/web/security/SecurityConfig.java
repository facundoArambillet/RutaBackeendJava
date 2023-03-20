package com.platzimarket.web.security;


import com.platzimarket.domain.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@EnableWebSecurity
@Configuration
public class SecurityConfig  {
    @Autowired
    private UserDetailsService userDetailsService;

/*
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/
    @Bean
    public AuthenticationManager authManager(HttpSecurity http/*,BCryptPasswordEncoder bCryptPasswordEncoder*/)throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
/*                .passwordEncoder(bCryptPasswordEncoder)*/
                .and()
                .build();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/**").permitAll(); //Permito que cualquiera use todos los endpoints porque no me funciona el JWT
        return http.build();
    }
/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable().authorizeHttpRequests()
                .requestMatchers("http://localhost:8000/platzi-market/api/auth/**").permitAll()
                .and()
                .build();
    }*/

}



