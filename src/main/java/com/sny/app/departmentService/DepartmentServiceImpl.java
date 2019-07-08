package com.sny.app.departmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sny.app.departmentDao.DepartmentDao;
import com.sny.app.user.Department;

@Service
@Transactional
@EnableJpaRepositories("com.sny.app.departmentDao")
public class DepartmentServiceImpl implements DepartmentService  {

	@Autowired
	DepartmentDao dpt;

	@Override
	public void addDepartment(Department dept)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartment(int id) 
	{
		dpt.delete(dpt.getOne(id));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(Department dept) 
	{
		// TODO Auto-generated method stub
        dpt.save(dept);		
	}

	@Override
	public Department getDepartmentByid(int id) 
	{
		// TODO Auto-generated method stub
		return  dpt.getOne(id);
	}

	@Override
	public List<Department> departments()
	{
		// TODO Auto-generated method stub
		return dpt.findAll();
	}
	
	
	
	
}
