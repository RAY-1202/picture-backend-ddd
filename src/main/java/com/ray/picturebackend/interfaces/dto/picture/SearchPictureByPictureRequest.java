package com.ray.picturebackend.interfaces.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 搜索相似图片请求
 */
@Data
public class SearchPictureByPictureRequest implements Serializable {

    /**
     * 图片 id
     */
    private Long pictureId;

    private static final long serialVersionUID = 1L;
}
