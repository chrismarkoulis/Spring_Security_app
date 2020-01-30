/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 *
 * @author chris
 */
@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;
    
    // <editor-fold defaultstate="collapsed" desc=" Make Users ">
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        UserBuilder userBuilder = User.builder();
        auth.jdbcAuthentication().dataSource(datasource);
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("admin").password("{noop}1234").roles("ADMIN"))
//                .withUser(userBuilder.username("user").password("{noop}1234").roles("USER"));

    }

// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Change/Restrict Access ">
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // fluent api
        http.authorizeRequests()//restrict access based on HttpServletRequest
//                .anyRequest().authenticated()//any request to the app must be authenticated(logged in)
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()//we are customizing the form login proccess
                .loginPage("/loginPage")// show my form at the request mapping
                .loginProcessingUrl("/authenticate")/*login form will POST data to this URL
                                                        for proccessing username and password*/  
                .permitAll()// allow everyone to see login page/dont have to be logged in
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/access-denied");
    }

}

// </editor-fold>
