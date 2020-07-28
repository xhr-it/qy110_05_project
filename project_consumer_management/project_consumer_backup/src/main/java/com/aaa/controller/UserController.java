package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author sheep
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IProjectService projectService;

    @GetMapping("/selectUser")
    public ResultData selectUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return projectService.selectUser(pageNo,pageSize);
    }

    @PostMapping("/selectOneUser")
    public ResultData selectOneUser(@RequestParam("id") Integer id){
        return projectService.selectOneUser(id);
    };

    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody User user){
        return projectService.addUser(user);
    }

    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody User user){
        return projectService.updateUser(user);
    }

    @PostMapping("/deleteUser")
    public ResultData deleteUser(@RequestBody User user){
        return projectService.deleteUser(user);
    }

    @PostMapping("/deleteAllUser")
    public ResultData deleteAllUser(@RequestBody List<Integer> ids){
        return projectService.deleteAllUser(ids);
    }


}
