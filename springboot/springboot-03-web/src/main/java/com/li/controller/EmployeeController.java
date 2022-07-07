package com.li.controller;

import com.li.pojo.Department;
import com.li.pojo.Employee;
import com.li.service.DepartmentService;
import com.li.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    //
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    // list 显示所有成员
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    // 添加请求
    @GetMapping("/emp")
    public String toAddEmployee(Model model){
        Collection<Department> department = departmentService.getAllDepartment();
        model.addAttribute("departments",department);
        return "emp/add";
    }

    // 添加用户
    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee); // 保存员工信息
        System.out.println("=====================================>"+employee);
        return "redirect:/emps";
    }

    // 修改信息
    @GetMapping("/change/{id}")
    public String changeEmp(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeService.getEmployee(id);
        Collection<Department> department = departmentService.getAllDepartment();
        model.addAttribute("emp",employee);
        model.addAttribute("change",department);
        return "/emp/change";
    }

    //确认修改请求
    @PostMapping("/update")
    public String update(Employee employee){
        employeeService.update(employee);
        return "redirect:/emps";
    }

//    删除用户
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }

}
