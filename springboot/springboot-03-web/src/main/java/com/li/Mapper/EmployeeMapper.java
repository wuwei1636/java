package com.li.Mapper;

import com.li.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface EmployeeMapper {

    int addEmployee(Employee employee);

    Collection<Employee> getAllEmployee();

    Employee getEmployee(int id);

    int update(Employee employee);

    int delete(int id);


}
