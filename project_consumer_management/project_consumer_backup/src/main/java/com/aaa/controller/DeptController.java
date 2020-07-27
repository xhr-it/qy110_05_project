package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author CZT
 * @date 2020/7/23 19:14
 */
@RestController
public class DeptController extends BaseController {

    @Autowired
    private IProjectService iProjectService;
    /***
     * @author CZT
     * @date 2020/7/23
     * @param []
     * @return com.aaa.base.ResultData<com.aaa.model.Dept>
     *****查询所有的一级部门以及其下面的子部门
    **/
    @GetMapping("/deptList")
    public ResultData deptList(){
        return iProjectService.deptList();
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条部门信息
    **/
    @PostMapping("/selectOneDept")
    public ResultData selectOneDept(@RequestBody Dept dept){
        return iProjectService.selectOneDept(dept);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dept]
     * @return com.aaa.base.ResultData
     *****添加部门信息
     **/
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept){
        return iProjectService.addDept(dept);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dept]
     * @return com.aaa.base.ResultData
     *****删除部门信息
     **/
    @PostMapping("/deleteDept")
    public ResultData deleteDept(@RequestBody Dept dept){
        return iProjectService.deleteDept(dept);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [ids]
     * @return com.aaa.base.ResultData
     *****批量删除部门信息
     **/
    @PostMapping("/deleteDeptAll")
    public ResultData deleteDeptAll(@RequestBody List<Long> ids){
        return iProjectService.deleteDeptAll(ids);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dept]
     * @return com.aaa.base.ResultData
     *****修改部门信息
     **/
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept){
        return iProjectService.updateDept(dept);
    }

}
