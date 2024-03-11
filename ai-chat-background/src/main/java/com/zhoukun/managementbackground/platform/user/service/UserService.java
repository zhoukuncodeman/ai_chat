package com.zhoukun.managementbackground.platform.user.service;

import com.zhoukun.managementbackground.platform.user.mapper.UserMapper;
import com.zhoukun.managementbackground.platform.user.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public User findByUsername(User user){
        return userMapper.findByUsername(user.getUsername());
    }
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}