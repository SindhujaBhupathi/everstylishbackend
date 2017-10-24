package com.everstylish.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.everstylish.model.Supplier;

@SuppressWarnings("deprecation")
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private SupplierDAO supplierDAO;
	
	public SupplierDAOImpl(SessionFactory sessionFactory) 
	{	
		this.sessionFactory=sessionFactory;
	}


	
	
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

	public List<Supplier> retrieveSupplier() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Supplier");
		@SuppressWarnings({ "unchecked" })
		List<Supplier> listSupplier=query.list();
		session.close();
		return listSupplier;
		
	}
@Transactional
	public boolean deleteSupplier(int supId) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(supId);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
			}

	public Supplier getSupplier(int supId) {
		
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

	
		
}