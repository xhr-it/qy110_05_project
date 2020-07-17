package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.MappingProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xhr
 * @date 2020/7/17
 * 项目相关
 **/
@RestController
public class MappingProjectController extends CommonController {

    @Autowired
    private MappingProjectService mappingProjectService;

    @Override
    public BaseService getBaseService() {
        return mappingProjectService;
    }

    /**
     * @param [pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/17 19:31
     * 项目汇交-查询所有未提交的汇交成果
     * 即resultsStatus = 3
     */
    @GetMapping("/getProject")
    ResultData getProjectByResultsStatus(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByResultsStatus = mappingProjectService.getProjectByResultsStatus(pageNo, pageSize);
        if (null != projectByResultsStatus){
            return getSuccess(projectByResultsStatus);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [mappingProject]
     * @return com.aaa.base.ResultData
     * @date 2020/7/17 20:41
     * 项目汇交-提交项目
     */
    @PostMapping("/updateProject")
    ResultData updateProjectResultsStatus(@RequestBody MappingProject mappingProject){
        Integer update = mappingProjectService.update(mappingProject);
        if (update > 0){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }


}
