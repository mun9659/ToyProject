package com.toyProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.formLogin()
			.loginPage("/auth/loginForm")
			.defaultSuccessUrl("/main")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.authorizeHttpRequests()
			.requestMatchers("/auth/**").permitAll()
			.anyRequest().authenticated();
			
		return http.build();
	}
	
}
