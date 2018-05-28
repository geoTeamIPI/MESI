package geoTeamIPI.GeoPatrimoine.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
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
	public static final String TOO_SHORT_PWD = "Le mot de passe doit contenir au moins 8 caractères"; 
	public static final String EMPTY_EMAIL = "L'email ne peut pas être vide"; 
	public static final String INCORRECT_FORMAT_EMAIL = "L'email n'est pas valide"; 
	public static final String EMPTY_PWD = "Le mot de passe ne peut être vide";
	public static final String NOT_SAME_PWD = "Les deux mots de passe ne correspondent pas"; 
	
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
	 public String afficheListeUsers(Map<String,Object> model,
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
	
	/* GET FORM
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.GET
	)
	public String formAddUser() {
		return "users/formAddUser"; 
	}*/
	
	// GET FORM2
	@RequestMapping(
			value = "/newBis", 
			method = RequestMethod.GET
	)
	public String formAddUser2(Model model) {

		User user = new User();
		model.addAttribute("userForm", user);
		return "users/formAddUser2";
	}
	
	/* Post form add User
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
	public String confirmAddUser(@Valid @ModelAttribute("user")User user, 
		      BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "erreur"; 
		}
	
		model.addAttribute("email", user.getEmail()); 
		model.addAttribute("password", user.getPassword()); 
		model.addAttribute("city", user.getCity()); 
		model.addAttribute("profile", user.getProfile()); 
		return "users/formAddUser"; 
	}*/
	
	public boolean tooShort(String field, int length){
		if (field.length() < length) {
			return true; 
		}
		return false; 
	}
	
	@RequestMapping(
			value = "/newBis", 
			method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
    public String checkPersonInfo(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, ModelMap model) {
		
		if (!bindingResult.hasErrors()) {
			model.addAttribute("success", "User created"); 
		}
		
        return "users/formAddUser2";
    }
	
	
	// POST - version test qui fonctionne sans ajout à la base pour l'instant
	@RequestMapping(
			value = "/new", 
			method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
	public String confirmAddUser(User user, 
			BindingResult result, ModelMap model, HttpServletRequest request) {
		
		Boolean show = true; 
		String email = request.getParameter("email"); 
		if (email.trim().isEmpty()) {
			model.addAttribute("emptyEmail", EMPTY_EMAIL);
			show = false; 
		}
		
		if (tooShort(email, 3)) {
			model.addAttribute("tooShortEmail", TOO_SHORT_EMAIL);
			show = false; 
		}
		
		if (!email.matches("@")) {
			model.addAttribute("incorrectEmailFormat", INCORRECT_FORMAT_EMAIL); 
		}
		
		String password = request.getParameter("password"); 
		String passwordConfirm = request.getParameter("passwordConfirm"); 
		if(password.trim().isEmpty() || passwordConfirm.trim().isEmpty() ) {
			model.addAttribute("emptyPassword", EMPTY_PWD);
			show = false; 
		}
		
		if (tooShort(password, 8) || tooShort(passwordConfirm, 8)) {
			model.addAttribute("tooShortPassword", TOO_SHORT_PWD); 
			show = false; 
		}
		
		if (!password.equals(passwordConfirm)){
			model.addAttribute("notEqualPasswords", NOT_SAME_PWD); 
			show = false; 
		}
		
		String city = request.getParameter("city"); 
		
		user.setEmail(email);
		user.setPassword(password);
		user.setCity(city);
		user.setProfile(USER_NORMAL);
		
		model.addAttribute("email", user.getEmail()); 
		model.addAttribute("password", user.getPassword()); 
		model.addAttribute("city", user.getCity()); 
		model.addAttribute("profile", user.getProfile());
		model.addAttribute("show", show);
		
		/* Sauvegarde en base
		userService.createUser(user);*/
		
		//model.put("user", new User()); 
		return "users/formAddUser"; 
	}
	
	
	
	 /* POST - Autre version
	 @RequestMapping(
			 value = "", 
			 method = RequestMethod.POST, 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
			 produces = "text/html"
	)
	public RedirectView createUser(User user, RedirectAttributes attributes) {
		 user = userService.createUser(user);
		 attributes.addAttribute("Success", "User created with success");
		 return new RedirectView("/");
	 }*/
	 
	 // PUT 
	 
	 // DELETE 
}
