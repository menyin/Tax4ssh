package com.cny.exception;

public class ActionException extends SysException {
    public ActionException() {
        super("控制器操作错误");
    }

    public ActionException(String errorMsg) {
        super(errorMsg);
    }

    public ActionException(Throwable cause, String errorMsg) {
        super(cause, errorMsg);
    }
}
