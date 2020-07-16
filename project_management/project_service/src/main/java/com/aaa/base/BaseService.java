package com.aaa.base;

import com.aaa.utils.Map2BeanUtils;
import com.aaa.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.staticproperties.OrderStatic.ASC;
import static com.aaa.staticproperties.OrderStatic.DESC;
import static com.sun.corba.se.impl.util.RepositoryId.cache;

/***
 * @author xhr
 * @date 2020/7/8
 * 通用service
**/
public abstract class BaseService<T> {

    // 全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper(){
        return mapper;
    }

    public ResultData insertData(T t){
        int insert = mapper.insert(t);
        if (insert>0){
            return new ResultData().setCode("300").setMsg("数据插入成功");
        }
        return null;
    }


    /**
     * @param [t]
     * @return java.lang.Integer
     * @date 2020/7/9 16:09
     * 根据主键新增
     */
    public Integer add(T t) {
        return mapper.insert(t);
    }

    /**
     * @param [t]
     * @return java.lang.Integer
     * @date 2020/7/9 16:11
     * 根据主键进行删除
     */
    public Integer delete(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * @param [ids]
     * @return java.lang.Integer
     * @date 2020/7/9 16:13
     * 根据主键批量删除
     */
    public Integer deleteByIds(List<Integer> ids) {
        /**
         * delete * from user where 1 = 1 and id in (1,2,3,4,5,6,7,8)
         * andIn("id")--->id就是数据库中的主键名称
         */
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /**
     * @param [t]
     * @return java.lang.Integer
     * @date 2020/7/9 16:24
     * 更新操作
     */
    public Integer update(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * @param [t, ids]
     * @return java.lang.Integer
     * @date 2020/7/9 16:26
     * 批量更新 update username = ?  from user where id in (1,2,3,4,5,6,7)
     */
    public Integer batchUpdate(T t, Integer[] ids) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t, example);
    }

    /**
     * @param [t]
     * @return T
     * @date 2020/7/9 16:28
     * 查询一条数据 形参中的t所传递的数据--->主键，唯一键(username, phone number....)
     */
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    /**
     * @param [where, orderByFiled, fileds]
     * @return T
     * @date 2020/7/9 16:30
     * 查询一条数据，可以排序(orderByFiled:ASC,DESC)
     * fileds:不只是代表唯一键 select * from user where password = xxxx and age = xx and address = xxx
     */
    public T selectOneByFiled(Sqls where, String orderByFiled, String... fileds) {
        return (T) selectByFileds(null, null, where, orderByFiled, null, fileds).get(0);
    }

    /**
     * @param [where, orderByField, fields]
     * @return java.util.List<T>
     * @date 2020/7/9 16:53
     * 通过条件查询一个列表
     */
    public List<T> selectListByFiled(Sqls where, String orderByField, String... fields) {
        return selectByFileds(null, null, where, orderByField, null, fields);
    }

    /**
     * @param [pageNo, pageSize, where, orderFiled, fileds]
     * @return com.github.pagehelper.PageInfo<T>
     * @date 2020/7/9 16:55
     * 分页查询
     */
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo, pageSize, where, orderFiled, null, fileds));
    }

    /**
     * @param [t]
     * @return java.util.List<T>
     * @date 2020/7/9 16:56
     * 查询集合，条件查询
     */
    public List<T> selectList(T t) {
        return mapper.select(t);
    }

    /**
     * @param [t, pageNo, pageSize]
     * @return com.github.pagehelper.PageInfo<T>
     * @date 2020/7/9 16:56
     * 查询集合，分页查询
     */
    public PageInfo<T> selectListByPage(T t, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * @param [map]
     * @return T
     * @date 2020/7/9 20:32
     * Map转实体类型
     */
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }

    /**
     * @param []
     * @return java.lang.Class<T>
     * @date 2020/7/9 16:17
     * 获取子类泛型类型
     */
    public Class<T> getTypeArguement() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * @param [pageNo, pageSize, where, orderByFiled, orderWord, fileds]
     * @return java.util.List<T>
     * @date 2020/7/9 16:32
     * 实现查询通用,不但可以作用于分页，还可以作用于排序，还能作用于多条件查询
     * orderByFiled:是所要排序的字段
     */
    private List<T> selectByFileds(Integer pageNo, Integer pageSize, Sqls where, String orderByFiled, String orderWord, String... fileds) {
        Example.Builder builder = null;
        if(null == fileds || fileds.length == 0) {
            // 查询所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if(where != null) {
            // 说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if(orderByFiled != null) {
            // 说明我需要对某个字段进行排序
            if(DESC.equals(orderWord.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if(ASC.equals(orderWord.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        // 实现分页
        if(pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     * @author Seven Lee
     * @description
     *      获取spring容器/获取spring的上下文
     *      在项目开始运行的时候，会去加载spring配置，
     *      如果你们项目需要在项目启动的时候也加载自己的配置文件
     *      在spring的源码中有一个必须要看的方法(init())
     *      init()--->就是在项目启动的时候去加载spring的配置
     *       如果你的项目中也需要把某一些配置一开始就托管给spring
     *       需要获取到spring的上下文(ApplicationContext)
     *
     * @param []
     * @date 2020/7/9
     * @return org.springframework.context.ApplicationContext
     * @throws
     **/
    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }

}
