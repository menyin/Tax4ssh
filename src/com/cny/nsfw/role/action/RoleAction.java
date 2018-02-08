package com.cny.nsfw.role.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class RoleAction extends ActionSupport {
    public String listUI(){
        //相关单元测试详见：console.TestHibernate
        return "listUI";
    }
}
