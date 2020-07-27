package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.CheckPerson;
import com.aaa.service.RandomCheckService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 随机抽查模块controller
 * @author sheep
 */
@RestController
public class RandomCheckController extends CommonController {

    @Autowired
    private RandomCheckService randomCheckService;

    @Override
    public BaseService getBaseService() {
        return randomCheckService;
    }

    /**
     * 根据随机数分页抽查单位
     * @param proportion
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/selectRandomMappingUnit")
    public ResultData selectRandomMappingUnit(@RequestParam("proportion")Double proportion, @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = randomCheckService.selectRandomMappingUnit(proportion,pageNo,pageSize);
        if (pageInfo.getTotal() > 0){
            return operationSuccess(pageInfo.getTotal());
        }
        return  operationFailed();
    }

    /**
     * 根据随机数查询人员
     * @param proportion
     * @return
     */
    @GetMapping("/selectRandomCheckPerson")
    public ResultData selectRandomCheckPerson(@RequestParam("proportion")Double proportion){
        List<CheckPerson> list = randomCheckService.selectRandomCheckPerson(proportion);
        if (list != null && list.size() > 0){
            return operationSuccess(list);
        }
        return  operationFailed();
    }


}
