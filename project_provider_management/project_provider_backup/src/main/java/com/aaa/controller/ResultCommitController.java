package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.ResultCommit;
import com.aaa.service.ResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultCommitController extends CommonController {

    @Autowired
    private ResultCommitService resultCommitService;

    @Override
    public BaseService getBaseService() {
        return resultCommitService;
    }

    /**
     * 查询测绘结果
     * @return
     */
    @GetMapping("/selectAllResultCommit")
    public ResultData selectAllResultCommit(){
        List<ResultCommit> list = resultCommitService.selectList(null);
        if (list != null && list.size() > 0){
            return operationSuccess(list);
        }else {
            return operationFailed();
        }
    }

    /**
     * 查询一个项目结果
     * @param resultCommit
     * @return
     */
    @PostMapping("/selectOneResultCommit")
    public ResultData selectOneResultCommit(@RequestBody ResultCommit resultCommit){
        List<ResultCommit> list = resultCommitService.selectList(resultCommit);
        if (list != null && list.size() > 0){
            return operationSuccess(list);
        }else {
            return operationFailed();
        }
    }
}
