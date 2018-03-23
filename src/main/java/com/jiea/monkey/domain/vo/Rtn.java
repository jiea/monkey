package com.jiea.monkey.domain.vo;

public class Rtn {

    private Integer code;

    private String msg;

    public Rtn(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Rtn ok(){
        return new Rtn(0, "success");
    }

    public static Rtn ok(String msg){
        return new Rtn(0, msg);
    }

    public static Rtn error(){
        return new Rtn(500, "系统错误，请联系管理员");
    }

    public static Rtn error(String msg){
        return new Rtn(500, msg);
    }

    public static Rtn error(Integer code, String msg){
        return new Rtn(code, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
