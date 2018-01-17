package com.devopsbuddy.devopsbuddy.config.security;

import com.devopsbuddy.devopsbuddy.service.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
@Profile("development")
public class SecurityConfigDev extends WebSecurityConfigurerAdapter {


    /**the ENCRIPTION SALT**/
    private static final String SALT="jaskspewfd;sdrve234009fk";

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(12,new SecureRandom(SALT.getBytes()));
    }

    private String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("userName")
                .passwordParameter("user_password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }
}
