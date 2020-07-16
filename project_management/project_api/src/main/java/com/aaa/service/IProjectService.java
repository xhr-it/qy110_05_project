package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.LoginLog;
import com.aaa.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xhr
 * @date 2020/7/15
 * api接口
 **/
public interface IProjectService {

    /**
     * @param [user]
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
}
