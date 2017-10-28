package com.everstylish.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable
{

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
private int productId;

@Lob
public byte[] image;
private String productName;
private String productDesc;
private int stock;
private int price;
private int catId;
private int supplierId;

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDesc() {
	return productDesc;
}
public void setProductDesc(String productDesc) {
	this.productDesc = productDesc;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getCatId() {
	return catId;
}
public void setCatId(int catId) {
	this.catId = catId;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}


}
