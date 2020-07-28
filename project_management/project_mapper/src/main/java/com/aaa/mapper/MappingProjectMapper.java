package com.aaa.mapper;

import com.aaa.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface MappingProjectMapper extends Mapper<MappingProject> {

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/18 10:06
     * 查询未提交的项目，audit_status = 3
     */
    List<MappingProject> getProjectProjectWithOutSubmit();

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/17 19:14
     * 查询所有未提交的项目成果
     * 即resultsStatus = 3
     */
    List<MappingProject> getProjectResultsWithOutSubmit();

    /**
     * @param [mappingProject]
     * @return java.lang.Integer
     * @date 2020/7/18 10:27
     * 新增项目
     */
    Integer insertProject(Map<String,Object> map);

    /**
     * @param [projectType]
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/18 9:08
     * 根据项目类型查询项目
     */
    List<MappingProject> getProjectByType(String projectType);

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/18 9:41
     * 查询项目成果汇交通过的项目
     * results_status = 2
     * 并根据项目名称模糊查询
     */
    List<MappingProject> getProjectByResultsStatus(String projectName);

    /**
     * @param [projectName]
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/20 11:20
     * 查询项目提交但未审核
     * audit_status = 2
     */
    List<MappingProject> getProjectWithOutAudit(String projectName);

    /**
     * @param [projectName]
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/23 19:05
     * 查询所有已审核的项目成果 results_status = 0
     */
    List<MappingProject> getProjectResultsWithAudit(String projectName);

    /**
     * @param [projectName]
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/23 19:19
     * 查询所有已提交但未审核的项目成果 results_status = 2
     */
    List<MappingProject> getProjectResultsWithOutAudit(String projectName);

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingProject>
     * @date 2020/7/27 21:27
     * 根据项目完成情况查询项目
     * status=2未完成 3已完成
     */
    List<Map> getProjectByStatus();
}