package com.nanay.mvc.mvc.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;


@Component
public abstract class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
  //  protected abstract void configure(AuthenticationManagerBuilder auth) throws Exception;

    //protected abstract void configure (HttpSecurity http) throws Exception;
}
