package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.LoginService;
import com.aaa.status.LoginStatus;
import com.aaa.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.status.LoginStatus.*;

/**
 * @author xhr
 * @date 2020/7/15
 **/
@RestController
public class LoginController extends CommonController<User> {

    @Autowired
    private LoginService loginService;


    @Override
    public BaseService<User> getBaseService() {
        return loginService;
    }

    /**
     * @param [user]
     * @return com.aaa.base.ResultData
     * @date 2020/7/15 22:01
     * 执行登录操作
     */
    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = loginService.doLogin(user);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess(LOGIN_SUCCESS.getMsg(),tokenVo.getToken());
        } else if(tokenVo.getType() == 1) {
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        } else if(tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        } else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
