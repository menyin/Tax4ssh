package com.cny.core.permission.impl;

import com.cny.core.permission.PermissionCheck;
import com.cny.nsfw.user.entity.User;

public class PermissionCheckImpl implements PermissionCheck {
    @Override
    public boolean isAccessible(User user, String code) {

        //加载用户角色，并加载角色权限，判断是否有包含code
        //此处不深入编写代码，只做模拟判断
        if ("cny".equals(user.getAccount())&&"nsfw".equals(code)) {
            return true;
        }
        return false;
    }
}
