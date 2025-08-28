package com.ray.picturebackend.interfaces.vo.picture;

import lombok.Data;

import java.util.List;

/**
 * 标签和分类列表视图
 */
@Data
public class PictureTagCategory {

    /**
     * 标签列表
     */
    private List<String> tagList;

    /**
     * 分类列表
     */
    private List<String> categoryList;
}