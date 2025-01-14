package com.cse.geo.applicationRunner;

import com.cse.geo.common.util.GeoRedisUtil;
import com.cse.geo.domain.entity.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import com.cse.geo.domain.repository.SpotRepository;
import org.springframework.data.geo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cse.geo.common.constant.GeoConstants.GEO_KEY;

@Component
@RequiredArgsConstructor
public class GeoApplicationRunner implements CommandLineRunner {

    private final SpotRepository spotRepository;

    private final StringRedisTemplate redisTemplate;

    private final GeoRedisUtil geoRedisUtil;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello world");
        Map<String, Point> points = new HashMap<>();
        // 清理缓存
        redisTemplate.delete(GEO_KEY);
        // 取数据库中spot数据
        List<Spot> spots = spotRepository.queryAllSpot(null);
        spots.forEach(item -> {
            points.put(item.getSpotId(),
                    new Point(item.getSpotLongitude().doubleValue(), item.getSpotLatitude().doubleValue()));
        });
        geoRedisUtil.geoAdd(GEO_KEY, points);
    }
}
