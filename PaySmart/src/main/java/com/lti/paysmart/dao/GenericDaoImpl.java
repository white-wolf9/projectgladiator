package com.lti.paysmart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.lti.paysmart.interfaces.GenericDao;

@Component
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
		List <E> list = entityManager.createQuery("select object from "+ classname.getName()+"as object").getResultList();
		return list;
	}

}
