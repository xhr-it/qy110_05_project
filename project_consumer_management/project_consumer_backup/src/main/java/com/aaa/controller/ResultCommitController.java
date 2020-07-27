package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.ResultCommit;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultCommitController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * 查询测绘结果
     * @return
     */
    @GetMapping("/selectAllResultCommit")
    public ResultData selectAllResultCommit(){
        return iProjectService.selectAllResultCommit();
    }

    /**
     * 查询一个项目结果
     * @param resultCommit
     * @return
     */
    @PostMapping("/selectOneResultCommit")
    public ResultData selectOneResultCommit(@RequestBody ResultCommit resultCommit){
        return iProjectService.selectOneResultCommit(resultCommit);
    }

}
