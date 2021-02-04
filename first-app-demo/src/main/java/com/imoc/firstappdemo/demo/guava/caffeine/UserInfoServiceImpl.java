package com.imoc.firstappdemo.demo.guava.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author jianghua
 * @date 2021/01/30
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private AsyncLoadingCache<String, UserInfo> caffeineCache;

    @Override
    public UserInfo getByUserId(String id) {
        try {
            CompletableFuture<UserInfo> future = caffeineCache.get(id);
            UserInfo result = future.get(3, TimeUnit.SECONDS);
            return result;
        } catch (Exception e) {
            log.error("getByName failed.{}", e);
        }
        return null;
    }
}
