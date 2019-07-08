package com.sny.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sny.app.employeeService.EmployeeService;
import com.sny.app.user.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {
    
	@Autowired
	EmployeeService emps;
	
//	
//	@Test
//	public void contextLoads() 
//	{
//		
//	}
//	@Test
//	public void test1() 
//	{
//      Employee  ee = new Employee();
//      ee.setEmail("jitudv09@gmail.com");
//      ee.setPassword("Jays@123");
//      List<Role> r =  new ArrayList<Role>();
//      r.add(new Role("USER_ROLE"));
//      ee.setRoles(r);
//      emps.addEmploye(ee);
//	}
	
	
	@Test
	public void test2()
	{
      Employee ee  = emps.getEmployeeByemail("jitudv09@gmail.com");
      //System.out.println("did not working "+ee.getEmail()); 
       System.out.println("role is "+ee.getRoles().get(0).getRole());
      // System.out.println("this is the password "+ee.getPassword());
      if(ee == null)
      {
      System.out.println("yes working ");	  
      }
      else
      {
       System.out.println("did not working "+ee.getEmail()+"\t\t this is the password "+ee.getPassword());   	  
      }
	}
//	
	
	

}
