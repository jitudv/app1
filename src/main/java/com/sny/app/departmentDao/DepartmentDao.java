package com.sny.app.departmentDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sny.app.user.Department;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
   
}
