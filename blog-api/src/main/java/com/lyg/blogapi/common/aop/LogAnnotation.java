package com.lyg.blogapi.common.aop;

import java.lang.annotation.*;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/3 21:53
 */

//使用aop记录日志

//type 代表可以放在类上面 method 代表可以放在方法上
@Target({ElementType.FIELD, ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    //开发注解

    String module() default "";

    String operator() default "";
}
