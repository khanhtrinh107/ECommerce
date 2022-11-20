package SpringMVCDemo7.validator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVCDemo7.pojos.User;
import SpringMVCDemo7.repository.UserRepository;
import SpringMVCDemo7.service.UserSevice;
@Component
public class UserValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		if(u.getPassword().equals(u.getConfirmPassword()) == false) {
			errors.rejectValue("password", "password.error");
		}
		
	}

}
