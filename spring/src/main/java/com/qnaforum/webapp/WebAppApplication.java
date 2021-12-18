package com.qnaforum.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
				.antMatchers("/").permitAll();
	}*/
}
