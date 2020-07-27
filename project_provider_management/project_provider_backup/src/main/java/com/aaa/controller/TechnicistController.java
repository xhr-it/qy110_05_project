package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Technicist;
import com.aaa.service.TechnicistService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CZT
 * @date 2020/7/18 8:59
 *
 */
@RestController
public class TechnicistController extends CommonController<Technicist> {

    @Autowired
    private TechnicistService technicistService;

    @Override
    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询技术人员信息
    **/
    @PostMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestBody HashMap hashMap){
        PageInfo pageInfo = technicistService.selectAllTechnicist(hashMap);
        if (pageInfo != null || !("").equals(pageInfo)) {
            return getSuccess(pageInfo);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单条人员信息
    **/
    @GetMapping("/selectOneAllTechnicist")
    public ResultData selectOneAllTechnicist(@RequestParam("id") Long id){
        List<Technicist> technicists = technicistService.selectOneTechnicist(id);
        if (technicists != null) {
            return getSuccess(technicists);
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
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestBody Technicist technicist){
        technicist.setCreateTime(new Date());
        technicist.setModifyTime(new Date());
        Integer add = getBaseService().add(technicist);
        if (add>0) {
            return getSuccess(add);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条
    **/
    @GetMapping("/selectOneTechnicist")
    public ResultData selectOneTechnicist(@RequestBody Technicist technicist){
        Technicist selectOne = getBaseService().selectOne(technicist);
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
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist){
        Integer update = getBaseService().update(technicist);
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
    @PostMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(@RequestBody Technicist technicist){

        Integer delete = getBaseService().delete(technicist);
        if (delete>0) {
            return getSuccess(delete);
        }else {
            return getFalse();
        }
    }
}
