package SpringMVCDemo7.repository.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import SpringMVCDemo7.pojos.Product;
import SpringMVCDemo7.repository.ProductRepository;
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
	@Autowired
	private LocalSessionFactoryBean factoryBean;
	@Override
	public List<Product> getproProducts(String kw) {
		Session session = factoryBean.getObject().getCurrentSession();
		Query q = session.createQuery("From Product p where p.name like :kw");
		q.setParameter("kw", "%" + kw + "%");
		return q.getResultList();
	}
	
	@Override
	public boolean addOrUpdate(Product product) {
		Session session = factoryBean.getObject().getCurrentSession();
		try {
			session.save(product);
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Product getProductById(int id) {
		Session session = factoryBean.getObject().getCurrentSession();
		Product p = session.get(Product.class, id);
		return p;
	}
}
