package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.model.Score;
import com.aaa.service.MappingUnitAuditService;
import com.aaa.vo.MappingUnitVo;
import com.aaa.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 单位审核controller
 * @author sheep
 */
@RestController
public class MappingUnitAuditController extends CommonController<MappingUnit> {

    @Autowired
    private MappingUnitAuditService mappingUnitAuditService;

    @Override
    public BaseService getBaseService() {
        return mappingUnitAuditService;
    }

    /**
     * 查询所有已审核的测绘单位
     * @return
     */
    @GetMapping("/selectAllMappingUnitAudit")
    public ResultData selectAllMappingUnitAudit(){
        MappingUnitVo mappingUnitVo = mappingUnitAuditService.selectAllMappingUnitAudit();
        if (mappingUnitVo.getIsSuccess()){
            return super.operationSuccess().setData(mappingUnitVo.getData());
        }
        return super.operationFailed();
    }

    /**
     * 查询所有未审核的测绘单位
     * @return
     */
    @GetMapping("/selectUpdateMappingUnitNoAudit")
    public ResultData selectUpdateMappingUnitNoAudit(){
        MappingUnitVo mappingUnitVo = mappingUnitAuditService.selectUpdateMappingUnitNoAudit();
        if (mappingUnitVo.getIsSuccess()){
            return super.operationSuccess().setData(mappingUnitVo.getData());
        }
        return super.operationSuccess();
    }

    /**
     * 查询所有未审核的测绘单位
     * @return
     */
    @GetMapping("/selectAddMappingUnitNoAudit")
    public ResultData selectAddMappingUnitNoAudit(){
        MappingUnitVo mappingUnitVo = mappingUnitAuditService.selectAddMappingUnitNoAudit();
        if (mappingUnitVo.getIsSuccess()){
            return super.operationSuccess().setData(mappingUnitVo.getData());
        }
        return super.operationSuccess();
    }

    /**
     * 审核已提交的测绘单位(通过)
     * @param mappingUnit
     * @return
     */
    @PostMapping("/updateMappingUnitAudit")
    public ResultData updateMappingUnitAudit(MappingUnit mappingUnit){
        MappingUnitVo mappingUnitVo = mappingUnitAuditService.updateMappingUnitAudit(mappingUnit);
        if (mappingUnitVo.getIsSuccess()){
            return super.operationSuccess().setData(mappingUnitVo.getData());
        }
        return super.operationSuccess();
    }

    /**
     * 审核已提交的测绘单位(不通过)
     * @param mappingUnit
     * @return
     */
    @PostMapping("/updateMappingUnitNoAudit")
    public ResultData updateMappingUnitNoAudit(@RequestBody MappingUnit mappingUnit){
        MappingUnitVo mappingUnitVo = mappingUnitAuditService.updateMappingUnitNoAudit(mappingUnit);
        if (mappingUnitVo.getIsSuccess()){
            return super.operationSuccess().setData(mappingUnitVo.getData());
        }
        return super.operationFailed();
    }

    /**
     * 根据主键查询测绘单位评分记录
     * @param id
     * @return
     */
    @PostMapping("/selectScoreRecord")
    public ResultData selectScoreRecord(@RequestParam Long id){
        List<Score> list = mappingUnitAuditService.selectScoreRecord(id);
        if (list != null){
            return super.operationSuccess(list);
        }
        return super.operationSuccess("未找到评分记录");
    }

    /**
     * 修改测绘单位评分
     * @param scoreVo
     * @return
     */
    @PostMapping("/updateMappingUnitScore")
    public ResultData updateMappingUnitScore(@RequestBody ScoreVo scoreVo){
        MappingUnitVo mappingUnitVo = mappingUnitAuditService.updateMappingUnitScore(scoreVo);
        if (mappingUnitVo.getIsSuccess()){
            return operationSuccess();
        }
        return operationFailed();
    }

    @PostMapping("/selectAudit")
    public ResultData selectAudit(@RequestParam("userId") Long userId){
        List<Score> list = mappingUnitAuditService.selectAudit(userId);
        if (list != null && list.size() != 0){
            return super.operationSuccess(list);
        }else {
            return super.operationFailed();
        }
    }


}
