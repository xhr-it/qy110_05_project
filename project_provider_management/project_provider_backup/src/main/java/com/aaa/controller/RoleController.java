package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.model.Role;
import com.aaa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xhr
 * @date 2020/7/16
 **/
@RestController
public class RoleController extends CommonController<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<Role> getBaseService() {
        return roleService;
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 20:03
     * 查询所有角色
     */
    @PostMapping("/getAllRole")
    public ResultData getRoleList(){
        List<Role> roleList = roleService.selectList(null);
        if (roleList != null && roleList.size() > 0) {
            return getSuccess(roleList);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [role]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 20:49
     * 新增角色
     */
    @PostMapping("/insertRole")
    public ResultData insertRole(@RequestBody Role role){
        if (role != null) {
            role.setCreateTime(new Date());
        }
        return roleService.insertData(role);
    }

    /**
     * @param [ids]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 21:02
     * 根据id批量删除角色
     */
    @PostMapping("/deleteRoleByIds")
    public ResultData deleteRoleByIds(@RequestBody List<Long> ids){
        Integer integer = roleService.batchDeleteRole(ids);
        if (integer > 0){
            return deleteSuccess();
        }else {
            return deleteFalse();
        }
    }

    /**
     * @param [roleId]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 21:24
     * 根据id查询角色
     */
    @GetMapping("/selectRoleById")
    public ResultData selectRoleById(@RequestParam("roleId") Long roleId){
        Role roleById = roleService.getRoleById(roleId);
        if (roleById != null) {
            return getSuccess(roleById);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [roleId]
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 21:57
     * 根据权限id查询菜单
     */
    @GetMapping("/getMenuByRoleId")
    public ResultData getMenuByRoleId(@RequestParam("roleId") Long roleId){
        List<Menu> menuByRoleId = roleService.getMenuByRoleId(roleId);
        if (menuByRoleId != null) {
            return getSuccess(menuByRoleId);
        }else {
            return getFalse();
        }
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 22:55
     * 修改角色，以及对该角色的权限进行分配
     */
    @PostMapping("/updateRoleAndMenu")
    public ResultData updateRoleAndMenu(@RequestBody Map map){
        Boolean aBoolean = roleService.updateRoleAndMenu(map);
        if (aBoolean){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }
}
