package com.everstylish.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everstylish.model.Product;


@SuppressWarnings("deprecation")
@Repository("productDAO")
	public class ProductDAOImpl implements ProductDAO
	{
		@Autowired
	    SessionFactory sessionFactory;

		@Transactional
		public boolean addProduct(Product product) {
			 try
		      {
		      sessionFactory.getCurrentSession().save(product);
		      return true;
		      }
		      catch(Exception e)
		      {
		      return false;
		      }
		}
		public boolean deleteProduct(Product product) {
			try
		     {
		     sessionFactory.getCurrentSession().delete(product);
		     return true;
		     }
		     catch(Exception e)
		     {
		     System.out.println("Exception Arised:"+e);  
			return false;
		     }	
		}
		public Product getProduct(int productId) {
			 Session session=sessionFactory.openSession();
			 Product product=(Product)session.get(Product.class,productId);
		     session.close();
		     return product;
		}
		public boolean updateProduct(Product product) {
			try
		     {
		     sessionFactory.getCurrentSession().saveOrUpdate(product);
		     return true;
		     }
		     catch(Exception e)
		     {
		     System.out.println("Exception Arised:"+e);
		     return false;
		}
		
		}
		public List<Product> retrieveProducts() {
			// TODO Auto-generated method stub
			return null;
		}
	
	}
