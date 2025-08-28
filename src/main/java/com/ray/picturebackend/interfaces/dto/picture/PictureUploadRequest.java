package com.ray.picturebackend.interfaces.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片上传请求
 */
@Data
public class PictureUploadRequest implements Serializable {
  
    /**  
     * 图片 id（用于修改）  
     */  
    private Long id;

    /**
     * 空间 id
     */
    private Long spaceId;


    /**
     * 图片 url
     */
    private String fileUrl;

    /**
     * 图片名称
     */
    private String picName;

  
    private static final long serialVersionUID = 1L;  
}
