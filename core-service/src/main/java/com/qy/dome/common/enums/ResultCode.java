package com.qy.dome.common.enums;

public enum ResultCode {

    /*
    请求返回状态码和说明信息
     */
    SUCCESS(200, "成功"),
    ERROR_PARAM(2002, "参数异常"),
    RESOURCE_ERROR(2003, "系统异常"),
    DATA_ERROR(2004, "数据异常"),
    REQUEST_ERROR(2005, "请求太频繁"),
    SERVER_ERROR(5000, "服务器内部错误"),
    ;

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
