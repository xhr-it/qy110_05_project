package com.aaa.mapper;

import com.aaa.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MappingProjectMapper extends Mapper<MappingProject> {

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/17 19:14
     * 查询所有未提交的汇交成果
     * 即resultsStatus = 3
     */
    List<MappingProject> getProjectByResultsStatus();
}