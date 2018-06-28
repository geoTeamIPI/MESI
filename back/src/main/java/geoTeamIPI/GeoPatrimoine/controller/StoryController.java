package geoTeamIPI.GeoPatrimoine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geoTeamIPI.GeoPatrimoine.entity.Story;
import geoTeamIPI.GeoPatrimoine.service.StoryService;

@RestController
@RequestMapping("/stories")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class StoryController {

	@Autowired
	private StoryService storyService;

	/**
	 * @Autowired private StoryValidator storyValidator;
	 */

	// LIST USERS - ADMIN MODE
	@GetMapping("")
	public List<Story> stories() {
		return storyService.findAllStories();
	}

}
