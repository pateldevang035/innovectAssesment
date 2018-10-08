package com.innovect.dao;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innovect.entities.Temperature;

@Repository
public class TemperatureDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureDAO.class);
	
	@SuppressWarnings("unchecked")
	public Collection<Temperature> getTemperature(Date date, Integer zip) {
		Collection<Temperature> today = null;
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("FROM temperature WHERE zip = :zip AND date = :date");
			query.setParameter("zip", zip);
			query.setParameter("date", date);
			today = query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e) {
			LOGGER.error("Exception in DAO Layer",e);
		}
		
		return today;
	}
}
