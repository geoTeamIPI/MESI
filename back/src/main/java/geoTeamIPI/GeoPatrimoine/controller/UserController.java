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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import geoTeamIPI.GeoPatrimoine.Validator.UserValidator;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.entity.User.RequiredPassword;
import geoTeamIPI.GeoPatrimoine.entity.User.requiredAllFields;
import geoTeamIPI.GeoPatrimoine.service.UserService;
import geoTeamIPI.GeoPatrimoine.utils.UserHelper;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
	
	public static final String USER_NORMAL = "user"; 
	public static final String USER_ADMIN = "admin"; 
	public static final String USER_MODERATOR = "moderator"; 
	public static final String TOO_SHORT_EMAIL = "L'email est trop court"; 
	public static final String EMAIL_EXISTS = "L'email existe déjà dans la base"; 
	public static final String TOO_SHORT_PWD = "Le mot de passe doit contenir au moins 8 caractères"; 
	public static final String EMPTY_EMAIL = "L'email ne peut pas être vide"; 
	public static final String ERR_SEARCHING_USER = "L'utilisateur n'existe pas"; 
	public static final String INCORRECT_FORMAT_EMAIL = "L'email n'est pas valide"; 
	public static final String EMPTY_PWD = "Le mot de passe ne peut être vide";
	public static final String NOT_SAME_PWD = "Les deux mots de passe ne correspondent pas"; 
	public static final String USER_CREATED = "Votre compte a bien été créé. Un email vient de vous être envoyé"; 
	public static final String USER_UPDATED = "Vos données ont bien été mis à jour"; 
	public static final String PWD_UPDATED = "Mot de passe mis à jour"; 
	public static final String ERR_IDENTIFICATION = "Erreur d'identification";
	public static final String SUCCESS_IDENTIFICATION = "Vous êtes maintenant connecté";
	public static final String PWD_NO_EXISTS = "Ce mot de passe n'existe pas";
	public static final String LOGOUT_SUCCESS = "Vous avez bien été déconnecté"; 
	public static final String USER_DELETED = "Utilisateur supprimé"; 
	public static final String USER_NO_EXISTS = "Utilisateur non existant"; 
	public static final String ERR_USER_UPDATED = "Erreur de mise à jour de vos données";
	public static final String EMPTY_CITY = "Champs ville requis"; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator; 
	

	
	/* POSTMAN SERVICES 
	 * 
	 * ADD USER : users/add
	 * UPDATE USER : users/update/{idUser}
	 * DELETE USER : users/delete/{idUser}
	 * GET USERS : /users
	 * 
	 * 
	 */
	
	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator); 
	}*/
	

	
	// ADD USER - ADMIN MODE
	@PostMapping("/users/add")
	public User createuser(@RequestBody @Validated({requiredAllFields.class}) User user, BindingResult result) {
		//userValidator.validate(user, result);
		if (!result.hasErrors()) {
			User userSearch = userService.findByEmail(user.getEmail()); 
			if (userSearch != null) {
				UserHelper.ThrowInternalServerErrorException(UserController.EMAIL_EXISTS);
			}
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userService.createUser(user);
		}
		return null; 
	}
	
	// REGISTERING - NORMAL MODE
	@PostMapping("/user/registering")
	public User registeringUser(@RequestBody @Validated({requiredAllFields.class}) User user, BindingResult result) {
		//userValidator.validate(user, result);
		if (!result.hasErrors()) {
			User userSearch = userService.findByEmail(user.getEmail()); 
			if (userSearch != null) {
				UserHelper.ThrowInternalServerErrorException(UserController.EMAIL_EXISTS);
			}
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setProfile(USER_NORMAL);
			return userService.createUser(user);
		}
		return user; 
	}
	
	// UPDATE USER - ADMIN MODE
	@PostMapping("/users/update/{idUser}")
	public ResponseEntity<String> updateUser(
			@PathVariable("idUser") Long idUser, 
			@RequestBody @Valid User user, 
			BindingResult result
	){
		User userSearch = userService.findById(idUser); 
		if (userSearch != null) {
			user.setPassword(userSearch.getPassword());
			if (!result.hasErrors()) {
				userService.updateUser(idUser, user);
				return new ResponseEntity<String>(USER_UPDATED + "Email" + user.getId() + " envoyée", HttpStatus.OK); 
			}
		}
		return new ResponseEntity<String>(ERR_USER_UPDATED + " " + user.getId(), HttpStatus.BAD_REQUEST); 
	}
	
	// UPDATE PERSONAL INFOS - NORMAL AND ADMIN MODE
	@PostMapping("/users/update")
	public ResponseEntity<String> updateUser(@Validated({requiredAllFields.class}) @RequestBody User user, BindingResult result, HttpSession session) throws Exception{
		String sEmail = "albert@gmail.com";
		user.setEmail(sEmail);
		User userSearch = userService.findByEmail(user.getEmail()); 
		if (userSearch == null) {
			return new ResponseEntity<String>(ERR_USER_UPDATED + " " + user.getId(), HttpStatus.NOT_FOUND);
		}
		// One field at least is not empty -  we want to change the password
		if (!StringUtils.isNullOrEmpty(user.getOldPassword()) || !StringUtils.isNullOrEmpty(user.getPassword()) || !StringUtils.isNullOrEmpty(user.getPasswordConfirm())) {
			// We want to change the password - check the fields errors
			userValidator.validate(user, result);
			if(!result.hasErrors() && user.getPassword().equals(user.getPasswordConfirm())) {
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); ; 
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			} else {
				return new ResponseEntity<String>(ERR_USER_UPDATED + " " + user.getId(), HttpStatus.BAD_REQUEST);
			}
		} else {
			user.setPassword(userSearch.getPassword());
		}
		// Password good and the fields are not empty
		userService.updateUser(userSearch.getId(), user);
		return new ResponseEntity<String>(USER_UPDATED + " " + user.getId(), HttpStatus.OK);
}
	
	// DELETE USER - ADMIN MODE
	@GetMapping("/users/delete/{idUser}")
	public ResponseEntity<String> deleteUser(@PathVariable("idUser") Long idUser) {
		User userSearch = userService.findById(idUser); 
		if (userSearch != null) {
			userService.deleteUser(userSearch);
			return new ResponseEntity<String>(USER_DELETED + " " + userSearch.getId(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}
	
	// LIST USERS - ADMIN MODE
	@GetMapping ("/users")
	public List<User> users(){
			 return userService.findAllUsers(); 
	}
	
	// INFOS USER - ADMIN MODE
	@GetMapping("/users/infos/{idUser}")
	public User infosUser(@PathVariable("idUser") Long idUser) {
		User userInfos = userService.findById(idUser);
		if (userInfos != null) {
			return userInfos; 
		}
		return null; 
	}
	
	// INFOS USER - NORMAL MODE
	@GetMapping("/user/infos")
	public User infosUser(HttpSession session) {
		String sEmail = "papi@gmail.com";
		if (!sEmail.isEmpty() || !sEmail.isEmpty()) {
			User userInfos = userService.findByEmail(sEmail);
			return userInfos;
		}
		return null; 
	}
	
	// LOGIN
	@RequestMapping(value="/user/login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> login(@RequestBody @Validated({RequiredPassword.class}) User user, BindingResult result, HttpSession session) {
		User userSearch = userService.findByEmail(user.getEmail());
		if (userSearch != null) {
			if  (!result.hasErrors()) {
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				if (passwordEncoder.matches(user.getPassword(), userSearch.getPassword())){
					session.setAttribute("sEmail", user.getEmail());
					session.setAttribute("sProfile", userSearch.getProfile());
					String sEmail = (String) session.getAttribute("email");
					return new ResponseEntity<String>(SUCCESS_IDENTIFICATION + "Variable de session " + sEmail + " envoyée", HttpStatus.OK); 
				}
			}
		}
		return new ResponseEntity<String>(ERR_IDENTIFICATION, HttpStatus.BAD_REQUEST); 
	}
	
	/* END TEST POSTMAN */
	
//	 @RequestMapping (
//			 value = "/users",
//			 method = RequestMethod.GET,
//			 params={"page", "size", "sortProperty", "sortDirection"}
//			 )	 
//	 public String users(Model model,
//			 @RequestParam("page") Integer page,
//			 @RequestParam("size") Integer size,
//			 @RequestParam("sortProperty") String sortProperty,
//			 @RequestParam("sortDirection") String sortDirection) {
//			 Page<User> listeUsers = userService.findAllUsers(page, size, sortProperty, sortDirection);
//			 model.addAttribute("users", listeUsers.getContent());
//			 model.addAttribute("hasNext", listeUsers.hasNext());
//			 model.addAttribute("hasPrevious", listeUsers.hasPrevious());
//			 model.addAttribute("start", page*size + 1);
//			 model.addAttribute("end", Math.min(page*size + size, listeUsers.getTotalElements()));
//			 model.addAttribute("total", listeUsers.getTotalElements());
//			 model.addAttribute("page", page + 1);
//			 model.addAttribute("size", size);
//			 model.addAttribute("sortProperty", sortProperty);
//			 model.addAttribute("sortDirection", sortDirection);
//			 model.addAttribute("nextPage", page+1);
//			 model.addAttribute("previousPage", page-1);
//			 return "users/liste";
//		 }
	 

	/* GET LIST USER
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> users = userService.findAllUsers();  
		model.addAttribute("users", users); 
		return "users/liste"; 
	}*/
	
	// GET USER
	// Je récupère les données stockés 
//	@GetMapping("/user/infos")
//	public String infoUser(HttpSession session, Model model) {
//			User userInfos = userService.findByEmail((String) session.getAttribute("email"));
//			model.addAttribute("user", userInfos);
//			return "users/detailsUser";
//	}
	
	/* GET USER - ADMIN MODE
	@GetMapping("/user/infos/{idUser}")
	public String infoUser(@PathVariable("idUser") Long idUser, HttpSession session, Model model) {
			User userInfos = userService.findById(idUser);
			model.addAttribute("user", userInfos); 
			model.addAttribute("idUser", idUser); 
			return "users/detailsUser";
	}*/
	
	// GET USER - ADMIN MODE

	
	/* 
	 * 
	 * 
	 * 
	 * FORM ADD USER 
	 * 
	 * 
	 * 
	 * */
	
	/* GET 
	@GetMapping("/user/new")
	public String createUser(Model model, HttpSession session) {

		model.addAttribute("user", new User());
		String sEmail = (String) session.getAttribute("email"); 
		String sProfile = (String) session.getAttribute("profile");
		model.addAttribute("userNormal", USER_NORMAL); 
		model.addAttribute("userAdmin", USER_ADMIN);
		model.addAttribute("userModerator", USER_MODERATOR); 
		model.addAttribute("sEmail", sEmail); 
		model.addAttribute("sProfile", sProfile); 
		return "users/formAddUser";
	}*/
	
	/*POST
	@RequestMapping(
			value = "/user/new", 
			method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
    public String createuser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		
		Boolean createUser = true; 
		
		// Cas où il n'y a pas d'erreur 
		if (!bindingResult.hasErrors()) {
			if (!user.getPassword().equals(user.getPasswordConfirm())){
				model.addAttribute("notMatchedPwd", NOT_SAME_PWD);
				createUser = false;  
			} 
			User findEmailUser = userService.findByEmail(user.getEmail());
			if (findEmailUser != null) {
				model.addAttribute("emailExists", EMAIL_EXISTS); 
				createUser = false; 
			}
			
			if (createUser == true) {
				user.setProfile(USER_NORMAL);
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				model.addAttribute("successUserCreated", USER_CREATED); 
				userService.createUser(user);
				// Send email - Does not work - find how it works
				/*SimpleMailMessage simpleMailMessage = new SimpleMailMessage(); 
				simpleMailMessage.setSubject("Test envoie email création de compte");
				simpleMailMessage.setText("Test envoi email création de compte");
				mailSender.send(simpleMailMessage);
				return "users/success"; 
			}

		}
		
        return "users/formAddUser";
    }*/

	

	
	/* 
	 * 
	 * 
	 * 
	 * FORM UPDATE USER 
	 * 
	 * 
	 * */
	
//	 // GET - ADMIN MODE
//	@GetMapping("/user/update/{idUser}")
//	public String updateUser(Model model, @PathVariable("idUser") Long idUser) {
//			User user = userService.findById(idUser);
//			model.addAttribute("user", user); 
//			model.addAttribute("idUser", idUser);  
//		return "users/formUpdateUser"; 
//	}
//	
//	// POST - ADMIN MODE
//	@RequestMapping(
//			value = "/user/update/{idUser}", 
//			method = RequestMethod.POST, 
//			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
//			produces = "text/html"
//	)
//	public String updateUser(@ModelAttribute("user") @Valid User user, @PathVariable("idUser") Long idUser, BindingResult bindingResult, Model model) {
//		// Ignore les erreurs liés au password
//		if (!bindingResult.hasErrors()) {
//				User userSearch = userService.findById(idUser);
//				user.setPassword(userSearch.getPassword());
//				user.setProfile(userSearch.getProfile());
//				userService.updateUser(idUser, user); 
//				model.addAttribute("successUserUdpated", USER_UPDATED);
//				return "users/success";
//		} 
//		return "users/formUpdateUser";
//	}
//	
//	// GET - UPDATE PERSONAL INFOS (ADMIN AND NORMAL USERS)
//	@GetMapping("/user/update")
//	public String updateUser(HttpSession session, Model model) {
//		String sEmail = (String) session.getAttribute("email"); 
//		String sProfile = (String) session.getAttribute("profile"); 
//		User userSearch = userService.findByEmail(sEmail);
//		userSearch.setPassword("");
//		model.addAttribute("user", userSearch);
//		model.addAttribute("userNormal", UserController.USER_NORMAL); 
//		model.addAttribute("userAdmin", UserController.USER_ADMIN); 
//		model.addAttribute("userModerator", UserController.USER_MODERATOR); 
//		model.addAttribute("sProfile", sProfile);
//		return "users/formUpdateUser"; 
//	}
//	
//	// POST - NORMAL USER
//	@RequestMapping(
//			value = "/user/update", 
//			method = RequestMethod.POST, 
//			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
//			produces = "text/html"
//	)
//	public String updateUser(@ModelAttribute("user") @Valid User user, HttpSession session, BindingResult bindingResult, Model model) {
//		
//		Boolean updateUser = true; 
//		String sPassword = (String) session.getAttribute("password");
//		user.setPassword(sPassword);
//		if (!bindingResult.hasErrors()) {
//				String email = (String) session.getAttribute("email"); 
//				String profile = (String) session.getAttribute("profile");
//				User userSearch = userService.findByEmail(email);
//				if (profile == USER_NORMAL) {
//					user.setProfile(userSearch.getProfile());
//				}
//				/* Test */
//				// Du moment où l'on va remplir l'ancien mot de passe alors on veut changer son mot de passe
//				if (!user.getOldPassword().trim().equals("")) {
//					PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//					user.setPassword(user.getPassword());
//					// valeurs non nulles 
//					// Ancien mot de passe encodé = mot de passe encodé dans la base
//					if (passwordEncoder.matches(user.getOldPassword(), userSearch.getPassword())) {
//						// vérifier si les deux mots de passe correspondent 
//						if (user.getPassword().equals(user.getPasswordConfirm())){
//							user.setPassword(passwordEncoder.encode(user.getPassword()));
//						} else {
//							model.addAttribute("notMatchedPwd", NOT_SAME_PWD);
//							updateUser = false; 
//						}
//					} else {
//						model.addAttribute("pwdNoExists", PWD_NO_EXISTS);
//						updateUser = false; 
//					}
//				}
//				// No error on the other fields
//				/* */
//				if (updateUser) {
//					userService.updateUser(userSearch.getId(), user);
//					model.addAttribute("successUserUdpated", USER_UPDATED);
//					return "users/success"; 
//				}
//		}
//
//		return "users/formUpdateUser";
//	}
//
//	/* DELETE 
//	@RequestMapping(
//			value = "/user/delete/{idUser}", 
//			method = RequestMethod.GET
//	)
//	public String deleteUser(@PathVariable("idUser") Long idUser) {
//		User user = userService.findById(idUser); 
//		userService.deleteUser(user);
//		return "redirect:/users?page=0&size=10&sortDirection=ASC&sortProperty=email"; 
//	}*/
//	
//
//	
//	// GET FORM IDENTIFICATION
//	@GetMapping("/user/login")
//	public String login(Model model) {
//		model.addAttribute("user", new User()); 
//		return "users/connexion"; 
//	}
//	
//	// POST IDENTIFICATION
//	@RequestMapping(
//			value = "/user/login", 
//			method = RequestMethod.POST, 
//			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
//			produces = "text/html"	
//	)
//	public String login(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model, HttpSession session) {
//		if (!bindingResult.hasErrors()) {
//			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			User userSearch = userService.findByEmail(user.getEmail()); 
//			if (userSearch == null || !passwordEncoder.matches(user.getPassword(), userSearch.getPassword())) {
//				model.addAttribute("errIdentification", ERR_IDENTIFICATION);
//			} else {
//				model.addAttribute("successIdentification", SUCCESS_IDENTIFICATION);
//				session.setAttribute("email", userSearch.getEmail());
//				session.setAttribute("profile", userSearch.getProfile());
//				// Regarder pour avoir les sessions
//				return "redirect:/user/myAccount";
//			}
//		}
//		return "users/connexion"; 
//	}
//	
//	/* DECONNEXION */
//	@GetMapping("/user/logout")
//	public String logout(HttpSession session, Model model) {
//		session.invalidate();
//		model.addAttribute("logoutSuccess", LOGOUT_SUCCESS); 
//		return "redirect:/";
//	}
//	
//	
//	
//	/* FORM UPDATING PASSWORD */
//	
//	// GET 
//	@GetMapping("/user/changePassword")
//	public String updatePwdUserView(Model model, HttpSession session) {
//		if (session.getAttribute("email") != null) {
//			String email = (String) session.getAttribute("email"); 
//			User userSearch = userService.findByEmail(email); 
//			if (userSearch == null) {
//				return "erreur"; 
//			}
//			userSearch.setPassword("");
//			model.addAttribute("user", userSearch);
//	}
//		return "users/formUpdatePwd"; 
//	}
//	
//	// POST
//	@RequestMapping(
//			value = "/user/changePassword", 
//			method = RequestMethod.POST, 
//			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
//			produces = "text/html"	
//	)
//	public String updatePwdUser(HttpSession session, @ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
//		if (!bindingResult.hasErrors() && !user.getOldPassword().trim().equals("")) {
//				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//				String email = (String) session.getAttribute("email"); 
//				User userSearchPwd = userService.findByEmail(email); 
//				// valeurs non nulles 
//				user.setCity(userSearchPwd.getCity());
//				user.setEmail(userSearchPwd.getEmail());
//				user.setProfile(userSearchPwd.getProfile()); 
//				// Ancien mot de passe encodé = mot de passe encodé dans la base
//				if (passwordEncoder.matches(user.getOldPassword(), userSearchPwd.getPassword())) {
//					// vérifier si les deux mots de passe correspondent 
//					if (user.getPassword().equals(user.getPasswordConfirm())){
//						user.setPassword(passwordEncoder.encode(user.getPassword()));
//						userService.updateUser(userSearchPwd.getId(), user);
//						model.addAttribute("pwdUpdated",PWD_UPDATED);
//						return "users/success"; 
//					} else {
//						model.addAttribute("notMatchedPwd", NOT_SAME_PWD);
//					}
//				} else {
//					model.addAttribute("pwdNoExists", PWD_NO_EXISTS);
//				}
//		}
//		
//		return "users/formUpdatePwd"; 
//	}
//	
//	// GET MY ACCOUNT WELCOMING 
//	@GetMapping("/user/myAccount")
//	public String myAccount(Model model) {
//		return "myAccount"; 
//	}

}
