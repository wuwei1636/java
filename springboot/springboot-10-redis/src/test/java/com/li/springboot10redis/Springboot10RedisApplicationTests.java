package com.li.springboot10redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.li.springboot10redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试的时候 要开启 redis-server.exe
     */
    @Test
    void contextLoads() {

    //    redisTemplate
    //    opsForValue() 操作字符串 ，类似string
    //     获取链接
    //    RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
    //    connection.flushDb();
    //    connection.flushAll();

        redisTemplate.opsForValue().set("myksy","lks");
        System.out.println(redisTemplate.opsForValue().get("myksy"));

    }

    @Test
    void  text1() throws JsonProcessingException {
        User user = new User("李坤松", 4);
        String s = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",s);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
