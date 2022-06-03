package com.lyg.blogapi.utils;

import com.lyg.blogapi.dao.pojo.SysUser;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/1 11:36
 */
public class UserThreadlocal {
    //线程变量隔离 想要在每个线程里面存储每个线程的特性信息就用到threadlocl
    //设置为私有的字段
    private UserThreadlocal(){};

    private static final ThreadLocal<SysUser> LOCAL=new ThreadLocal<>();

    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
