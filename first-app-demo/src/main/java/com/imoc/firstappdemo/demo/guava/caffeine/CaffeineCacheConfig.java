package com.imoc.firstappdemo.demo.guava.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author jianghua
 * @date 2021/01/30
 */
@Configuration
public class CaffeineCacheConfig {
    /**
     * examples:https://www.programcreek.com/java-api-examples/?api=com.github.benmanes.caffeine.cache.AsyncLoadingCache
     * https://www.jianshu.com/p/9a80c662dac4
     */
    /**
     * initialCapacity: 初始的缓存空间大小
     * maximumSize: 缓存的最大数量
     * maximumWeight: 缓存的最大权重
     * expireAfterAccess: 最后一次读或写操作后经过指定时间过期
     * expireAfterWrite: 最后一次写操作后经过指定时间过期
     * refreshAfterWrite: 创建缓存或者最近一次更新缓存后经过指定时间间隔，刷新缓存
     * weakKeys: 打开key的弱引用
     * weakValues：打开value的弱引用
     * softValues：打开value的软引用
     * recordStats：开发统计功能
     */

    @Bean
    public AsyncLoadingCache<String, UserInfo> caffeineCache() {
        // 1、最简单
    //    Cache<String, Object> cache = Caffeine.newBuilder()
    //            .build();
        // 2、真实使用过程中我们需要自己配置参数。这里只列举部分，具体请看下面列表
//        Cache<String, String> cache = Caffeine.newBuilder()
//                .initialCapacity(300)//初始大小
//                .maximumSize(1300)//最大数量
//                .refreshAfterWrite(3, TimeUnit.DAYS)//过期时间
//                .build();
        // 2、真实使用过程中我们需要自己配置参数。这里只列举部分，具体请看下面列表
        AsyncLoadingCache<String, UserInfo> cache = Caffeine.newBuilder()
                .initialCapacity(2)//初始大小
                .maximumSize(5)//最大数量
                .refreshAfterWrite(10, TimeUnit.MINUTES)//过期时间
                .buildAsync(k -> getValueFromDB(k).get());
        return cache;
    }


    public CompletableFuture<UserInfo> getValueFromDB(String key){
        return CompletableFuture.supplyAsync(() -> {
            UserInfo info = new UserInfo();
            info.setId(key);
            info.setName("江." + key);
            System.out.println("查询." + info);
            return info;
        });
    }




}
