package com.cny.login.action;

import com.cny.nsfw.user.entity.User;
import com.cny.nsfw.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware{
    private UserService userService;
    private String loginResult;
    private User user;

    Map<String, Object> session;


    //登录界面
    public String loginUI() {
        return "loginUI";
    }

    //登录

    public String login() {

//        ActionContext actionContext = ServletActionContext.getActionContext(request);
        if (user != null) {
            if (StringUtils.isNotBlank(user.getAccount()) && StringUtils.isNotBlank(user.getPassword())) {
                List<User> userList = userService.findUserByAccountAndPass(user.getAccount(), user.getPassword());
                if (userList != null && userList.size() > 0) {
                    User user = userList.get(0);
                    //根据用户的id获取用户角色并存储到用户实体中//暂时不做

                    //将用户信息存储到session中
                    session.put("user", user);

                    //将登录操作记录日志
                    Log log = LogFactory.getLog(getClass());
                    log.info("用户【" + user.getName() + "】登录系统 " + new Date().toString());
                    return "home";
                } else {
                    loginResult = "账号或密码错误！";
                }
            } else {
                loginResult = "账号和密码都不能为空！";
            }
        } else {
            loginResult = "请输入账号和密码";
        }
        return "loginUI";
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
