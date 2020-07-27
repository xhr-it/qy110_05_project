package com.aaa.mapper;

import com.aaa.model.CheckPerson;
import com.aaa.model.MappingUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 随机抽查模块mapper
 * @author sheep
 */
public interface RandomCheckMapper {

    /**
     * 随机抽查单位
     * @param randomNum
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<MappingUnit> selectRandomMappingUnit(@Param("randomNum") Integer randomNum,
                                              @Param("pageNo") Integer pageNo,
                                              @Param("pageSize") Integer pageSize);

    /**
     * 随机抽查人员
     * @param randomNum
     * @return
     */
    List<CheckPerson> selectRandomCheckPerson(@Param("randomNum") Integer randomNum);
}
