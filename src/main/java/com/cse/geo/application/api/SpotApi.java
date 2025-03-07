package com.cse.geo.application.api;

import com.cse.geo.application.api.request.SpotRadiusRequest;
import com.cse.geo.application.service.SpotService;
import com.cse.geo.domain.entity.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpotApi {
    private final SpotService spotService;

    @GetMapping("/spots")
    public List<String> queryAllSpot() {
        return spotService.queryAllSpot();
    }

    @PostMapping("/spot/radius")
    public List<Spot> querySpotRadius(@RequestBody SpotRadiusRequest request) {
        return spotService.querySpotRadius(request);
    }
}