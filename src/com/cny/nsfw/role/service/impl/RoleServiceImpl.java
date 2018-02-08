package com.cny.nsfw.role.service.impl;

import com.cny.nsfw.role.dao.RoleDao;
import com.cny.nsfw.role.entity.Role;
import com.cny.nsfw.role.service.RoleService;

import java.io.Serializable;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void save(Role entity) {
        this.roleDao.save(entity);
    }

    @Override
    public void update(Role entity) {
        this.roleDao.update(entity);
    }

    @Override
    public void delete(Serializable id) {
        this.roleDao.delete(id);
    }

    @Override
    public Role findObjectById(Serializable id) {
        return this.roleDao.findObjectById(id);
    }

    @Override
    public List<Role> findObjects() {
        return this.roleDao.findObjects();
    }

}
