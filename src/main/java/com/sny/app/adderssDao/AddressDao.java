package com.sny.app.adderssDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sny.app.user.Address;

//@Repository
public interface AddressDao extends JpaRepository<Address, Integer> 
{
  // implicitaly you have 16 methods  with jpa  repository
}
