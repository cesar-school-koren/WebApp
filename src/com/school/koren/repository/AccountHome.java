package com.school.koren.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.school.koren.model.Account;


public class AccountHome {

	private static final Log log = LogFactory.getLog(AccountHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory; 
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}


	public void persist(Account transientInstance) {
		log.debug("persisting Account instance");
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

	public void attachDirty(Account instance) {
		log.debug("attaching dirty Account instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Account instance) {
		log.debug("attaching clean Account instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Account persistentInstance) {
		log.debug("deleting Account instance");
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

	public Account merge(Account detachedInstance) {
		log.debug("merging Account instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Account result = (Account) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public Account findById(int id) {
		log.debug("getting Account instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Account instance = (Account) session.get(Account.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			session.close();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Account> findByExample(Account instance) {
		log.debug("finding Account instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
			Root<Account> root = criteria.from(Account.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			//Replicar para todos os atributos
			if(instance.getUsername() != null) {
				predicates.add(builder.and(builder.equal(root.get("username"), instance.getUsername())));
			}
			
			if(instance.getEmail() != null) {
				predicates.add(builder.and(builder.equal(root.get("email"), instance.getEmail())));
			}
			
			if(instance.getCreationDate() != null) {
				predicates.add(builder.and(builder.equal(root.get("creationDate"), instance.getCreationDate())));
			}
			
			if(instance.getLastLogin() != null) {
				predicates.add(builder.and(builder.equal(root.get("lastLogin"), instance.getLastLogin())));
			}
			
			if(instance.getPrivilege() != null) {
				predicates.add(builder.and(builder.equal(root.get("privilege"), instance.getPrivilege())));
			}
			
			criteria.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			Query<Account> q = session.createQuery(criteria);
			List<Account> results = q.getResultList();
			log.debug("find by example successful, result size: " + results.size());
			session.close();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
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
