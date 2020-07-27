package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Principal;
import com.aaa.service.PrincipalService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CZT
 * @date 2020/7/17 19:49
 */
@RestController
public class PrincipalController extends CommonController<Principal> {

    @Autowired
    private PrincipalService principalService;

    @Override
    public BaseService<Principal> getBaseService() {
        return principalService;
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询单位负责人信息
    **/
    @PostMapping("/selectPrincipal")
    public ResultData selectPrincipal(@RequestBody HashMap hashMap){
        PageInfo pageInfo = principalService.selectPrincipal(hashMap);
        if (pageInfo != null || !("").equals(pageInfo)) {
            return getSuccess(pageInfo);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单个单位负责人信息
    **/
    @GetMapping("/selectOnePrincipal")
    public ResultData selectOnePrincipal(@RequestParam("id") Long id){
        List<Principal> principals = principalService.selectOnePrincipal(id);
        if (principals != null || !"".equals(principals)) {
            return getSuccess(principals);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询单条
    **/
    @PostMapping("/selectOnePrincipal")
    public ResultData selectOnePrincipal(@RequestBody Principal principal){
        Principal selectOne = getBaseService().selectOne(principal);
        if (selectOne != null) {
            return getSuccess(selectOne);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****修改
    **/
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal){
        Integer update = getBaseService().update(principal);
        if (update>0) {
            return getSuccess(update);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****删除
    **/
    @PostMapping("/deletePrincipal")
    public ResultData deletePrincipal(@RequestBody Principal principal){
        Integer delete = getBaseService().delete(principal);
        if (delete>0) {
            return getSuccess(delete);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****新增
    **/
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestBody Principal principal){
        principal.setCreateTime(new Date());
        principal.setModifyTime(new Date());
        Integer add = getBaseService().add(principal);
        if (add>0) {
            return getSuccess(add);
        }else {
            return getFalse();
        }
    }

}
