package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.IProjectService;
import com.aaa.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sheep
 */
@RestController
public class MappingUnitAuditController {

    @Autowired
    private IProjectService projectService;

    /**
     * 查询所有已审核的测绘单位
     * @return
     */
    @GetMapping("/selectAllMappingUnitAudit")
    public ResultData selectAllMappingUnitAudit(){
        return projectService.selectAllMappingUnitAudit();
    }

    /**
     * 查询所有未审核的测绘单位
     * @return
     */
    @GetMapping("/selectUpdateMappingUnitNoAudit")
    public ResultData selectUpdateMappingUnitNoAudit(){
        return projectService.selectUpdateMappingUnitNoAudit();
    }

    /**
     * 查询所有未审核的测绘单位
     * @return
     */
    @GetMapping("/selectAddMappingUnitNoAudit")
    public ResultData selectAddMappingUnitNoAudit(){
        return projectService.selectAddMappingUnitNoAudit();
    }

    /**
     * 审核已提交的测绘单位(通过)
     * @param mappingUnit
     * @return
     */
    @PostMapping("/updateMappingUnitAudit")
    ResultData updateMappingUnitAudit(MappingUnit mappingUnit){
        return updateMappingUnitAudit(mappingUnit);
    }

    /**
     * 审核已提交的测绘单位(不通过)
     * @param mappingUnit
     * @return
     */
    @PostMapping("/updateMappingUnitNoAudit")
    public ResultData updateMappingUnitNoAudit(@RequestBody MappingUnit mappingUnit){
        return projectService.updateMappingUnitNoAudit(mappingUnit);
    }

    /**
     * 根据主键查询测绘单位评分记录
     * @param id
     * @return
     */
    @PostMapping("/selectScoreRecord")
    public ResultData selectScoreRecord(@RequestParam Long id){
        return projectService.selectScoreRecord(id);
    }

    /**
     * 修改测绘单位评分
     * @param scoreVo
     * @return
     */
    @PostMapping("/updateMappingUnitScore")
    public ResultData updateMappingUnitScore(@RequestBody ScoreVo scoreVo){
        return projectService.updateMappingUnitScore(scoreVo);
    }

    @PostMapping("/selectAudit")
    public ResultData selectAudit(@RequestParam("userId") Long userId){
        return projectService.selectAudit(userId);
    }


}
