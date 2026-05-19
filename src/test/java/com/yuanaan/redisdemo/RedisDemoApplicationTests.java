package com.yuanaan.redisdemo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

@SpringBootTest
class RedisDemoApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
    }


    @Test
    public void test12() {
        redisTemplate.opsForValue().set("yes", new Yuan().setName("yuanan").setAddress("beijing").setAge(15));
    }

    @Test
    public void test123() {
        System.out.println(redisTemplate.opsForValue().get("yes"));

    }

    @Data
    @Accessors(chain = true)
    public static class Yuan implements Serializable {
        private String name;
        private String address;
        private int age;
            private String hobby;


    }
}

