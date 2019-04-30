package com.school;
// Generated 29/04/2019 14:27:10 by Hibernate Tools 5.2.12.Final

import java.io.File;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Postagem.
 * @see com.school.Postagem
 * @author Hibernate Tools
 */
public class PostagemHome {

	private static final Log log = LogFactory.getLog(PostagemHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().
		configure(new File("src/META-INF/hibernate.cfg.xml"))
		.buildSessionFactory();
		return sessionFactory; 
	}

	public void persist(Postagem transientInstance) {
		log.debug("persisting Postagem instance");
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

	public void delete(Postagem persistentInstance) {
		log.debug("deleting Postagem instance");
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

	public Postagem merge(Postagem detachedInstance) {
		log.debug("merging Postagem instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Postagem result = (Postagem) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Postagem findById(int id) {
		log.debug("getting Postagem instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Postagem instance = (Postagem) session.get("com.school.Postagem", id);
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

	public List findByExample(Postagem instance) {
		log.debug("finding Postagem instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.school.Postagem")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void terminate() {
		log.debug("Terminating sessionFactory");
		try {;
			sessionFactory.close();
			log.debug("terminate successful");
		} catch (RuntimeException re) {
			log.error("terminate failed", re);
			throw re;
		}
	}
}
