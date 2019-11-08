package com.nagarro.adminPanel.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.adminPanel.model.CustomerDetails;

@Repository
public class FilterUsersDaoImpl implements FilterUsersDao {

	private Configuration con;
	private SessionFactory sessionFactory;

	final static Logger LOG = Logger.getLogger(FilterUsersDaoImpl.class);

	public FilterUsersDaoImpl() {
		LOG.info("Configuring hibernate and building session factory. ");

		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();

		LOG.info("Configuration and building Succesfull");
	}

	public List<CustomerDetails> filterList(String filterName, String filterContact, String filterEMail) {

		LOG.info("Inside the function to filter the details of the user.");

		Session session = sessionFactory.openSession();

		CriteriaBuilder criteriaBuider = session.getCriteriaBuilder();
		CriteriaQuery<CustomerDetails> criteriaQuery = criteriaBuider.createQuery(CustomerDetails.class);

		Root<CustomerDetails> root = criteriaQuery.from(CustomerDetails.class);

		Predicate[] predicates = new Predicate[3];
		predicates[0] = criteriaBuider.like(root.get("customerName"), "%" + filterName + "%");
		predicates[1] = criteriaBuider.like(root.get("contactNumber"), "%" + filterContact + "%");
		predicates[2] = criteriaBuider.like(root.get("emailID"), "%" + filterEMail + "%");

		criteriaQuery.select(root).where(predicates);

		Query<CustomerDetails> query = session.createQuery(criteriaQuery);

		List<CustomerDetails> usersList = query.getResultList();

		session.close();

		return usersList;

	}

}
