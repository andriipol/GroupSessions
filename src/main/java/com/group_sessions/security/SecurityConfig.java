package com.group_sessions.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable().authorizeRequests()
                .mvcMatchers("/api/sessions/create").access("#oauth2.hasScope('create:sessions')")
                .mvcMatchers("/api/sessions").access("#oauth2.hasScope('create:sessions')")
                .mvcMatchers("/api/sessions/id/*").access("#oauth2.hasScope('create:sessions')")
                .mvcMatchers("/api/habits/*").permitAll()
                .anyRequest().permitAll().and().cors();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceId);
    }
}
