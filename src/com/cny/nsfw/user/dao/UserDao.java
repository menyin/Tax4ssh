package com.cny.nsfw.user.dao;

import com.cny.core.dao.BaseDao;
import com.cny.nsfw.user.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User>{
    public List<User> findUserByAccountAndPass(String userAccount, String userPassword);
}
