package com.nanay.mvc.mvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends  SecurityWebApplicationInitializer{
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource((dataSource));
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .anyRequest().permitAll();
          //      .antMatchers("/products/edit").hasAnyRole("ADMIN");
               // .antMatchers("/products/edit/**").hasAnyRole("MANAGER", "ADMIN")
                //.and()
                //.formLogin()
                //.permitAll();

    }
}