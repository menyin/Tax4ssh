package com.cny.nsfw.role.entity;

public class RolePrivilege {
    /*private Role role;
         private String code;*/
    private RolePrivilegeKey id;

    public RolePrivilege() {
    }
    public RolePrivilege(RolePrivilegeKey id) {
        this.id = id;
    }

    public RolePrivilegeKey getId() {
        return id;
    }

    public void setId(RolePrivilegeKey id) {
        this.id = id;
    }
}
