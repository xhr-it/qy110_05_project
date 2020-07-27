package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.UserMapper;
import com.aaa.model.User;
import com.aaa.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 用户管理service
 * @author sheep
 */
@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询集合
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo selectUser(Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Map> list = userMapper.selectUser(pageNo, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        if (list != null && list.size() > 0){
            return pageInfo;
        }
        return null;
    }

    /**
     * 查询用户的详细信息
     * @param id
     * @return
     */
    public UserVo selectOneUser(Integer id){
        UserVo userVo = new UserVo();
        if (id == null) {
            return userVo.setIfSuccess(false);
        }
        User user = userMapper.selectOneUser(id);
        if (user == null) {
            return userVo.setIfSuccess(false);
        }
        String deptName = userMapper.selectDeptName(id);
        if (deptName == null) {
            return userVo.setIfSuccess(false);
        }
        String roleName = userMapper.selectRoleName(id);
        if (roleName == null) {
            return userVo.setIfSuccess(false);
        }
        return userVo.setIfSuccess(true).setUser(user).setDeptName(deptName).setRoleName(roleName);
    }

    /**
     * 新增用户
     * @param map
     * @return
     */
    @Transactional
    public UserVo addUser(Map map){
        UserVo userVo = new UserVo();
        if (map == null && map.size() == 0){
            return userVo.setIfSuccess(false);
        }
        Integer resultUser  = userMapper.addUser(map);
        if (resultUser == null && resultUser == 0) {
            return userVo.setIfSuccess(false);
        }
        Object id = map.get("id");
        map.put("userId",id);
        Integer resultUSerRole = userMapper.addUserRole(map);
        if (resultUSerRole == null && resultUSerRole == 0) {
            return userVo.setIfSuccess(false);
        }
        return userVo.setIfSuccess(true).setResult(resultUser+resultUSerRole);
    }

    /**
     * 更新用户
     * @param map
     * @return
     */
    @Transactional
    public UserVo updateUser(Map map){
        UserVo userVo = new UserVo();
        if (map == null && map.size() == 0){
            return userVo.setIfSuccess(false);
        }
        Integer userResult = userMapper.updateUser(map);
        Integer userRoleResult = userMapper.updateUserRole(map);
        if (userResult == null && userResult == 0 ||
            userRoleResult == null && userRoleResult == 0){
            return userVo.setIfSuccess(false);
        }
        return userVo.setIfSuccess(true).setResult(userResult+userRoleResult);
    }

    /**
     * 根据主键删除用户
     * @param user
     * @return
     */
    @Transactional
    public UserVo deleteUser(User user){
        UserVo userVo = new UserVo();
        if (user == null) {
            return userVo.setIfSuccess(false);
        }
        Integer delete = userMapper.delete(user);
        Integer deleteUserRole = userMapper.deleteUserRole(user.getId());
        if (delete != null && delete == 0 ||
            deleteUserRole != null && deleteUserRole == 0){
            return userVo.setIfSuccess(false);
        }
        return userVo.setIfSuccess(true).setResult(delete+deleteUserRole);
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @Transactional
    public UserVo deleteAllUser(List<Integer> ids){
        UserVo userVo = new UserVo();
        if (ids != null && ids.size() == 0){
            return userVo.setIfSuccess(false);
        }
        Integer deleteByIds = super.deleteByIds(ids);
        for (Integer id : ids) {
            Integer deleteUserRole = userMapper.deleteUserRole(Long.valueOf(id));
            if (deleteUserRole == null && deleteUserRole == 0) {
                return userVo.setIfSuccess(false);
            }
        }
        return userVo.setIfSuccess(true).setResult(deleteByIds);
    }

}
