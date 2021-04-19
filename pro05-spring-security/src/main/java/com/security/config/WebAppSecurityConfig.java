package com.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("tom")
                .password(new BCryptPasswordEncoder().encode("123123"))
                .roles("ADMIN","学徒")
                .and()
                .withUser("jerry")
                .password("123123")
                .authorities("UPDATE", "内门弟子");


//        builder.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user1")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("USER");


    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security
                .authorizeRequests()
                .antMatchers("/index.jsp")
                .permitAll()
                .antMatchers("/layui/**")
                .permitAll()
                .antMatchers("/level1/**")
                .hasRole("学徒")
                .antMatchers("/level2/**")
                .hasAuthority("内门弟子")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/index.jsp")
                .loginProcessingUrl("/do/login.html")
                .permitAll()
                .usernameParameter("loginAcct")
                .passwordParameter("userPswd")
                .defaultSuccessUrl("/main.html")
                .and()
//                .csrf()
//                .disable()
                .logout()
                .logoutUrl("/do/logout.html")
                .logoutSuccessUrl("/index.jsp")
        ;

    }
}
