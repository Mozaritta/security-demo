package com.security.demo.config;

import com.security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    protected AuthenticationManager authenticationManager() throws Exception{
//        return super.authenticationManager();
//    }
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //In-memory
//        auth.inMemoryAuthentication().withUser("Leila").password(passwordEncoder.encode("123")).authorities("USER", "ADMIN");

        //Database Auth
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        super.configure(auth);
    } 

    protected void configure(HttpSecurity httpSecurity) throws Exception{
        //httpSecurity.authorizeRequests().anyRequest().permitAll(); will show an error page if there is no controller
        // lo login and then have access to the main welcome page :
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.formLogin();
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
