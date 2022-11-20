package SpringMVCDemo7.repository;

import java.util.Map;

import SpringMVCDemo7.pojos.Cart;

public interface OrderRepository {
	boolean addOrder(Map<Integer, Cart> cart , int userId);
}
