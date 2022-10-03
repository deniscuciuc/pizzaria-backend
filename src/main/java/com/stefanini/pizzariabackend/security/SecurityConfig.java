package com.stefanini.pizzariabackend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/sign-in", "/api/sign-up").permitAll()
                .antMatchers("/api/token/refresh").permitAll()
                .antMatchers("/api/menu-item/**", "/api/history/**", "/api/order/**").permitAll()
                .antMatchers("/api/post/**", "/api/restaurant/**", "/api/service/**").permitAll()
                .antMatchers("/api/user/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
