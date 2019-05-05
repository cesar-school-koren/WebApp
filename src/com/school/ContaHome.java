package com.school;
// Generated 29/04/2019 14:27:10 by Hibernate Tools 5.2.12.Final

import java.io.File;
import java.util.List;
import javax.naming.InitialContext;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Conta.
 * @see com.school.Conta
 * @author Hibernate Tools
 */
public class ContaHome {

	private static final Log log = LogFactory.getLog(ContaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().
		configure(new File("src/META-INF/hibernate.cfg.xml"))
		.buildSessionFactory();
		return sessionFactory; 
	}

	public void persist(Conta transientInstance) {
		log.debug("persisting Conta instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}


	public void delete(Conta persistentInstance) {
		log.debug("deleting Conta instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Conta merge(Conta detachedInstance) {
		log.debug("merging Conta instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Conta result = (Conta) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Conta findById(java.lang.String id) {
		log.debug("getting Conta instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Conta instance = (Conta) session.get("com.school.Conta", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Conta> findAll() {
		log.debug("finding All Conta instances");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			CriteriaQuery<Conta> criteriaQuery = session.getCriteriaBuilder().createQuery(Conta.class);
			criteriaQuery.from(Conta.class);
			
			List<Conta> results = session.createQuery(criteriaQuery).getResultList();
			log.debug("find all successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void terminate() {
		log.debug("Terminating sessionFactory");
		try {
			sessionFactory.close();
			log.debug("terminate successful");
		} catch (RuntimeException re) {
			log.error("terminate failed", re);
			throw re;
		}
	}
}
