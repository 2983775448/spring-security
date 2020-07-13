package com.zj.security;

import org.springframework.security.core.AuthenticationException;

public class VerifyCodeException extends AuthenticationException {
    public VerifyCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public VerifyCodeException(String msg) {
        super(msg);
    }
}
