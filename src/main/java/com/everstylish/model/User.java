package com.everstylish.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User implements Serializable
{
public static final long serialVersionUID=1L;

@Id
@GeneratedValue
private int id;
private String username;
private String email;
private String password;
private String contact;
private String address;
private String role;
private boolean enabled;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}




}
