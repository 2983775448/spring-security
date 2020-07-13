package com.zj.security;

import com.zj.domain.Permission;
import com.zj.domain.User;
import com.zj.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyUserDetailsService implements UserDetailsService {

    private Logger logger =Logger.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        User user = userMapper.findUserByUsername(username);
        if (user != null){
            //查询用户权限
            List<Permission> permissionList = userMapper.findPerssionByUsername(username);
            //authorities存放用户权限
            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
            for (Permission permission : permissionList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermTag());
                authorityList.add(authority);
            }
            logger.info("当前用户："+user.toString()+"当前用户权限:"+permissionList.toString());
            //把所有的权限授权给user
            user.setAuthorities(authorityList);
        }
        return user;
    }
}
