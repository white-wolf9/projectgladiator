package com.lti.paysmart.interfaces;

public interface GenericDao {
	
	public void add(Object object);
	public void fetchById(int primary_key);
	public void fetchAll();

}
