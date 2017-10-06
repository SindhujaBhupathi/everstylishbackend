package com.everstylish.dao;
import java.util.List;

import com.everstylish.model.Product;


public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public List<Product> retrieveProduct();
	public boolean deleteProduct(Product product);
	public Product getProduct(int productId);
	public boolean updateProduct(Product product);
}