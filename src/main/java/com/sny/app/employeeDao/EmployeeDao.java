package com.sny.app.employeeDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sny.app.user.Employee;

//@Repository
public interface employeeDao extends JpaRepository<Employee,Integer>
{
   // there are 18 method are implimented by JpaRepository
}
