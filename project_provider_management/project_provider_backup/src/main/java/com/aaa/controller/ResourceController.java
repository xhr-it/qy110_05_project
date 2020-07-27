package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Resource;
import com.aaa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CZT
 * @date 2020/7/21 15:11
 */
@RestController
public class ResourceController extends CommonController<Resource> {

    @Autowired
    private ResourceService resourceService;

    @Override
    public BaseService<Resource> getBaseService() {
        return resourceService;
    }
    /*** 
     * @author CZT
     * @date 2020/7/21   
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****测绘成果及档案管理
    **/ 
    @PostMapping("/selectListResource")
    public ResultData selectListResource(@RequestBody Resource resource){
        List<Resource> resources = getBaseService().selectList(resource);
        if (resources != null || !("").equals(resources)) {
            return getSuccess(resources);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/21
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****测绘成果及档案管理修改
    **/
    @PostMapping("/updateResource")
    public ResultData updateResource(@RequestBody Resource resource){
        Integer update = getBaseService().update(resource);
        if (update > 0 || !("").equals(update)) {
            return getSuccess(update);
        }else {
            return getFalse();
        }
    }

    /***
     * @author CZT
     * @date 2020/7/21
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****通用材料附件汇总
     **/
    @PostMapping("/selectListAllResource")
    public ResultData selectListAllResource(@RequestBody Resource resource){
        List<Resource> resources = getBaseService().selectList(resource);
        if (resources != null) {
            return getSuccess(resources);
        }else {
            return getFalse();
        }
    }
}
