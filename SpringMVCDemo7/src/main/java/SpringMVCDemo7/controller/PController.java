package SpringMVCDemo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import SpringMVCDemo7.pojos.Product;
import SpringMVCDemo7.service.ProductService;

@Controller
public class PController {
	@Autowired
	private ProductService productService;
	@GetMapping("/product/{productId}")
	public String detail(@PathVariable(value = "productId") int id, Model model) {
		Product p = productService.getProductById(id);
		model.addAttribute("product", p);
		return "detail";
	}
}
