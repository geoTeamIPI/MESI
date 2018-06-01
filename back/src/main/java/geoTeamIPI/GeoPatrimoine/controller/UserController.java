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
	public static final String EXISTING_EMAIL = "L'email ne peut pas être vide"; 
	public static final String INCORRECT_FORMAT_EMAIL = "L'email n'est pas valide"; 
	public static final String EMPTY_PWD = "Le mot de passe ne peut être vide";
	public static final String NOT_SAME_PWD = "Les deux mots de passe ne correspondent pas"; 
	public static final String USER_CREATED = "Votre compte a bien été créé. Un email vient de vous être envoyé"; 
	public static final String USER_UPDATED = "Vos données ont bien été mis à jour"; 
	
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
	
	@GetMapping("")
	public String showUsers(Model model) {
		List<User> users = userService.findAllUsers();  
		model.addAttribute("users", users); 
		return "users/liste"; 
	}
	
	// GET FORM2
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.GET
	)
	public String createPersonInfoView(Model model) {

		model.addAttribute("user", new User());
		return "users/formAddUser";
	}
	
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
    public String createPersonInfo(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
		
		Boolean createUser = true; 
		
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
				// Trouver une méthode de hashage du mot de passe
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				model.addAttribute("success", "User created"); 
				userService.createUser(user);
			}
		}
		
        return "users/formAddUser";
    }
	
	
	 // PUT 
	@RequestMapping(
			value = "/{idUser}", 
			method = RequestMethod.GET
	)
	public String updateUserInfoView(Model model, @PathVariable("idUser") Long idUser) {
			User user = userService.findById(idUser);
			if (user == null) {
				// Throw an exception
				
			}
			model.addAttribute("user", user); 
		return "users/formUpdateUser"; 
	}
		
		@RequestMapping(
				value = "/{idUser}", 
				method = RequestMethod.PUT, 
				consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
				produces = "text/html"
		)
		public String updateUserInfo(@PathVariable("idUser") Long idUser, @ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
			if (!bindingResult.hasErrors()) {
				if (!user.getPassword().equals(user.getPasswordConfirm())){
					model.addAttribute("notMatchedPwd", NOT_SAME_PWD); 
				} else {
					model.addAttribute("success", USER_UPDATED); 
					PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					userService.updateUser(idUser, user); 
				}
			}
		return "users/formUpdateUser"; 
	}
	
	 
	 // DELETE 
		@RequestMapping(
				value = "/{idUser}", 
				method = RequestMethod.DELETE
		)
		public ModelAndView deleteUser(@PathVariable("idUser") Long idUser) {
			User user = userService.findById(idUser); 
			if (user == null) {
				// Throw an exception
			}
			return new ModelAndView(new RedirectView("index")); 
		}
	
}
