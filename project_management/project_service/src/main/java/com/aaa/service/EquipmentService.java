package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.EquipmentMapper;
import com.aaa.model.Equipment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/17 10:54
 */
@Service
public class EquipmentService extends BaseService<Equipment> {
    @Autowired
    private EquipmentMapper equipmentMapper;


    /***
     * @author CZT
     * @date 2020/7/16
     * @param hashMap
     * @return com.github.pagehelper.PageInfo
     *****分页查询仪器信息
     **/
    public PageInfo equipmentAlls(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNo")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(equipmentMapper.equipmentAlls(hashMap));
        if (pageInfo != null && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }
    /**
     * 根据user_id查询所有
     * @param userId
     * @return
     */
    public List<Equipment> selectEquipment(Long userId){
        if (!"".equals(userId)) {
           return equipmentMapper.selectEquipment(userId);
        }
        return null;
    }
}
