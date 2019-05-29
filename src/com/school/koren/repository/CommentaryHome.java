package com.school.koren.repository;

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

import com.school.koren.model.Commentary;


public class CommentaryHome {

	private static final Log log = LogFactory.getLog(CommentaryHome.class);

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

	public void persist(Commentary transientInstance) {
		log.debug("persisting Commentary instance");
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

	public void attachDirty(Commentary instance) {
		log.debug("attaching dirty Commentary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commentary instance) {
		log.debug("attaching clean Commentary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Commentary persistentInstance) {
		log.debug("deleting Commentary instance");
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

	public Commentary merge(Commentary detachedInstance) {
		log.debug("merging Commentary instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Commentary result = (Commentary) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Commentary findById(int id) {
		log.debug("getting Commentary instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Commentary instance = (Commentary) session.get(Commentary.class, id);
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

	public List<Commentary> findByExample(Commentary instance) {
		log.debug("finding Commentary instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Commentary> criteria = builder.createQuery(Commentary.class);
			Root<Commentary> root = criteria.from(Commentary.class);
			
			Predicate predicate = builder.and();
			
			//Replicar para todos os atributos
			if(instance.getAccountId() != null) {
				predicate = builder.and(builder.equal(root.get("account_id"), instance.getAccountId()));
			}
			
			if(instance.getCreationDate() != null) {
				predicate = builder.and(builder.equal(root.get("creation_date"), instance.getCreationDate()));
			}
			
			if(instance.getParentId() != null) {
				predicate = builder.and(builder.equal(root.get("parent_id"), instance.getParentId()));
			}
			
			if(instance.getPostId() != null) {
				predicate = builder.and(builder.equal(root.get("post_id"), instance.getPostId()));
			}
			
			if(instance.getText() != null) {
				predicate = builder.and(builder.equal(root.get("text"), instance.getText()));
			}
			
			if(instance.getDepth() != null) {
				predicate = builder.and(builder.equal(root.get("depth"), instance.getDepth()));
			}
			
			criteria.select(root).where(predicate);
			Query<Commentary> q = session.createQuery(criteria);
			List<Commentary> results = q.getResultList();
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
