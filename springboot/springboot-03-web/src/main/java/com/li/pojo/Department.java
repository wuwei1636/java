package com.li.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private int id;
    private String departmentName;


}
