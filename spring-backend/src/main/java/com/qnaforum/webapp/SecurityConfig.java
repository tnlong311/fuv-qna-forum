package com.qnaforum.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
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
                /*cors.setAllowedHeaders(List.of("Origin", "Content-Type", "X-Auth-Token"));*/
                cors.setAllowedOriginPatterns(List.of("*"));
                return cors;
            })
            .and()
            .antMatcher("/**").authorizeRequests()
            .antMatchers("/", "/welcome", "/not-restricted", "/auth/**", "/oauth2/**",
                          "/webjars/**", "/error").permitAll()
            .anyRequest().authenticated()
            .and()
            /*.exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            )*/
            .csrf(c -> c
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
            .oauth2Login()
              .defaultSuccessUrl("http://localhost:3000/welcome");
    }
}