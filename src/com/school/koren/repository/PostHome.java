package com.school.koren.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.school.koren.model.Post;


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
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			//Replicar para todos os atributos
			if(instance.getAccountId() != null) {
				predicates.add(builder.and(builder.equal(root.get("account_id"), instance.getAccountId())));
			}
			
			if(instance.getCategoryId() != null) {
				predicates.add(builder.and(builder.equal(root.get("category_id"), instance.getCategoryId())));
			}
			
			if(instance.getCreationDate() != null) {
				predicates.add(builder.and(builder.equal(root.get("creation_date"), instance.getCreationDate())));
			}
			
			if(instance.getTags() != null) {
				predicates.add(builder.and(builder.equal(root.get("tags"), Arrays.asList(instance.getTags()))));
			}
			
			if(instance.getTitle() != null) {
				predicates.add(builder.and(builder.equal(root.get("title"), instance.getTitle())));
			}
			
			if(instance.getText() != null) {
				predicates.add(builder.and(builder.equal(root.get("text"), instance.getText())));
			}
			
			criteria.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
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
	
	public List<Post> getAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Post> cq = cb.createQuery(Post.class);
	    Root<Post> rootEntry = cq.from(Post.class);
	    CriteriaQuery<Post> all = cq.select(rootEntry);
	 
	    TypedQuery<Post> allQuery = session.createQuery(all);
	    List<Post> resultado = allQuery.getResultList();
	    session.close();
	    return resultado;
	}
	
	
	@SuppressWarnings("deprecation")
	public List<Post> searchText(String texto){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(Post.class);
		crit.add(Restrictions.ilike("title", texto, MatchMode.ANYWHERE));
		
		@SuppressWarnings("unchecked")
		List<Post> results = crit.list();
		
		session.close();
		return results;
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
