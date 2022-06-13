package com.li.mapper;

import com.li.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> selectUser() {

        User user = new User(6, "小王", "123324");

        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);


        mapper.addUser(user);
        mapper.del(6);

        return mapper.selectUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int del(int id) {
        return getSqlSession().getMapper(UserMapper.class).del(id);
    }
}
