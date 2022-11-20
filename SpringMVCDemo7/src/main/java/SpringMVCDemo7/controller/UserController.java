package SpringMVCDemo7.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.service.UserSevice;
import SpringMVCDemo7.validator.UserValidator;
import SpringMVCDemo7.validator.WebAppProductValidator;
import SpringMVCDemo7.validator.WebAppUserValidator;


@Controller
public class UserController {
	@Autowired
	private UserSevice userDetailsService;
	@Autowired
	private WebAppUserValidator userValidator;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String registerView(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String register(Model model,@ModelAttribute(value = "user") @Valid User user , BindingResult result) {
		if(!result.hasErrors()) {
			if(userDetailsService.addUser(user) == true) {
				return "redirect:/";
			}
			else {
				model.addAttribute("errorMsg", "Something Wrong!");
			}
		}
		return "register";
	}
}
