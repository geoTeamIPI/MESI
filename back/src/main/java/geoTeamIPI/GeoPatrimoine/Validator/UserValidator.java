package geoTeamIPI.GeoPatrimoine.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mysql.jdbc.StringUtils;

import geoTeamIPI.GeoPatrimoine.controller.UserController;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.service.UserService;
import geoTeamIPI.GeoPatrimoine.utils.UserHelper;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		User userSearch = userService.findByEmail(user.getEmail());

		// if the password is not null and it does not exist
		if (!passwordEncoder.matches(user.getOldPassword(), userSearch.getPassword())){
			errors.rejectValue("oldPassword", UserController.PWD_NO_EXISTS);
		}
		
		/* if the password is not empty and the two passwords are not equals
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("password", UserController.NOT_SAME_PWD);
		}*/
		
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.empty", "email", UserController.EMPTY_EMAIL);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city.empty", "city", UserController.EMPTY_CITY);*/
			
	}


}
