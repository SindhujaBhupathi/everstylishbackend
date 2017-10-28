package com.everstylish.test;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.everstylish.dao.ProductDAO;
import com.everstylish.model.Product;

@Ignore
public class ProductTest {


	static ProductDAO productDAO;

	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.spring");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		productDAO=(ProductDAO)configApplnContext.getBean("productDAO");
	}

	@Transactional
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(1002);
		product.setProductName("two layer bamboo plant");
		product.setProductDesc("A bamboo plant is a very special plant.It not only brings greenery in the house but brings lots of luck too.Give it to a person you really want to prosper in life.");
		product.setStock(10);
		product.setPrice(299);
		product.setCatId(1001);
		product.setSupplierId(1001);
		
		assertTrue("Problem in Insertion",productDAO.addProduct(product));
		
	}
}
