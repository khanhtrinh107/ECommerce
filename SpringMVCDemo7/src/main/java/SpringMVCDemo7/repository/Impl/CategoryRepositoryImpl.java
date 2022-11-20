package SpringMVCDemo7.repository.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import SpringMVCDemo7.pojos.Category;
import SpringMVCDemo7.repository.CategoryRepository;
@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
	@Autowired
	private LocalSessionFactoryBean factoryBean;
	@Transactional
	@Override
	public List<Category> getCategories() {
		Session session = factoryBean.getObject().getCurrentSession();
		Query q = session.createQuery("From Category");
		return q.getResultList();
	}
	
}
