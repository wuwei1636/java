package com.li.mapper;

import com.li.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> seleectuser() {

        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        return mapper.seleectuser();
        return getSqlSession().getMapper(UserMapper.class).seleectuser();
    }
}
