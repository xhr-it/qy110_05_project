package com.aaa.base;

import static com.aaa.status.CrudStatus.*;
import static com.aaa.status.CrudStatus.UPDATE_SUCCESS;
import static com.aaa.status.LoginStatus.*;
import static com.aaa.status.OperationStatus.*;


/***
 * @author xhr
 * @date 2020/7/8
 *  统一controller，所有的controller都需要继承这个controller，进行统一返回
**/
public class BaseController {

    /**
     * 登录成功-使用系统消息
     * @return ResultData
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登录成功-自定义返回消息
     * @param msg
     * @return ResultData
     */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登录成功-返回数据信息，使用系统消息
     * @param data
     * @return ResultData
     */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登录成功-返回数据信息，自定义消息
     * @param msg
     * @param data
     * @return ResultData
     */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登录失败-使用系统消息
     * @return ResultData
     */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * 登录失败-使用系统消息，详细解释说明
     * @param detail
     * @return ResultData
     */
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/9 20:38
     * 操作成功，返回系统消息
     */
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 操作成功(重载)
     *  返回系统消息
     * @return
     */
    protected ResultData operationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @param []
     * @return com.aaa.base.ResultData
     * @date 2020/7/9 20:39
     * 操作失败，返回系统消息
     */
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * 操作失败(重载)
     *  返回自定义消息
     * @return
     */
    protected ResultData operationFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Author xj
     * @Description 删除成功
     * @Date 9:58 2020/5/13
     * @Param * @param
     * @return com.aaa.lee.base.ResultData
     */
    protected ResultData deleteSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author xj
     * @Description 删除失败
     * @Date 10:12 2020/5/13
     * @Param * @param
     * @return com.aaa.lee.base.ResultData
     */
    protected ResultData deleteFalse() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }
    /**
     * @Author xj
     * @Description 更新失败
     * @Date 10:28 2020/5/13
     * @Param * @param
     * @return com.aaa.lee.base.ResultData
     */
    protected ResultData updateSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author xj
     * @Description 更新失败
     * @Date 10:28 2020/5/13
     * @Param * @param
     * @return com.aaa.lee.base.ResultData
     */
    protected ResultData updateFalse() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }
    /**
     * @Author xj
     * @Description 查询成功，使用系统消息，自定义返回值
     * @Date 10:37 2020/5/13
     * @Param * @param
     * @return com.aaa.lee.base.ResultData
     */
    protected ResultData getSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(GET_SUCCESS.getCode());
        resultData.setMsg(GET_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author xj
     * @Description 查询失败
     * @Date 10:37 2020/5/13
     * @Param * @param
     * @return com.aaa.lee.base.ResultData
     */
    protected ResultData getFalse() {
        ResultData resultData = new ResultData();
        resultData.setCode(GET_FAILED.getCode());
        resultData.setMsg(GET_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Summary:
     * @Author:  xj
     * @description
     *       新增成功
     * @Data: 2020/5/13
     * @param
     * @Return:com.aaa.xj.base.ResultData
     */
    protected ResultData addSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_SUCCESS.getCode());
        resultData.setMsg(ADD_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Summary:
     * @Author:  xj
     * @description
     *      新增失败
     * @Data: 2020/5/13
     * @param
     * @Return:com.aaa.xj.base.ResultData
     */
    protected ResultData addFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_FAILED.getCode());
        resultData.setMsg(ADD_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Summary:
     * @Author:  xj
     * @description
     *      文件上传成功
     * @Data: 2020/5/30
     * @param []
     * @Return:com.aaa.xj.base.ResultData
     */
    protected ResultData uploadSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPLOAD_SUCCESS.getCode());
        resultData.setMsg(UPLOAD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Summary:
     * @Author:  xj
     * @description
     *      文件上传失败
     * @Data: 2020/5/30
     * @param []
     * @Return:com.aaa.xj.base.ResultData
     */
    protected ResultData uploadFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPLOAD_FAILED.getCode());
        resultData.setCode(UPLOAD_FAILED.getMsg());
        return resultData;
    }
    // TODO 代码未完善，记得补充
}
