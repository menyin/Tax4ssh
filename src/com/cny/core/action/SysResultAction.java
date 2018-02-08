package com.cny.core.action;

import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysResultAction extends StrutsResultSupport {

    @Override
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
//        BaseAction action = (BaseAction)invocation.getAction();//此操作要求每个Action继承自定义的基础Action

        //do something
        System.out.println("进入了 SysResultAction ...可在此操作请求响应流和当前action实例 ... ");
    }
}
