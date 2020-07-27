package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DictMapper;
import com.aaa.model.Dict;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/16 14:58
 * 字典管理
 */
@Service
public class DictService extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;

    /***
     * @author CZT
     * @date 2020/7/16
     * @param hashMap
     * @return com.github.pagehelper.PageInfo
     *****分页查询字典信息
    **/
    public PageInfo seleAllDict(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(dictMapper.selectAlls(hashMap));
        if (pageInfo != null && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }

    /***
     * @author CZT
     * @date 2020/7/16
     * @param ids
     * @return java.lang.Integer
     *****批量删除
     **/
    public Integer deleteDictAll(List<Long> ids){
        Example example = Example.builder(Dict.class).where(Sqls.custom().andIn("dictId", ids)).build();
        return dictMapper.deleteByExample(example);
    }


}
