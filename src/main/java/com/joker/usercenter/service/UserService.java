package com.joker.usercenter.service;

import com.joker.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.usercenter.model.vo.UserVO;
import io.swagger.models.auth.In;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 李保定
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-01-23 10:48:56
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @param planetCode 星球编号
     * @return
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);

    /**
     * @param userAccount        用户账户
     * @param userPassword       用户密码
     * @param request  用户登录状态
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user,User loginUser);

    /**
     * 获取当前用户信息
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 鉴权，是否为管理员
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     * @param loginUser
     * @return
     */
    boolean isAdmin(User loginUser);

    /**
     * 匹配用户
     * @param num
     * @param loginUser
     * @return
     */
    List<User> matchUser(long num, User loginUser);
}
