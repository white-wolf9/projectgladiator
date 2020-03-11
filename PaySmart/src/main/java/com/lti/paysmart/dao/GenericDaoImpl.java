package com.lti.paysmart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.lti.paysmart.interfaces.GenericDao;

/*The @Component annotation marks a java class as a bean so the component-scanning 
 * mechanism of spring can pick it up and pull it into the application context.*/

@Component
@Primary
public class GenericDaoImpl implements GenericDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public <E> void add(E object) {
		entityManager.merge(object);
	}

	@Override
	public <E> Object fetchById(Class<E> classname, long primary_key) {
		return entityManager.find(classname, primary_key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> List<E> fetchAll(Class<E> classname) {
		List <E> list = entityManager.createQuery("select object from "+ classname.getName()+" as object").getResultList();
		return list;
	}

}
