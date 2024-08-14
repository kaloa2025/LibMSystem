package com.example.LibMSystem.LMSConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.Encoder;
@Configuration
public class CommonConfig {
    @Bean
    public PasswordEncoder getEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
