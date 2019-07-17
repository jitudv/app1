package com.sny.app.securityConfig;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.sny.app.user.Employee;

public class MyPrinciple implements UserDetails  {
   
	Log log = LogFactory.getLog(MyPrinciple.class);
	public static  int userId;
	Employee user =null;
	
	MyPrinciple(Employee usr)
	{
      user=usr;
//      log.warn(usr.getEmail());
//      log.warn(usr.getPassword());
//      log.warn("error is here ");
//      log.warn(usr.getRoles().get(0).getRole());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
     log.warn(user.getRoles().get(0).getRole());
     
     log.warn("this is the user id "+user.getId());
     userId=user.getId();
     return  Collections.singleton( new SimpleGrantedAuthority(user.getRoles().get(0).getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return  user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
