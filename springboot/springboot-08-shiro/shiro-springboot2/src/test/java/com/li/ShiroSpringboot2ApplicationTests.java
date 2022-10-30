package com.li;

import com.li.pojo.User;
import com.li.service.Impl.UserServiceImpl;
import com.li.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringboot2ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        User user = userService.queryUserByName("李四");

        System.out.println(userService.queryUserByName("李四"));

        System.out.println(md5(user.getPwd(), user.getName()));
    }


    public static final String md5(String password, String salt){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 10;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return result.toString();
    }

}
