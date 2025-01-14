package com.cse.geo.application.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoService {
    private StringRedisTemplate redisTemplate;

    public void syncSpotLocation() {
        redisTemplate.opsForList().leftPush("location", "location");
    }

}