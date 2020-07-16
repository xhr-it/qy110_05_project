package com.aaa.redis;

import com.aaa.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.aaa.staticproperties.RedisProperties.*;

/**
 * @author xhr
 * @date 2020/7/10
 * RedisService
**/
public class RedisService<T> {

    private RedisSerializer keySerializer = null;

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * @param []
     * @return void
     * @date 2020/7/10 17:06
     * 初始化redis的key序列化器
     * PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次
     */
    @PostConstruct
    public void initRedisSerializer() {
        if(this.keySerializer == null) {
            this.keySerializer = new JdkSerializationRedisSerializer(this.getClass().getClassLoader());
        }
    }

    /**
     * @param [key, value, nxxx, expx, seconds]
     * @return java.lang.String
     * @date 2020/7/10 16:33
     * 向redis中存入数据
     * nxxx：
     *      固定值
     *      “nx”：如果redis中的key不存在则可以存储，如果redis中已经有这个key了，则不存数据
     *      “xx”：如果redis中的key存在，则直接覆盖，如果key不存在则不存
     * expx：
     *     也是固定值。
     *     ex：失效时间的单位是秒
     *     px：失效时间的单位是毫秒
     * seconds:
     *      失效时间
     */
    public String set(String key, T value, String nxxx, String expx, Integer seconds) {
        if(null != seconds && 0 < seconds &&
                (EX.equals(expx) || PX.equals(expx)) &&
                (XX.equals(nxxx) || NX.equals(nxxx))) {
            // 说明在存入数据的时候我就必须要上失效时间了
            return jedisCluster.set(key, JSONUtils.toJsonString(value), nxxx, expx, seconds);
        } else {
            // 说明不需要设置失效时间
            // 但是仍然需要进一步去判断用户所传递到底nx还是xx
            if(NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key, JSONUtils.toJsonString(value)));
            } else if(XX.equals(nxxx)) {
                return jedisCluster.set(key, JSONUtils.toJsonString(value));
            }
        }
        return NO;
    }

    /**
     * @param [key]
     * @return T
     * @date 2020/7/10 16:59
     * 从redis中查询数据(单个数据)
     */
    public T getOne(String key) {
        return (T) JSONUtils.toObject(jedisCluster.get(key), Object.class);
    }

    /**
     * @param [key]
     * @return java.lang.String
     * @date 2020/7/10 16:59
     * 从redis中查询数据(value值是字符串)
     */
    public String getString(String key) {
        return jedisCluster.get(key);
    }

    /**
     * @param [key]
     * @return java.util.List<T>
     * @date 2020/7/10 17:00
     * 从redis中查询数据(集合数据)
     */
    public List<T> getList(String key) {
        return (List<T>) JSONUtils.toList(jedisCluster.get(key), Object.class);
    }

    /**
     * @param [key]
     * @return java.lang.Long
     * @date 2020/7/10 17:07
     * 删除单个redis
     */
    public Long delOne(Object key) {
        /**
         * 思路:
         *  目前来说架构遇到的问题:
         *      封装redis的时候发现无法实现通用，因为JedisCluster只能接收String类型key值
         *      并不符合架构标准，最终可以把Object对象转换为字节数组来进行处理这个问题
         */
        return jedisCluster.del(rawKey(key));
    }

    /**
     * @param [keys]
     * @return java.lang.Long
     * @date 2020/7/10 17:08
     * 批量删除redis
     */
    public Long delMany(Collection<T> keys) {
        /**
         *  这种循环的形式看似没有毛病，但是有问题
         *  假设有10个key需要删除
         *      其中九个都删了，但是只有一个没有删，如果这一个不是在最后
         *      那么结果返回一定大于0
         *      不能使用循环操作
         *
         */
        if(CollectionUtils.isEmpty(keys)) {
            return 0L;
        } else {
            byte[][] bytes = this.rawkeys(keys);
            return jedisCluster.del(bytes);
        }
    }

    /**
     * @param [key]
     * @return byte[]
     * @date 2020/7/10 17:02
     * 把Object对象转换为字节数组
     */
    private byte[] rawKey(Object key) {
        // 1.判断
        /**
         * 断言就是来判断用的:
         *  如果key有值则会去执行下面的代码
         *  如果key没有，则直接return了
         */
        /*if(key == null) {
            System.out.println("key不存在");
            return null;
        } else {
            if(keySerializer == null && key instanceof byte[]) {
                // 直接转换
                return (byte[]) key;
            } else {
                // 说明条件不满足，需要进行转换
                return keySerializer.serialize(key);
            }
        }*/
        Assert.notNull(key, "non null key required");
        /*if(keySerializer == null && key instanceof byte[]) {
            // 直接转换
            return (byte[]) key;
        } else {
            // 说明条件不满足，需要进行转换
            return keySerializer.serialize(key);
        }*/
        return this.keySerializer == null && key instanceof byte[] ?
                (byte[]) key : this.keySerializer.serialize(key);
    }

    private byte[][] rawkeys(Collection<T> keys) {
        byte[][] rks = new byte[keys.size()][];
        int i = 0;
        Object key;
        for(Iterator i9 = keys.iterator(); i9.hasNext(); rks[i++] = this.rawKey(key)) {
            key = i9.next();
        }
        return rks;
    }
}
