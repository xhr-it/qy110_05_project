package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/24 20:00
 */
@RestController
public class DictController extends BaseController {
    @Autowired
    private IProjectService iProjectService;


    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData<com.aaa.model.Dict>
     *****分页查询字典信息
     **/
    @PostMapping("/seleAllDict")
    public ResultData<Dict> seleAllDict(@RequestBody HashMap hashMap){
        return iProjectService.seleAllDict(hashMap);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条字典信息
     **/
    @GetMapping("/selectOneDict")
    public ResultData selectOneDict(@RequestBody Dict dict){
        return iProjectService.selectOneDict(dict);
    }

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dict]
     * @return com.aaa.base.ResultData
     *****字典添加一段信息
     **/
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        return iProjectService.addDict(dict);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dict]
     * @return com.aaa.base.ResultData
     *****字典删除一条信息
     **/
    @PostMapping("/deleteDict")
    public ResultData deleteDict(@RequestBody Dict dict){
        return iProjectService.deleteDict(dict);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [ids]
     * @return com.aaa.base.ResultData
     *****批量删除字典
     **/
    @PostMapping("/deleteDictAll")
    public ResultData deleteDictAll(@RequestBody List<Long> ids){
        return iProjectService.deleteDictAll(ids);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dict]
     * @return com.aaa.base.ResultData
     *****修改字典信息
     **/
    @PostMapping ("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        return iProjectService.updateDict(dict);
    }

}
