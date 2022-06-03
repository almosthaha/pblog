package com.lyg.blogapi.controller;

import com.lyg.blogapi.common.aop.LogAnnotation;
import com.lyg.blogapi.service.LoginService;
import com.lyg.blogapi.vo.Result;
import com.lyg.blogapi.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
//    @Autowired
//    private SysUserService sysUserService;

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){
        //登录 验证用户  访问用户表，但是
        return loginService.login(loginParam);
    }
}
