package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Audit;
import com.aaa.model.MappingProject;
import com.aaa.model.ResultCommit;
import com.aaa.service.AuditService;
import com.aaa.service.MappingProjectService;
import com.aaa.service.ResultCommitService;
import com.aaa.service.UploadService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author xhr
 * @date 2020/7/17
 * 项目相关
 **/
@RestController
public class MappingProjectController extends CommonController {

    @Autowired
    private MappingProjectService mappingProjectService;

    @Autowired
    private ResultCommitService resultCommitService;

    @Autowired
    private AuditService auditService;

    @Autowired
    private UploadService uploadService;

    @Override
    public BaseService getBaseService() {
        return mappingProjectService;
    }

    /**
     * @param [pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 10:05
     * 项目管理
     * 查询未提交的项目，audit_status = 3
     */
    @GetMapping("/getProjectWithOutSubmit")
    ResultData getProjectWithOutSubmit(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectProjectWithOutSubmit = mappingProjectService.getProjectProjectWithOutSubmit(pageNo, pageSize);
        if (null != projectProjectWithOutSubmit){
            return getSuccess(projectProjectWithOutSubmit);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [mappingProject, resultCommit]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 15:14
     * 项目管理
     * 新增项目
     */
    @PostMapping("/insertProject")
    ResultData insertProject(@RequestBody MappingProject mappingProject){
        Integer integer = mappingProjectService.insertProject(mappingProject);
        if (integer > 0 ){
            return addSuccess();
        }else {
            return addFalse();
        }
    }

    /**
     * @param [file]
     * @return com.aaa.base.ResultData
     * @date 2020/7/21 21:18
     * 文件上传
     */
    @PostMapping("/uploadProject")
    ResultData uploadProject(@RequestBody MultipartFile file){
        Boolean upload = uploadService.upload(file);
        if (upload){
            return uploadSuccess();
        }else {
            return uploadFalse();
        }
    }

    /**
     * @param [id]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 17:23
     * 项目管理（这部分有争议，项目管理中应该不需要修改项目状态）
     * 完成项目-修改项目状态为已完成 status=3
     */
    @GetMapping("/updateProjectStatus")
    ResultData updateProjectStatus(@RequestParam("id") Long id){
        MappingProject mappingProject = new MappingProject();
        if (null != id){
            mappingProject.setId(id);
            mappingProject.setStatus(3);
            Integer update = mappingProjectService.update(mappingProject);
            if (update > 0){
                return updateSuccess();
            }
        }
        return updateFalse();
    }

    /**
     * @param [pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/17 19:31
     * 项目汇交
     * 查询所有未提交的项目成果
     * 即results_status = 3
     */
    @GetMapping("/getProjectResults")
    ResultData getProjectResultsWithOutSubmit(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByResultsStatus = mappingProjectService.getProjectResultsWithOutSubmit(pageNo, pageSize);
        if (null != projectByResultsStatus){
            return getSuccess(projectByResultsStatus);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [mappingProject]
     * @return com.aaa.base.ResultData
     * @date 2020/7/17 20:41
     * 项目汇交-提交项目
     */
    @PostMapping("/updateProject")
    ResultData updateProjectResultsStatus(@RequestBody MappingProject mappingProject){
        Integer update = mappingProjectService.update(mappingProject);
        if (update > 0){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }

    /**
     * @param [projectType, pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 9:15
     * 根据项目类型查询项目
     */
    @GetMapping("/getProjectByType")
    ResultData getProjectByType(@RequestParam("projectType") String projectType,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByType = mappingProjectService.getProjectByType(projectType, pageNo, pageSize);
        if (null != projectByType){
            return getSuccess(projectByType);
        }else{
            return getFalse();
        }
    }

    /**
     * @param [pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 9:46
     * 项目审核-项目信息
     * 查询项目审核通过的项目信息 audit_status = 0
     * 并可以根据项目名称模糊查询
     */
    @GetMapping("/getProjectByResultsStatus")
    ResultData getProjectByResultsStatus(@RequestParam("projectName") String projectName, @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByAuditStatus = mappingProjectService.getProjectByResultsStatus(projectName,pageNo, pageSize);
        if (null != projectByAuditStatus){
            return getSuccess(projectByAuditStatus);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [id]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 16:20
     * 项目审核-项目信息
     * 根据id查询项目审核通过的项目
     */
    @GetMapping("/getProjectByIdWithResults")
    ResultData getProjectByIdWithResults(@RequestParam("id") Long id){
        MappingProject mappingProject = new MappingProject();
        if (null != id){
            mappingProject.setId(id);
            mappingProject.setResultsStatus(0);
            MappingProject mappingProject1 = mappingProjectService.selectOne(mappingProject);
            if (null != mappingProject1){
                return getSuccess(mappingProject1);
            }
        }
        return getFalse();
    }

    /**
     * @param [id]
     * @return com.aaa.base.ResultData
     * @date 2020/7/18 17:04
     * 项目审核-项目信息
     * 根据项目id查询审核情况，此时审核类别为2（项目登记审核）
     */
    @GetMapping("/getAuditByProjectId")
    ResultData getAuditByProjectId(@RequestParam("id") Long id){
        Audit audit = new Audit();
        if (null != id){
            audit.setType(2);
            audit.setRefId(id);
            List<Audit> audits = auditService.selectList(audit);
            if (null != audits){
                return getSuccess(audits);
            }
        }
        return getFalse();
    }

    /**
     * @param [projectName, pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/20 11:02
     * 项目审核-项目审核
     * 查询已提交但未审核的项目 audit_status = 2
     */
    @GetMapping("/getProjectWithOutAudit")
    ResultData getProjectWithOutAudit(@RequestParam("projectName") String projectName, @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByAuditStatus = mappingProjectService.getProjectWithOutAudit(projectName,pageNo, pageSize);
        if (null != projectByAuditStatus){
            return getSuccess(projectByAuditStatus);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [id]
     * @return com.aaa.base.ResultData
     * @date 2020/7/20 11:36
     * 项目审核-项目审核
     * 根据id查询已提交但未审核的项目
     */
    @GetMapping("/getProjectByIdWithOutAudit")
    ResultData getProjectByIdWithOutAudit(@RequestParam("id") Long id){
        MappingProject mappingProject = new MappingProject();
        if (null != id){
            mappingProject.setId(id);
            mappingProject.setAuditStatus(2);
            MappingProject mappingProject1 = mappingProjectService.selectOne(mappingProject);
            if (null != mappingProject1){
                return getSuccess(mappingProject1);
            }
        }
        return getFalse();
    }

    /**
     * @param [id, auditStatus, audit]
     * @return com.aaa.base.ResultData
     * @date 2020/7/20 18:57
     * 项目审核-项目审核
     * 修改项目审核结果 audit_status通过：0 不通过：1
     * 同时添加审核日志 审核意见memo 审核状态status==audit_status
     */
    @GetMapping("/updateProjectAuditStatus")
    ResultData updateProjectAuditStatus(@RequestParam("id") Long id,
                                        @RequestParam("auditStatus") Integer auditStatus,
                                        Audit audit){
        Boolean aBoolean = mappingProjectService.updateProjectAuditStatus(id, auditStatus, audit);
        if (aBoolean){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }

    /**
     * @param [projectName, pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/22 21:40
     * 项目审核-汇交成果信息
     * 查询所有已审核的项目成果 results_status = 0
     */
    ResultData getProjectResultsWithAudit(@RequestParam("projectName") String projectName, @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByAuditStatus = mappingProjectService.getProjectResultsWithAudit(projectName,pageNo, pageSize);
        if (null != projectByAuditStatus){
            return getSuccess(projectByAuditStatus);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [projectName, pageNo, pageSize]
     * @return com.aaa.base.ResultData
     * @date 2020/7/23 19:17
     * 项目审核-成果汇交审核
     * 查询所有已提交但未审核的项目成果 results_status = 2
     */
    ResultData getProjectResultsWithOutAudit(@RequestParam("projectName") String projectName, @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectByAuditStatus = mappingProjectService.getProjectResultsWithOutAudit(projectName,pageNo, pageSize);
        if (null != projectByAuditStatus){
            return getSuccess(projectByAuditStatus);
        }else {
            return getFalse();
        }
    }

    /**
     * @param [id, auditStatus, audit]
     * @return com.aaa.base.ResultData
     * @date 2020/7/23 19:20
     * 项目审核-成果汇交审核
     * 修改项目成果汇交审核结果 results_status通过：0 不通过：1
     * 同时添加审核日志 审核意见memo 审核状态status==results_status
     */
    ResultData updateProjectResultsStatus(@RequestParam("id") Long id,
                                    @RequestParam("resultsStatus") Integer resultsStatus,
                                    Audit audit){
        Boolean aBoolean = mappingProjectService.updateProjectResultsStatus(id, resultsStatus, audit);
        if (aBoolean){
            return updateSuccess();
        }else {
            return updateFalse();
        }
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/27 20:46
     * 数据统计-资质项目汇总统计-项目类型统计
     * 根据项目完成情况查询项目
     * status=2未完成 3已完成
     */
    @GetMapping("/getProjectByStatus")
    ResultData getProjectByStatus(){
        List<Map> projectByStatus = mappingProjectService.getProjectByStatus();
        if (null != projectByStatus){
            return getSuccess(projectByStatus);
        }else {
            return getFalse();
        }
    }

}
