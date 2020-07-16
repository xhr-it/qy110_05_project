package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.User;
import com.aaa.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author xhr
 * @date 2020/7/15
 **/
@Service
public class LoginService extends BaseService<User> {
    public TokenVo doLogin(User user){
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        if (null != user) {
            //1.先根据用户名进行查询
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            if (null == user2){
                //用户名不存在
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            }else {
                //2.用户名存在，再根据密码查询
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                if (null == user3) {
                    //密码错误
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                }else {
                    //3.登录成功，创建token（mybatis会把“-”连接符转义，所以需要替换连接符）
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    user3.setToken(token);
                    //4.将token更新到数据库中
                    Integer updateResult = super.update(user3);
                    if (updateResult > 0){
                        //5.将token存入TokenVo对象
                        tokenVo.setIfSuccess(true).setToken(token);
                    }else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        } else {
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }
}
