package com.li.Mapper;

import com.li.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper // mybatis
@Repository // 被spring托管
public interface DepartmentMapper {

    //获取所有的department
    Collection<Department> getAllDepartment();


    // 通过id获取department
    Department getDepartment(Integer id);


}
