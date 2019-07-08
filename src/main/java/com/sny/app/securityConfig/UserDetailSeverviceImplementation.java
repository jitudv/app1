package com.sny.app.securityConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sny.app.employeeService.*;
import com.sny.app.user.Employee;

@Service
public class UserDetailSeverviceImplementation implements  UserDetailsService  {
     
	Log log = LogFactory.getLog(UserDetailSeverviceImplementation.class);
	
    @Autowired
	EmployeeService emps;
	
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	   log.warn("email is  sent  by  the  angular client    =\t "+email);
	   Employee user = emps.getEmployeeByemail(email);
//	   log.warn(user.getPassword());
//	   log.warn(user.getEmail());
//	   log.warn(user.getRoles().get(0).getRole());
	   if(user ==null)
	   {  
		   log.warn("user not found  "+email);
		  throw new UsernameNotFoundException(email);
	   }
	   return new MyPrinciple(user);
	}

}
