package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.SpecialPostMapper;
import com.aaa.model.SpecialPost;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/18 10:22
 */
@Service
public class SpecialPostService extends BaseService<SpecialPost> {

    @Autowired
    private SpecialPostMapper specialPostMapper;

    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.github.pagehelper.PageInfo
     *****分页查询特殊岗位人员
    **/
    public PageInfo selectAllSpecialPost(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageSize")+""),Integer.parseInt(hashMap.get("pageNo")+""));
        PageInfo pageInfo = new PageInfo(specialPostMapper.selectAllSpecialPost(hashMap));
        if (pageInfo != null && !"".equals(pageInfo)) {
            return pageInfo;
        }else {
            return null;
        }
    }
}
