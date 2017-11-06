package com.everstylish.dao;
import java.util.List;

import com.everstylish.model.Address;
public interface AddressDAO {
	public boolean saveOrUpdate(Address address);
	
	public Address getAddressById(int addressId);
	
	public boolean deleteAddressById(int addressId);
	
	public List<Address> getAllAddressOfUser(int userId);
	
	public Address getAddressOfUser(int userId);
}
