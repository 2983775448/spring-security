package com.zj.config;

import com.zj.security.MyAuthenticationFailureHandler;
import com.zj.security.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyAuthenticationFailureHandler failureHandler;

    @Resource
    private MyAuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/showOrder").hasAnyAuthority("showOrder")
                .antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
                .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
                .antMatchers("/addOrder").hasAnyAuthority("addOrder")
                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login")
                .successHandler(successHandler).failureHandler(failureHandler)
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("showOrder", "addOrder", "updateOrder", "deleteOrder");
        auth.inMemoryAuthentication().withUser("userAdd").password("123456").authorities("showOrder", "addOrder");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
