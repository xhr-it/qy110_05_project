package com.aaa.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/***
 * @author xhr
 * @date 2020/7/8
 * 对后端controller的返回值进行统一
**/
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;
}
