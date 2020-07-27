package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DeptMapper;
import com.aaa.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CZT
 * @date 2020/7/14 19:57
 */
@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;
    /***
     * @author CZT
     * @date 2020/7/16
     * @param []
     * @return java.util.List<com.aaa.model.Dept>
     *****查询所有一级部门
    **/
    public List<Dept> deptList(){
        List<Dept> deptList = new ArrayList<Dept>();
        Dept deptId = new Dept();
        deptId.setParentId(0L);
        //获取所有一级部门
        List<Dept> depts = super.selectList(deptId);
        if (depts != null && depts.size() > 0) {
            for (int i = 0; i < depts.size(); i++) {
                //获取当前一级部门
                Dept depta =depts.get(i);
                Dept dept = new Dept();
                dept.setParentId(depta.getDeptId());
                //获取当前一级部门中所有的子部门
                List<Dept> deptList1 = super.selectList(dept);
               //实体类中添加deptlists
                depta.setDeptLists(deptList1);
                deptList.add(depta);
            }
        }
        return deptList;
    }
    /***
     * @author CZT
     * @date 2020/7/16
     * @param [ids]
     * @return java.lang.Integer
     *****批量删除
    **/
    public Integer deleteDeptAll(List<Long> ids){
        Example example = Example.builder(Dept.class).where(Sqls.custom().andIn("deptId", ids)).build();
        return deptMapper.deleteByExample(example);
    }
}
