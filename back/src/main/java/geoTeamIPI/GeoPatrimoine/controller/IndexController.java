package geoTeamIPI.GeoPatrimoine.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	// Inclusion de la session dans le header 
	public String header(HttpSession session, Model model) {
		String sEmail = (String) session.getAttribute("email"); 
		String sProfile = (String) session.getAttribute("profile"); 
		model.addAttribute("email", sEmail); 
		model.addAttribute("profile", sProfile); 
		model.addAttribute("userNormal", UserController.USER_NORMAL); 
		model.addAttribute("userAdmin", UserController.USER_ADMIN); 
		model.addAttribute("userModerator", UserController.USER_MODERATOR); 
		return "tags/header"; 
	}
	
	@GetMapping("/index")
	public String index() {
		return "index"; 
	}

	
	
	
	
	// Logout 
	

}
