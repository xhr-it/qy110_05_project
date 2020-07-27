package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.SpecialPost;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author CZT
 * @date 2020/7/24 20:30
 * 特殊岗位人员信息
 */
@RestController
public class SpecialPostController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息分页查询
     **/
    @PostMapping("/selectAllSpecialPost")
    public ResultData selectAllSpecialPost(@RequestBody HashMap hashMap){
        return iProjectService.selectAllSpecialPost(hashMap);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息单条查询
     **/
    @PostMapping("/selectOneSpecialPost")
    public ResultData selectOneSpecialPost(@RequestBody SpecialPost specialPost){
        return iProjectService.selectOneSpecialPost(specialPost);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [specialPost]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息新增
     **/
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(@RequestBody SpecialPost specialPost){
        return iProjectService.addSpecialPost(specialPost);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [id]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息根据id删除
     **/
    @GetMapping("/deleteSpecialPost")
    public ResultData deleteSpecialPost(@RequestParam("id") Long id){
        return iProjectService.deleteSpecialPost(id);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [specialPost]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息修改
     **/
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost){
        return iProjectService.updateSpecialPost(specialPost);
    }

}
