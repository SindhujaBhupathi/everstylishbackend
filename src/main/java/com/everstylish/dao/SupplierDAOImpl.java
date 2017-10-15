package com.everstylish.dao;
import java.util.List;
//import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.everstylish.dao.SupplierDAO;
//import com.everstylish.dao.*;
import com.everstylish.model.Supplier;



@SuppressWarnings("deprecation")
@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addSupplier(Supplier supplier) {
		
        try
        {
        Session session=sessionFactory.getCurrentSession();
        session.save(supplier);
        return true;
        }
        catch(Exception e)
        {e.printStackTrace();
        return false;
        }
	}

	public List<Supplier> retrieveSupplier() 
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Supplier");
		@SuppressWarnings({ "unchecked" })
		List<Supplier> listSupplier=query.list();
		session.close();
		return listSupplier;
	}



	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
	}





	public Supplier  getSupplier(int supId) {
		Session session=sessionFactory.openSession();
		Supplier Supplier=(Supplier)session.get(Supplier.class,supId);
		session.close();
		return Supplier;
	}





	public boolean updateSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}





	public String getSupId() {
		// TODO Auto-generated method stub
		return null;
	}





	public String getSupName() {
		// TODO Auto-generated method stub
		return null;
	}



	}
