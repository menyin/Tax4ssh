package com.cny.exception;

public abstract class SysException extends Exception{
    private String errorMsg;

    public SysException() {
    }

    public SysException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public SysException(Throwable cause, String errorMsg) {
        super(cause);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
