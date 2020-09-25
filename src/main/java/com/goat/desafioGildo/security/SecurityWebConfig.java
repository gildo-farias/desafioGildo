package com.goat.desafioGildo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** @author GILDO */

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {		
		builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.cors().and().csrf().disable();		
		http.authorizeRequests().antMatchers("/").authenticated().anyRequest().permitAll().and().formLogin();		
	}	
	
	
	
}
