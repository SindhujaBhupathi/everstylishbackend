package com.everstylish.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.everstylish.dao.SupplierDAO;
import com.everstylish.dao.SupplierDAOImpl;
import com.everstylish.model.Supplier;

public class SupplierTest {

	static SupplierDAO supplierDAO;
	     
	    @BeforeClass
	    public static void initialize()
	    {
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
	     
	    @Ignore
	    @Test
	    public void updateSupplierTest()
	    {
	        Supplier supplier=new Supplier();
	        supplier.setSupId(1002);
	        supplier.setSupName("JMShirt");
	        supplier.setSupDesc("John Miller Shirt with Best Price");
	         
	        assertTrue(supplierDAO.updateSupplier(supplier));
	    }
	    @Ignore
	    @Test
	    public void deleteSupplierTest()
	    {
	        Supplier supplier=new Supplier();
	        supplier.setSupId(1002);
	        assertTrue(supplierDAO.deleteSupplier(supplier));
	    }
	     
	    @Test
	    public void retrieveSupplierTest()
	    {
	        List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
	        assertNotNull("Problem in Retriving ",listSupplier);
	        this.show(listSupplier);
	    }
	     
	    public void show(List<Supplier> listSupplier)
	    {
	        for(Supplier supplier:listSupplier)
	        {
	            System.out.println("Supplier ID:"+supplier.getSupId());
	            System.out.println("Supplier Name:"+supplier.getSupName());
	        }
	    }
	     
	     
	    @Test
	    public void getSupplierTest()
	    {
	        SupplierDAOImpl supplier=supplierDAO.getSupplier(1003);
	        assertNotNull("Problem in Getting:",supplier);
	        System.out.println("Supplier ID:"+supplier.getSupId());
	        System.out.println("Supplier Name:"+supplier.getSupName());
	    }
	 
}
