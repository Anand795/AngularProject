package com.smi.allone.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.smi.allone.repository.UserRepository;




@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		http.csrf().disable().cors().disable();
//		http.authorizeRequests()
//			.antMatchers("**/secured/**").authenticated()
//			.antMatchers("/user/**").permitAll()
//			.anyRequest().permitAll()
//			.and()
//			.httpBasic();
		
		http.csrf().disable().cors().disable();
		http.antMatcher("*/secured/*").authorizeRequests()
			.antMatchers("*/secured/*").authenticated()
			.anyRequest().permitAll()
			.and()
			.httpBasic();
	}

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//
//		List<UserDetails> users = new ArrayList<UserDetails>();
//		users.add(User.withDefaultPasswordEncoder().username("anand@gmail.com").password("anandanand").roles("USER").build());
//
//		return new InMemoryUserDetailsManager(users);
//
//	}
//	

}