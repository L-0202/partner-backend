package com.joker.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.usercenter.model.domain.Team;
import com.joker.usercenter.model.domain.User;
import com.joker.usercenter.model.dto.TeamQuery;
import com.joker.usercenter.model.request.TeamJoinRequest;
import com.joker.usercenter.model.request.TeamQuitRequest;
import com.joker.usercenter.model.request.TeamUpdateRequest;
import com.joker.usercenter.model.vo.TeamUserVO;

import java.util.List;

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

    /**
     * 搜索队伍
     * @param teamQuery 队伍封装类
     * @param isAdmin 是否为管理员
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍信息
     * @param teamUpdateRequest 队伍更新请求封装类
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    /**
     * 用户加入队伍
     * @param teamJoinRequest 用户加入队伍请求封装体
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);

    /**
     * 用户退出队伍
     * @param teamQuitRequest 用户退出队伍请求封装体
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest,User loginUser);

    /**
     * 队长解散队伍
     * @param id 队伍id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id,User loginUser);
}
