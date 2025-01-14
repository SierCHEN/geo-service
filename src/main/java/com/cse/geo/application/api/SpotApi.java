package com.cse.geo.application.api;

import com.cse.geo.application.service.SpotService;
import com.cse.geo.domain.entity.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpotApi {
    private final SpotService spotService;

    @GetMapping("/spots")
    public List<Spot> queryAllSpot() {
        return spotService.queryAllSpot();
    }
}