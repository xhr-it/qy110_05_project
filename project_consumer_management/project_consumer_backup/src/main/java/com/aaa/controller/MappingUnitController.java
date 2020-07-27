package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @author CZT
 * @date 2020/7/24 20:16
 * 测绘单位
 */
public class MappingUnitController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单位信息
     **/
    @GetMapping("/selectOneMappingUnit")
    public ResultData selectOneMappingUnit(@RequestParam("id") Long id){
        return iProjectService.selectOneMappingUnit(id);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [mappingUnit]
     * @return com.aaa.base.ResultData
     *****修改单位信息
     **/
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit){
        return iProjectService.updateMappingUnit(mappingUnit);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****白名单查询
     **/
    @PostMapping("/selectStatusOneMappingUnit")
    public ResultData selectStatusOneMappingUnit(@RequestBody HashMap hashMap){
        return iProjectService.selectStatusOneMappingUnit(hashMap);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****黑名单查询
     **/
    @PostMapping("/selectStatusTwoMappingUnit")
    public ResultData selectStatusTwoMappingUnit(@RequestBody HashMap hashMap){
        return iProjectService.selectStatusTwoMappingUnit(hashMap);
    }

}
