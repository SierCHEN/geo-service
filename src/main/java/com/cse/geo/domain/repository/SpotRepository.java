package com.cse.geo.domain.repository;

import com.cse.geo.domain.entity.Spot;

import java.util.List;


public interface SpotRepository {
    List<Spot> queryAllSpot(String spotType);

    Spot querySpotById(String id);
}