package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xhr
 * @date 2020/7/16
 * 菜单管理
 **/
@RestController
public class MenuController extends CommonController {

    @Autowired
    private MenuService menuService;

    @Override
    public BaseService getBaseService() {
        return menuService;
    }

    /**
     * @param [userId]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 19:08
     * 根据当前登录人的id查询可以操作的菜单（一级菜单）
     */
    @GetMapping("/getMenuByUserId")
    public ResultData getMenuByUserId(@RequestParam("userId") Long userId){
        List<Menu> menuByUserId = menuService.getMenuByUserId(userId);
        if (menuByUserId != null && menuByUserId.size() > 0) {
            return getSuccess(menuByUserId);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [parentId]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 15:14
     * 根据父菜单id查询子菜单
     */
    @GetMapping("/getMenuByParentId")
    public ResultData getMenuByParentId(@RequestParam("parentId") Long parentId){
        List<Menu> menuByParentId = menuService.getMenuByParentId(parentId);
        if (menuByParentId != null && menuByParentId.size() > 0) {
            return getSuccess(menuByParentId);
        }else {
            return getFalse();
        }
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 14:45
     * 查询所有菜单
     */
    @GetMapping("/getAllMenu")
    public ResultData getMenuList(){
        List<Menu> menuList = menuService.selectList(null);
        if (menuList != null && menuList.size() > 0) {
            return getSuccess(menuList);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [menu]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 15:42
     * 新增菜单
     */
    @PostMapping("/insertMenu")
    public ResultData insertMenu(@RequestBody Menu menu){
        if (menu != null) {
            menu.setCreateTime(new Date());
        }
        return menuService.insertData(menu);
    }

    /**
     * @param [ids]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 16:02
     * 根据id批量删除菜单
     */
    @PostMapping("/deleteMenuByIds")
    public ResultData deleteMenuByIds(@RequestBody List<Long> ids){
        System.out.println(ids);
        Integer integer = menuService.batchDeleteMenu(ids);
        if (integer > 0){
            return deleteSuccess();
        }else {
            return deleteFalse();
        }
    }

    /**
     * @param [menuId]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 17:57
     * 根据id查询菜单
     */
    @GetMapping("/selectMenuById")
    public ResultData selectMenuById(@RequestParam("menuId") Long menuId){
        Menu menu = menuService.selectMenuById(menuId);
        if (menu != null) {
            return getSuccess(menu);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [menu]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 18:22
     * 更新菜单
     */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestBody Menu menu){
        Integer update = menuService.update(menu);
        if (update > 0){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }

}
