package com.lti.training.apigateway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/*@Autowired
	DataSource dataSource;*/
	
	// define the interaction with credential repo
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// from where to check for credentials
		
		// jdbc authentication
		// auth.jdbcAuthentication().dataSource(dataSource);
		
		
		// in memory auth
		
		// TO create users
		UserBuilder builder = User.withDefaultPasswordEncoder(); // noop(plain text) | bcrypt
		
		auth.inMemoryAuthentication()
			.withUser(builder.username("First").password("abc").roles("ADMIN"))
			.withUser(builder.username("Second").password("abc").roles("ADMIN"))
			.withUser(builder.username("Third").password("abc").roles("ADMIN"));
		
	}
	
	// core logic constraint
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()  // auto configure application to use CrossOrigin
		.and()
			.csrf().disable() // form security will not conflict
			.authorizeRequests() // must be logged
				.antMatchers("/micro-post/api/post/add/**").hasRole("ADMIN")
				.antMatchers("/micro-user/api/user/login").hasRole("ADMIN")
				//.antMatchers("/micro-user/**").permitAll() // all ROLES 
			.and()
				.httpBasic(); // Basic token system (formed using username/password)
		
	}
	
	// configure JWT/OAuth
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
