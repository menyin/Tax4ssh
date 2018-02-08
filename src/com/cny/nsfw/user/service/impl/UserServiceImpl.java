package com.cny.nsfw.user.service.impl;

import com.cny.exception.ServiceException;
import com.cny.nsfw.user.dao.UserDao;
import com.cny.nsfw.user.entity.User;
import com.cny.nsfw.user.service.UserService;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.List;

import static com.oracle.jrockit.jfr.ContentType.StackTrace;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Serializable id) {
        userDao.delete(id);
    }

    @Override
    public User findObjectById(Serializable id) {
        return userDao.findObjectById(id);
    }

    @Override
    public List<User> findObjects() throws ServiceException{
        /*
        //测试全局异常配置
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new ServiceException("尼玛~， 业务操作出错了~~");
        }*/
        return userDao.findObjects();
    }

    @Override
    public void exportExcel(List<User> userList, ServletOutputStream outputStream) {
        System.out.println("正在导出用户列表...");
        System.out.println("已经导出用户列表...");
    }

    @Override
    public void importExcel(File userExcel, String userExcelFileName) {
        System.out.println("正在导入用户列表...");
        System.out.println("已经导入用户列表...");
    }

    @Override
    public List<User> findUserByAccountAndPass(String userAccount, String userPassword) {
        return userDao.findUserByAccountAndPass(userAccount, userPassword);
    }
}
