package com.joker.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.usercenter.model.domain.Team;
import com.joker.usercenter.model.domain.User;

/**
* @author joker
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-02-13 19:54:58
*/
public interface TeamService extends IService<Team> {

    /**
     *添加队伍
     * @param team 队伍
     * @param loginUser 当前登录用户
     * @return
     */
    long addTeam(Team team,User loginUser);
}
