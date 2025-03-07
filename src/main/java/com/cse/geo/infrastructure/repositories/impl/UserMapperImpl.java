package com.cse.geo.infrastructure.repositories.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse.geo.domain.entity.User;
import com.cse.geo.infrastructure.repositories.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl extends ServiceImpl<UserMapper, User> {
}
