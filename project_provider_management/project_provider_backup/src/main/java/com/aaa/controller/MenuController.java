package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author xhr
 * @date 2020/7/16
 **/
public class MenuController extends CommonController {

    @Autowired
    private MenuService menuService;

    @Override
    public BaseService getBaseService() {
        return menuService;
    }

    @PostMapping("/getAllMenu")
    public ResultData getMenuList(){
        List<Menu> menuList = menuService.selectList(null);
        if (menuList != null && menuList.size() > 0) {
            return getSuccess(menuList);
        }else {
            return getFalse();
        }
    }
}
