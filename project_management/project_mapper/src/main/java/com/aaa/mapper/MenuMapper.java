package com.aaa.mapper;

import com.aaa.model.Menu;
import com.aaa.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {

    /**
     * @param [userId]
     * @return java.util.List<com.aaa.model.Menu>
     * @date 2020/7/16 19:11
     * 根据当前登录人的id查询可以操作的菜单（一级菜单）
     */
    List<Menu> getMenuByUserId(Long userId);

    /**
     * @param [parentId]
     * @return java.util.List<com.aaa.model.Menu>
     * @date 2020/7/16 14:54
     * 根据父id查询子菜单
     */
    List<Menu> getMenuByParentId(Long parentId);
}