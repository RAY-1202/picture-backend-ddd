package com.ray.picturebackend.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.picturebackend.domain.space.entity.SpaceUser;
import com.ray.picturebackend.domain.space.repository.SpaceUserRepository;
import com.ray.picturebackend.infrastructure.mapper.SpaceUserMapper;
import org.springframework.stereotype.Service;

@Service
public class SpaceUserRepositoryImpl extends ServiceImpl<SpaceUserMapper, SpaceUser> implements SpaceUserRepository {
}