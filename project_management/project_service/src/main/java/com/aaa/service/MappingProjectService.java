package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.AuditMapper;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.Audit;
import com.aaa.model.MappingProject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.aaa.staticproperties.TimeFormatProperties.DATE_FORMAT;

/**
 * @author xhr
 * @date 2020/7/17
 **/
@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    @Autowired
    private AuditMapper auditMapper;

    /**
     * @param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/18 10:06
     * 查询未提交的项目，audit_status = 3
     */
    public PageInfo<MappingProject> getProjectProjectWithOutSubmit(Integer pageNo, Integer pageSize) {
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);
            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectProjectWithOutSubmit();
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [mappingProject]
     * @return java.lang.Integer
     * @date 2020/7/18 15:01
     * 新增项目
     */
    public Integer insertProject(MappingProject mappingProject){
        int insert = 0;
        if (null != mappingProject){
            //获取系统当前时间的毫秒数
            Long timeMillis = System.currentTimeMillis();

            //生成一个0-9999之间的随机数
            Random random = new Random();
            int randomNum = random.nextInt(9999);
            Long id = timeMillis + randomNum;

            //设置项目id
            mappingProject.setId(id);

            //设置创建时间
            mappingProject.setCreateTime(DateUtil.formatDate(new Date(),DATE_FORMAT));

            insert = mappingProjectMapper.insert(mappingProject);
            if (insert>0){
                return insert;
            }
        }
        return insert;
    }
    
    /**
     * @param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/17 19:10
     * 查询所有未提交的项目成果
     * 即resultsStatus = 3
     */
    public PageInfo<MappingProject> getProjectResultsWithOutSubmit(Integer pageNo, Integer pageSize){
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);
            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectResultsWithOutSubmit();
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [projectType, pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/18 9:11
     * 根据项目类型查询
     */
    public PageInfo<MappingProject> getProjectByType(String projectType, Integer pageNo, Integer pageSize){
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);

            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectByType(projectType);
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/18 9:44
     * 查询项目提交但未审核的项目
     * audit_status = 2
     */
    public PageInfo<MappingProject> getProjectByResultsStatus(String projectName, Integer pageNo, Integer pageSize) {
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);

            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectByResultsStatus(projectName);
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [projectName, pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/20 11:04
     * 查询已提交但未审核的项目 audit_status = 2
     */
    public PageInfo<MappingProject> getProjectWithOutAudit(String projectName, Integer pageNo, Integer pageSize) {
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);

            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectWithOutAudit(projectName);
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [id, auditStatus, audit]
     * @return java.lang.Integer
     * @date 2020/7/20 19:39
     * 修改项目审核结果 audit_status通过：0 不通过：1
     * 同时添加审核日志 审核意见memo 审核状态status==audit_status
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateProjectAuditStatus(@RequestParam("id") Long id,
                                     @RequestParam("auditStatus") Integer auditStatus,
                                     @RequestBody Audit audit){
        MappingProject mappingProject = new MappingProject();
        Integer update = 0;
        if (null != id){
            mappingProject.setId(id);
            mappingProject.setAuditStatus(auditStatus);
            update = mappingProjectMapper.updateByPrimaryKeySelective(mappingProject);
            if (update > 0 ){
                //修改项目审核结果成功
                //随机生成id
                long currentTimeMillis = System.currentTimeMillis();
                Random random = new Random();
                int randomNum = random.nextInt(9999);
                Long myId = currentTimeMillis+randomNum;
                //设置审核编号
                audit.setId(myId);
                //设置审核项
                String name = "项目登记审核";
                audit.setName(name);
                //设置审核表中其他字段
                audit.setStatus(auditStatus)
                        .setRefId(id)
                        .setType(2)
                        .setAuditTime(new Date())
                        .setCreateTime(new Date());
                Integer update1 = auditMapper.insert(audit);
                update += update1;
                if (update > 1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param [projectName, pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/23 19:05
     * 查询所有已审核的项目成果 results_status = 0
     */
    public PageInfo<MappingProject> getProjectResultsWithAudit(String projectName, Integer pageNo, Integer pageSize) {
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);

            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectResultsWithAudit(projectName);
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [projectName, pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<com.aaa.model.MappingProject>
     * @date 2020/7/23 19:19
     * 查询所有已提交但未审核的项目成果 results_status = 2
     */
    public PageInfo<MappingProject> getProjectResultsWithOutAudit(String projectName, Integer pageNo, Integer pageSize) {
        PageInfo<MappingProject> projectPageInfo = null;

        try {
            PageHelper.startPage(pageNo,pageSize);

            List<MappingProject> projectByResultsStatus = mappingProjectMapper.getProjectResultsWithOutAudit(projectName);
            projectPageInfo = new PageInfo<MappingProject>(projectByResultsStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != projectPageInfo) {
            return projectPageInfo;
        }
        return null;
    }

    /**
     * @param [id, auditStatus, audit]
     * @return java.lang.Boolean
     * @date 2020/7/23 19:23
     * 修改项目成果汇交审核结果 results_status通过：0 不通过：1
     * 同时添加审核日志 审核意见memo 审核状态status==results_status
     */
    public Boolean updateProjectResultsStatus(Long id, Integer resultsStatus, Audit audit) {
        MappingProject mappingProject = new MappingProject();
        Integer update = 0;
        if (null != id){
            mappingProject.setId(id);
            mappingProject.setResultsStatus(resultsStatus);
            update = mappingProjectMapper.updateByPrimaryKeySelective(mappingProject);
            if (update > 0 ){
                //修改项目审核结果成功
                //随机生成id
                long currentTimeMillis = System.currentTimeMillis();
                Random random = new Random();
                int randomNum = random.nextInt(9999);
                Long myId = currentTimeMillis+randomNum;
                //设置审核编号
                audit.setId(myId);
                //设置审核项
                String name = "项目登记审核";
                audit.setName(name);
                //设置审核表中其他字段
                audit.setStatus(resultsStatus)
                        .setRefId(id)
                        .setType(2)
                        .setAuditTime(new Date())
                        .setCreateTime(new Date());
                Integer update1 = auditMapper.insert(audit);
                update += update1;
                if (update > 1){
                    return true;
                }
            }
        }
        return false;
    }
}
