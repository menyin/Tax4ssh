package com.cny.nsfw.role.entity;

import java.io.Serializable;
import java.util.Objects;

public class RolePrivilegeKey implements Serializable {
    private Role role;

    private String code;

    public RolePrivilegeKey() {
    }
    public RolePrivilegeKey(Role role, String code) {
        this.role = role;
        this.code = code;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePrivilegeKey that = (RolePrivilegeKey) o;
        return Objects.equals(role, that.role) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(role, code);
    }


}
