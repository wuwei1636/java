package com.li.Mapper;

import com.li.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //查询所有用户
    List<User> userList();

    User queryUserByName(@Param("name") String name, @Param("pwd") String pwd);

    User queryUserName(@Param("name") String name);
}
