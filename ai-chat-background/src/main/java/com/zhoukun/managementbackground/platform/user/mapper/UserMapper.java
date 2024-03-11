package com.zhoukun.managementbackground.platform.user.mapper;

import com.zhoukun.managementbackground.platform.user.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);
}