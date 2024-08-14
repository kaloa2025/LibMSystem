package com.example.LibMSystem.LMSConfiguration;

import com.example.LibMSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private CommonConfig commonConfig;
    @Value("${admin.authority}")
    private String adminAuthority;
    @Value("${student.authority}")
    private String studentAuthority;
    @Autowired
    private UserService userService;
    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(securityService);
        authenticationProvider.setPasswordEncoder(commonConfig.getEncoder());
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
    {
        HttpSecurity httpSecurity=http.authorizeHttpRequests(authorize->authorize
                .requestMatchers("/home/**").permitAll()
                .anyRequest().authenticated()
        ).formLogin(withDefaults().httpBasic(withDefaults()));
        return http.build();
    }
}
