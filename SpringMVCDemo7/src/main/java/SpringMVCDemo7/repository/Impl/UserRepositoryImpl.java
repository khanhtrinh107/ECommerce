package SpringMVCDemo7.repository.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.repository.UserRepository;
import net.bytebuddy.asm.Advice.This;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	private LocalSessionFactoryBean sessionFactoryBean;
	@Override
	public boolean addUser(User user) {
		Session session = sessionFactoryBean.getObject().getCurrentSession();
		try {
			session.save(user);
			return true;
		}catch (HibernateException e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public List<User> getUsers(String username) {
		Session session = sessionFactoryBean.getObject().getCurrentSession();
		Query q = session.createQuery("from User U where U.username = :kw ");
		q.setParameter("kw", username);
		System.out.println(q.getResultList().size());
		return q.getResultList();
	}

	@Override
	public User getUserById(int userId) {
		Session session = sessionFactoryBean.getObject().getCurrentSession();
		try {
			User u = session.get(User.class, userId);
			return u;
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

}
