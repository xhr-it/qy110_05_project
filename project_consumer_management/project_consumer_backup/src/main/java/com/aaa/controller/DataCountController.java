package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xhr
 * @date 2020/7/27
 * 数据统计
 **/
@RestController
public class DataCountController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/27 20:46
     * 数据统计-资质项目汇总统计-项目类型统计
     */
    @GetMapping("/getProjectByStatus")
    ResultData getProjectByStatus(){
        return iProjectService.getProjectByStatus();
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/27 21:43
     * 数据统计-资质项目汇总统计-单位资质统计
     */
    @GetMapping("/getUnitByLevel")
    ResultData getUnitByLevel(){
        return iProjectService.getUnitByLevel();
    }
}
