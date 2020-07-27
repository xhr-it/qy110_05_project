package com.aaa.mapper;

import com.aaa.model.Dict;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface DictMapper extends Mapper<Dict> {

    /**
     * 分页查询字典信息
     * @param hashMap
     * @return
     */
    List<Dict> selectAlls(HashMap hashMap);
}