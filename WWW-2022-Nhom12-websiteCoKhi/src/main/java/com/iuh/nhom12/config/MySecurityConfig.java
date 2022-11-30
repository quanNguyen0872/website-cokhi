package com.iuh.nhom12.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	// add a reference to our security data source
    @Autowired
    private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource)
        .usersByUsernameQuery("select username, password, enabled from users where username = ? ")
        .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//add your custom encoding filter as the first filter in the chain
        http.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class);
		http.authorizeRequests()
		.antMatchers("/showCartPage/**").hasAnyRole("CUSTOMER")
		.antMatchers("/showInfomationUserPage").hasAnyRole("CUSTOMER")
		.antMatchers("/infomationUserForm").hasAnyRole("CUSTOMER")
		.antMatchers("/processUpdateUserInfo").hasAnyRole("CUSTOMER")
		.antMatchers("/manager/**").hasAnyRole("MANAGER")
		.antMatchers("/showReceiptList").hasAnyRole("CUSTOMER")
		.antMatchers("/saveOrderDetail").hasAnyRole("CUSTOMER")
		.antMatchers("/showShopPage").permitAll()
		.antMatchers("/showRecommendPage").permitAll()
		.antMatchers("/register/**").permitAll()
		.antMatchers("/").permitAll()
		.and()
		.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
		.and()
		.logout().permitAll()
		.logoutSuccessUrl("/")
		.and()
        .exceptionHandling().accessDeniedPage("/access-denied");			
	}
	
	@Bean
    public UserDetailsManager userDetailsManager() {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

        jdbcUserDetailsManager.setDataSource(securityDataSource);

        return jdbcUserDetailsManager;
    }
}
