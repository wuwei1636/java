package com.li.service;

import com.li.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface EmployeeService {

    int addEmployee(Employee employee);

    Collection<Employee> getAllEmployee();

    Employee getEmployee(int id);

    int update(Employee employee);

    int delete(int id);

}
