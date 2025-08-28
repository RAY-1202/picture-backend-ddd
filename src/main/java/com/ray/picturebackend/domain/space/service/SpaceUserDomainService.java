package com.ray.picturebackend.domain.space.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ray.picturebackend.domain.space.entity.SpaceUser;
import com.ray.picturebackend.interfaces.dto.spaceuser.SpaceUserQueryRequest;

public interface SpaceUserDomainService {

    /**
     * 获取查询对象
     *
     * @param spaceUserQueryRequest
     * @return
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);
}