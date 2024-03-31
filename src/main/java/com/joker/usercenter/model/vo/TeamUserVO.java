package com.joker.usercenter.model.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 队伍用户信息的封装类（脱敏）
 */
@Data
public class TeamUserVO implements Serializable {
    
    private static final long serialVersionUID = 4573996075532238731L;
    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 用户id（队长 id）
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;


    /**
     * 队伍用户列表
     */
    List<UserVO> userList;

    /**
     * 队伍创建者的用户信息
     */
    private UserVO createUser;

    /**
     * 已经加入的用户数
     */
    private Integer hasJoinNum;

    /**
     * 是否已加入队伍
     */
    private boolean hasJoin = false;
}
