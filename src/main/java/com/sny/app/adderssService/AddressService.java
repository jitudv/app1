package com.sny.app.adderssService;
import com.sny.app.user.*;
public interface AddressService 
{
  public void addAddress(Address address);
  public void deleteAddress(int id);
  public Address getAddress(int id);
  public void updateAddress(Address address);
}
