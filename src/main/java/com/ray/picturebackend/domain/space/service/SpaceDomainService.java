package com.ray.picturebackend.domain.space.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ray.picturebackend.domain.space.entity.Space;
import com.ray.picturebackend.domain.user.entity.User;
import com.ray.picturebackend.interfaces.dto.space.SpaceQueryRequest;

public interface SpaceDomainService {

    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 根据空间级别填充空间对象
     *
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 校验空间权限
     *
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}