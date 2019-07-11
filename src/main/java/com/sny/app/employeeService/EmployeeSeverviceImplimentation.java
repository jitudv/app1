package com.sny.app.employeeService;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sny.app.employeeDao.EmployeeDao;
import com.sny.app.user.Employee;

@Service
@Transactional
@EnableJpaRepositories("com.sny.app.employeeDao")
public class EmployeeSeverviceImplimentation implements EmployeeService {
    
	Log log = LogFactory.getLog(EmployeeSeverviceImplimentation.class);
	
	@Autowired
	@PersistenceContext
	EntityManager entm;
	
	@Autowired
    EmployeeDao empdao;
	 
	@Override
	public void addEmploye(Employee e) 
	 {
		// TODO Auto-generated method stub
		 entm.merge(e);
		//empdao.save(e);
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

	@Override
	public Employee getEmployeeByemail(String email) {
		  
		return  empdao.getEmployeeByemail(email);
	}

	@Override
	public List<Object> getEmployeeNameAndId() {
	
		return empdao.getemployeeNameId();
	}
		//return 

}
