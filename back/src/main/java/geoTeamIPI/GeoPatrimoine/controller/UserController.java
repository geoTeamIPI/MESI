package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.service.StoryService;
import geoTeamIPI.GeoPatrimoine.service.UserService;

@Controller
@RequestMapping("/users")
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
	
	@Autowired
	private UserService userService;
	/*
	@RequestMapping(
			value="/{id}",
			method=RequestMethod.GET)
	public String detailStory(@PathVariable(value="id") Long id , Map<String,Object> model) {
		User user = userService.findById(id);
		model.put("user", user);
		return "users/details";
	}*/
	
	/*
	 @RequestMapping (
			 value = "",
			 method = RequestMethod.GET,
			 params={"page", "size", "sortProperty", "sortDirection"}
			 )	 
	 public String users(Model model,
			 @RequestParam("page") Integer page,
			 @RequestParam("size") Integer size,
			 @RequestParam("sortProperty") String sortProperty,
			 @RequestParam("sortDirection") String sortDirection) {
			 Page<User> pagin = userService.findAllUsers(page, size, sortProperty, sortDirection);
			 model.put("pagination", pagin);
			 model.put("listePagination", pagin.getContent());
			 model.put("hasNext", pagin.hasNext());
			 model.put("hasPrevious", pagin.hasPrevious());
			 model.put("start", page*size + 1);
			 model.put("end", Math.min(page*size + size, pagin.getTotalElements()));
			 model.put("total", pagin.getTotalElements());
			 model.put("pageActuel", page + 1);
			 model.put("sizeActuel", size);
			 model.put("sortPropertyActuel", sortProperty);
			 model.put("sortDirectionActuel", sortDirection);
			 model.put("nextPage", page+1);
			 model.put("previousPage", page-1);
			 return "users/liste";
		 }
	*/
	
	// GET LIST USER
	@GetMapping("")
	public String showUsers(Model model) {
		List<User> users = userService.findAllUsers();  
		model.addAttribute("users", users); 
		return "users/liste"; 
	}
	
	/* 
	 * 
	 * 
	 * 
	 * FORM ADD USER 
	 * 
	 * 
	 * 
	 * */
	
	// GET 
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.GET
	)
	public String createPersonInfoView(Model model) {

		model.addAttribute("user", new User());
		return "users/formAddUser";
	}
	
	// POST
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
    public String createPersonInfo(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		
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
				// Envoi du mail (trouver le service
				return "users/success"; 
			}

		}
		
        return "users/formAddUser";
    }
	
	/* 
	 * 
	 * 
	 * 
	 * FORM UPDATE USER 
	 * 
	 * 
	 * */
	
	 // GET 
	@RequestMapping(
			value = "/update/{idUser}", 
			method = RequestMethod.GET
	)
	public String updateUserInfoView(Model model, @PathVariable("idUser") Long idUser) {
			User user = userService.findById(idUser);
			if (user == null) {
				// Throw an exception
				return "erreur"; 
			}
			model.addAttribute("user", user); 
		return "users/formUpdateUser"; 
	}
	
	// POST
	@RequestMapping(
			value = "/update/{idUser}", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			produces = "text/html"
	)
	public String updateUserInfo(@ModelAttribute("user") @Valid User user, @PathVariable("idUser") Long idUser, BindingResult bindingResult, Model model) {
		// Ignore les erreurs liés au password
		if (!bindingResult.hasErrors()) {
				User userSearch = userService.findById(idUser);
				user.setPassword(userSearch.getPassword());
				user.setProfile(userSearch.getProfile());
				userService.updateUser(idUser, user); 
				model.addAttribute("successUserUdpated", USER_UPDATED); 
				return "users/success";
		} 
		return "users/formUpdateUser";

	}

	// DELETE 
	@RequestMapping(
			value = "/{idUser}", 
			method = RequestMethod.GET
	)
	public String deleteUser(@PathVariable("idUser") Long idUser) {
		User user = userService.findById(idUser); 
		userService.deleteUser(user);
		return "users/liste"; 
	}
	
	// GET FORM IDENTIFICATION
	@RequestMapping(
			value = "/connexion", 
			method = RequestMethod.GET
	)
	public String connexionUserView(Model model) {
		model.addAttribute("user", new User()); 
		return "users/connexion"; 
	}
	
	// POST IDENTIFICATION
	@RequestMapping(
			value = "/connexion", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			produces = "text/html"	
	)
	public String checkConnexionUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User userSearch = userService.findByEmailAndPassword(user.getEmail(), user.getPassword()); 
			if (userSearch == null) {
				model.addAttribute("errIdentification", ERR_IDENTIFICATION);
			} else {
				model.addAttribute("successIdentification", SUCCESS_IDENTIFICATION);
				// Regarder pour avoir les sessions
				return "users/sucess";
			}
		}
		return "users/connexion"; 
	}
	
	/* FORM UPDATING PASSWORD */
	
	// GET 
	@RequestMapping(
		value = "/changePassword/{idUser}", 
		method = RequestMethod.GET
	)
	public String updatePwdUserView(@PathVariable("idUser") Long idUser, Model model) {
		User userSearch = userService.findById(idUser); 
		if (userSearch == null) {
			return "erreur"; 
		}
		userSearch.setPassword("");
		model.addAttribute("user", userSearch); 
		return "users/formUpdatePwd"; 
	}
	
	// POST
	@RequestMapping(
			value = "/changePassword/{idUser}", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			produces = "text/html"	
	)
	public String updatePwdUser(@PathVariable("idUser") Long idUser, @ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors() && !user.getOldPassword().trim().equals("")) {
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String oldPwdEncode = passwordEncoder.encode(user.getOldPassword());
				User userSearchPwd = userService.findById(idUser);
				// valeurs non nulles 
				user.setCity(userSearchPwd.getCity());
				user.setEmail(userSearchPwd.getEmail());
				model.addAttribute("oldPwdEncode", oldPwdEncode); 
				model.addAttribute("currentPwdEncode", userSearchPwd.getPassword()); 
				// Ancien mot de passe encodé = mot de passe encodé dans la base
				if (passwordEncoder.matches(oldPwdEncode, userSearchPwd.getPassword())) {
					// vérifier si les deux mots de passe correspondent 
					if (user.getPassword().equals(user.getPasswordConfirm())){
						userService.updateUser(idUser, user);
						model.addAttribute("pwdUpdated",PWD_UPDATED);
						return "users/success"; 
					} else {
						model.addAttribute("notMatchedPwd", NOT_SAME_PWD);
					}
				} else {
					model.addAttribute("pwdNoExists", PWD_NO_EXISTS);
				}
		}
		
		return "users/formUpdatePwd"; 
	}

}
