package com.cny.nsfw.home.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
    public String home(){
        return "home";
    }
    public String frame(){
        return "frame";
    }
    public String top(){
        return "top";
    }
    public String left(){
        return "left";
    }
}
