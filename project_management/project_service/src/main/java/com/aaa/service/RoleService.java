package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.RoleMapper;
import com.aaa.mapper.RoleMenuMapper;
import com.aaa.model.Menu;
import com.aaa.model.Role;
import com.aaa.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xhr
 * @date 2020/7/16
 **/
@Service
public class RoleService extends BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * @param [menuIds]
     * @return java.lang.Integer
     * @date 2020/7/16 21:00
     * 根据id批量删除角色
     */
    public Integer batchDeleteRole(List<Long> menuIds) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("roleId", menuIds)).build();
        return roleMapper.deleteByExample(example);
    }

    /**
     * @param [roleId]
     * @return com.aaa.model.Role
     * @date 2020/7/16 21:24
     * 根据id查询角色
     */
    public Role getRoleById(Long roleId){
        if (roleId != null) {
            return roleMapper.selectByPrimaryKey(roleId);
        }
        return null;
    }

    /**
     * @param [roleId]
     * @return java.util.List<com.aaa.model.Menu>
     * @date 2020/7/16 21:51
     * 根据权限id查询菜单
     */
    public List<Menu> getMenuByRoleId(Long roleId){
        if (roleId != null) {
            return roleMapper.getMenuByRoleId(roleId);
        }
        return null;
    }

    /**
     * @param [map]
     * @return java.lang.Boolean
     * @date 2020/7/17 10:29
     * 修改角色
     */
    public Boolean updateRoleAndMenu(Map map){
        Role role = new Role();
        role.setCreateTime(new Date());
        role.setRoleId(Long.valueOf(map.get("roleId").toString())).setRoleName(map.get("roleName").toString()).setRemark(map.get("remark").toString());
        //1.修改角色
        Integer update = roleMapper.updateByPrimaryKey(role);
        //2.删除该角色对应的所有权限
        if (update > 0){
            Integer integer = roleMapper.deleteMenuByRoleId(role.getRoleId());
            //3.新增权限
            if (integer > 0){
                //获取前台传入的menuId的String字符串（"1-2-3-"）
                //因为map中获取的是Object类型，需要转为String
                String menuIdStr = map.get("menuIdStr").toString();
                System.out.println(menuIdStr);
                //当前String格式为"1-2-3-"以"-"分割转化为数组[1,2,3]
                String[] menuIdArr = menuIdStr.substring(0,menuIdStr.length()-1).split("-");
                for (int i = 0; i < menuIdArr.length; i++) {
                    System.out.println("遍历出menuId：");
                    System.out.println(menuIdArr[i]);
                    Long menuId = Long.valueOf(menuIdArr[i]);
                    //操作角色权限中间表
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId(role.getRoleId()).setMenuId(menuId);
                    Integer insertRoleMenu = roleMenuService.insertRoleMenu(roleMenu);
                    integer += insertRoleMenu;
                }
            }
            if (integer > 1){
                return true;
            }
        }
        return false;
    }
}
