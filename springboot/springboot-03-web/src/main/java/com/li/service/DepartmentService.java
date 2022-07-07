package com.li.service;

import com.li.pojo.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface DepartmentService {

    //获取所有的department
    Collection<Department> getAllDepartment();


    // 通过id获取department
    Department getDepartment(Integer id);

}
