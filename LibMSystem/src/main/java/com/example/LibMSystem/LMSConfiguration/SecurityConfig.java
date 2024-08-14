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

import static org.springframework.security.config.Customizer.withDefaults;


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
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(commonConfig.getEncoder());
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
    {
        HttpSecurity httpSecurity=http.authorizeHttpRequests(authorize->authorize
                .requestMatchers("/user/addStudent/**").permitAll()
                .requestMatchers("/user/addAdmin/**").permitAll()
                .requestMatchers("/user/filter/**").hasAnyAuthority(studentAuthority,adminAuthority)
                .requestMatchers("/txn/create/**").hasAuthority(adminAuthority)
                .requestMatchers("/txn/return/**").hasAuthority(adminAuthority)
                .requestMatchers("/book/addBook/**").hasAuthority(adminAuthority)
                .requestMatchers("/book/filter/**").hasAnyAuthority(adminAuthority,studentAuthority)
                .anyRequest().authenticated()
        ).formLogin(withDefaults()).httpBasic(withDefaults()).csrf(csrf -> csrf.disable());
        return http.build();
    }
}
