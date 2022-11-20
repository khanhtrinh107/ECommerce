package SpringMVCDemo7.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVCDemo7.pojos.Cart;
import SpringMVCDemo7.repository.OrderRepository;
import SpringMVCDemo7.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public boolean addOrder(Map<Integer, Cart> cart, int userId) {
		return orderRepository.addOrder(cart, userId);
	}

}
