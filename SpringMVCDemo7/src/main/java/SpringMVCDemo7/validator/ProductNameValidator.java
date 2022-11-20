package SpringMVCDemo7.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import SpringMVCDemo7.pojos.Product;

@Component
public class ProductNameValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product p = (Product)target;
		if(Character.compare(Character.toUpperCase(p.getName().charAt(0)), p.getName().charAt(0)) != 0) {
			errors.rejectValue("name","product.name.myError");
		}
		boolean check = false;
		for(int i = 0 ; i < p.getName().length(); i++) {
			if (Character.isDigit(p.getName().charAt(i))) {
				check = true;
				break;
			}
		}
		if(check == false) {
			errors.rejectValue("name", "product.name.myError2");
		}
	}
	
}
