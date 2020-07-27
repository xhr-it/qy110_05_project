package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomCheckController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * 根据随机数分页抽查单位
     * @param proportion
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/selectRandomMappingUnit")
    public ResultData selectRandomMappingUnit(Double proportion, Integer pageNo, Integer pageSize){
        return iProjectService.selectRandomMappingUnit(proportion,pageNo,pageSize);
    }

    /**
     * 根据随机数查询人员
     * @param proportion
     * @return
     */
    @GetMapping("/selectRandomCheckPerson")
    public ResultData selectRandomCheckPerson(Double proportion){
        return iProjectService.selectRandomCheckPerson(proportion);
    }
}
