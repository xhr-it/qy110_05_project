package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.RoleMenuMapper;
import com.aaa.model.Role;
import com.aaa.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xhr
 * @date 2020/7/17
 **/
@Service
public class RoleMenuService extends BaseService<RoleMenu> {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * @param [roleMenu]
     * @return java.lang.Integer
     * @date 2020/7/17 10:20
     * 新增角色权限中间表
     */
    public Integer insertRoleMenu(RoleMenu roleMenu){
        if (roleMenu != null) {
            return roleMenuMapper.insert(roleMenu);
        }
        return null;
    }

}
