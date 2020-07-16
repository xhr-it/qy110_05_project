package com.aaa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xhr
 * @date 2020/7/15
 * 用于登录日志的注解
 * Target：标识了自己所自定义注解的使用范围
 * Retention：标识了自定义注解所生效的时间
 *            RUNTIME：项目运行的时候该自定义生效
 *            TEST：在有junit的时候生效
 * Inherited：当有该注解的时候，自定义注解的作用范围必须是类；定义了自定义注解的类，子类默认具有该自定义注解。
 * 所有的注解是没有任何实际意义的，只是起到了一个标识的作用，真正有意义的代码在于实现了这个注解的业务逻辑
 * 自定义注解+AOP实现自动日志，真正实现的地方在于AOP，自定义注解只是做了一个标识
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {

    //要执行的操作类型：delete、update、insert
    String operationType();

    //所要执行的具体操作内容：删除用户、删除菜单、删除部门
    String operationName();
}
