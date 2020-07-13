package com.zj.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
    //读取用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User("zhangsan","123456",
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//        User user1 = new User("lisi","123456"
//                ,AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        return user;
    }
}
