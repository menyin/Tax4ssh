package com.cny.nsfw.user.action;

import com.cny.exception.ActionException;
import com.cny.exception.SysException;
import com.cny.nsfw.user.entity.User;
import com.cny.nsfw.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.*;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserAction extends ActionSupport implements SessionAware, RequestAware, ApplicationAware,ServletRequestAware,ServletResponseAware{
    private UserService userService;
    private User user;

    private File headImg;
    private String headImgContentType;
    private String headImgFileName;

    HttpServletRequest servletRequest;
    HttpServletResponse servletResponse;

    /**
     * 测试ajax接口
      */
    public void ajax() throws IOException {
        //获取请求参数
        //String dept = this.request.get("dept");//这个为什么不行
        String dept = this.servletRequest.getParameter("dept");
        //处理参数并获取数据库数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "请求成功");
        List<String> list = new ArrayList<String>();
        list.add("陈百强");
        list.add("张学友");
        list.add("黄家驹");
        list.add("林子祥");
        jsonObject.accumulate("data", list);
        //数据返回给响应流
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write(jsonObject.toString());
    }

    public String listUI() throws Exception{
        //测试全局异常处理
        //int i = 1 / 0;
        /*try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionException("尼玛~， 控制器出错了~~");
        }*/

        /*ActionContext context = ActionContext.getContext();
        Map<String, Object> request= context.getContextMap();*/
        List<User> userList = userService.findObjects();
//        List<User> userList = new ArrayList<User>();
//        userList.add(new User("111", "技术部", "menyin0", "张小龙", "123456", "http://www.baidu.com", true, "停用", "13960392037", "845257580@qq.com", new Date(), "革命先驱"));
//        userList.add(new User("111", "设计部", "menyin0", "释小龙", "123456", "http://www.baidu.com", true, "停用", "13960392037", "845257580@qq.com", new Date(), "革命先驱"));
        request.put("userList", userList); //直接采用接口注入
        return "listUI";
    }

    public String addUI() {
        return "addUI";
    }

    public String add() {
        try {
            if (user != null) {
                if (headImg != null) {
                    //1、保存头像到upload/user
                    //获取保存路径的绝对地址
                    String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
                    String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
                    //复制文件
                    FileUtils.copyFile(headImg, new File(filePath, fileName));

                    //2、设置用户头像路径
                    user.setHeadImg("user/" + fileName);
                }
                userService.save(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "list";
    }

    public String editUI() {
        if (user != null && user.getId() != null) {
            user = userService.findObjectById(user.getId());
        }
        request.put("user", user);
        return "editUI";
    }

    public String edit() {
        try {
            if (user != null) {
                //处理头像
                if (headImg != null) {
                    //1、保存头像到upload/user
                    //获取保存路径的绝对地址
                    String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
                    String fileName = UUID.randomUUID().toString().replaceAll("-", "") + headImgFileName.substring(headImgFileName.lastIndexOf("."));
                    //复制文件
                    FileUtils.copyFile(headImg, new File(filePath, fileName));

                    //2、设置用户头像路径
                    user.setHeadImg("user/" + fileName);
                }
                userService.update(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return "list";
    }

    public String delete() {
        if (user != null && user.getId() != null) {
            userService.delete(user.getId());
        }
        return "list";
    }

    public String deleteSelected() {
        if (selectedRow != null) {
            for (String id : selectedRow) {
                userService.delete(id);
            }
        }
        return "list";
    }

    private String[] selectedRow;

    public void setSelectedRow(String[] selectedRow) {
        this.selectedRow = selectedRow;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public User getUser() {
        return user;
    }

    public File getHeadImg() {
        return headImg;
    }

    public void setHeadImg(File headImg) {
        this.headImg = headImg;
    }

    public String getHeadImgContentType() {
        return headImgContentType;
    }

    public void setHeadImgContentType(String headImgContentType) {
        this.headImgContentType = headImgContentType;
    }

    public String getHeadImgFileName() {
        return headImgFileName;
    }

    public void setHeadImgFileName(String headImgFileName) {
        this.headImgFileName = headImgFileName;
    }

    private Map<String, Object> application;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    private Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.servletRequest = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.servletResponse = httpServletResponse;
    }
}
