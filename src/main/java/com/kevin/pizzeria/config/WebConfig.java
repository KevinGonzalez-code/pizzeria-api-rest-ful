package com.kevin.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebConfig{
    
    @Bean
    public BCryptPasswordEncoder encriptarContraseña(){
        return new BCryptPasswordEncoder();
    }
}