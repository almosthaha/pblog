package com.lyg.blogapi.controller;

import com.lyg.blogapi.dao.pojo.SysUser;
import com.lyg.blogapi.utils.UserThreadlocal;
import com.lyg.blogapi.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/1 10:52
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        //怎么保存用户信息
        SysUser sysUser = UserThreadlocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
