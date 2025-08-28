package com.ray.picturebackend.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.picturebackend.domain.picture.entity.Picture;
import com.ray.picturebackend.domain.picture.repository.PictureRepository;
import com.ray.picturebackend.infrastructure.mapper.PictureMapper;
import org.springframework.stereotype.Service;

@Service
public class PictureRepositoryImpl extends ServiceImpl<PictureMapper, Picture> implements PictureRepository {
}