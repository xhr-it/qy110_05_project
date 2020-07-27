package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import com.aaa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author CZT
 * @date 2020/7/16 9:42
 * 部门增删改
 */
@RestController
public class DeptController extends CommonController<Dept> {
    @Autowired
    private DeptService deptService;

    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }

    /**
     * 查询所有的一级部门以及其下面的子部门
     * @return
     */
    @GetMapping("/deptList")
    public ResultData deptList(){
        List<Dept> deptList = deptService.deptList();
        if (deptList != null && deptList.size() > 0) {
            return super.getSuccess(deptList);
        }else {
            return super.getFalse();
        }
    }

    /**
     * 查询一条部门信息
     * @param map
     * @return
     */
    @PostMapping("/selectOneDept")
    public ResultData selectOneDept(@RequestBody Dept dept){
        Dept dept1 = getBaseService().selectOne(dept);
        if (dept1 != null) {
            return getSuccess(dept1);
        }else {
            return getFalse();
        }
    }

    /**
     * 添加部门信息
     * @param dept
     * @return
     */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept){
        dept.setCreateTime(new Date());
        dept.setModifyTime(new Date());
        Integer add = getBaseService().add(dept);
        if (add>0) {
            return getSuccess(add);
        }else {
            return getFalse();
        }
    }

    /**
     * 删除部门信息
     * @param dept
     * @return
     */
    @PostMapping("/deleteDept")
    public ResultData deleteDept(@RequestBody Dept dept) {
        Integer delete = getBaseService().delete(dept);
        if (delete>0) {
            return getSuccess(delete);
        }else {
            return getFalse();
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteDeptAll")
    public ResultData deleteDeptAll(@RequestParam List<Long> ids){
        Integer integer = deptService.deleteDeptAll(ids);
        if (integer > 0) {
            return super.deleteSuccess();
        }else {
            return super.deleteFalse();
        }
    }

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept){
        Integer update = deptService.update(dept);
        if (update > 0) {
            return super.updateSuccess();
        }else {
            return super.updateFalse();
        }
    }
}
