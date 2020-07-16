package com.aaa.utils;

import java.util.Random;

/**
 * @author xhr
 * @date 2020/7/10
 * 操作文件名工具类
**/
public class FileNameUtils {

    private FileNameUtils() {

    }

    /**
     * @param []
     * @return java.lang.String
     * @date 2020/7/10 19:31
     * 随机生成文件名称
     */
    public static String getFileName() {
        // 1.获取当前系统时间的毫秒数
        long currentTimeMillis = System.currentTimeMillis();
        // 2.创建随机数对象
        Random random = new Random();
        // 3.随机 从0-999之间随机
        int number = random.nextInt(999);
        // 4.生成最终的文件名
        /**
         * format():
         *      格式化方法
         *      %:占位符
         *      03:三位，如果不够三位则向前补0
         *      0-999随机---->11--->011
         *      --->9--->009
         *      d:数字
         */
        return currentTimeMillis + String.format("%03d", number);
    }

}
