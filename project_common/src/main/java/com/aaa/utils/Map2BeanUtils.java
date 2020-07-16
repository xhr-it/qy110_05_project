package com.aaa.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xhr
 * @date 2020/7/9
 * 将Map转换为Java Bean
**/
public class Map2BeanUtils {

    private Map2BeanUtils() {

    }

    //高性能实例化工具类
    private final static Objenesis OBJENESIS = new ObjenesisStd(true);
    //使用String效率太低，使用StringBuffer相对于StringBuilder来说效率还是低
    private final static StringBuilder STRING_BUILDER = new StringBuilder();
    //高性能反射字节集
    //ConcurrentHashMap：在线程中运转，这个Map会在当前线程中出现
    //而且线程和线程具有隔离性，这里的Map就不会被其他的线程所干扰
    private final static  ConcurrentHashMap<Class,MethodAccess> CONCURRENT_HASH_MAP =
            new ConcurrentHashMap<Class, MethodAccess>(16);

    /**
     * @param [map, clazz]
     * @return T
     * @date 2020/7/9 19:48
     * map转换java bean
     */
    public static <T> T map2Bean(Map<String,Object> map, Class<T> clazz){
        // 1.获取实例对象信息
        T instance = OBJENESIS.newInstance(clazz);
        // 2.从Map中通过key(instance)，或者MethodAccess对象
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(clazz);
        // 3.判断
        if(null == methodAccess) {
            /**
             * MethodAccess.get(User.class):
             *      获取的是User类中的MethodAccess的信息
             */
            // 3.通过类获取MethodAccess对象
            methodAccess = MethodAccess.get(clazz);
            // 4.存入CONCURRENT_HASH_MAP中
            CONCURRENT_HASH_MAP.putIfAbsent(clazz, methodAccess);
        }
        // 5.循环Map对象
        for (Map.Entry entry : map.entrySet()) {
            /**
             * Map中的数据需要通过对象的set方法来进行存放
             *      User.java{
             *          private String username;
             *      }
             */
            String setMethodName = getSetMethodName((String)entry.getKey());
            int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
            methodAccess.invoke(instance, index, entry.getValue());
        }
        return instance;
    }

    /**
     * @param [filedName]
     * @return java.lang.String
     * @date 2020/7/9 19:49
     * 通过字段拼接方法名
     */
    private static String getSetMethodName(String filedName) {
        STRING_BUILDER.setLength(0);
        // setUsername();
        return STRING_BUILDER.append("set").append(first2UpperCase(filedName)).toString();
    }

    /**
     * @param [str]
     * @return java.lang.String
     * @date 2020/7/9 19:51
     * 把属性的首字母转换为大写
     */
    private static String first2UpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
