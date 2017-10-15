package com.everstylish.dao;

import java.util.List;

import com.everstylish.model.Supplier;

//import com.everstylish.model.Supplier;




public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
		    public List<Supplier> retrieveSupplier();
		    public boolean deleteSupplier(Supplier supplier);
		    public Supplier getSupplier(int supId);
		    public boolean updateSupplier(Supplier supplier);

	}


