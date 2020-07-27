package com.aaa.base;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xhr
 * @date 2020/7/9
 * 通用Controler
**/
public abstract class CommonController<T> extends BaseController {

    public abstract BaseService<T> getBaseService();

    /**
     * @param [map]
     * @return void
     * @date 2020/7/9 17:13
     * 钩子函数，在新增之前去执行某些操作
     */
    protected void beforeAdd(Map map) {
        // TODO AddMethod Before to do something
    }

    /**
     * @param [map]
     * @return void
     * @date 2020/7/9 17:17
     * 钩子函数，新增之后去执行
     */
    protected void afterAdd(Map map) {
        // TODO AddMethod After to do something
    }

    /**
     * @param [map]
     * @return com.aaa.base.ResultData
     * @date 2020/7/9 20:41
     * 通用的新增方法
     */
    public ResultData add(@RequestBody Map map) {
        // 因为根据咱们的封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类
        // 但是controller是一个Map类型
        beforeAdd(map);
        // 1.将Map转为实体类
        T instance = getBaseService().newInstance(map);
        // 2.通用service
        Integer addResult = getBaseService().add(instance);
        if(addResult > 0) {
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /***
     * @author CZT
     * @date 2020/7/11
     * @param map
     * @return com.aaa.base.ResultData
     *查询一条数据
     **/
    public ResultData getOne(@RequestBody Map map) {
        T t = getBaseService().newInstance(map);
        t = getBaseService().selectOne(t);
        if (null != t) {
            return getSuccess(t);
        }
        return getFalse();
    }

    /***
     * @author CZT
     * @date 2020/7/11
     * @param [map]
     * @return com.aaa.base.ResultData
     *更新操作
     **/
    public ResultData update(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        int updateResult = getBaseService().update(t);
        if(updateResult > 0){
            return  getSuccess(updateResult);
        }
        return getFalse();
    }

    /**
     * @param [map]
     * @return com.aaa.base.ResultData
     * @date 2020/7/9 20:44
     * 删除操作
     */
    public ResultData delete(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @param [ids]
     * @return com.aaa.base.ResultData
     * @date 2020/7/9 20:44
     * 批量删除
     */
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids) {
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if(deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
}
