package com.aaa.mapper;

import com.aaa.model.Technicist;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface TechnicistMapper extends Mapper<Technicist> {

    /**
     * 分页查询技术人员信息
     * @param hashMap
     * @return
     */
    List<Technicist> selectAllTechnicist(HashMap hashMap);

    /**
     * 根据id查询单条技术人员信息
     * @param id
     * @return
     */
    List<Technicist> selectOneTechnicist (Long id);
}