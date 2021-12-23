package com.qnaforum.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/*@Configuration*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*https://stackoverflow.com/questions/32319396/cors-with-spring-boot-and-angularjs-not-working*/
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .cors().configurationSource(request -> {
                var cors = new CorsConfiguration();
                cors.setAllowedOrigins(List.of("*"));
                cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
                cors.setAllowedHeaders(List.of("*"));
                cors.setAllowedOriginPatterns(List.of("*"));
                return cors;
            })
            .and()
            .antMatcher("/**").authorizeRequests()
            .antMatchers(new String[]{"/", "/welcome", "/not-restricted"}).permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login();
    }
}