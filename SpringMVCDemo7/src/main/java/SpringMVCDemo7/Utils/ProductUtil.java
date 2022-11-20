package SpringMVCDemo7.Utils;

import java.util.HashMap;
import java.util.Map;

import SpringMVCDemo7.pojos.Cart;

public class ProductUtil {
	
	public static int countCart(Map<Integer, Cart> cart) {
		if(cart == null) return 0;
		int count = 0;
		for (Cart c : cart.values()) {
			count += c.getCount();
		}
		return count;
	}
	public static Map<String, String> sumAmount(Map<Integer, Cart> cart) {
		long sum = 0;
		int q = 0;
		for(Cart c : cart.values()) {
			sum += c.getCount()*c.getPrice();
			q += c.getCount();
		}
		Map<String , String> kq = new HashMap<>();
		kq.put("amount", Long.toString(sum));
		kq.put("count", Integer.toString(q));
		return kq;
	}
}
