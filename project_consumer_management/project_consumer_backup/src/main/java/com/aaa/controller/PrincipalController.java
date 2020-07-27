package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Principal;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author CZT
 * @date 2020/7/24 20:20
 * 单位负责人信息
 */
@RestController
public class PrincipalController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询单位负责人信息
     **/
    @PostMapping("/selectPrincipal")
    public ResultData selectPrincipal(@RequestBody HashMap hashMap){
        return iProjectService.selectPrincipal(hashMap);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单个单位负责人信息
     **/
    @GetMapping("/selectOnePrincipal")
    public ResultData selectOnePrincipal(@RequestParam("id") Long id){
        return iProjectService.selectOnePrincipal(id);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询单个单位负责人信息
     **/
    @PostMapping("/selectOnePrincipal")
    public ResultData selectOnePrincipal(@RequestBody Principal principal){
        return iProjectService.selectOnePrincipal(principal);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [principal]
     * @return com.aaa.base.ResultData
     *****修改单位负责人信息
     **/
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal){
        return iProjectService.updatePrincipal(principal);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [principal]
     * @return com.aaa.base.ResultData
     *****删除单位负责人信息
     **/
    @PostMapping("/deletePrincipal")
    public ResultData deletePrincipal(@RequestBody Principal principal){
        return iProjectService.deletePrincipal(principal);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [principal]
     * @return com.aaa.base.ResultData
     *****新增单位负责人信息
     **/
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestBody Principal principal){
        return iProjectService.addPrincipal(principal);
    }

}
