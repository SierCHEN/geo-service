package com.cse.geo.domain.repository;

import com.cse.geo.domain.entity.Spot;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SpotRepository {
    List<Spot> queryAllSpot(String spotType);
}