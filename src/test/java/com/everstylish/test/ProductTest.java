package com.everstylish.test;
import static org.junit.Assert.*;




import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.everstylish.dao.ProductDAO;
import com.everstylish.model.Product;

@Ignore
public class ProductTest {

	@Autowired
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configAppinContext=new AnnotationConfigApplicationContext();
		configAppinContext.scan("com.everstylish");
		configAppinContext.refresh();
		
		productDAO=(ProductDAO)configAppinContext.getBean("productDAO");
	
	}
	@Test
	public void addProductTest()
	{
		 Product product= new Product();
		 product.setProductId(1036);
		 product.setProductName("watch");
		 product.setProductDesc("this");
		 product.setPrice(2000);
		 product.setStock(25);
		 product.setCatId(1001);
		 product.setSupplierId(1001);
		 assertTrue("problem in insertion",productDAO.addProduct(product));
	}

}
