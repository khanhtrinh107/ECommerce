package SpringMVCDemo7.repository.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import SpringMVCDemo7.pojos.Customer;
import SpringMVCDemo7.repository.CustomerRepository;
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
	@Autowired
	private LocalSessionFactoryBean factoryBean;
	@Override
	public Customer getCustomer(int id) {
		Session session = factoryBean.getObject().getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public List<Customer> getCustomers() {
		Session session = factoryBean.getObject().getCurrentSession();
		Query q = session.createQuery("from Customer");
		return q.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = factoryBean.getObject().getCurrentSession();
		session.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = factoryBean.getObject().getCurrentSession();
		Query q = session.createQuery("delete from Customer where id =:kw");
		q.setParameter("kw", id);
		q.executeUpdate();
	}

}
