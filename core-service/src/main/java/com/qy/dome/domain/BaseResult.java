package com.qy.dome.domain;


import com.qy.dome.common.enums.ResultCode;

import java.io.Serializable;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhinian
 * RESTful API 返回类型
 * Created at 2021/9/2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 783015033603078674L;
    private int code;
    private String msg;
    private T data;

    public static BaseResult<Object> ok() {
        return ok(new HashMap<>(1));
    }
    public static <T> BaseResult<T> ok(T data) {
        return new BaseResult<>(ResultCode.SUCCESS, data);
    }

    public static <T> BaseResult<T> failure(ResultCode code) {
        return failure(code, null);
    }

    public static <T> BaseResult<T> failure(ResultCode code, T o) {
        return new BaseResult<>(code, o);
    }

    public static <T> BaseResult<T> failure(int code, String msg) {
        return new BaseResult<>(code, msg);
    }

    public BaseResult(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(ResultCode resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }


    public static BaseResult success() {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SUCCESS.getCode());
        jsonResult.setMsg(ResultCode.SUCCESS.getMsg());
        return jsonResult;
    }

    public static BaseResult successResult(Object data) {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SUCCESS.getCode());
        jsonResult.setMsg(ResultCode.SUCCESS.getMsg());
        jsonResult.setData(data);
        return jsonResult;
    }

    public static BaseResult successMessage(String message) {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SUCCESS.getCode());
        jsonResult.setMsg(message);
        return jsonResult;
    }

    public static BaseResult failure() {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SERVER_ERROR.getCode());
        return jsonResult;
    }

    public static BaseResult failureResult(Object data) {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SERVER_ERROR.getCode());
        jsonResult.setMsg(ResultCode.SERVER_ERROR.getMsg());
        jsonResult.setData(data);
        return jsonResult;
    }


    public static BaseResult failureMessage(String message, Object data) {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SERVER_ERROR.getCode());
        jsonResult.setMsg(message);
        jsonResult.setData(data);
        return jsonResult;
    }


    public static BaseResult failureMessage(String message) {
        BaseResult jsonResult = new BaseResult();
        jsonResult.setCode(ResultCode.SERVER_ERROR.getCode());
        jsonResult.setMsg(message);
        return jsonResult;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":\"" + data + '\"'+
                '}';
    }


}

