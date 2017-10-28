package com.everstylish.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everstylish.model.Supplier;

@SuppressWarnings("deprecation")
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	SessionFactory sessionFactory;
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
	        session.saveOrUpdate(supplier);
	        return true;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        return false;
	        }
		
	}
	@Transactional
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
	public Supplier deleteSupplier(int supId) {
	Supplier SupplierToDelete = new Supplier();
	SupplierToDelete.setSupId(supId);
	sessionFactory.getCurrentSession().delete(SupplierToDelete);
	return SupplierToDelete;
			}
@Transactional
	public Supplier getSupplier(int supId) {
		String hql = "from"+" Supplier"+" where id=" + supId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		
	
		return null;
	}
@Transactional
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