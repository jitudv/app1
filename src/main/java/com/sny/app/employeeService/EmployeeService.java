package com.sny.app.employeeService;

import java.util.List;

import com.sny.app.user.Employee;

 public interface EmployeeService {
 public void  addEmploye(Employee e);
 public void updateEmployee(Employee e);
 public void deleteEmployee(int id );
 public Employee getEmployee(int id );
 public List<Employee> getEmployees();
 public Employee getEmployeeByemail(String email);
 
}
