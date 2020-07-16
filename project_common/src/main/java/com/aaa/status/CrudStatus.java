package com.aaa.status;

/**
 * @author xhr
 * @date 2020/7/16
 * 增删改查返回值
 **/
public enum  CrudStatus {
    //增删改查
    GET_SUCCESS("20001","获取数据成功"),
    GET_FAILED("10001","获取数据失败"),
    ADD_SUCCESS("20002","新增数据成功"),
    ADD_FAILED("10002","新增数据失败"),
    UPDATE_SUCCESS("20003","更改数据成功"),
    UPDATE_FAILED("10003","更改数据失败"),
    DELETE_SUCCESS("20004","删除数据成功"),
    DELETE_FAILED("10004","删除数据失败"),
    UPLOAD_SUCCESS("20005","文件上传成功"),
    UPLOAD_FAILED("10005","文件上传失败");

    CrudStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
