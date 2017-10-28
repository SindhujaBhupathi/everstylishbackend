package com.everstylish.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everstylish.dao.ProductDAO;
import com.everstylish.model.Product;


@SuppressWarnings("deprecation")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
    SessionFactory sessionFactory;
	
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addProduct(Product product) 
	{
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
	@Transactional
	public List<Product> retrieveProduct()
	{
		Session session=sessionFactory.openSession();
        @SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Product");
        @SuppressWarnings("unchecked")
		List<Product> listProduct=query.list();
        session.close();
        return listProduct;
		
	}
	@Transactional
	public boolean deleteProduct(Product product)
	{
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
	@Transactional
	public Product getProduct(int productId) 
	{
		String hql = "from" + " Product" + " where id=" + productId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}

		return null;
	}
	@Transactional
	public boolean updateProduct(Product product)
	{
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

	@Transactional
	public Product getItem(int productId) 
	{
		 Product product=sessionFactory.getCurrentSession().get(Product.class,productId);
		return product;
	}

	@Transactional
	public boolean deleteProduct(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Object peristanceInstance = session.load(Product.class, productId);
		
		if(peristanceInstance != null){
			session.delete(peristanceInstance);
			System.out.println("Category deleted successfully");
		}
		
		return true;
	}

}


