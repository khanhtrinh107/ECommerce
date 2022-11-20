package SpringMVCDemo7.service;

import java.util.Map;

import SpringMVCDemo7.pojos.Cart;

public interface OrderService {
	boolean addOrder(Map<Integer, Cart> cart , int user);
}
