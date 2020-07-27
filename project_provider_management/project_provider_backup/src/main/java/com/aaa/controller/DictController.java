package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.DictService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CZT
 * @date 2020/7/16 15:51
 * 字典增删改
 */
@RestController
public class DictController extends CommonController<Dict> {
    @Autowired
    private DictService dictService;

    @Override
    public BaseService<Dict> getBaseService() {
        return dictService;
    }

    /**
     * 分页查询字典信息
     * @param hashMap
     * @return
     */
    @PostMapping("/seleAllDict")
    public ResultData<Dict> seleAllDict(@RequestBody HashMap hashMap){
        PageInfo pageInfo = dictService.seleAllDict(hashMap);
        if (pageInfo != null || !("").equals(pageInfo)) {
            return super.getSuccess(pageInfo);
        }else {
            return super.getFalse();
        }
    }

    /**
     * 查询一条数据
     * @param map
     * @return
     */
    @GetMapping("/selectOneDict")
    public ResultData selectOneDict(@RequestBody Dict dict){
        Dict selectOne = getBaseService().selectOne(dict);
        if (selectOne != null) {
            return getSuccess(selectOne);
        }else {
            return getFalse();
        }

    }

    /**
     * 字典添加一段信息
     * @param dict
     * @return
     */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestParam Dict dict){
        Integer add = getBaseService().add(dict);
        if (add>0) {
            return getSuccess(add);
        }else {
            return getFalse();
        }
    }

    /**
     * 字典删除一条信息
     * @param dict
     * @return
     */
    @PostMapping("/deleteDict")
    public ResultData deleteDict(@RequestBody Dict dict){
        Integer delete = getBaseService().delete(dict);
        if (delete>0) {
            return getSuccess(delete);
        }else {
            return getFalse();
        }
    }

    /**
     * 批量删除字典
     * @param ids
     * @return
     */
    @PostMapping("/deleteDictAll")
    public ResultData deleteDictAll(@RequestBody List<Long> ids){
        Integer integer = dictService.deleteDictAll(ids);
        if (integer > 0) {
            return super.deleteSuccess();
        }else {
            return super.deleteFalse();
        }
    }

    /**
     * 修改字典信息
     * @param dict
     * @return
     */
    @PostMapping ("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        Integer update = dictService.update(dict);
        if (update > 0){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }


}
