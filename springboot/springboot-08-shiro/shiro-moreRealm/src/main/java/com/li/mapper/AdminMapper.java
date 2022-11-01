package com.li.mapper;


import com.li.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    Admin queryAdminByName(String name);

}
