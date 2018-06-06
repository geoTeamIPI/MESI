package geoTeamIPI.GeoPatrimoine.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class IndexController {
	
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET
	)
	public String index(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email"); 
		model.addAttribute("email", email); 
		return "index"; 
	}

}
