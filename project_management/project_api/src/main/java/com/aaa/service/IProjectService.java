package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.ScoreVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @author xhr
 * @date 2020/7/15
 * api接口
 **/
@FeignClient("system-interface")
public interface IProjectService {

    /**
     * @param user
     * @return com.aaa.base.ResultData
     * @date 2020/7/15 15:47
     * 执行登录操作
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * @param [loginLog]
     * @return java.lang.Integer
     * @date 2020/7/15 19:43
     * 新增日志
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);
    
    @PostMapping(value = "/uploadProject",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResultData uploadProject(@RequestBody MultipartFile file);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param []
     * @return com.aaa.base.ResultData<com.aaa.model.Dept>
     *****查询所有的一级部门以及其下面的子部门
    **/
    @GetMapping("/deptList")
     ResultData<Dept> deptList();

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条部门信息
    **/
    @PostMapping("/selectOneDept")
    ResultData selectOneDept(@RequestBody Dept dept);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dept]
     * @return com.aaa.base.ResultData
     *****添加部门信息
    **/
    @PostMapping("/addDept")
     ResultData addDept(@RequestBody Dept dept);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dept]
     * @return com.aaa.base.ResultData
     *****删除部门信息
    **/
    @PostMapping("/deleteDept")
     ResultData deleteDept(@RequestBody Dept dept);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [ids]
     * @return com.aaa.base.ResultData
     *****批量删除部门信息
    **/
    @PostMapping("/deleteDeptAll")
     ResultData deleteDeptAll(@RequestBody List<Long> ids);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dept]
     * @return com.aaa.base.ResultData
     *****修改部门信息
    **/
    @PostMapping("/updateDept")
     ResultData updateDept(@RequestBody Dept dept);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData<com.aaa.model.Dict>
     *****分页查询字典信息
    **/
    @PostMapping("/seleAllDict")
     ResultData<Dict> seleAllDict(@RequestBody HashMap hashMap);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条字典信息
    **/
    @GetMapping("/selectOneDict")
    public ResultData selectOneDict(@RequestBody Dict dict);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dict]
     * @return com.aaa.base.ResultData
     *****字典添加一段信息
    **/
    @PostMapping("/addDict")
     ResultData addDict(@RequestBody Dict dict);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dict]
     * @return com.aaa.base.ResultData
     *****字典删除一条信息
    **/
    @PostMapping("/deleteDict")
     ResultData deleteDict(@RequestBody Dict dict);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [ids]
     * @return com.aaa.base.ResultData
     *****批量删除字典
    **/
    @PostMapping("/deleteDictAll")
     ResultData deleteDictAll(@RequestBody List<Long> ids);

    /***
     * @author CZT
     * @date 2020/7/23
     * @param [dict]
     * @return com.aaa.base.ResultData
     *****修改字典信息
    **/
    @PostMapping ("/updateDict")
     ResultData updateDict(@RequestBody Dict dict);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询仪器信息
    **/
    @PostMapping("/equipmentAlls")
     ResultData equipmentAlls(@RequestBody HashMap hashMap);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****根据实体查询单条设备信息
    **/
    @PostMapping("/selectOneEquipment")
     ResultData selectOneEquipment(@RequestBody Equipment equipment);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [userId]
     * @return com.aaa.base.ResultData
     *****根据userId查询询仪器信息数据
    **/
    @GetMapping("/selectEquipment")
     ResultData selectEquipment (@RequestParam("userId") Long userId);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查看一条询仪器信息数据
    **/
    @PostMapping("/selectOneAllEquipment")
    public ResultData selectOneAllEquipment(@RequestBody Equipment equipment);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****新增一条询仪器信息数据
    **/
    @PostMapping("/addEquipment")
     ResultData addEquipment (@RequestBody Equipment equipment);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****修改一条询仪器信息数据
    **/
    @PostMapping("/updateEquipment")
     ResultData updateEquipment(@RequestBody Equipment equipment);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [equipment]
     * @return com.aaa.base.ResultData
     *****删除一条询仪器信息数据
    **/
    @PostMapping("/deleteEquipment")
     ResultData deleteEquipment(@RequestBody Equipment equipment);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单位信息
    **/
    @GetMapping("/selectOneMappingUnit")
     ResultData selectOneMappingUnit(@RequestParam("id") Long id);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [mappingUnit]
     * @return com.aaa.base.ResultData
     *****修改单位信息
    **/
    @PostMapping("/updateMappingUnit")
     ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****白名单查询
    **/
    @PostMapping("/selectStatusOneMappingUnit")
     ResultData selectStatusOneMappingUnit(@RequestBody HashMap hashMap);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****黑名单查询
    **/
    @PostMapping("/selectStatusTwoMappingUnit")
     ResultData selectStatusTwoMappingUnit(@RequestBody HashMap hashMap);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询单位负责人信息
    **/
    @PostMapping("/selectPrincipal")
     ResultData selectPrincipal(@RequestBody HashMap hashMap);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单个单位负责人信息
    **/
    @GetMapping("/selectOnePrincipal")
     ResultData selectOnePrincipal(@RequestParam("id") Long id);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询单个单位负责人信息
    **/
    @PostMapping("/selectOnePrincipal")
    public ResultData selectOnePrincipal(@RequestBody Principal principal);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [principal]
     * @return com.aaa.base.ResultData
     *****修改单位负责人信息
    **/
    @PostMapping("/updatePrincipal")
     ResultData updatePrincipal(@RequestBody Principal principal);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [principal]
     * @return com.aaa.base.ResultData
     *****删除单位负责人信息
    **/
    @PostMapping("/deletePrincipal")
     ResultData deletePrincipal(@RequestBody Principal principal);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [principal]
     * @return com.aaa.base.ResultData
     *****新增单位负责人信息
    **/
    @PostMapping("/addPrincipal")
     ResultData addPrincipal(@RequestBody Principal principal);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****测绘成果及档案管理
    **/
    @PostMapping("/selectListResource")
     ResultData selectListResource(@RequestBody Resource resource);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****测绘成果及档案管理修改
    **/
    @PostMapping("/updateResource")
     ResultData updateResource(@RequestBody Resource resource);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [resource]
     * @return com.aaa.base.ResultData
     *****通用材料附件汇总
    **/
    @PostMapping("/selectListAllResource")
     ResultData selectListAllResource(@RequestBody Resource resource);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息分页查询
    **/
    @PostMapping("/selectAllSpecialPost")
     ResultData selectAllSpecialPost(@RequestBody HashMap hashMap);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [map]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息单条查询
    **/
    @PostMapping("/selectOneSpecialPost")
    public ResultData selectOneSpecialPost(@RequestBody SpecialPost specialPost);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [specialPost]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息新增
    **/
    @PostMapping("/addSpecialPost")
     ResultData addSpecialPost(@RequestBody SpecialPost specialPost);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [id]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息根据id删除
    **/
    @GetMapping("/deleteSpecialPost")
     ResultData deleteSpecialPost(@RequestParam("id") Long id);
    /***
     * @author CZT
     * @date 2020/7/23
     * @param [specialPost]
     * @return com.aaa.base.ResultData
     *****特殊岗位人员信息修改
    **/
    @PostMapping("/updateSpecialPost")
     ResultData updateSpecialPost(@RequestBody SpecialPost specialPost);

    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.aaa.base.ResultData
     *****分页查询技术人员信息
     **/
    @PostMapping("/selectAllTechnicist")
     ResultData selectAllTechnicist(@RequestBody HashMap hashMap);

    /***
     * @author CZT
     * @date 2020/7/18
     * @param [id]
     * @return com.aaa.base.ResultData
     *****根据id查询单条技术人员信息
     **/
    @GetMapping("/selectOneAllTechnicist")
     ResultData selectOneAllTechnicist(@RequestParam("id") Long id);
    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****新增技术人员信息
     **/
    @PostMapping("/addTechnicist")
     ResultData addTechnicist(@RequestBody Technicist technicist);

    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****查询一条技术人员信息
     **/
    /*@GetMapping("/selectOneTechnicist")
    public ResultData selectOneTechnicist(@RequestBody Technicist technicist);*/

    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****修改技术人员信息
     **/
    @PostMapping("/updateTechnicist")
     ResultData updateTechnicist(@RequestBody Technicist technicist);

    /***
     * @author CZT
     * @date 2020/7/20
     * @param [map]
     * @return com.aaa.base.ResultData
     *****删除技术人员信息
     **/
    @PostMapping("/deleteTechnicist")
     ResultData deleteTechnicist(@RequestBody Technicist technicist);

    //李有阳
    /**
     * 查询所有测绘单位
     * @return
     */
    @GetMapping("/selectMappingUnit")
    ResultData selectMappingUnit();

    /**
     * 新增测绘单位
     * @return
     */
    @PostMapping("/addMappingUnit")
    ResultData addMappingUnit();

    /**
     * 更新测绘单位
     * @return
     */
    @PostMapping("/updateMappingUnit")
    ResultData updateMappingUnit();

    /**
     * 删除测绘单位
     * @return
     */
    @PostMapping("/deleteMappingUnit")
    ResultData deleteMappingUnit();

    /**
     * 分页查询用户
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/selectUser")
    ResultData selectUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     * 根据主键查询用户详细信息
     * @param id
     * @return
     */
    @GetMapping("/selectOneUser")
    ResultData selectOneUser(@RequestParam("id") Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    ResultData addUser(@RequestBody User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    ResultData updateUser(@RequestBody User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/deleteUser")
    ResultData deleteUser(@RequestBody User user);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteAllUser")
    ResultData deleteAllUser(@RequestBody List<Integer> ids);

    /**
     * 查询所有已审核的测绘单位
     * @return
     */
    @GetMapping("/selectAllMappingUnitAudit")
    ResultData selectAllMappingUnitAudit();

    /**
     * 查询所有未审核的测绘单位
     * @return
     */
    @GetMapping("/selectUpdateMappingUnitNoAudit")
    ResultData selectUpdateMappingUnitNoAudit();

    /**
     * 查询所有未审核的测绘单位
     * @return
     */
    @GetMapping("/selectAddMappingUnitNoAudit")
    ResultData selectAddMappingUnitNoAudit();

    /**
     * 审核已提交的测绘单位(通过)
     * @param mappingUnit
     * @return
     */
    @PostMapping("/updateMappingUnitAudit")
    ResultData updateMappingUnitAudit(@RequestBody MappingUnit mappingUnit);

    /**
     * 审核已提交的测绘单位(不通过)
     * @param mappingUnit
     * @return
     */
    @PostMapping("/updateMappingUnitNoAudit")
    ResultData updateMappingUnitNoAudit(@RequestBody MappingUnit mappingUnit);

    /**
     * 根据主键查询测绘单位评分记录
     * @param id
     * @return
     */
    @GetMapping("/selectScoreRecord")
    ResultData selectScoreRecord(@RequestParam("id") Long id);

    /**
     * 修改测绘单位评分
     * @param scoreVo
     * @return
     */
    @PostMapping("/updateMappingUnitScore")
    ResultData updateMappingUnitScore(@RequestBody ScoreVo scoreVo);

    @PostMapping("/selectAudit")
    ResultData selectAudit(@RequestParam("userId") Long userId);

    /**
     * 根据随机数分页抽查单位
     * @param proportion
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/selectRandomMappingUnit")
    ResultData selectRandomMappingUnit(@RequestParam("proportion") Double proportion,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

    /**
     * 根据随机数分页查询人员
     * @param proportion
     * @return
     */
    @GetMapping("/selectRandomCheckPerson")
    ResultData selectRandomCheckPerson(@RequestParam("proportion")Double proportion);

    /**
     * 查询项目测绘
     * @return
     */
    @GetMapping("/selectAllMappingProject")
    ResultData selectAllMappingProject();

    /**
     * 查询一个项目测绘
     * @param mappingProject
     * @return
     */
    @PostMapping("/selectOneMappingProject")
    ResultData selectOneMappingProject(@RequestBody MappingProject mappingProject);

    /**
     * 查询测绘结果
     * @return
     */
    @GetMapping("/selectAllResultCommit")
    ResultData selectAllResultCommit();

    /**
     * 查询一个项目结果
     * @param resultCommit
     * @return
     */
    @PostMapping("/selectOneResultCommit")
    ResultData selectOneResultCommit(@RequestBody ResultCommit resultCommit);

    //徐浩然

    @GetMapping("/getProjectWithOutSubmit")
    ResultData getProjectWithOutSubmit(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/27 20:46
     * 数据统计-资质项目汇总统计-项目类型统计
     */
    @GetMapping("/getProjectByStatus")
    ResultData getProjectByStatus();

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/27 21:43
     * 数据统计-资质项目汇总统计-单位资质统计
     */
    @GetMapping("/getUnitByLevel")
    ResultData getUnitByLevel();

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/28 15:28
     * 查询所有菜单
     */
    @GetMapping("/getAllMenu")
    ResultData getMenuList();

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/16 20:03
     * 查询所有角色
     */
    @GetMapping("/getAllRole")
    public ResultData getRoleList();
}
