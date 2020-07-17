package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xhr
 * @date 2020/7/17
 **/
@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    
    /**
     * @param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/17 19:10
     * 查询所有未提交的汇交成果
     * 即resultsStatus = 3
     */
    public PageInfo<MappingProject> getProjectByResultsStatus(Integer pageNo, Integer pageSize){
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);
            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectByResultsStatus();
            projectPageInfo = new PageInfo<>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }
}
