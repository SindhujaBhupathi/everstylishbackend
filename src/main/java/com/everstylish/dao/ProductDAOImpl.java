package com.everstylish.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everstylish.model.Product;

@Repository("productDao")
	public class ProductDAOImpl implements ProductDAO
	{
		@Autowired
	    SessionFactory sessionFactory;

		public boolean addProduct(Product product) {
			// TODO Auto-generated method stub
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

		public List<Product> retrieveProduct() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean deleteProduct(Product product) {
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			 Session session=sessionFactory.openSession();
			 Product product=(Product)session.get(Product.class,productId);
		     session.close();
		     return product;
			
		}

		public boolean updateProduct(Product product) {
			// TODO Auto-generated method stub
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
		
}
