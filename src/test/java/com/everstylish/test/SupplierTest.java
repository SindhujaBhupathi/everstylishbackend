package com.everstylish.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.everstylish.dao.SupplierDAO;
import com.everstylish.model.Supplier;




public class SupplierTest {

	static SupplierDAO supplierDAO;
	     
	    @BeforeClass
	    public static void initialize()
	    {
	        @SuppressWarnings("resource")
			AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
	        configApplnContext.scan("com.everstylish");
	        configApplnContext.refresh();
	         
	        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
	         
	        supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");
	    }
	     
	    @Ignore
	    @Test
	    public void addSupplierTest()
	    {
	    	Supplier supplier=new Supplier();
	        supplier.setSupId(1002);
	        supplier.setSupName("JMShirt");
	        supplier.setSupDesc("John Miller Shirt");
	         
	        assertTrue(supplierDAO.addSupplier(supplier));
	    }
	     
}