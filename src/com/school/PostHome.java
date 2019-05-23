package com.school;

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


public class PostHome {

	private static final Log log = LogFactory.getLog(PostHome.class);

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

	public void persist(Post transientInstance) {
		log.debug("persisting Post instance");
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

	public void attachDirty(Post instance) {
		log.debug("attaching dirty Post instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Post instance) {
		log.debug("attaching clean Post instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Post persistentInstance) {
		log.debug("deleting Post instance");
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

	public Post merge(Post detachedInstance) {
		log.debug("merging Post instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Post result = (Post) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Post findById(int id) {
		log.debug("getting Post instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Post instance = (Post) session.get(Post.class, id);
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

	public List<Post> findByExample(Post instance) {
		log.debug("finding Post instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
			Root<Post> root = criteria.from(Post.class);
			
			Predicate predicate = builder.and();
			
			//Replicar para todos os atributos
			if(instance.getAccountId() != null) {
				predicate = builder.and(builder.equal(root.get("account_id"), instance.getAccountId()));
			}
			
			if(instance.getCategoryId() != null) {
				predicate = builder.and(builder.equal(root.get("category_id"), instance.getCategoryId()));
			}
			
			if(instance.getCreationDate() != null) {
				predicate = builder.and(builder.equal(root.get("creation_date"), instance.getCreationDate()));
			}
			
			if(instance.getTags() != null) {
				predicate = builder.and(builder.equal(root.get("tags"), instance.getTags()));
			}
			
			if(instance.getTitle() != null) {
				predicate = builder.and(builder.equal(root.get("title"), instance.getTitle()));
			}
			
			if(instance.getText() != null) {
				predicate = builder.and(builder.equal(root.get("text"), instance.getText()));
			}
			
			criteria.select(root).where(predicate);
			Query<Post> q = session.createQuery(criteria);
			List<Post> results = q.getResultList();
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
