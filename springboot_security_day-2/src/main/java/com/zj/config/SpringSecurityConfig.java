package com.zj.config;

import com.zj.security.MyAuthenticationFailureHandler;
import com.zj.security.MyAuthenticationSuccessHandler;
import com.zj.security.MyUserDetailsService;
import com.zj.utils.MD5Util;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyAuthenticationSuccessHandler successHandler;
    @Resource
    private MyAuthenticationFailureHandler failureHandler;
    @Resource
    private MyUserDetailsService userDetailsService;

    //认证授权
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            //对用户输入的密码进行加密处理
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String) charSequence);
            }
            //对用户输入的密码进行校验
            @Override
            public boolean matches(CharSequence charSequence, String source) {
                String password = MD5Util.encode((String) charSequence);
                return password.trim().equals(source.trim());
            }
        });
    }

    //登录
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/showOrder").hasAnyAuthority("showOrder")
                .antMatchers("/addOrder").hasAnyAuthority("addOrder")
                .antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
                .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
                .antMatchers("/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin()
                .successHandler(successHandler).failureHandler(failureHandler).loginPage("/login")
                .and().csrf().disable();
    }

}
