package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.SpecialPost;
import com.aaa.service.SpecialPostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CZT
 * @date 2020/7/18 10:30
 * 特殊岗位人员信息
 */
@RestController
public class SpecialPostController extends CommonController<SpecialPost> {

    @Autowired
    private SpecialPostService specialPostService;

    @Override
    public BaseService<SpecialPost> getBaseService() {
        return specialPostService;
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询
    **/
    @PostMapping("/selectAllSpecialPost")
    public ResultData selectAllSpecialPost(@RequestBody HashMap hashMap){
        PageInfo pageInfo = specialPostService.selectAllSpecialPost(hashMap);
        if (pageInfo != null || ("").equals(pageInfo)) {
            return getSuccess(pageInfo);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询单条
    **/
    @PostMapping("/selectOneSpecialPost")
    public ResultData selectOneSpecialPost(@RequestBody SpecialPost specialPost){
        SpecialPost specialPost1 = getBaseService().selectOne(specialPost);
        if (specialPost1 != null) {
            return getSuccess(specialPost1);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [specialPost]
     * @return com.aaa.base.ResultData
     *****新增
    **/
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(@RequestBody SpecialPost specialPost){
        specialPost.setCreateTime(new Date());
        specialPost.setModifyTime(new Date());
        Integer add = getBaseService().add(specialPost);
        if(add > 0){
            return getSuccess("添加成功");
        }{
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****删除
    **/
    @GetMapping("/deleteSpecialPost")
    public ResultData deleteSpecialPost(@RequestParam("id") Long id){
        SpecialPost specialPost = new SpecialPost();
        specialPost.setId(id);
        Integer integer = getBaseService().delete(specialPost);
        if (integer > 0 ) {
            return getSuccess(integer);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [specialPost]
     * @return com.aaa.base.ResultData
     *****修改
    **/
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost){
        Integer integer = getBaseService().update(specialPost);
        if (integer > 0) {
            return getSuccess(integer);
        }else {
            return getFalse();
        }
    }
}
