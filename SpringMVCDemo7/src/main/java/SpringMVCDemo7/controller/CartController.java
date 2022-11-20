package SpringMVCDemo7.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import SpringMVCDemo7.Utils.ProductUtil;
import SpringMVCDemo7.pojos.Cart;
import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.service.OrderService;

@Controller
public class CartController {
	@Autowired
	private OrderService orderService;
	@GetMapping("/cart")
	public String gioHang(Model model, HttpSession session) {
		Map<Integer, Cart> cart = (Map<Integer, Cart>)session.getAttribute("cart");
		if(cart != null) {
			model.addAttribute("carts",cart.values() );
		}
		model.addAttribute("cartState", ProductUtil.sumAmount(cart));
		return "cart";
	}
	@GetMapping("/pay")
	public String pay(HttpSession session , Model model) {
		User u = (User) session.getAttribute("currentUser");
		if(u == null) {
			return "login";
		}
		orderService.addOrder((Map<Integer, Cart>) session.getAttribute("cart"), u.getId());
		session.removeAttribute("cart");
		return "redirect:/";
	}
}
