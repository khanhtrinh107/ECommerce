package SpringMVCDemo7.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloudinary.Cloudinary;

import SpringMVCDemo7.pojos.Product;
import SpringMVCDemo7.service.ProductService;
import SpringMVCDemo7.validator.ProductNameValidator;
import SpringMVCDemo7.validator.WebAppProductValidator;

@Controller
public class ProductController {
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	private WebAppProductValidator productValidator;
	@Autowired
	private ProductService productService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(productValidator);
	}
	@GetMapping("/admin/products")
	public String product(Model model) {
		model.addAttribute("product", new Product());
		return "product";
	}
	@PostMapping("/admin/products")
	public String add(Model model,@ModelAttribute(value = "product") @Valid Product product, BindingResult result) {
		if(!result.hasErrors()) {
			if (productService.addOrUpdate(product) == true) {
				return "redirect:/";
			}
			else {
				model.addAttribute("errMsg", "Something wrong!");
			}
		}
		return "product";
	}
}
