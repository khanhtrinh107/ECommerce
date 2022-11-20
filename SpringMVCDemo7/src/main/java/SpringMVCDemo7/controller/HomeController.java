package SpringMVCDemo7.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringMVCDemo7.Utils.ProductUtil;
import SpringMVCDemo7.pojos.Cart;
import SpringMVCDemo7.service.CategoryService;
import SpringMVCDemo7.service.ProductService;
import antlr.Utils;

@Controller
@ControllerAdvice
@EnableTransactionManagement
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@ModelAttribute
	public void commmonAttr(Model model, HttpSession session) {
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("count", ProductUtil.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
	}
	
	@RequestMapping("/")
	@Transactional
	public String index(Model model,@RequestParam(name = "kw" , defaultValue = "" , required = false) String kw,HttpSession session) {
		model.addAttribute("list", categoryService.getCategories());
		model.addAttribute("products", productService.getProducts(kw));
		model.addAttribute("search",kw );
		return "index";
	}
}
