package com.cse.geo.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GeoRedisUtil {

    private final StringRedisTemplate redisTemplate;

    /**
     * 添加成员
     * @param key
     * @param lon 经度
     * @param lat 纬度
     * @param member 成员
     * @return
     */
    public Long geoAdd(String key, BigDecimal lon, BigDecimal lat, String member){
        return redisTemplate.opsForGeo().add(key, new Point(lon.doubleValue(), lat.doubleValue()), member);
    }

    /**
     * 批量添加成员
     * @param key
     * @param memberCoordinateMap 成员map
     * @return
     */
    public Long geoAdd(String key, Map<String, Point> memberCoordinateMap){
        return redisTemplate.opsForGeo().add(key, memberCoordinateMap);
    }

    /**
     * 获取两个成员的距离
     * @param key
     * @param member1
     * @param member2
     * @return
     */
    public Distance geoDist(String key, String member1, String member2){
        return redisTemplate.opsForGeo().distance(key, member1, member2);
    }

    /**
     * 获取两个成员的距离
     * @param key
     * @param member1
     * @param member2
     * @param metric 度规（枚举）（km、m）
     * @return
     */
    public Distance geoDist(String key, String member1, String member2, Metrics metric){
        return redisTemplate.opsForGeo().distance(key, member1, member2, metric);
    }

    /**
     * 获取成员经纬度
     * @param key
     * @param members
     * @return
     */
    public List<Point> geoPos(String key, String... members){
        return redisTemplate.opsForGeo().position(key, members);
    }

    /**
     * 获取某个成员附近（距离范围内）的成员
     * @param key
     * @param member 成员
     * @param v 距离
     * @param metric  度规（枚举）（km、m）
     * @return
     */
    public List<String> geoRadiusByMember(String key, String member, double v, Metrics metric){
        GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = redisTemplate.opsForGeo().radius(key, member, new Distance(v, metric));
        List<String> result = new ArrayList<>();
        for(GeoResult<RedisGeoCommands.GeoLocation<String>> geoResult :geoResults.getContent()){
            result.add(geoResult.getContent().getName());
        }
        return result;
    }

    /**
     * 获取某个成员附近（距离范围内）的成员
     * @param key
     * @param member 成员
     * @param v 距离
     * @param metric  度规（枚举）（km、m）
     * @param args
     * 示例：RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeCoordinates().includeDistance().limit(1).sortAscending();
     * includeCoordinates：结果包含坐标，includeDistance：结果包含距离，limit：返回数量：sort...：排序
     * @return GeoResults
     * geoResult.getContent().getName() 元素名称
     * geoResult.getContent().getPoint() 元素坐标
     * geoResult.getDistance() 元素距离
     */
    public GeoResults<RedisGeoCommands.GeoLocation<String>> geoRadiusByMember(String key, String member, double v, Metrics metric, RedisGeoCommands.GeoRadiusCommandArgs args){
        return redisTemplate.opsForGeo().radius(key, member, new Distance(v, metric), args);
    }
}