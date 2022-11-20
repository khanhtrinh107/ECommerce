package SpringMVCDemo7.repository.Impl;

import javax.transaction.Transactional;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import SpringMVCDemo7.pojos.Comment;
import SpringMVCDemo7.repository.CommentRepository;
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{
	@Autowired
	private LocalSessionFactoryBean factoryBean;
	@Override
	public Comment addComment(Comment c) {
		Session session = factoryBean.getObject().getCurrentSession();
		try {
			session.save(c);
			return c;
		}
		catch (HibernateError  ex) {
			ex.printStackTrace();
		}
		return null; 
	}
	
}
