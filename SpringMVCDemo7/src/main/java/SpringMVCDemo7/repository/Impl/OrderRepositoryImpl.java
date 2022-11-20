package SpringMVCDemo7.repository.Impl;

import java.util.Date;
import java.util.Map;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import SpringMVCDemo7.Utils.ProductUtil;
import SpringMVCDemo7.pojos.Cart;
import SpringMVCDemo7.pojos.OrderDetail;
import SpringMVCDemo7.pojos.SaleOrder;
import SpringMVCDemo7.repository.OrderRepository;
import SpringMVCDemo7.repository.ProductRepository;
import SpringMVCDemo7.repository.UserRepository;
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class OrderRepositoryImpl implements OrderRepository{
	@Autowired
	private LocalSessionFactoryBean factoryBean;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public boolean addOrder(Map<Integer, Cart> cart, int userId) {
		try {
			Session session = factoryBean.getObject().getCurrentSession();
			SaleOrder order = new SaleOrder();
			order.setUser(userRepository.getUserById(userId));
			order.setAmount(Float.parseFloat(ProductUtil.sumAmount(cart).get("amount")));
			order.setCreatedDate(new Date());
			session.save(order);
			for(Cart c : cart.values()) {
				OrderDetail o = new OrderDetail();
				o.setNum(c.getCount());
				o.setOrderId(order);
				o.setPrice((float)c.getPrice());
				o.setProduct(productRepository.getProductById(c.getProductId()));
				session.save(o);
			}
			return true;
		}catch(HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
