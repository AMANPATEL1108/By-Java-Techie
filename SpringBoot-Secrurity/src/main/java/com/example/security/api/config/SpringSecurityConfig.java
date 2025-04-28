package com.example.security.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfiguration {


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("aman").password("pass1").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("patel").password("pass2").roles("USER");

    }

    //security for all api
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeHttpRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//    }

    //security for base ur
//    protected void configure(HttpSecurity http)throws Exception{
//        http.csrf().disable();
//        http.authorizeHttpRequests().anyMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
//    }

    //security based on role

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests().anyMatchers("/rest/**").hasAnyRole("ADMIN").anuRequest().fullyAuthenticated()
                .and().httpBasic();
    }


    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
