package com.sny.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sny.app.adderssService.*;
import com.sny.app.user.Address;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4100"})
@RestController
public class AddressController 
{  
	 @Autowired
	 AddressService adr;
	
    @GetMapping(value="/user/address/{1}")
	public ResponseEntity<Address> getAddress(@PathVariable("id")int id)
	{
		return ResponseEntity.ok(adr.getAddress(id));
	}
    
    @PostMapping(value="/user/address")
    public ResponseEntity<String> saveAddress(@RequestBody Address address)
    {   adr.addAddress(address);
    	return ResponseEntity.ok("your address save ");
    }
    
    @PutMapping(value="/user/address/{id}")
    public ResponseEntity<String> updateAddress(@RequestBody Address address , @PathVariable("id") int id)
    {
    	Address ad = adr.getAddress(id);
    	ad.setCity(address.getCity());
    	ad.setCity(address.getColony());
    	ad.setHouse(address.getHouse());
    	ad.setPin(address.getPin());
    	adr.updateAddress(ad);
    	return ResponseEntity.ok("address saved "+ad.getId());
    }
    
    @DeleteMapping(value="/user/address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") int id)
    {
    	adr.deleteAddress(id);
       return ResponseEntity.ok("address delted ");
    }
    
}
