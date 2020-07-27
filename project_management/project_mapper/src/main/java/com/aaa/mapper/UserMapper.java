package com.aaa.mapper;


import com.aaa.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author sheep
 */
public interface UserMapper extends Mapper<User> {
    /**
     *  分页查询用户
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Map> selectUser(Integer pageNo, Integer pageSize);

    /**
     * 根据主键查询用户详细信息
     * @param id
     * @return
     */
    User selectOneUser(Integer id);

    /**
     * 根据主键查询用户部门
     * @param id
     * @return
     */
    String selectDeptName(Integer id);

    /**
     * 根据主键查询用户角色
     * @param id
     * @return
     */
    String selectRoleName(Integer id);

    /**
     * 新增用户
     * @param map
     * @return
     */
    Integer addUser(Map map);

    /**
     * 新增用户时的角色
     * @param map
     * @return
     */
    Integer addUserRole(Map map);

    /**
     * 修改用户信息
     * @param map
     * @return
     */
    Integer updateUser(Map map);

    /**
     * 修改用户角色
     * @param map
     * @return
     */
    Integer updateUserRole(Map map);

    /**
     * 删除用户对应角色
     * @param userId
     * @return
     */
    Integer deleteUserRole(Long userId);

}