package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.PrincipalMapper;
import com.aaa.model.Principal;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/17 19:42
 */
@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;
    /***
     * @author CZT
     * @date 2020/7/17
     * @param [hashMap]
     * @return com.github.pagehelper.PageInfo
     *****分页查询单位负责人信息
    **/
    public PageInfo selectPrincipal(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageSize")+""),Integer.parseInt(hashMap.get("pageNo")+""));
        PageInfo pageInfo = new PageInfo(principalMapper.selectPrincipal(hashMap));
        if (pageInfo != null && !"".equals(pageInfo)) {
            return pageInfo;
        }else {
            return null;
        }
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param [id]
     * @return java.util.List<com.aaa.model.Principal>
     *****根据id查询单个单位负责人信息
    **/
    public List<Principal> selectOnePrincipal(Long id){
        List<Principal> principals = principalMapper.selectOnePrincipal(id);
        if (principals != null && !"".equals(principals)) {
            return principals;
        }else {
            return null;
        }
    }

}
