package com.aaa.mapper;

import com.aaa.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface SpecialPostMapper extends Mapper<SpecialPost> {

    /**
     * 分页查询特殊岗位成员
     * @param hashMap
     * @return
     */
    List<SpecialPost> selectAllSpecialPost(HashMap hashMap);
}