package SpringMVCDemo7.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVCDemo7.pojos.Product;

@Component 
public class WebAppProductValidator implements Validator{
	@Autowired
	private javax.validation.Validator beanvaValidator;
	
	private Set<Validator> springValidators;
	
	public Set<Validator> getSpringValidators() {
		return springValidators;
	}

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> beans = beanvaValidator.validate(target);
		for(ConstraintViolation<Object> ojb : beans) {
			errors.rejectValue(ojb.getPropertyPath().toString(), ojb.getMessage(), ojb.getMessageTemplate());
		}
		for(Validator v : springValidators) {
			v.validate(target, errors);
		}
	}
}
