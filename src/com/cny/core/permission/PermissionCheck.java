package com.cny.core.permission;

import com.cny.nsfw.user.entity.User;

public interface PermissionCheck {
    /**
     * 判断用户是否有指定权限
     * @param user 用户实体
     * @param code 权限编码
     * @return
     */
    public boolean isAccessible(User user,String code);
}
