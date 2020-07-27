package com.aaa.service;


import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitAuditMapper;
import com.aaa.model.MappingUnit;
import com.aaa.model.Score;
import com.aaa.vo.MappingUnitVo;
import com.aaa.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 单位审核service
 * @author sheep
 */
@Service
public class MappingUnitAuditService extends BaseService<MappingUnit> {

    @Autowired
    private MappingUnitAuditMapper mappingUnitAuditMapper;

    /**
     * 查询所有已审核的测绘单位
     * @return
     */
    public MappingUnitVo selectAllMappingUnitAudit(){
        List<MappingUnit> list = mappingUnitAuditMapper.selectAllMappingUnitAudit();
        MappingUnitVo mappingUnitVo = new MappingUnitVo();
        if (list != null && list.size() > 0 ){
            return mappingUnitVo.setIsSuccess(true).setData(list);
        }
        return mappingUnitVo.setIsSuccess(false);
    }

    /**
     * 查询所有未审核的修改后的测绘单位
     * @return
     */
    public MappingUnitVo selectUpdateMappingUnitNoAudit(){
        List<MappingUnit> list = mappingUnitAuditMapper.selectUpdateMappingUnitNoAudit();
        MappingUnitVo mappingUnitVo = new MappingUnitVo();
        if (list != null && list.size() > 0){
            return mappingUnitVo.setIsSuccess(true).setData(list);
        }
        return mappingUnitVo.setIsSuccess(false);
    }

    /**
     * 查询所有未审核的新注册的测绘单位
     * @return
     */
    public MappingUnitVo selectAddMappingUnitNoAudit(){
        List<MappingUnit> list = mappingUnitAuditMapper.selectAddMappingUnitNoAudit();
        MappingUnitVo mappingUnitVo = new MappingUnitVo();
        if (list != null && list.size() > 0){
            return mappingUnitVo.setIsSuccess(true).setData(list);
        }
        return mappingUnitVo.setIsSuccess(false);
    }

    /**
     * 审核已提交的测绘单位(通过)
     * @param mappingUnit
     * @return
     */
    public MappingUnitVo updateMappingUnitAudit(MappingUnit mappingUnit){
        Integer i = mappingUnitAuditMapper.updateMappingUnitAudit(mappingUnit);
        MappingUnitVo mappingUnitVo = new MappingUnitVo();
        if (mappingUnit != null) {
            return mappingUnitVo.setIsSuccess(false);
        }else if (i != null && i > 0){
            return mappingUnitVo.setIsSuccess(true).setData(i);
        }
        return mappingUnitVo.setIsSuccess(false);
    }

    /**
     * 审核已提交的测绘单位(不通过)
     * @param mappingUnit
     * @return
     */
    public MappingUnitVo updateMappingUnitNoAudit(MappingUnit mappingUnit){
        Integer i = mappingUnitAuditMapper.updateMappingUnitNoAudit(mappingUnit);
        MappingUnitVo mappingUnitVo = new MappingUnitVo();
        if (mappingUnit.getId() == null) {
            return mappingUnitVo.setIsSuccess(false);
        }else if (i != null && i > 0){
            return mappingUnitVo.setIsSuccess(true).setData(i);
        }
        return mappingUnitVo.setIsSuccess(false);
    }

    /**
     * 查询评分记录
     * @param unitId
     * @return
     */
    public List<Score> selectScoreRecord(Long unitId){
        List<Score> list = mappingUnitAuditMapper.selectScoreRecord(unitId);
        if (unitId != null && list != null && list.size() > 0){
            return list;
        }
        return null;
    }

    /**
     * 修改测绘单位评分
     * @param scoreVo
     * @return
     */
    @Transactional
    public MappingUnitVo  updateMappingUnitScore(ScoreVo scoreVo){
        Integer updateResult = null;
        Score score = new Score();
        MappingUnitVo mappingUnitVo = new MappingUnitVo();
        MappingUnit mappingUnit = new MappingUnit();

        //判断传入的vo中是否存在测绘单位的id
        if (scoreVo.getUnitId() == null){
            return mappingUnitVo.setIsSuccess(false);
        }
        //获取该测绘单位的初始分值
        Integer newScore = mappingUnitAuditMapper.selectOneMappingUnit(scoreVo.getUnitId()).getScore();
        if (newScore == null){
            return mappingUnitVo.setIsSuccess(false);
        }
        //赋值主键给mappingUnit
        mappingUnit.setId(scoreVo.getUnitId());
        //创建一个测绘单位修改后分值的初始值
        Integer oldScore = null;
        //判断传入的vo中的plusOrSubtract参数是加还是减
        if (scoreVo.getPlusOrSubtract() == 1){
            score.setScorePlus(scoreVo.getPoints());
            oldScore = newScore + scoreVo.getPoints();
            mappingUnit.setScore(oldScore);
            updateResult = super.update(mappingUnit);
            mappingUnit.setScore(null);
        }else if (scoreVo.getPlusOrSubtract() == 0){
            score.setScoreSubtract(scoreVo.getPoints());
            oldScore = newScore - scoreVo.getPoints();
            mappingUnit.setScore(oldScore);
            updateResult = super.update(mappingUnit);
            mappingUnit.setScore(null);
        }
        //判断修改单位分值是否成功
        if (updateResult != null && updateResult != 0){
            score.setScore(newScore);
            score.setReason(scoreVo.getReason());
            score.setUnitId(scoreVo.getUnitId());
            long l = System.currentTimeMillis();
            int n = (int)((Math.random()*9+1)*100000);
            score.setId(Long.parseLong(l + "" + n + ""));
            Integer i = mappingUnitAuditMapper.addScoreRecord(score);
            if (i == null && i == 0) {
                mappingUnitVo.setIsSuccess(false);
            }else {
                mappingUnitVo.setIsSuccess(true);
            }
        }
        //根据修改后测绘单位的分值去设置它的黑白名单
        if (oldScore >= 100){
            mappingUnit.setUnitStatus(1);
            Integer i = super.update(mappingUnit);
            if (i >= 0 && i != null){
                return mappingUnitVo;
            }else {
                return mappingUnitVo.setIsSuccess(false);
            }
        }else if (oldScore >= 60){
            return mappingUnitVo.setIsSuccess(true);
        } else if (oldScore < 60){
            mappingUnit.setUnitStatus(2);
            Integer i = super.update(mappingUnit);
            if (i >= 0 && i != null){
                return mappingUnitVo;
            }else {
                return mappingUnitVo.setIsSuccess(false);
            }
        }
        return mappingUnitVo.setIsSuccess(false);
    }


    public List<Score> selectAudit(Long userId){
        if (userId == null){
            return null;
        }
        List<Score> list = mappingUnitAuditMapper.selectAudit(userId);
        if (list != null && list.size() != 0){
            return list;
        }else {
            return null;
        }
    }

}
