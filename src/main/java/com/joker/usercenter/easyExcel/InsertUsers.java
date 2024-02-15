package com.joker.usercenter.easyExcel;

import com.joker.usercenter.mapper.UserMapper;
import com.joker.usercenter.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;


/**
 * 批量插入新数据
 */
//@Component
//public class InsertUsers {
//
//    @Resource
//    private UserMapper userMapper;
//
//    @Scheduled(initialDelay = 5000,fixedRate = Long.MAX_VALUE)
//    public void doInsertUsers(){
//        StopWatch stopWatch = new StopWatch();
//        final int INSERT_NUM = 10000000;
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setUsername("testUser");
//            user.setUserAccount("testUser");
//            user.setAvatarUrl("https://img1.baidu.com/it/u=1645832847,2375824523&fm=253&fmt=auto&app=138&f=JPEG?w=480&h=480");
//            user.setGender(0);
//            user.setUserPassword("12345678");
//            user.setEmail("123@qq.com");
//            user.setUserStatus(0);
//            user.setPhone("666666");
//            user.setUserRole(0);
//            user.setPlanetCode("11111");
//            userMapper.insert(user);
//        }
//        stopWatch.stop();
//        System.out.println(stopWatch.getTotalTimeMillis());
//    }
//}
