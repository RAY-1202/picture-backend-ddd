package com.ray.picturebackend.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.picturebackend.domain.user.entity.User;
import com.ray.picturebackend.domain.user.repository.UserRepository;
import com.ray.picturebackend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl extends ServiceImpl<UserMapper, User> implements UserRepository {
}
