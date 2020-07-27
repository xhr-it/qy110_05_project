package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/17 18:50
 * 测绘单位
 */
@RestController
public class MappingUnitController extends CommonController<MappingUnit> {

    @Autowired
    private MappingUnitService mappingUnitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单位信息
    **/
    @GetMapping("/selectOneMappingUnit")
    public ResultData selectOneMappingUnit(@RequestParam("id") Long id){
        MappingUnit mappingUnits = mappingUnitService.selectOneMappingUnit(id);
        if (mappingUnits != null) {
            return getSuccess(mappingUnits);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/21
     * @param [mappingUnit]
     * @return com.aaa.base.ResultData
     *****修改单位信息
    **/
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit){
        Integer update = mappingUnitService.update(mappingUnit);
        if (update > 0 || ("").equals(update)) {
            return getSuccess(update);
        }else {
            return getFalse();
        }
    }

    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****白名单
    **/
    @PostMapping("/selectStatusOneMappingUnit")
    public ResultData selectStatusOneMappingUnit(@RequestBody HashMap hashMap){
        PageInfo pageInfo = mappingUnitService.selectStatusOneMappingUnit(hashMap);
        if (pageInfo != null || ("").equals(pageInfo)) {
            return getSuccess(pageInfo);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****黑名单
    **/
    @PostMapping("/selectStatusTwoMappingUnit")
    public ResultData selectStatusTwoMappingUnit(@RequestBody HashMap hashMap){
        PageInfo pageInfo = mappingUnitService.selectStatusTwoMappingUnit(hashMap);
        if (pageInfo != null || ("").equals(pageInfo)) {
            return getSuccess(pageInfo);
        }else {
            return getFalse();
        }
    }
}
