package com.ray.picturebackend.shared.websocket;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.ray.picturebackend.application.service.SpaceApplicationService;
import com.ray.picturebackend.application.service.UserApplicationService;
import com.ray.picturebackend.shared.auth.SpaceUserAuthManager;
import com.ray.picturebackend.shared.auth.model.SpaceUserPermissionConstant;
import com.ray.picturebackend.domain.picture.entity.Picture;
import com.ray.picturebackend.domain.space.entity.Space;
import com.ray.picturebackend.domain.user.entity.User;
import com.ray.picturebackend.domain.space.valueobject.SpaceTypeEnum;
import com.ray.picturebackend.application.service.PictureApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * WebSocket 拦截器，建立连接前要先校验
 */
@Slf4j
@Component
public class WsHandshakeInterceptor implements HandshakeInterceptor {

    @Resource
    private UserApplicationService userApplicationService;

    @Resource
    private PictureApplicationService pictureApplicationService;

    @Resource
    private SpaceApplicationService spaceApplicationService;

    @Resource
    private SpaceUserAuthManager spaceUserAuthManager;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 获取当前登录用户
        if(request instanceof ServletServerHttpRequest) {
            HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            // 从请求中获取参数
            String pictureId = httpServletRequest.getParameter("pictureId");
            if (StrUtil.isBlank(pictureId)) {
                log.error("缺少图片参数。拒绝握手");
                return false;
            }
            // 获取当前登录用户
            User loginUser = userApplicationService.getLoginUser(httpServletRequest);
            if (ObjUtil.isEmpty(loginUser)) {
                log.error("用户未登录。拒绝握手");
                return false;
            }
            // 校验用户是否有编辑当前图片权限
            Picture picture = pictureApplicationService.getById(pictureId);
            if (ObjUtil.isEmpty(picture)) {
                log.error("图片不存在。拒绝握手");
                return false;
            }
            Long spaceId = picture.getSpaceId();
            Space space = null;
            if (spaceId != null) {
                space = spaceApplicationService.getById(spaceId);
                if (ObjUtil.isEmpty(space)) {
                    log.error("空间不存在。拒绝握手");
                    return false;
                }
                if (space.getSpaceType() != SpaceTypeEnum.TEAM.getValue()) {
                    log.error("图片所在空间不是团队空间，拒绝握手");
                    return false;
                }
            }
            // 如果是团队空间，并且有编辑者权限，才能编辑
            List<String> permissionList = spaceUserAuthManager.getPermissionList(space, loginUser);
            if (!permissionList.contains(SpaceUserPermissionConstant.PICTURE_EDIT)) {
                log.error("用户没有编辑图片权限。拒绝握手");
                return false;
            }
            // 设置用户登录信息等属性到 WebSocket 会话中
            attributes.put("user", loginUser);
            attributes.put("userId", loginUser.getId());
            attributes.put("pictureId", Long.valueOf(pictureId));
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
    }
}
