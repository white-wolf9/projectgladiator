package com.lti.paysmart.interfaces;

public interface GenericDao {
	
	public void add(Object object);
	public Object fetchById(Class classname, int primary_key);

}
