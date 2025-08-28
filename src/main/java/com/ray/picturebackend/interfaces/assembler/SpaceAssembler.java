package com.ray.picturebackend.interfaces.assembler;

import com.ray.picturebackend.domain.space.entity.Space;
import com.ray.picturebackend.interfaces.dto.space.SpaceAddRequest;
import com.ray.picturebackend.interfaces.dto.space.SpaceEditRequest;
import com.ray.picturebackend.interfaces.dto.space.SpaceUpdateRequest;
import org.springframework.beans.BeanUtils;

public class SpaceAssembler {

    public static Space toSpaceEntity(SpaceAddRequest request) {
        Space space = new Space();
        BeanUtils.copyProperties(request, space);
        return space;
    }

    public static Space toSpaceEntity(SpaceUpdateRequest request) {
        Space space = new Space();
        BeanUtils.copyProperties(request, space);
        return space;
    }

    public static Space toSpaceEntity(SpaceEditRequest request) {
        Space space = new Space();
        BeanUtils.copyProperties(request, space);
        return space;
    }
}
