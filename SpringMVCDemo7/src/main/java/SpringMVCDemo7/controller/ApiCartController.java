package SpringMVCDemo7.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.velocity.app.event.EventCartridge;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringMVCDemo7.Utils.ProductUtil;
import SpringMVCDemo7.pojos.Cart;
import SpringMVCDemo7.pojos.Product;
import SpringMVCDemo7.service.ProductService;
import antlr.Utils;

@RestController
public class ApiCartController {
	@Autowired
	private ProductService productService;
	@GetMapping("/api/products")
	public ResponseEntity<List<Product>> listProducts(){
		List<Product> products = productService.getProducts("");
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	@GetMapping("/api/cart/{productId}")
	public ResponseEntity<Integer> cart(@PathVariable(value = "productId") Integer id , HttpSession session){
		Map<Integer, Cart> cart = (Map<Integer, Cart>)session.getAttribute("cart");
		if(cart == null)
			cart = new HashMap<>();
		if(cart.containsKey(id)) {
			Cart c = cart.get(id);
			c.setCount(c.getCount() + 1);
			cart.put(id, c);
		}
		else {
			Product p = productService.getProductById(id);
			Cart c = new Cart();
			c.setName(p.getName());
			c.setCount(1);
			c.setPrice(p.getPrice());
			c.setProductId(id);
			cart.put(id, c);
		}
		session.setAttribute("cart", cart);
		return new ResponseEntity<>(ProductUtil.countCart(cart),HttpStatus.OK);
	}
	@PutMapping("/api/cart")
	public Map<String, String> updateCart(@RequestBody Cart cart, HttpSession session) {
		Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("cart");
		if(cart == null) {
			carts = new HashMap<>();
		}
		if(carts.containsKey(cart.getProductId())) {
			Cart c = carts.get(cart.getProductId());
			c.setCount(cart.getCount());
		}
		session.setAttribute("cart", carts);
		return ProductUtil.sumAmount(carts);
	}
	@DeleteMapping("/api/cart/{productId}")
	public Map<String, String> deleteCart(@PathVariable(value = "productId") int productId, HttpSession session) {
		Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
		if(cart != null && cart.containsKey(productId)) {
			cart.remove(productId);
			session.setAttribute("cart", cart);
		}
		return ProductUtil.sumAmount(cart);
	}
}
