package com.li.dao;

import com.li.pojo.User;
import com.li.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {


    // 查询所有数据
    @Test
    public void test(){

        // 第一步： 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper(推荐使用)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        // 方式二
//        List<User> userList = sqlSession.selectList("com.li.dao.UserDao.getUserList");

        for(User user : userList){
            System.out.println(user);
        }

        // 关闭sqlSession
        sqlSession.close();

    }

    // 根据id查询数据
    @Test
    public void text(){

        // 第一步： 获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一：getMapper(推荐使用)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);

        System.out.println(userById);

        // 关闭sqlSession
        sqlSession.close();
    }

    // 增删改查需要确定事务
    @Test
    public void insert(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.addUser(new User(4,"困困","123456"));

        if(num > 0){
            System.out.println("插入成功");
        }

        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    // 更新数据
    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.updateUser(new User(1,"平安","12345"));

        if(num > 0){
            System.out.println("修改成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    // 删除数据
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.deleteUser(4);

        if(num > 0){
            System.out.println("删除成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
