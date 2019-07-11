package com.sny.app.roleModule;

import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.sny.app.user.Role;

@Service
@EnableJpaRepositories("com.sny.app.roleModule")
public class RoleService 
{
	@Autowired
	RoleRepo rp ;
	
	public void addRole(Role role)
	{
		 rp.save(role);
	}
  
     public void deleteRole(Short id)
     {
    	 rp.deleteById(id);
     }
     
     public Role  getRole(Short id)
     {
    	 return  rp.findById(id).get();
     }
	
}
