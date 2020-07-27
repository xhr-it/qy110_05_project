package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Equipment;
import com.aaa.service.EquipmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/17 10:59
 */
@RestController
public class EquipmentController extends CommonController<Equipment> {

    @Autowired
    private EquipmentService equipmentService;

    @Override
    public BaseService<Equipment> getBaseService() {
        return equipmentService;
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param hashMap
     * @return com.aaa.base.ResultData
     *****分页查询仪器信息
    **/
    @PostMapping("/equipmentAlls")
    public ResultData equipmentAlls(@RequestParam HashMap hashMap){
        PageInfo pageInfo = equipmentService.equipmentAlls(hashMap);
        if (pageInfo != null || !("").equals(pageInfo)) {
            return super.getSuccess(pageInfo);
        }else {
            return super.getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param equipment
     * @return java.util.List<com.aaa.model.Equipment>
     *****根据ID查询单条设备信息
    **/
    @GetMapping("/selectOneEquipment")
    public ResultData selectOneEquipment(@RequestBody Equipment equipment){
        Equipment equipment1 = getBaseService().selectOne(equipment);
        if (equipment1!= null ) {
            return getSuccess(equipment1);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/17
     * @param [userId]
     * @return com.aaa.base.ResultData
     *****根据userId查询数据
    **/
    @GetMapping("/selectEquipment")
    public ResultData selectEquipment (@RequestParam("userId") Long userId){
        List<Equipment> equipment = equipmentService.selectEquipment(userId);
        if (equipment != null) {
            return getSuccess(equipment);
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查看一条数据
    **/
    @PostMapping("/selectOneAllEquipment")
    public ResultData selectOneAllEquipment(@RequestBody Equipment equipment){
        Equipment selectOne = getBaseService().selectOne(equipment);
        if (selectOne != null) {
            return getSuccess(selectOne);
        }else {
            return getFalse();
        }
    }

    /***
     * @author CZT
     * @date 2020/7/20
     * @param equipment
     * @return com.aaa.base.ResultData
     *****新增
    **/
    @PostMapping("/addEquipment")
    public ResultData addEquipment (@RequestParam Equipment equipment){
        equipment.setCreateTime(new Date());
        equipment.setModifyTime(new Date());
        Integer update = equipmentService.add(equipment);
        if (update >0) {
            return getSuccess("添加成功");
        }else {
            return getFalse();
        }
    }
    /***
     * @author CZT
     * @date 2020/7/20
     * @param equipment
     * @return com.aaa.base.ResultData
     *****修改
    **/
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(@RequestParam Equipment equipment){
        Integer update = equipmentService.update(equipment);
        if (update > 0) {
            return getSuccess(update);
        }else {
            return getFalse();
        }
    }

    /***
     * @author CZT
     * @date 2020/7/20
     * @param equipment
     * @return com.aaa.base.ResultData
     *****删除
    **/
    @PostMapping("/deleteEquipment")
    public ResultData deleteEquipment(@RequestBody Equipment equipment){
        Integer delete = equipmentService.delete(equipment);
        if (delete > 0) {
            return getSuccess(delete);
        }else {
            return getFalse();
        }
    }
}
