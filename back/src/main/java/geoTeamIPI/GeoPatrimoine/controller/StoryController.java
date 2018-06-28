package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import geoTeamIPI.GeoPatrimoine.Validator.StoryValidator;
import geoTeamIPI.GeoPatrimoine.Validator.UserValidator;
import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.entity.User;
import geoTeamIPI.GeoPatrimoine.entity.User.requiredAllFields;
import geoTeamIPI.GeoPatrimoine.service.StoryService;
import geoTeamIPI.GeoPatrimoine.service.UserService;
import geoTeamIPI.GeoPatrimoine.utils.UserHelper;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class StoryController {
	
	@Autowired
	private StoryService storyService;
	
	/**
	@Autowired
	private StoryValidator storyValidator; 
	*/
	
	
	/* POSTMAN SERVICES 
	 * 
	 * ADD STORY : stories/add
	 * UPDATE STORY : stories/update/{idUser}
	 * DELETE STORY : stories/delete/{idUser}
	 * GET STORY : /stories
	 * 
	 * 
	 */
	
	/**
	// ADD STORY
	@PostMapping("/stories/add")
	public Story createStory(@RequestBody Story story, BindingResult result) {
		if (!result.hasErrors()) {
			return storyService.createStory(story);
		}
		return null; 
	}*/
	
	// LIST USERS - ADMIN MODE
	@GetMapping ("/stories")
	public List<Story> stories(){
			 return storyService.findAllStories(); 
	}

}
