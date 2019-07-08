package com.sny.app.adderssService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sny.app.adderssDao.AddressDao;
import com.sny.app.user.Address;

@Service
@Transactional
@EnableJpaRepositories("com.sny.app.adderssDao")
public class AddressServiceImpl implements AddressService {
    
	
	@Autowired
	AddressDao ad ;
	
	
	@Override
	public void addAddress(Address address) {
	
	      ad.save(address);	
	}

	@Override
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub
		ad.delete(ad.getOne(id));
	}

	@Override
	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		return ad.getOne(id);
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		ad.save(address);
	}

}
