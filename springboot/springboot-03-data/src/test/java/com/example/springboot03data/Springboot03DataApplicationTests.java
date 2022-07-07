package com.example.springboot03data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot03DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {

        //查看默认的数据源
        System.out.println(dataSource.getClass());

        // 获得数据库连接
        Connection connection = dataSource.getConnection();

        connection.close();


    }

}
