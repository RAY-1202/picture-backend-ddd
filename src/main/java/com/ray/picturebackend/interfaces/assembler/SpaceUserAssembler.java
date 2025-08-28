package com.ray.picturebackend.interfaces.assembler;

import com.ray.picturebackend.domain.space.entity.SpaceUser;
import com.ray.picturebackend.interfaces.dto.spaceuser.SpaceUserAddRequest;
import com.ray.picturebackend.interfaces.dto.spaceuser.SpaceUserEditRequest;
import org.springframework.beans.BeanUtils;

public class SpaceUserAssembler {

    public static SpaceUser toSpaceUserEntity(SpaceUserAddRequest request) {
        SpaceUser spaceUser = new SpaceUser();
        BeanUtils.copyProperties(request, spaceUser);
        return spaceUser;
    }

    public static SpaceUser toSpaceUserEntity(SpaceUserEditRequest request) {
        SpaceUser spaceUser = new SpaceUser();
        BeanUtils.copyProperties(request, spaceUser);
        return spaceUser;
    }
}
