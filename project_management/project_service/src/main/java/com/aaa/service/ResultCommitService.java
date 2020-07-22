package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ResultCommitMapper;
import com.aaa.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;


/**
 * @author xhr
 * @date 2020/7/18
 **/
@Service
public class ResultCommitService extends BaseService<ResultCommit> {

    @Autowired
    private ResultCommitMapper resultCommitMapper;

    /**
     * @param [resultCommit]
     * @return java.lang.Integer
     * @date 2020/7/18 14:59
     * 新增项目成果
     */
    public Integer insertResultCommit(ResultCommit resultCommit){
        int insert = 0;
        if (null != resultCommit){
            //获取系统当前时间的毫秒数
            Long timeMillis = System.currentTimeMillis();

            //生成一个0-9999之间的随机数
            Random random = new Random();
            int randomNum = random.nextInt(9999);
            Long id = timeMillis + randomNum;
            //设置项目成果编号
            resultCommit.setId(id);

            //设置创建时间
            resultCommit.setCreateDate(new Date());

            insert = resultCommitMapper.insert(resultCommit);
            if (insert > 0){
                return insert;
            }
        }
        return insert;
    }
}
