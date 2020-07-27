package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.TechnicistMapper;
import com.aaa.model.Technicist;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/18 8:48
 */
@Service
public class TechnicistService extends BaseService<Technicist> {

    @Autowired
    private TechnicistMapper technicistMapper;

    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.github.pagehelper.PageInfo
     *****分页查询技术人员信息
    **/
    public PageInfo selectAllTechnicist(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageSize")+""),Integer.parseInt(hashMap.get("pageNo")+""));
        PageInfo pageInfo= new PageInfo(technicistMapper.selectAllTechnicist(hashMap));
        if (pageInfo != null && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [id]
     * @return java.util.List<com.aaa.model.Technicist>
     *****根据id查询单条人员信息
    **/
    public List<Technicist> selectOneTechnicist(Long id){
        if (!"".equals(id)) {
            return technicistMapper.selectOneTechnicist(id);
        }else {
            return null;
        }
    }
}
