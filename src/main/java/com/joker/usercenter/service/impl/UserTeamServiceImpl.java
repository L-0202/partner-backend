package com.joker.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joker.usercenter.model.domain.UserTeam;
import com.joker.usercenter.mapper.UserTeamMapper;
import com.joker.usercenter.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author 李保定
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-02-13 20:19:41
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




