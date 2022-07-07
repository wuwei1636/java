package com.li.service;

import com.li.Mapper.DepartmentMapper;
import com.li.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Collection<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }

    @Override
    public Department getDepartment(Integer id) {
        return departmentMapper.getDepartment(id);
    }
}
