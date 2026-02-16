package com.zs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	 public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		 return http
//	        .authorizeHttpRequests(request -> request.requestMatchers("/hello").permitAll())
//	        .authorizeHttpRequests((request -> request.requestMatchers("/hello").authenticated().anyRequest().permitAll()))
			.authorizeHttpRequests(request -> request.anyRequest().authenticated())
//			.authorizeHttpRequests(request -> request.anyRequest().permitAll())
	        .httpBasic(Customizer.withDefaults())
	        .build();
	 }
	 
	 @Bean
	 public UserDetailsManager userDetailsManager() {
	    UserDetails ud1 = User.builder()
	        .username("zubair")
	        .password("{noop}secret")
	        .roles("USER")
	        .build();
	    
	    UserDetails ud2 = User.builder()
		    .username("kavita")
		    .password("{noop}secret")
		    .roles("ADMIN")
		    .build();
	    
	    return new InMemoryUserDetailsManager(ud1, ud2);
	}
}








