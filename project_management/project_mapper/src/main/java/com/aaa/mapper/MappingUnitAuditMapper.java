package com.aaa.mapper;

import com.aaa.model.MappingUnit;
import com.aaa.model.Score;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 单位审核mapper
 * @author sheep
 */
public interface MappingUnitAuditMapper extends Mapper<MappingUnit> {

    /**
     * 根据主键查询该测绘单位信息
     * @param id
     * @return
     */
    MappingUnit selectOneMappingUnit(Long id);
    /**
     * 查询所有已审核的测绘单位
     * @return
     */
    List<MappingUnit> selectAllMappingUnitAudit();

    /**
     * 查询所有未审核的修改后的测绘单位
     * @return
     */
    List<MappingUnit> selectUpdateMappingUnitNoAudit();

    /**
     * 查询所有未审核的新注册的测绘单位
     * @return
     */
    List<MappingUnit> selectAddMappingUnitNoAudit();

    /**
     * 审核已提交的测绘单位(通过)
     * @param mappingUnit
     * @return
     */
    Integer updateMappingUnitAudit(MappingUnit mappingUnit);

    /**
     * 审核已提交的测绘单位(不通过)
     * @param mappingUnit
     * @return
     */
    Integer updateMappingUnitNoAudit(MappingUnit mappingUnit);
    /**
     * 修改单位评分后增加一条评分记录
     * @param score
     * @return
     */
    Integer addScoreRecord(Score score);

    /**
     *  查看评分记录
     * @param unitId
     * @return
     */
    List<Score> selectScoreRecord(Long unitId);

    /**
     * 根据用户id查询审核记录
     * @return
     */
    List<Score> selectAudit(@Param("userId") Long userId);


    /**
     * 白名单
     * @return
     */
    List<MappingUnit> selectStatusOneMappingUnit();

    /**
     * 黑名单
     * @return
     */
    List<MappingUnit> selectStatusTwoMappingUnit();

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingUnit>
     * @date 2020/7/27 21:46
     * 根据单位资质等级查询
     * qualification_level 甲乙丙丁
     */
    List<Map> getUnitByLevel();
}
