package com.sny.app.employeeDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.sny.app.user.Employee;

//@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>
{
   // there are 18 method are implimented by JpaRepository
	Employee  getEmployeeByemail(String email); // employee by email 
	
	@Query(value ="select u.employee_id , u.emp_name from employee_master u" ,nativeQuery=true)
	List<Object> getemployeeNameId();
	
	@Modifying(clearAutomatically = true)
	@Query(value ="update  employee_master_roles  set roles_id=1  where employee_employee_id=18" ,nativeQuery=true)
	public int  createAdminEmployee(int empid); // update employee create admin
	
}
