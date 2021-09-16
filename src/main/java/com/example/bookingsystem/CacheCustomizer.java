package com.example.bookingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Autowired
    public CacheCustomizer(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(List.of("seats"));
    }

    private final CacheManager cacheManager;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void clearCacheSchedule(){
        System.out.println("CLEARING");
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();
        }
    }
}