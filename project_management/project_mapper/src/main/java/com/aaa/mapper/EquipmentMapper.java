package com.aaa.mapper;

import com.aaa.model.Equipment;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface EquipmentMapper extends Mapper<Equipment> {
    /**
     * 分页查询仪器
     * @param hashMap
     * @return
     */
    List<Equipment> equipmentAlls(HashMap hashMap);

    /**
     * 根据id查询单条设备信息
     * @param id
     * @return
     */
    List<Equipment> selectOneEquipment(Long id);

    /**
     * 根据user_id查询所有
     * @param userId
     * @return
     */
    List<Equipment> selectEquipment(Long userId);
}