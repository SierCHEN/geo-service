package com.cse.geo.infrastructure.repositories.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse.geo.domain.entity.Spot;
import com.cse.geo.infrastructure.repositories.mapper.SpotMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SpotMapperImpl extends ServiceImpl<SpotMapper, Spot>  {

}