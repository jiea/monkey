package com.jiea.monkey.common.exception;

public class MonkeyException extends RuntimeException{

    private int code = 500;
    private String msg;

    public MonkeyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MonkeyException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
