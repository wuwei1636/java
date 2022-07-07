package com.li.dao;

// 部门dao

import com.li.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DepartmentDao {

    //    模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;

    static {

        departmentMap = new HashMap<Integer,Department>(); // 创建一个功能表

        departmentMap.put(101,new Department(101,"教学部"));
        departmentMap.put(102,new Department(102,"市场部"));
        departmentMap.put(103,new Department(103,"运营部"));
        departmentMap.put(104,new Department(104,"教研部"));
        departmentMap.put(105,new Department(105,"后勤部"));

    }

    //    数据库的操作
//    获得所有部门信息
    public Collection<Department> getDepartment(){
        return departmentMap.values();
    }

    // 通过id获取部门信息
    public Department getDepartment(Integer id){
        return departmentMap.get(id);
    }

}
