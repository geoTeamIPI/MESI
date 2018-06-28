package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import geoTeamIPI.GeoPatrimoine.Validator.UserValidator;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.entity.User.RequiredPassword;
import geoTeamIPI.GeoPatrimoine.entity.User.requiredAllFields;
import geoTeamIPI.GeoPatrimoine.exception.UserExceptionHandler;
import geoTeamIPI.GeoPatrimoine.service.UserService;
import geoTeamIPI.GeoPatrimoine.utils.UserHelper;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	/*
	 * POSTMAN SERVICES
	 * 
	 * ADD USER : users/add UPDATE USER : users/update/{idUser} DELETE USER : users/delete/{idUser} GET USERS : /users
	 * 
	 * 
	 */

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) { binder.addValidators(userValidator); }
	 */

	// ADD USER - ADMIN MODE
	@PostMapping("/users/add")
	public User createuser(@RequestBody @Validated({ requiredAllFields.class }) User user, BindingResult result) {
		// userValidator.validate(user, result);
		User userSearch = userService.findByEmail(user.getEmail());
		if (userSearch != null) {
			UserExceptionHandler.userAlreadyExists();
		}
		if (result.hasErrors()) {
			UserExceptionHandler.userIllegalArguments();
		}
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userService.createUser(user);
	}

	// REGISTERING - NORMAL MODE
	@PostMapping("/user/registering")
	public User registeringUser(@RequestBody @Validated({ requiredAllFields.class }) User user, BindingResult result) {
		// userValidator.validate(user, result);
		User userSearch = userService.findByEmail(user.getEmail());
		if (userSearch != null) {
			UserExceptionHandler.userAlreadyExists();
		}
		if (result.hasErrors()) {
			UserExceptionHandler.userIllegalArguments();
		}
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setProfile(UserHelper.USER_NORMAL);
		return userService.createUser(user);
	}

	// UPDATE USER - ADMIN MODE
	@PostMapping("/users/update/{idUser}")
	public User updateUser(
			@PathVariable("idUser") Long idUser,
			@RequestBody @Valid User user,
			BindingResult result) {
		User userSearch = userService.findById(idUser);
		if (userSearch == null) {
			UserExceptionHandler.userNotFound();
		}
		if (result.hasErrors()) {
			UserExceptionHandler.userIllegalArguments();
		}
		user.setPassword(userSearch.getPassword());
		return userService.updateUser(idUser, user);
	}

	// UPDATE PERSONAL INFOS - NORMAL AND ADMIN MODE
	@PostMapping("/user/update")
	public User updateUser(@Validated({ requiredAllFields.class }) @RequestBody User user, BindingResult result, HttpSession session)
			throws Exception {
		String sEmail = (String) session.getAttribute("sEmail");
		user.setEmail(sEmail);
		User userSearch = userService.findByEmail(user.getEmail());
		if (userSearch == null) {
			UserExceptionHandler.userNotFound();
		}
		// One field at least is not empty - we want to change the password
		if (!StringUtils.isNullOrEmpty(user.getOldPassword()) || !StringUtils.isNullOrEmpty(user.getPassword())
				|| !StringUtils.isNullOrEmpty(user.getPasswordConfirm())) {
			// We want to change the password - check the fields errors
			userValidator.validate(user, result);
			if (!result.hasErrors() && user.getPassword().equals(user.getPasswordConfirm())) {
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				;
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			} else {
				UserExceptionHandler.userIllegalArguments();
			}
		} else {
			user.setPassword(userSearch.getPassword());
		}
		// Password good and the fields are not empty
		return userService.updateUser(userSearch.getId(), user);
	}

	// DELETE USER - ADMIN MODE
	@DeleteMapping("/users/delete/{idUser}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("idUser") Long idUser) {
		User userSearch = userService.findById(idUser);
		if (userSearch == null) {
			UserExceptionHandler.userNotFound();
		}
		userService.deleteUser(userSearch);
	}

	// LIST USERS - ADMIN MODE
	@GetMapping("/users")
	public List<User> users() {
		return userService.findAllUsers();
	}

	// INFOS USER - ADMIN MODE
	@GetMapping("/users/infos/{idUser}")
	public User infosUser(@PathVariable("idUser") Long idUser) {
		User userInfos = userService.findById(idUser);
		if (userInfos == null) {
			UserExceptionHandler.userNotFound();
		}
		return userInfos;
	}

	// INFOS USER - NORMAL MODE
	@GetMapping("/user/infos")
	public User infosUser(HttpSession session) {
		if (session.getAttribute("sEmail") == null) {
			UserExceptionHandler.userNotFound();
		}
		String sEmail = (String) session.getAttribute("sEmail");
		User userInfos = userService.findByEmail(sEmail);
		return userInfos;
	}

	// LOGIN
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User login(@RequestBody @Validated({ RequiredPassword.class }) User user, BindingResult result, HttpSession session) {
		User userSearch = userService.findByEmail(user.getEmail());
		if (userSearch == null) {
			UserExceptionHandler.userNotFound();
		}
		if (result.hasErrors()) {
			UserExceptionHandler.userIllegalArguments();
		}
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (!passwordEncoder.matches(user.getPassword(), userSearch.getPassword())) {
			UserExceptionHandler.userAuthenticationException();
		}
		user.setProfile(userSearch.getProfile());
		user.setCity(userSearch.getCity());
		session.setAttribute("sEmail", user.getEmail());
		session.setAttribute("sProfile", user.getProfile());
		return userSearch;
	}

	/* DECONNEXION */
	@GetMapping("/user/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		if (session.isNew()) {
			return new ResponseEntity<String>(UserHelper.EMPTY_SESSION, HttpStatus.OK);
		}
		session.invalidate();
		return new ResponseEntity<String>(UserHelper.LOGOUT_SUCCESS, HttpStatus.OK);
	}

}