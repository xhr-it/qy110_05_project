package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xhr
 * @date 2020/7/28
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/28 15:28
     * 查询所有菜单
     */
    @GetMapping("/getAllMenu")
    ResultData getMenuList(){
        return iProjectService.getMenuList();
    }
}
