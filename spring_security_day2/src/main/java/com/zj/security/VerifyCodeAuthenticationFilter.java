package com.zj.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyCodeAuthenticationFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler;

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/login")){
            //获取用户输入的验证码
            String verify = request.getParameter("verify");
            //获取系统生成的验证码
            String verifyCode = (String) request.getSession().getAttribute("verifyCode");

            try {
                if (StringUtils.isEmpty(verify)){
                    throw new VerifyCodeException("验证码不能为空");
                }
                //校验用户的验证码是否正确
                if (!verify.trim().equalsIgnoreCase(verifyCode.trim())){
                    throw new VerifyCodeException("验证码错误");
                }
            } catch (AuthenticationException e) {
                    authenticationFailureHandler.onAuthenticationFailure(request,response,e);
                    return;
            }
        }
        filterChain.doFilter(request,response);
    }
}
