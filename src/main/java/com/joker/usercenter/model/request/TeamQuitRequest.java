package com.joker.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;


/**
 * 用户退出请求体
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = -8572480440870926427L;

    /**
     * 队伍id
     */
    private Long teamId;

}
