package com.lti.paysmart.interfaces;

import java.util.List;

public interface GenericDao {
	
	public <E> void add(E object);
	public <E> Object fetchById(Class<E> classname, long primary_key);
	public <E> List<E> fetchAll(Class<E> classname);

}
