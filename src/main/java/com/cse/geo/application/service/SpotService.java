package com.cse.geo.application.service;

import com.cse.geo.domain.entity.Spot;
import com.cse.geo.domain.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {

    private final SpotRepository spotRepository;

    public List<Spot> queryAllSpot() {
        List<Spot> spots = spotRepository.queryAllSpot(null);
        return spots;
    }
}