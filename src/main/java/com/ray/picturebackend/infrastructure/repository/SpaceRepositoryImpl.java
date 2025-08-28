package com.ray.picturebackend.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.picturebackend.domain.space.entity.Space;
import com.ray.picturebackend.domain.space.repository.SpaceRepository;
import com.ray.picturebackend.infrastructure.mapper.SpaceMapper;
import org.springframework.stereotype.Service;

@Service
public class SpaceRepositoryImpl extends ServiceImpl<SpaceMapper, Space> implements SpaceRepository {
}