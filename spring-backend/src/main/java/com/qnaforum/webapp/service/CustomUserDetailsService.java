package com.qnaforum.webapp.service;

import com.qnaforum.webapp.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface CustomUserDetailsService{

    UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

    UserDetails loadUserById(Long id);

    User getCurrentUserByUsername();
}