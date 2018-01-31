package pl.reservation.validator;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

	@Override
	public void initialize(PhoneNumber constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		final String telephone = "([+]{1}[0-9]{2})?\\s?[0-9]{3}([-]?[0-9]{3}){2}";		// tel regex e.g +48724-570-120
		return Pattern.matches(telephone, value);
		

	}

}

