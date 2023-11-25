package com.app.kharcha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.app.kharcha.security.CustomUserDetailService;

@Configuration
public class WebSecConfig{

	@Autowired
	CustomUserDetailService custUserDetailServ;
	
	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(contextPath+"/newUser")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
	}
	

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(custUserDetailServ);
    }
	

}

