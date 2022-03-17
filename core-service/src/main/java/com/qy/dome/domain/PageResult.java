package com.qy.dome.domain;



import com.qy.dome.common.enums.ResultCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by huangch on 2019/8/14 11:04 description:
 *
 * @since JDK 1.6
 */
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 3188644681821190677L;

    private Integer code;

    private String msg;

    //分页查询count总数.
    private Long total;

    //当前页数
    private Integer pageNo = 1;

    //展示条数
    private Integer pageSize = 20;

    //总页数
    private Integer pageTotal;

    //分页查询结果集.
    private List<T> data;

    public PageResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = new ArrayList<>();
    }

    public PageResult(ResultCode code, List<T> data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public PageResult() {
    }


    /**
     * 构造函数返回分页对象
     */
    public PageResult(Long total, Integer pageNo, Integer pageSize, List<T> data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.pageTotal = setPageTotal(pageSize);
        this.data = data;
    }

    //构造函数返回下载对象
    public PageResult(Long total, List<T> data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.total = total;
        this.data = data;
    }


    public static PageResult empty() {
        return new PageResult(0L, 0, 0, Collections.emptyList());
    }

    public static <T> PageResult<T> success() {
        return new PageResult<T>(ResultCode.SUCCESS.getCode(), "");
    }

    public static <T> PageResult<T> successResult(List<T> data) {
        return new PageResult<T>(ResultCode.SUCCESS, data);
    }

    public static <T> PageResult<T> successResult(Long total, Integer pageNo, Integer pageSize, List<T> data) {
        return new PageResult<T>(total, pageNo, pageSize, data);
    }

    public static <T> PageResult<T> successMessage(String msg) {
        return new PageResult<T>(ResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> PageResult<T> failure(ResultCode code) {
        return failure(code, null);
    }

    public static <T> PageResult<T> failure(ResultCode code, List<T> data) {
        return new PageResult<T>(code, data);
    }

    public static <T> PageResult<T> failure(Integer code, String msg) {
        return new PageResult<T>(code, msg);
    }


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        if (total < 0) {
            this.total = 0L;
            return;
        }
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
            return;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 设置总页数.
     */
    private Integer setPageTotal(int pageSize) {
        if (pageSize == 0) {
            return 0;
        }
        if (total < 0) {
            pageTotal = 0;
        } else {
            pageTotal = (total.intValue() % pageSize == 0) ? total.intValue() / pageSize : total.intValue() / pageSize + 1;
        }
        return pageTotal;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }


}
