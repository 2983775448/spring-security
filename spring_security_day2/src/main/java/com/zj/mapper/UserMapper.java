package com.zj.mapper;

import com.zj.domain.Permission;
import com.zj.domain.User;

import java.util.List;

public interface UserMapper {

    //根据用户账号查询用户信息
    User findUserByUsername(String username);
    //查询用户权限
    List<Permission> findPerssionByUsername(String username);
    //修改用户的密码
    int updatePassword(User user);
}
