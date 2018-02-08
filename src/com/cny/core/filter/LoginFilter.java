package com.cny.core.filter;

import com.cny.core.permission.PermissionCheck;
import com.cny.nsfw.user.entity.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (uri.contains("/nsfw/")) {
            //判断是否登录
            Object userObj = request.getSession().getAttribute("user");
            if (userObj != null) {
                User user = (User) userObj;
                WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
                PermissionCheck permissionCheck = (PermissionCheck) webApplicationContext.getBean("permissionCheck");
                boolean nsfw = permissionCheck.isAccessible(user, "nsfw");
                if (nsfw) {
                    //有权限放行
                    filterChain.doFilter(request, response);
                } else {
                    //没权限重定向
                        response.sendRedirect(request.getContextPath() + "/sys/login_toNoPermissionUI");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/sys/login_loginUI");
            }
        } else {
            //非nsfw资源请求直接放行
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
