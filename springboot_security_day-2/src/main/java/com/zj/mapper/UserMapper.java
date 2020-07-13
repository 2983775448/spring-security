package com.zj.mapper;

import com.zj.domain.Permission;
import com.zj.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据用户名查找用户
    User findUserByUsername(String username);
    //根据用户名查找用户权限
    List<Permission> findPermissionByUsername(String username);
}
