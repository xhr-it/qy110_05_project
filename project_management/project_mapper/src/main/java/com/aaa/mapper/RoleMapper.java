package com.aaa.mapper;

import com.aaa.model.Menu;
import com.aaa.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {

    /**
     * @param [roleId]
     * @return java.util.List<com.aaa.model.Menu>
     * @date 2020/7/16 21:51
     * 根据角色id查询对应权限
     */
    List<Menu> getMenuByRoleId(Long roleId);

    /**
     * @param [roleId]
     * @return java.lang.Integer
     * @date 2020/7/17 8:58
     * 根据角色id删除对应的权限
     */
    Integer deleteMenuByRoleId(Long roleId);
}