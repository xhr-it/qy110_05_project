package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Technicist;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author CZT
 * @date 2020/7/24 20:36
 * 技术人员信息
 */
@RestController
public class TechnicistController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询技术人员信息
     **/
    @PostMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestBody HashMap hashMap){
        return iProjectService.selectAllTechnicist(hashMap);
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单条技术人员信息
     **/
    /*@GetMapping("/selectOneTechnicist")
    public ResultData selectOneTechnicist(@RequestParam("id") Long id){
        return iProjectService.selectOneTechnicist(id);
    }*/
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****新增技术人员信息
     **/
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestBody Technicist technicist){
        return iProjectService.addTechnicist(technicist);
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条技术人员信息
     **/
    /*@GetMapping("/selectOneTechnicist")
    public ResultData selectOneTechnicist(@RequestBody Technicist technicist){
        return iProjectService.selectOneTechnicist(technicist);
    }*/
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****修改技术人员信息
     **/
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist){
        return iProjectService.updateTechnicist(technicist);
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****删除技术人员信息
     **/
    @PostMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(@RequestBody Technicist technicist){
        return iProjectService.deleteTechnicist(technicist);
    }
}
