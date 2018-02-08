package com.cny.nsfw.user.dao.impl;

import com.cny.core.dao.impl.BaseDaoImpl;
import com.cny.nsfw.user.dao.UserDao;
import com.cny.nsfw.user.entity.User;
import org.hibernate.Query;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Override
    public List<User> findUserByAccountAndPass(String userAccount, String userPassword) {
        Query query = getSession().createQuery("from User where account=? and password=?");
        query.setString(0, userAccount);
        query.setString(1, userPassword);
        return query.list();
    }
}
