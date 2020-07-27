package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Resource;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CZT
 * @date 2020/7/24 20:25
 * 测绘成果及档案管理
 */
@RestController
public class ResourceController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****测绘成果及档案管理
     **/
    @PostMapping("/selectListResource")
    public ResultData selectListResource(@RequestBody Resource resource){
        return iProjectService.selectListResource(resource);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****测绘成果及档案管理修改
     **/
    @PostMapping("/updateResource")
    public ResultData updateResource(@RequestBody Resource resource){
        return iProjectService.updateResource(resource);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****通用材料附件汇总
     **/
    @PostMapping("/selectListAllResource")
    public ResultData selectListAllResource(@RequestBody Resource resource){
        return iProjectService.selectListAllResource(resource);
    }

}
