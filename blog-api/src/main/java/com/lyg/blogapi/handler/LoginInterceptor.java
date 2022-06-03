package com.lyg.blogapi.handler;

import com.alibaba.fastjson.JSON;
import com.lyg.blogapi.dao.pojo.SysUser;
import com.lyg.blogapi.service.LoginService;
import com.lyg.blogapi.utils.UserThreadlocal;
import com.lyg.blogapi.vo.ErrorCode;
import com.lyg.blogapi.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 为什么需要登录拦截器
 * 1.每次访问需要登录的资源的时候，都需要在代码中进行判断，一旦登录的逻辑有所改变，
 * 代码都得进行变动，非常不合适
 * 2.那么可不可以统一进行登录判断呢
 * 3.可以，使用登录拦截器，进行登录拦截，如果遇到需要登录才能访问的接口,如果未登录，拦截器直接返回
 * 并跳转到登录页面
 *
 * 原理:登录成功放到redis里面,在访问这个接口的时候，只要传这个token，那么后台就会认为登录验证成功
 * 拦截器就会放行，那么就可以访问对应接口的功能
 */

//标识为Component 让spring能够识别
@Component
//注入日志
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;
    @Override


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行controller方法(Handler)之前进行执行
        //重写preHandler
        /**
         * 1. 需要判断 请求的接口路径 是否为 HandlerMethod (controller方法)
         * 2. 判断 token是否为空，如果为空 未登录
         * 3. 如果token 不为空，登录验证 loginService checkToken
         * 4. 如果认证成功 放行即可
         */
        if (!(handler instanceof HandlerMethod)){
            //handler 可能是 RequestResourceHandler springboot 程序 访问静态资源 默认去classpath下的static目录去查询
            //如果不是访问controller,直接放行
            return true;
        }

        //token在header里面
        String token = request.getHeader("Authorization");

        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");


        if (StringUtils.isBlank(token)){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser == null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //登录验证成功，放行

        //我希望在controller中 直接获取用户的信息 怎么获取?
        UserThreadlocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除，ThreadLocal中用完的信息 会有内存泄露的风险
        //所有的方法都执行完要执行收尾工作，那么userThreadlocal就没有用，要把它删除掉
        //要把为什么要有内存泄露风险搞清楚 非常有技术涵量
        UserThreadlocal.remove();
    }
}
