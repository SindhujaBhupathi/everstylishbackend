package com.everstylish.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.everstylish.dao.CategoryDAO;
import com.everstylish.model.Category;

import static org.junit.Assert.*;

import java.util.List;


@SuppressWarnings("unused")
@Ignore
public class CategoryTest 
{
	@Autowired
    static CategoryDAO categoryDAO;
     
    @BeforeClass
    public static void initialize()
    {
        @SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
        configApplnContext.scan("com.everstylish");
        configApplnContext.refresh();
         
        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DataBaseConfig.class");
         
        categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
    }
   // @Ignore
    @Test
    public void addCategoryTest()
    {
        Category category=new Category();
        category.setCatId(1009);
        category.setCatName("ring");
        category.setCatDesc(" worn as a ornamental piece of jewellery around the finger ");
        assertTrue(categoryDAO.addCategory(category));
    }
    @Ignore
    @Test
    public void updateCategoryTest()
	{
		Category category=new Category();
		category.setCatId(103);
		category.setCatName("rings");
		category.setCatDesc("The Indian climatic life.");
		
		assertTrue(categoryDAO.updateCategory(category));
	}
   
    @Ignore
	@Test
	public void deleteCategoryTest(int catId)
	{
		Category category=new Category();
		category.setCatId(1002);
		assertTrue(categoryDAO.deleteCategory(catId));
	}
	
	@Ignore
	@Test
	public void retrieveCategoryTest()
	{
		List<Category> listCategory=categoryDAO.retrieveCategory();
		assertNotNull("Problem in Retriving ",listCategory);
		this.show(listCategory);
	}
	
	public void show(List<Category> listCategory)
	{
		for(Category category:listCategory)
		{
			System.out.println("Category ID:"+category.getCatId());
			System.out.println("Category Name:"+category.getCatName());
		}
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		Category category=categoryDAO.getCategory(102);
		assertNotNull("Problem in Getting:",category);
		System.out.println("Category ID:"+category.getCatId());
		System.out.println("Category Name:"+category.getCatName());
		System.out.println("Category Description  = "+category.getCatDesc());
	}
 
}