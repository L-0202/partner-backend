package com.joker.usercenter.service;

import com.joker.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test(){
        //增
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("userString","userString");
        valueOperations.set("userInt",100121);
        valueOperations.set("userDouble",2.5);
        User user = new User();
        user.setUsername("testUser");
        user.setId(1L);
        valueOperations.set("userObject",user);
        //查
        Object userTest = valueOperations.get("userString");
        Assertions.assertTrue("userString".equals((String) userTest));
        userTest = valueOperations.get("userInt");
        Assertions.assertTrue(100121 == (Integer)userTest);
        userTest = valueOperations.get("userInt");
        Assertions.assertTrue(100121 == (Integer)userTest);
        userTest = valueOperations.get("userDouble");
        Assertions.assertTrue(2.5 == (Double) userTest);
        System.out.println(valueOperations.get("userObject"));
    }
}
