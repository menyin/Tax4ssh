package com.cny.nsfw.user.service;

import com.cny.exception.ServiceException;
import com.cny.nsfw.user.entity.User;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public interface UserService {
    //新增
    public void save(User user);
    //更新
    public void update(User user);
    //根据id删除O
    public void delete(Serializable id);
    //根据id查找
    public User findObjectById(Serializable id);
    //查找列表
    public List<User> findObjects() throws ServiceException;
    //导出用户列表
    public void exportExcel(List<User> userList, ServletOutputStream outputStream);
    //导入用户列表
    public void importExcel(File userExcel, String userExcelFileName);
    //根据用户名和密码获取用户
    public List<User> findUserByAccountAndPass(String userAccount, String userPassword);
    //根据用户id获取用户角色//暂时不做
//    public List<UserRole> getUserRolesByUserId(String id);

}
