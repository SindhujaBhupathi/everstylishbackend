package com.everstylish.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.everstylish.dao.CartDAO;
import com.everstylish.dao.CartDAOImpl;
import com.everstylish.dao.CategoryDAO;
import com.everstylish.dao.CategoryDAOImpl;
import com.everstylish.dao.ProductDAO;
import com.everstylish.dao.ProductDAOImpl;
import com.everstylish.dao.SupplierDAO;
import com.everstylish.dao.SupplierDAOImpl;
import com.everstylish.dao.UserDAO;
import com.everstylish.dao.UserDAOImpl;

@Configuration
@ComponentScan("com.everstylish.*")
@EnableTransactionManagement
@Component
public class DataBaseConfig {
	
	//bean is used

	/*public DataSource getH2DataSource()
	{
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
  	}*/
	
	 @Bean(name = "dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			System.out.println("Datasource");
			return dataSource;

		}


	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}

	/*@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource());
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.everstylish");
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}*/
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.everstylish.*");
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}
	
@Autowired
@Bean(name = "userDAO")
public UserDAO getUserDAO(SessionFactory sessionFactory) {
    return new UserDAOImpl(sessionFactory);
}

@Autowired
@Bean(name = "productDAO")
public ProductDAO getProductDao(SessionFactory sessionFactory) {
    return new ProductDAOImpl(sessionFactory);
}


@Autowired
@Bean(name="categoryDAO")
public CategoryDAO getCategory(SessionFactory sessionFactory)
{
	return new CategoryDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="supplierDAO")
public SupplierDAO getSupplier(SessionFactory sessionFactory)
{
	return new SupplierDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="cartDAO")
public CartDAO getCart(SessionFactory sessionFactory)
{
	return new CartDAOImpl(sessionFactory);
	
}

}
