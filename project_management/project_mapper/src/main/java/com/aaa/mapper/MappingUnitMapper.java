package com.aaa.mapper;

import com.aaa.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MappingUnitMapper extends Mapper<MappingUnit> {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    List<MappingUnit> selectOneMappingUnit(Long id);

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


}