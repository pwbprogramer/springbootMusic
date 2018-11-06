package com.example.demo.configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.handler.MyAuthenctiationSuccessHandler;
import com.example.demo.services.MyUserDetailServices;

import io.swagger.annotations.Api;
@Api(value="SecurityConfig",description="SpringSecurity配置类")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailServices myUserDetailServices;
	
	@Autowired
	private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
	
	@Autowired
	@Qualifier("DataSource1")
	private DataSource DataSource1;

	/**
	 * HttpSecurity配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/html/error/error.html")
				.successHandler(myAuthenctiationSuccessHandler).permitAll().and().logout().and().authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/img/**", "/html/register/register.html", "/register/registerHtml")
				.permitAll().anyRequest().authenticated().and().csrf().disable();
	}
	
	/**
	 * 从数据库获取用户名和权限
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(DataSource1).passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select username,password,status as enabled from user where username=?")
		.authoritiesByUsernameQuery("select u.username,r.name as authority from user u join user_role ur  on u.id=ur.user_id join role r on r.id=ur.role_id where u.username=?");
	}
    
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(this.authenticationProvider());
//	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(myUserDetailServices);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	

}
