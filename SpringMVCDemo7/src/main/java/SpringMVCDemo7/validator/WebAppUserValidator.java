package SpringMVCDemo7.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVCDemo7.pojos.User;
@Component
public class WebAppUserValidator implements Validator{
	@Autowired
	private javax.validation.Validator beanValidator;
	private Set<Validator> springValidators;
	public Set<Validator> getSpringValidators() {
		return springValidators;
	}

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> bean = beanValidator.validate(target);
		for(ConstraintViolation<Object> obj : bean) {
			errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessage(), obj.getMessageTemplate());
		}
		for(Validator v : springValidators) {
			v.validate(target, errors);
		}
	}

}
