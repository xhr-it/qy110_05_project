package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.IProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingProjectController {

    private IProjectService iProjectService;

    /**
     * 查询项目测绘
     * @return
     */
    @GetMapping("/selectAllMappingProject")
    public ResultData selectAllMappingProject(){
        return iProjectService.selectAllMappingProject();
    }

    /**
     * 查询一个项目测绘
     * @param mappingProject
     * @return
     */
    @PostMapping("/selectOneMappingProject")
    public ResultData selectOneMappingProject(@RequestBody MappingProject mappingProject){
        return iProjectService.selectOneMappingProject(mappingProject);
    }

    /**
     * @param [pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/27 20:20
     * 项目管理
     * 查询未提交的项目，audit_status = 3
     */
    @GetMapping("/getProjectWithOutSubmit")
    ResultData getProjectWithOutSubmit(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return iProjectService.getProjectWithOutSubmit(pageNo, pageSize);
    }
}
