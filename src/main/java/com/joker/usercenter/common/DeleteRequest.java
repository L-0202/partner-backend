package com.joker.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求参数
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = -2980521012160771588L;

    /**
     * id
     */
    private long id;

}
