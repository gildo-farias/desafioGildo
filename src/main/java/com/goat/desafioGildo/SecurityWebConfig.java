package com.goat.desafioGildo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
/** @author GILDO */

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {	 
	 @Override
	  public void configure(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    builder.inMemoryAuthentication().withUser("gildo").password(encoder.encode("123")).roles("USER"); 	        
	  }
}
