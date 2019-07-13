package com.lti.paysmart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.lti.paysmart.interfaces.GenericDao;

@Component
public class GenericDaoImpl implements GenericDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Object object) {
		entityManager.merge(object);
	}

	@Override
	public Object fetchById(Class classname, int primary_key) {
		return entityManager.find(classname, primary_key);
	}

}
