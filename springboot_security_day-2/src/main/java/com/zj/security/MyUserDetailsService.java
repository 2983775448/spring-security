package com.zj.security;

import com.zj.domain.Permission;
import com.zj.domain.User;
import com.zj.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private MyAuthenticationFailureHandler failureHandler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User user = userMapper.findUserByUsername(username);
        if (user != null){
            //查询用户的权限
            List<Permission> permissionList = userMapper.findPermissionByUsername(username);
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
            for (Permission permission : permissionList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermTag());
                grantedAuthorityList.add(grantedAuthority);
            }
            user.setAuthorities(grantedAuthorityList);
        }
        return user;
    }
}
