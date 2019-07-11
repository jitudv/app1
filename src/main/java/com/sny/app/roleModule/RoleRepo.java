package com.sny.app.roleModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sny.app.user.Role;

@Repository
public interface RoleRepo extends  JpaRepository<Role,Short> 
{

}
