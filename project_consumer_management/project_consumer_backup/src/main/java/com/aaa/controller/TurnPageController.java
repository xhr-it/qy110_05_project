package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xhr
 * @date 2020/7/28
 * 负责页面跳转
 **/
@Controller
public class TurnPageController {

    /**
     * @param []
     * @return java.lang.String
     * @date 2020/7/28 9:51
     * 跳转到登录页
     */
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

    /**
     * @param []
     * @return java.lang.String
     * @date 2020/7/28 9:52
     * 跳转到首页
     */
    @GetMapping("/toIndexPage")
    public String toIndex(){
        return "index";
    }

    /**
     * @param []
     * @return java.lang.String
     * @date 2020/7/28 15:24
     * 跳转到菜单管理页面
     */
    @GetMapping("/menu")
    public String toMenu(){
        return "menu";
    }

    /**
     * @param []
     * @return java.lang.String
     * @date 2020/7/28 15:09
     * 跳转到用户管理页面
     */
    @GetMapping("/admin")
    public String toAdmin(){
        return "admin";
    }

    /**
     * @param []
     * @return java.lang.String
     * @date 2020/7/28 15:48
     * 跳转到角色管理页面
     */
    @GetMapping("/role")
    public String toRole(){
        return "role";
    }
}
