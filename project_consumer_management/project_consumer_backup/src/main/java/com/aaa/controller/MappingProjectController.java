package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.IProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
