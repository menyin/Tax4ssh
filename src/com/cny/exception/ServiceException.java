package com.cny.exception;

public class ServiceException extends SysException {
    public ServiceException() {
        super("业务操作错误！");
    }
    public ServiceException(String errorMsg) {
        super(errorMsg);
    }

    public ServiceException(Throwable cause, String errorMsg) {
        super(cause, errorMsg);
    }
}
