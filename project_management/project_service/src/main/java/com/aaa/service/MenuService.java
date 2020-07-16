package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MenuMapper;
import com.aaa.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @author xhr
 * @date 2020/7/16
 **/
@Service
public class MenuService extends BaseService<Menu> {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * @param [userId]
     * @return java.util.List<com.aaa.model.Menu>
     * @date 2020/7/16 19:37
     * 根据当前登录人的id查询可以操作的菜单（一级菜单）
     */
    public List<Menu> getMenuByUserId(Long userId){
        if (userId != null){
            return menuMapper.getMenuByUserId(userId);
        }
        return null;
    }

    /**
     * @param [parentId]
     * @return java.util.List<com.aaa.model.Menu>
     * @date 2020/7/16 15:08
     * 根据父id查询子菜单
     */
    public List<Menu> getMenuByParentId(Long parentId){
        if (parentId != null) {
            return menuMapper.getMenuByParentId(parentId);
        }
        return null;
    }

    /**
     * @param [menuIds]
     * @return java.lang.Integer
     * @date 2020/7/16 17:29
     * 根据id批量删除菜单
     */
    public Integer batchDeleteMenu(List<Long> menuIds) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("menuId", menuIds)).build();
        return menuMapper.deleteByExample(example);
    }

    /**
     * @param [menuId]
     * @return com.aaa.model.Menu
     * @date 2020/7/16 18:03
     * 根据id查询菜单
     */
    public Menu selectMenuById(Long menuId){
        if (menuId != null) {
            return menuMapper.selectByPrimaryKey(menuId);
        }
        return null;
    }

}
