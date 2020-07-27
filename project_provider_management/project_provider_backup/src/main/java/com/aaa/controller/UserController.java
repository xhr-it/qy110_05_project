package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.UserService;
import com.aaa.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户管理controller
 * @author sheep
 */
@RestController
public class UserController extends CommonController<User> {

    @Autowired
    private UserService userService;

    @Override
    public BaseService getBaseService() {
        return userService;
    }

    /**
     * 分页查询用户
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/selectUser")
    public ResultData selectUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = userService.selectUser(pageNo, pageSize);
        if (pageInfo.getSize() > 0){
            return super.operationSuccess(pageInfo);
        }
        return super.operationFailed("未找到数据");
    }

    /**
     * 根据主键查询用户详细信息
     * @param id
     * @return
     */
    @PostMapping("/selectOneUser")
    public ResultData selectOneUser(@RequestParam Integer id){
        UserVo userVo = userService.selectOneUser(id);
        if (userVo.getIfSuccess()){
            return super.operationSuccess(userVo);
        }
        return super.operationFailed("找不到该用户");
    }

    /**
     * 新增用户
     * @param map
     * @return
     */
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody Map map){
        UserVo userVo = userService.addUser(map);
        if (userVo.getIfSuccess()) {
            return super.operationSuccess(userVo.getResult());
        }
        return super.operationFailed("插入失败");
    }

    /**
     * 修改用户
     * @param map
     * @return
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody Map map){
        UserVo userVo = userService.updateUser(map);
        if (userVo.getIfSuccess()){
            return super.operationSuccess(userVo.getResult());
        }
        return super.operationFailed();
    }

    /**
     * 根据主键删除用户
     * @param user
     * @return
     */
    @PostMapping("/deleteUser")
    public ResultData deleteUser(@RequestBody User user){
        UserVo userVo = userService.deleteUser(user);
        if (userVo.getIfSuccess()){
            return super.operationSuccess(userVo.getResult());
        }
        return super.operationFailed();
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @PostMapping("/deleteAllUser")
    public ResultData deleteAllUser(@RequestBody List<Integer> ids){
        UserVo userVo = userService.deleteAllUser(ids);
        if (userVo.getIfSuccess()){
            return super.operationSuccess(userVo.getResult());
        }
        return super.operationFailed();
    }
}
