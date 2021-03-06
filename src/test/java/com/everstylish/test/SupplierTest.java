package com.everstylish.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.everstylish.dao.SupplierDAO;
import com.everstylish.model.Supplier;

@SuppressWarnings("unused")
@Ignore
public class SupplierTest {
	
	@Autowired
	private static SupplierDAO supplierDAO;

	    @BeforeClass
	    public static void initialize()
	    {
	        @SuppressWarnings("resource")
			AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
	        configApplnContext.scan("com.everstylish");
	        configApplnContext.refresh();
	        supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");
	    }
	    @Ignore
	    @Test
	    public void addSupplierTest()
	    {
	        Supplier supplier=new Supplier();
	        supplier.setSupId(265);
	        supplier.setSupName("jeweleries");
	        supplier.setSupDesc("all available ");
	        assertTrue(supplierDAO.addSupplier(supplier));
	    }
	    @Ignore
	    @Test
	    public void updateSupplierTest()
		{
			Supplier supplier=new Supplier();
			supplier.setSupId(76);
			supplier.setSupName("fri");
			supplier.setSupDesc("The Indian climatic life.");
			
			assertTrue(supplierDAO.updateSupplier(supplier));
		}
	    
	  /*  @Ignore
		@Test
		public void deleteSupplierTest(int supId)
		{
			Supplier Supplier=new Supplier();
			Supplier.setSupId(1002);
			assertTrue(supplierDAO.deleteSupplier(supId));
		}*/
		@Ignore
		@Test
		public void retrieveSupplierTest()
		{
			List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
			assertNotNull("Problem in Retriving ",listSupplier);
			this.show(listSupplier);
		}
		@Ignore
		public void show(List<Supplier> listSupplier)
		{
			for(Supplier Supplier:listSupplier)
			{
				System.out.println("Supplier ID:"+Supplier.getSupId());
				System.out.println("Supplier Name:"+Supplier.getSupName());
			}
		}
		
		@Ignore
		@Test
		public void getSupplierTest()
		{
			Supplier Supplier=supplierDAO.getSupplier(1001);
			assertNotNull("Problem in Getting:",Supplier);
			System.out.println("Supplier ID:"+Supplier.getSupId());
			System.out.println("Supplier Name:"+Supplier.getSupName());
			System.out.println("Supplier Description  = "+Supplier.getSupDesc());
		}

}

