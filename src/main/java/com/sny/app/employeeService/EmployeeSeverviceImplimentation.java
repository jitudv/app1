package com.sny.app.employeeService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sny.app.user.Employee;

@Service
@Transactional
@EnableJpaRepositories("com.sny.app.employeeDao")
public class EmployeeSeverviceImplimentation implements EmployeeService {
    
	@Autowired
	@PersistenceContext
	EntityManager entm;
	
	@Override
	public void addEmploye(Employee e) 
	 {
		// TODO Auto-generated method stub
		entm.persist(e);
     }

	@Override
	public void updateEmployee(Employee e) 
	{
      // TODO Auto-generated method stub
      entm.persist(e);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		entm.remove(entm.find(Employee.class, id));

	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return  entm.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		   return  entm.createQuery("From Employee e").getResultList();
	}

}
