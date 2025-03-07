package com.cse.geo.domain.impl;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cse.geo.domain.entity.Spot;
import com.cse.geo.domain.repository.SpotRepository;
import com.cse.geo.infrastructure.repositories.mapper.SpotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SpotRepositoryImpl implements SpotRepository {

    private final SpotMapper spotMapper;

    @Override
    public List<Spot> queryAllSpot(String spotType) {
        LambdaQueryWrapper<Spot> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtil.notNullNorEmpty(spotType), Spot::getSpotId, spotType);
        return spotMapper.selectList(wrapper);
    }

    @Override
    public Spot querySpotById(String id) {
        LambdaQueryWrapper<Spot> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Spot::getSpotId, id);
        return spotMapper.selectOne(wrapper);
    }
}