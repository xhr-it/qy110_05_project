package com.aaa.mapper;

import com.aaa.model.Principal;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface PrincipalMapper extends Mapper<Principal> {

    /**
     * 分页查询单位负责人信息
     * @param hashMap
     * @return
     */
    List<Principal> selectPrincipal(HashMap hashMap);

    /**
     * 根据id查询单个单位负责人的信息
     * @param id
     * @return
     */
    List<Principal> selectOnePrincipal(Long id);
}