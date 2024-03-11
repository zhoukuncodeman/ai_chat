package com.zhoukun.managementbackground.platform.user.controller;

import com.zhoukun.managementbackground.platform.user.pojo.UserLoginInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description：TODO
 * @author： sc
 * @create： 2024/1/30 17:45
 */

@RestController
@RequestMapping("/management/platform/user/login")
public class UserLoginController {

    @RequestMapping("doLogin")
    public Object doLogin(@RequestBody UserLoginInfo userLoginInfo){
        Map<String, String> data = new HashMap<>();
        data.put("code", "200");
        data.put("data", "tokenaaaa");
        return data;
    }


}
