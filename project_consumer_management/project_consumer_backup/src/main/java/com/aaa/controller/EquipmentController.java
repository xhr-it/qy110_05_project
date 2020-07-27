package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Equipment;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author CZT
 * @date 2020/7/24 20:07
 */
@RestController
public class EquipmentController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询仪器信息
     **/
    @PostMapping("/equipmentAlls")
    public ResultData equipmentAlls(@RequestBody HashMap hashMap){
        return iProjectService.equipmentAlls(hashMap);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****根据实体查询单条设备信息
     **/
    @PostMapping("/selectOneEquipment")
    public ResultData selectOneEquipment(@RequestBody Equipment equipment){
        return iProjectService.selectOneEquipment(equipment);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [userId]
     * @return com.aaa.base.ResultData
     *****根据userId查询询仪器信息数据
     **/
    @GetMapping("/selectEquipment")
    public ResultData selectEquipment (@RequestParam("userId") Long userId){
        return iProjectService.selectEquipment(userId);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查看一条询仪器信息数据
     **/
    @PostMapping("/selectOneAllEquipment")
    public ResultData selectOneAllEquipment(@RequestBody Equipment equipment){
        return iProjectService.selectOneAllEquipment(equipment);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****新增一条询仪器信息数据
     **/
    @PostMapping("/addEquipment")
    public ResultData addEquipment (@RequestBody Equipment equipment){
        return iProjectService.addEquipment(equipment);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****修改一条询仪器信息数据
     **/
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(@RequestBody Equipment equipment){
        return iProjectService.updateEquipment(equipment);
    }
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****删除一条询仪器信息数据
     **/
    @PostMapping("/deleteEquipment")
    public ResultData deleteEquipment(@RequestBody Equipment equipment){
        return iProjectService.deleteEquipment(equipment);
    }
}
