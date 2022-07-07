package com.li.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer gender;  // 0 : 女   1 : 男

    private int departmentId;
    private Department department;
    private Date birth;

    public Employee(Integer id, String name, String email, Integer gender, Department department,int departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.departmentId = departmentId;
        this.birth = new Date();
    }
}
