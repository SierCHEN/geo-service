package com.cse.geo.application.service;

import com.cse.geo.application.api.request.SpotRadiusRequest;
import com.cse.geo.common.enums.SpotRadiusEnum;
import com.cse.geo.common.util.GeoRedisUtil;
import com.cse.geo.domain.entity.Spot;
import com.cse.geo.domain.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Metrics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cse.geo.common.constant.GeoConstants.GEO_KEY;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final SpotRepository spotRepository;

    private final GeoRedisUtil geoRedisUtil;

    public List<String> queryAllSpot() {
        List<String> spots = geoRedisUtil.geoRadiusByMember(GEO_KEY, "c0304660e5be494eaff45ce26fcb9bf9", 1, Metrics.KILOMETERS);
        return spots;
    }

    public List<Spot> querySpotRadius(SpotRadiusRequest request) {
        List<Spot> spots = new ArrayList<>();
        List<String> spotIds = geoRedisUtil.geoRadiusByMember(GEO_KEY, request.getSpotId(), request.getRadius(),
                SpotRadiusEnum.getByCode(request.getRadiusUnit()).getMetrics());
        for (String spotId : spotIds) {
            if (spotId.equals(request.getSpotId())) {
                continue;
            }
            Spot spot = spotRepository.querySpotById(spotId);
            spots.add(spot);
        }
        return spots;
    }


}