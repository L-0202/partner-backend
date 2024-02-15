package com.joker.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -2980521012160771588L;
    /**
     * 页面大小（默认为10）
     */
    protected int pageSize = 10;

    /**
     * 当前为第几页（默认为第一页）
     */
    protected int pageNum = 1;

}
