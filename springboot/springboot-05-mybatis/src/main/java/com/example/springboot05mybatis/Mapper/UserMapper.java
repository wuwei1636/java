package com.example.springboot05mybatis.Mapper;


import com.example.springboot05mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> userList();

    User queryUserId(int id);

    int update(User user);

    int addUser(User user);

    int delete(int id);

}
