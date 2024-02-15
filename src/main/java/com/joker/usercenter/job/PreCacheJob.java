package com.joker.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joker.usercenter.model.domain.User;
import com.joker.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 数据预热
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    //重点用户信息预热

    private List<Long> mainUserList = Arrays.asList(1L);

    //每天执行，预热加载用户信息

    @Scheduled(cron = "0 55 0 * * *")
    public void doCacheRecommendUser(){
        RLock rLock = redissonClient.getLock("partner:precachejob:docache:lock");
        try {
            //只有一个线程获取到锁
            //等待时间为0，且不自动解锁
            if (rLock.tryLock(0,-1,TimeUnit.MILLISECONDS)){
                System.out.println("lock ThreadId:" + Thread.currentThread().getId());
                for (Long userId : mainUserList) {
                    //查数据库
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("joker:recommend:%s",mainUserList);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    //写缓存，30s后过期
                    try {
                        valueOperations.set(redisKey,userPage,30000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set error",e);
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("doCacheJob error",e);
        } finally {
            //只能释放自己的锁
            if (rLock.isHeldByCurrentThread()){
                System.out.println("unlock ThreadId:" + Thread.currentThread().getId());
                rLock.unlock();
            }
        }
    }
}
