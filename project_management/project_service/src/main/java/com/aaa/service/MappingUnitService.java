package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitAuditMapper;
import com.aaa.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CZT
 * @date 2020/7/17 17:27
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitAuditMapper mappingUnitMapper;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public MappingUnit selectOneMappingUnit(Long id){
        if (!"".equals(id)) {
            return mappingUnitMapper.selectOneMappingUnit(id);
        }
        return null;
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.github.pagehelper.PageInfo
     *****白名单
    **/
    public PageInfo selectStatusOneMappingUnit(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNumber")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(mappingUnitMapper.selectStatusOneMappingUnit());
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }
    /***
     * @author CZT
     * @date 2020/7/18
     * @param [hashMap]
     * @return com.github.pagehelper.PageInfo
     *****黑名单
    **/
    public PageInfo selectStatusTwoMappingUnit(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNumber")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(mappingUnitMapper.selectStatusTwoMappingUnit());
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }

    /**
     * @param []
     * @return java.util.List<com.aaa.model.MappingUnit>
     * @date 2020/7/27 21:45
     * 根据单位资质等级查询
     * qualification_level 甲乙丙丁
     */
    public List<Map> getUnitByLevel(){
        List<Map> unitByLevel = mappingUnitMapper.getUnitByLevel();
        if (null != unitByLevel){
            return unitByLevel;
        }
        return null;
    }
}
